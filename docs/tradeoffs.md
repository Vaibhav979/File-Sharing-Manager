# ⚖️ Architectural Trade-offs — File Sharing Manager

## 1. What a Trade-off Means

In system design, a trade-off means deliberately choosing one advantage while accepting a corresponding cost.

Every design decision optimizes for something:

- Simplicity
- Performance
- Scalability
- Reliability
- Security

It is impossible to optimize all of them at once.

#### This system prioritizes simplicity, correctness, and clarity over raw scale.

## 2. File Storage: Database vs File System

### Decision

Store file data directly in MySQL as LONGBLOB.

### Why this was chosen

- File and metadata remain in a single transaction
- Easy backup and restore
- No extra infrastructure required
- Simpler data model

### Cost

- Large files cause heavy DB I/O
- Queries become slow as data grows
- Database becomes the main bottleneck
- Not suitable for high-scale workloads

### Trade-off

- Simplicity and consistency vs scalability and performance

## 3. Monolithic Architecture vs Microservices

### Decision

- Use a single Spring Boot application.

### Why this was chosen

- Faster development
- Easier debugging
- No network failures between services
- Simpler deployment

### Cost

- No independent scaling
- Failures affect the entire system
- Harder to evolve into large distributed systems

### Trade-off

- Developer productivity vs system resilience and scalability

## 4. OAuth2 Authentication vs Local Passwords

### Decision

- Use Google and GitHub OAuth2.

### Why this was chosen

- No password handling
- Strong security by default
- Easy user onboarding

### Cost

- System depends on external providers
- If Google/GitHub is down → login fails

### Trade-off

- Security and convenience vs availability and control

## 5. No Caching Layer

### Decision

- All reads come directly from MySQL.

### Why this was chosen

- Always up-to-date data
- No cache invalidation complexity
- Fewer moving parts

### Cost

- High DB load
- Slow file listing
- Poor scalability

### Trade-off

- Data correctness and simplicity vs performance

## 6. Scheduled Cleanup vs Real-time Deletion

### Decision

- Expired files are deleted every 24 hour.

### Why this was chosen

- Simple to implement
- No overhead on every request
- Easy to reason about

### Cost

- Expired files may exist temporarily
- If scheduler fails, cleanup stops

### Trade-off

- Implementation simplicity vs precision and reliability

## 7. No Resilience Layer

### Decision

- No retries, no circuit breakers, no fallbacks.

### Why this was chosen

- Clean architecture
- Easier to understand
- Fewer failure modes

### Cost

- Any DB or OAuth failure breaks the system
- No graceful degradation

### Trade-off

- System simplicity vs fault tolerance

## 8. Summary

This system is intentionally designed to be:

- Simple
- Consistent
- Easy to understand

### At the cost of:

- Scalability
- Fault tolerance
- Performance at high load

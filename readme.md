src/
├── main/
│   ├── java/
│   │   └── com.example.employee/
│   │       ├── config/              # Configuration classes (e.g., security, database)
│   │       ├── controller/          # REST Controllers (API layer)
│   │       ├── dto/                 # Data Transfer Objects (Request/Response)
│   │       ├── entity/              # JPA Entities (Database models)
│   │       ├── exception/           # Custom Exceptions and Handlers
│   │       ├── repository/          # Repositories (Data access layer)
│   │       ├── service/             # Service classes (Business logic)
│   │       ├── util/                # Utility classes (e.g., constants, helpers)
│   │       └── EmployeeApplication.java  # Main Application Class
│   ├── resources/
│       ├── application.yml          # Configuration file (Production, Test, etc.)
│       ├── application-dev.yml      # Dev-specific configuration
│       ├── application-prod.yml     # Prod-specific configuration
│       └── schema.sql               # Schema initialization (if needed)
├── test/
│   ├── java/com/example/employee/   # Unit and integration tests
│   │       ├── controller/
│   │       ├── service/
│   │       ├── repository/
│   │       └── EmployeeApplicationTests.java
│   └── resources/
│       ├── application-test.yml     # Test-specific configuration



for jpa database only provide 
the path not the extension with it 
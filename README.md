<div align="center">

# 🚀 Hibernate & ORM – Complete Learning Guide

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Hibernate](https://img.shields.io/badge/Hibernate-7.0.0.Beta3-green.svg)](https://hibernate.org/)
[![Database](https://img.shields.io/badge/Database-PostgreSQL-blue.svg)](https://www.postgresql.org/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36.svg)](https://maven.apache.org/)

> A beginner-friendly repository for learning Object Relational Mapping (ORM), Hibernate, database persistence, entity mapping, CRUD operations, relationships, caching, and more.

</div>

Welcome to the **Hibernate & ORM Learning Guide**! This repository is designed to help beginners and intermediate developers understand how Java applications interact with relational databases using Hibernate ORM. It provides clear conceptual explanations alongside practical, ready-to-run Java examples demonstrating core Hibernate concepts.

---

## 📖 Table of Contents

- [Introduction](#-introduction)
- [What is ORM?](#-what-is-orm)
- [Why Do We Need ORM?](#-why-do-we-need-orm)
- [JDBC vs ORM](#-jdbc-vs-orm)
- [What is Hibernate?](#-what-is-hibernate)
- [Hibernate Architecture](#-hibernate-architecture)
- [How Hibernate Works Internally](#-how-hibernate-works-internally)
- [Repository Structure](#-repository-structure)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Database Configuration](#-database-configuration)
- [Entity Mapping](#-entity-mapping)
- [CRUD Operations](#-crud-operations)
- [Hibernate Relationships](#-hibernate-relationships)
- [Important Hibernate Concepts](#-important-hibernate-concepts)
- [Hibernate vs JPA](#-hibernate-vs-jpa)
- [Hibernate vs JDBC](#-hibernate-vs-jdbc)
- [Examples Available in This Repository](#-examples-available-in-this-repository)
- [How to Run the Project](#-how-to-run-the-project)
- [Common Errors & Solutions](#-common-errors--solutions)
- [ORM Learning Path](#-orm-learning-path)
- [Best Practices](#-best-practices)
- [Interview Questions](#-interview-questions)
- [Future Learning](#-future-learning)
- [Official Resources](#-official-resources)
- [Author](#-author)

---

## 🧠 What is ORM?

**ORM** stands for **Object Relational Mapping**. 

To understand ORM, we must understand the problem it solves. Java applications are object-oriented and deal with **Java Objects**. However, relational databases organize data into **Tables, Rows, and Columns**.

This difference creates an **object-relational impedance mismatch**. 

ORM acts as a bridge between the object-oriented world of Java and the relational world of the database.

**Java Object** ↓ **ORM Framework** ↓ **Relational Database**

### The Impedance Mismatch Example

**Java Object:**
```java
Alien alien = new Alien();
alien.setAid(104);
alien.setAname("Avni");
alien.setTech("Databases");
```

**Database Table (Alien):**
| aid | aname | tech      |
|-----|-------|-----------|
| 104 | Avni  | Databases |

**How ORM Maps It:**
- **Class** → Table (`Alien` class maps to `Alien` table)
- **Object** → Row (An instance of `Alien` is a row in the table)
- **Field** → Column (`aid` maps to the `aid` column)
- **Relationship** → Foreign Key

---

## 🤔 Why Do We Need ORM?

When using traditional **JDBC**, developers face several challenges:
- Writing repetitive, plain SQL statements.
- Manually mapping the `ResultSet` from the database into Java objects.
- Handling database connection and resource management (opening and closing connections).
- High amounts of boilerplate code.
- Difficulty porting across different database vendors because SQL syntax can vary.

**How ORM Helps:**
- **Object-oriented programming:** Work with objects instead of writing raw SQL.
- **Automatic mapping:** Automatic conversion between Java objects and database tables.
- **Reduced boilerplate:** Eliminates repetitive JDBC code.
- **Database independence:** The ORM framework generates the correct SQL dialect for your database automatically.
- **Transaction support & Caching:** Built-in performance and consistency mechanisms.

> ⚠️ **Note:** ORM does NOT mean developers never need SQL. Understanding SQL and database fundamentals remains crucial for optimization and complex queries.

---

## ⚔️ JDBC vs ORM

| Feature | JDBC | ORM |
|---|---|---|
| **SQL Writing** | Manual | Often handled by ORM |
| **Object Mapping** | Manual | Automatic |
| **Boilerplate Code** | High | Lower |
| **Relationships** | Manual | Managed by the framework |
| **Database Portability** | Lower (DB specific SQL) | Higher (Dialect configurations) |
| **Learning Curve** | Moderate | Moderate to High |
| **Performance Control** | Direct | More abstraction (requires tuning) |
| **Caching** | Manual | Built-in options |

---

## 🔥 What is Hibernate?

Hibernate is an open-source Java ORM framework that helps map Java objects to relational database tables. Hibernate ORM is designed to handle object-relational persistence and provides APIs and mappings for working with relational databases.

Hibernate sits between your application and the database:
**Java Application** ↓ **Hibernate** ↓ **JDBC** ↓ **Database**

> **Important:** Hibernate does not replace JDBC. Internally, Hibernate uses JDBC to communicate with relational databases, but abstracts away all the repetitive and manual work.

---

## 🏗️ Hibernate Architecture

```text
       Java Application
              │
              ▼
          Hibernate
              │
       ├── Configuration
       ├── SessionFactory
       ├── Session
       ├── Transaction
              │
              ▼
            JDBC
              │
              ▼
          Database
```

### Components:
- **Configuration:** Reads the configuration properties (like database URL, credentials) and mapping files/annotations to bootstrap Hibernate.
- **SessionFactory:** Created once during application startup using the `Configuration`. It is a heavyweight, thread-safe object used to create `Session` instances.
- **Session:** Represents a short-lived interaction with the database. It is a lightweight, non-thread-safe object used for CRUD operations.
- **Transaction:** Represents a database transaction. Crucial for ensuring data consistency. 
  Example: `Transaction transaction = session.beginTransaction();`

---

## 🔄 How Hibernate Works Internally

Here is the complete execution flow when saving data:

1. **Java Object Created:** You instantiate and populate your Entity object.
2. **Hibernate Entity Mapping:** Hibernate reads the annotations (like `@Entity`).
3. **Session Opens:** Your app requests a `Session` from the `SessionFactory`.
4. **Transaction Begins:** A `Transaction` is started to wrap operations.
5. **Hibernate Generates SQL:** Using your database Dialect, Hibernate converts the object save into an `INSERT` statement.
6. **JDBC Executes SQL:** Hibernate uses JDBC to execute the SQL against the database.
7. **Database Stores/Retrieves Data:** The database commits the change.
8. **Transaction Commits:** The data is permanently persisted.

---

## 📁 Repository Structure

The actual project structure is divided into several modules, progressing from simple configurations to CRUD operations.

```text
Hibernate/
│
├── Hibernate_Demo_01/       # Basic Maven setup with Hibernate dependencies
├── Hibernate_Demo_02/       # Adding an Entity class without mapping
├── Hibernate_Demo_03/       # Basic Entity mapping & Save (Persist) operation
├── Hibernate_Demo_04/       # Advanced CRUD operations & Fetching strategies
├── Hibernate_Demo_05/       # Reviewing the complete save flow
├── demorest/                # REST application demo code
├── springboot-rest/         # Spring Boot application basic setup
├── springbootrest/          # Spring Boot application basic setup
│
├── pom.xml                  # Parent/Global configuration (if applicable)
└── README.md                # This documentation
```

---

## ⚙️ Prerequisites

To run this repository locally, you will need:
- ☕ **Java JDK 21** or higher (`java -version`)
- 🗄️ **PostgreSQL** database running locally (port 5432)
- 📦 **Maven** build tool (`mvn -version`)
- 🖥️ IDE: Eclipse, IntelliJ IDEA, or VS Code

---

## 📦 Installation & Setup

**Step 1 — Clone the Repository**
```bash
git clone https://github.com/Mohammad-Asfin/Hibernate.git
```

**Step 2 — Navigate to the Project**
```bash
cd Hibernate
```

**Step 3 — Import Dependencies (Maven)**
Navigate into any demo directory and download the required libraries.
```bash
cd Hibernate_Demo_03
mvn clean install
```
Maven will automatically download the required dependencies: `hibernate-core` and `postgresql` driver.

---

## 🔌 Database Configuration

Inside `src/main/resources/hibernate.cfg.xml`, you will find the critical configurations required for Hibernate to connect to PostgreSQL:

```xml
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/telusko</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">12345678</property>
<property name="hibernate.hbm2ddl.auto">update</property>
<property name="hibernate.show_sql">true</property>
```

- **`hibernate.connection.url/username/password`:** Standard JDBC connection details. Ensure your PostgreSQL instance has a database named `telusko`.
- **`hibernate.show_sql`:** Prints the SQL statements generated by Hibernate to the console (useful for learning).
- **`hibernate.hbm2ddl.auto`:** Manages the database schema automatically.
  - `create`: Destroys and recreates the schema every time (good for tests).
  - `update`: Updates the schema without destroying data (good for development).
  - `none`: Does nothing (safest for production).

---

## 🧩 Entity Mapping

Hibernate maps Java objects using JPA annotations. In `Hibernate_Demo_03/../Alien.java`:

```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;
    
    // Getters and setters...
}
```

- **`@Entity`:** Marks the Java class as a persistent entity. Hibernate will map this to an `Alien` table.
- **`@Id`:** Marks the `aid` field as the primary key.
- *Additional concepts to learn:* `@Table`, `@Column`, `@GeneratedValue`.

---

## 🔄 CRUD Operations

In `Hibernate_Demo_04/src/main/java/com/telusko/Main.java`, we explore complete CRUD:

### Create (Persist)
```java
Alien a1 = new Alien();
a1.setAid(104);
a1.setAname("Avni");
session.persist(a1);
```

### Read (Fetch)
```java
// Eager fetching - immediately queries database
Alien a1 = session.get(Alien.class, 103);
Alien a2 = session.find(Alien.class, 103);
```

### Update (Merge)
```java
a1.setTech("Cloud");
session.merge(a1);
```

### Delete (Remove)
```java
Alien a1 = session.find(Alien.class, 104);
session.remove(a1);
```

---

## 🔗 Hibernate Relationships

*(Note: While the current demo code focuses on basic mapping, understanding relationships is critical for real-world projects.)*

- **One-to-One:** `@OneToOne` (e.g., Person ───── Passport)
- **One-to-Many:** `@OneToMany` (e.g., Department ───── Employees)
- **Many-to-One:** `@ManyToOne` (e.g., Employees ───── Department)
- **Many-to-Many:** `@ManyToMany` (e.g., Students ───── Courses)

Always define an owning side (usually the side with the foreign key) and an inverse side (`mappedBy`).

---

## 🧠 Important Hibernate Concepts

### Entity Lifecycle
Entities move through states:
1. **Transient:** New object, not associated with a Session.
2. **Persistent:** Attached to a Session, changes are tracked.
3. **Detached:** Session is closed, object data remains but is no longer tracked.
4. **Removed:** Scheduled for deletion.

### Lazy vs Eager Loading (Demonstrated in Demo 04)
- **LAZY:** Data is loaded only when specifically requested via a getter. (`session.getReference()`)
- **EAGER:** Data is loaded immediately along with the parent object. (`session.get()` or `session.find()`)

---

## 🆚 Hibernate vs JPA

| JPA | Hibernate |
|---|---|
| **Specification** (A standard interface) | **Implementation** (The actual working code) |
| Defines standard API and persistence concepts | Provides the implementation and extra vendor-specific features |
| E.g., `jakarta.persistence.Entity` | Implements the mapping logic underneath |

---

## 🆚 Hibernate vs JDBC

**JDBC Workflow:**
You write SQL manually ↓ You deal with Connection/Statement/ResultSet ↓ Map data to objects manually.

**Hibernate Workflow:**
Work strictly with Java objects ↓ Hibernate automatically generates SQL based on mapping ↓ Hibernate handles JDBC and resource cleanup underneath.

---

## 🧪 Examples Available in This Repository

1. **Hibernate_Demo_01**
   - **Concept Learned:** Initial setup, verifying Maven dependencies.
   - **Files:** `pom.xml`, `Main.java`.
2. **Hibernate_Demo_02**
   - **Concept Learned:** Creating the `Alien` POJO and adding configuration XML.
3. **Hibernate_Demo_03**
   - **Concept Learned:** Basic `@Entity` mapping and saving (`persist()`) an object.
   - **Files:** `Alien.java`, `Main.java`, `hibernate.cfg.xml`.
   - **How it Works:** Configures the `SessionFactory`, begins a transaction, and saves an object.
4. **Hibernate_Demo_04**
   - **Concept Learned:** Advanced CRUD, finding records, updating, deleting, and exploring **Lazy vs Eager Fetching**.
5. **Hibernate_Demo_05**
   - **Concept Learned:** Complete repetition and review of the persist flow to solidify learning.

---

## ▶️ How to Run the Project

**Option 1 — Eclipse / IntelliJ IDEA:**
1. Open IDE and choose "Open" or "Import Project".
2. Select the parent folder or a specific `Hibernate_Demo_*` folder as a Maven project.
3. Allow the IDE to resolve Maven dependencies.
4. Ensure PostgreSQL is running and you have a database named `telusko` with username `postgres` and password `12345678` (or update `hibernate.cfg.xml` to match your DB).
5. Run `Main.java` as a Java Application.
6. Check your console to see the generated SQL.

---

## ❗ Common Errors & Solutions

❌ **ClassNotFoundException (org.postgresql.Driver)**
- **Solution:** You are missing the PostgreSQL driver in your `pom.xml` dependencies.

❌ **Database Connection Failed / FATAL: password authentication failed**
- **Solution:** Double-check your `hibernate.connection.username` and `password` in the `hibernate.cfg.xml`. Ensure PostgreSQL is running on port `5432`.

❌ **Unknown Entity**
- **Solution:** Ensure the class has the `@Entity` annotation and is registered in the configuration: `config.addAnnotatedClass(Alien.class);`

❌ **Table Does Not Exist**
- **Solution:** Set `<property name="hibernate.hbm2ddl.auto">update</property>` to let Hibernate auto-create tables for you in development.

---

## 🎓 ORM Learning Path

1️⃣ **Learn SQL Basics**  
2️⃣ **Learn JDBC**  
3️⃣ **Understand the ORM concept**  
4️⃣ **Learn Hibernate Architecture & Setup**  
5️⃣ **Entity Mapping & Annotations**  
6️⃣ **CRUD Operations**  
7️⃣ **Relationships (OneToMany, ManyToMany)**  
8️⃣ **HQL / JPQL**  
9️⃣ **Caching Strategies**  
🔟 **Spring Data JPA**  

---

## 💡 Best Practices

- **Transactions:** Always wrap your read/write database interactions inside a transaction.
- **Auto DDL:** Be extremely careful with `hbm2ddl.auto` in production. Never use `create` or `update` on live production databases.
- **Meaningful Names:** Name your entities and tables clearly.
- **DTOs over Entities:** Avoid exposing raw database Entities directly in your REST APIs; use Data Transfer Objects (DTOs) instead.
- **Logging:** Enable `hibernate.show_sql` during development to understand exactly what queries are being executed.

---

## 🎯 Interview Questions

### Beginner
- **What is ORM?** Object Relational Mapping, bridging Java objects and DB tables.
- **What is the difference between JDBC and Hibernate?** JDBC is manual and SQL-heavy; Hibernate is automatic, mapping objects directly.
- **What is SessionFactory vs Session?** `SessionFactory` is a heavyweight, thread-safe factory created once. `Session` is a short-lived, lightweight object used for a single unit of work.

### Intermediate
- **What is lazy loading?** Loading associated data only when it is explicitly accessed to save memory and performance.
- **What is eager loading?** Fetching all associated data immediately alongside the main object.
- **What is dirty checking?** Hibernate's ability to automatically detect changes made to a persistent entity and push those updates to the database upon transaction commit.

### Advanced
- **What is the N+1 query problem?** Occurs when you fetch a collection of items (1 query), and then access a lazily-loaded association for each item, triggering an additional query per item (N queries).
- **What is the persistence context?** A first-level cache where Hibernate tracks entity state. Entities within the persistence context are managed.

---

## 🚀 Future Learning

Once you have mastered Hibernate, your next steps in modern Java development should be:

**Hibernate** ↓ **JPA** ↓ **Spring Data JPA** ↓ **Spring Boot** ↓ **REST APIs** ↓ **Microservices**

---

## 📚 Official Resources

- [Hibernate ORM Official Documentation](https://hibernate.org/orm/documentation/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/)
- [Maven Getting Started Guide](https://maven.apache.org/guides/getting-started/index.html)

---

## 👨‍💻 Author

**Mohammad Asfin**  
*AI & Full Stack Developer*  
Java | Spring Boot | Hibernate | React | AI/ML  

[GitHub: Mohammad-Asfin](https://github.com/Mohammad-Asfin)

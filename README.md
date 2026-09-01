<div align="center">

# 🚀 Hibernate & ORM – Complete Learning Guide (Level 1 to 5)

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Hibernate](https://img.shields.io/badge/Hibernate-7.0.0.Beta3-green.svg)](https://hibernate.org/)
[![Database](https://img.shields.io/badge/Database-MySQL%20%7C%20PostgreSQL-blue.svg)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36.svg)](https://maven.apache.org/)

> A masterclass repository for learning Object Relational Mapping (ORM), Hibernate, database persistence, and performance tuning from Beginner to Advanced.

</div>

Welcome to the **Complete Beginner-to-Advanced Hibernate & ORM Learning Repository**! 

This repository is built for **Beginners, College Students, and Backend Developers** moving toward Spring Boot. It starts from raw SQL, moves through JDBC, explains the "Why" of ORM, and takes you all the way to advanced Caching, N+1 problem-solving, and Performance tuning.

---

## 📖 What You Will Learn

- **SQL Basics**: How relational databases work under the hood.
- **JDBC & The Boilerplate Problem**: Why developers invented ORM.
- **Hibernate Fundamentals**: Setup, Entity Mapping, CRUD.
- **Intermediate Concepts**: Entity Lifecycle, 1-to-1/1-to-N Relationships, Fetching (Lazy/Eager), HQL.
- **Advanced Hibernate**: 2nd Level Caching, N+1 Query Problem, Optimistic/Pessimistic Locking, Batch Processing.
- **The Ecosystem**: How JPA relates to Hibernate, and the bridge to Spring Data JPA.

---

## 🗺️ Complete Learning Roadmap

```text
BEGINNER 🟢
 │
 ├── 01-SQL-Fundamentals
 ├── 02-JDBC-to-ORM
 ├── 03-ORM-Fundamentals
 └── 04-Hibernate-Setup
 │
INTERMEDIATE 🟡
 │
 ├── 05-Entity-Mapping
 ├── 06-CRUD-Operations
 ├── 07-Entity-Lifecycle
 ├── 08-Relationships
 ├── 09-Fetching-and-Cascading
 ├── 10-HQL-and-Queries
 ├── 11-Native-SQL
 ├── 12-Persistence-Context
 └── 13-Transactions
 │
ADVANCED 🟠
 │
 ├── 14-ID-Generation
 ├── 15-Caching
 ├── 16-Performance
 └── 17-Advanced-Hibernate
 │
NEXT STEP 🔵
 │
 └── 18-JPA-vs-Hibernate
```

---

## ⚙️ How to Run the Projects

This repository uses **Maven**. You can run these modules using your favorite IDE or the command line.

### Option 1 — IntelliJ IDEA
1. Open IntelliJ IDEA.
2. Click **File > Open** and select the root `Hibernate` folder (or any specific module folder like `06-CRUD-Operations`).
3. IntelliJ will detect the `pom.xml` and download dependencies automatically.
4. Open any `Main.java` or `*Example.java` file.
5. Click the **Green Play Button** next to the `main` method.

### Option 2 — Eclipse
1. Open Eclipse.
2. Click **File > Import > Maven > Existing Maven Projects**.
3. Browse to the specific module folder (e.g., `06-CRUD-Operations`) and click Finish.
4. Wait for Maven to download dependencies.
5. Right-click the Java file containing the `main` method -> **Run As > Java Application**.

### Option 3 — Command Line
If you have Maven installed:
```bash
cd 06-CRUD-Operations
mvn clean compile exec:java -Dexec.mainClass="com.hibernate.learning.crud.CreateExample"
```

### What are Dependencies?
Dependencies (like the MySQL Driver and Hibernate Core) are external libraries your code needs to run. 
Maven reads the `pom.xml` file, connects to the central repository, and downloads them automatically into your local `.m2` folder. If dependencies are missing, right-click your project in your IDE and select **Maven > Reload Project** or run `mvn clean install` in the terminal.

---

## ❗ Troubleshooting

| Error | Cause | Solution |
|---|---|---|
| **Database Connection Failed** | MySQL/PostgreSQL is not running, or password in `hibernate.cfg.xml` is wrong. | Start your DB server. Check port (3306/5432). Update `YOUR_PASSWORD` in config. |
| **JDBC Driver Not Found** | Maven did not download the dependencies. | Reload Maven project or run `mvn clean install`. |
| **Unknown Entity** | You forgot the `@Entity` annotation or forgot to add `<mapping class="..."/>` in config. | Add `@Entity` to your class and `<mapping class="com.yourpackage.Class"/>` to `hibernate.cfg.xml`. |
| **Table Does Not Exist** | Database doesn't have the table, and `hbm2ddl.auto` is not set to `update`. | Set `<property name="hibernate.hbm2ddl.auto">update</property>` in your config. |
| **LazyInitializationException** | You tried to access a LAZY loaded collection after the Hibernate `Session` was closed. | Initialize the collection before closing the session, or use a `JOIN FETCH` in HQL. |
| **Transaction Required** | You tried to `persist()`, `merge()`, or `remove()` without starting a transaction. | Always wrap modifications in `session.beginTransaction()` and `transaction.commit()`. |

---

## 🎓 Interview Preparation

### Beginner Level
- **What is ORM?** Object Relational Mapping. It bridges the gap between object-oriented Java classes and relational database tables.
- **What is Hibernate?** An ORM framework for Java that implements the JPA specification.
- **What is an Entity?** A Java class mapped to a database table using the `@Entity` annotation.
- **What is Session?** A single-threaded, short-lived object representing a conversation between the application and the persistent store.
- **What is SessionFactory?** A thread-safe, heavyweight, immutable object that creates `Session` instances. Usually, there is one per database.

### Intermediate Level
- **What is the entity lifecycle?** The states an entity goes through: Transient, Persistent (Managed), Detached, and Removed.
- **What is LAZY loading?** Related entities/collections are only fetched from the database when their getter method is explicitly called.
- **What is cascading?** Propagating entity state transitions (like persist or remove) from a parent entity to its child entities.
- **What is dirty checking?** Hibernate automatically detects modifications to managed entities within a transaction and executes UPDATE statements upon commit.
- **What is HQL?** Hibernate Query Language. An object-oriented query language that queries Java objects and properties instead of database tables and columns.

### Advanced Level
- **What is the N+1 problem?** Executing 1 query to fetch a list of parent entities, and then N additional queries to fetch their related children. Solved via `JOIN FETCH`.
- **What is the second-level cache?** A cache scoped to the `SessionFactory`. It stores entity data across multiple sessions to reduce database hits.
- **What is optimistic locking?** Using a `@Version` field to prevent lost updates in highly concurrent applications without locking database rows.
- **How do you improve Hibernate performance?** Avoid N+1 queries, use pagination, enable batch inserts/updates, prefer LAZY fetching, and utilize caching.
- **What is the persistence context?** The first-level cache. A staging area within a `Session` where Hibernate manages persistent entities.

---

## 👨‍💻 Author

**Mohammad Asfin**  
*AI & Full Stack Developer*  
Java | Spring Boot | Hibernate | React | AI/ML  

[GitHub: Mohammad-Asfin](https://github.com/Mohammad-Asfin)

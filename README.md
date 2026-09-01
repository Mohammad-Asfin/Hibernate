<div align="center">

# 🚀 Hibernate & ORM – Complete Learning Guide

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Hibernate](https://img.shields.io/badge/Hibernate-7.0.0.Beta3-green.svg)](https://hibernate.org/)
[![Database](https://img.shields.io/badge/Database-MySQL%20%7C%20PostgreSQL-blue.svg)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36.svg)](https://maven.apache.org/)

> A beginner-friendly repository for learning Object Relational Mapping (ORM), Hibernate, database persistence, entity mapping, CRUD operations, HQL, and Native SQL.

</div>

Welcome to the **Hibernate & ORM Learning Guide**! This repository is designed to help beginners and intermediate developers understand how Java applications interact with relational databases. 

We take a comprehensive approach: learning raw SQL fundamentals first, then understanding how Hibernate maps Java objects (like `Student`) to database rows effortlessly.

---

## 📖 Table of Contents

- [Introduction](#-introduction)
- [Learning Progression](#-learning-progression)
- [What is ORM?](#-what-is-orm)
- [Hibernate Architecture](#-hibernate-architecture)
- [Repository Structure](#-repository-structure)
- [Prerequisites & Setup](#-prerequisites--setup)
  - [Option A: MySQL Setup](#option-a-mysql-setup-recommended)
  - [Option B: PostgreSQL Setup](#option-b-postgresql-setup)
- [Module 1: SQL Fundamentals](#module-1-sql-fundamentals)
- [Module 2: Entity Mapping](#module-2-entity-mapping)
- [Module 3: CRUD Operations](#module-3-crud-operations)
- [Module 4: HQL Queries](#module-4-hql-queries)
- [Module 5: Native SQL](#module-5-native-sql)
- [SQL vs Hibernate Comparison](#-sql-vs-hibernate-comparison)
- [Best Practices](#-best-practices)
- [Author](#-author)

---

## 🎓 Learning Progression

Follow this roadmap to master ORM:
1️⃣ **SQL Fundamentals** ↓ 2️⃣ **JDBC Basics** ↓ 3️⃣ **What is ORM?** ↓ 4️⃣ **Hibernate Setup** ↓ 5️⃣ **Entity Mapping** ↓ 6️⃣ **CRUD Operations** ↓ 7️⃣ **Relationships** ↓ 8️⃣ **HQL** ↓ 9️⃣ **Native SQL** ↓ 🔟 **Spring Data JPA**

---

## 🧠 What is ORM?

**ORM** stands for **Object Relational Mapping**. 

Java applications are object-oriented (**Java Objects**), but databases use **Tables, Rows, and Columns**. This creates an **object-relational impedance mismatch**. 

ORM acts as a bridge:
**Java Object** ↓ **ORM Framework** ↓ **Relational Database**

### The Impedance Mismatch Example

**Java Object:**
```java
Student student = new Student();
student.setName("Elena Gilbert");
student.setEmail("elena@example.com");
student.setAge(22);
```

**Database Table (`students`):**
| id | name | email | age |
|---|---|---|---|
| 1 | Elena Gilbert | elena@example.com | 22 |

**How ORM Maps It:**
- **Class** → Table (`Student` class maps to `students` table)
- **Object** → Row (An instance of `Student` is a row)
- **Field** → Column (`email` maps to `email` column)

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
       MySQL / PostgreSQL
```

---

## 📁 Repository Structure

The project is divided into logical, step-by-step modules:

```text
Hibernate/
├── 01-SQL-Fundamentals/             # Learn pure SQL before learning Hibernate
├── 02-Hibernate-Setup-PostgreSQL/   # Minimal setup for PostgreSQL
├── 03-Hibernate-Setup-MySQL/        # Minimal setup for MySQL
├── 04-Entity-Mapping/               # @Entity, @Id, @Column annotations
├── 05-CRUD-Operations/              # Create, Read, Update, Delete with Hibernate
├── 06-HQL-Queries/                  # Hibernate Query Language examples
├── 07-Native-SQL/                   # Raw SQL execution via Hibernate
└── README.md
```

---

## ⚙️ Prerequisites & Setup

- ☕ **Java JDK 21**
- 📦 **Maven**
- 🗄️ **MySQL** (Port 3306) or **PostgreSQL** (Port 5432)

### Option A: MySQL Setup (Recommended)
1. Install MySQL and start the server.
2. Create the database: `CREATE DATABASE hibernate_learning;`
3. In any module (e.g., `03-Hibernate-Setup-MySQL/src/main/resources/hibernate.cfg.xml`), configure the connection:
```xml
<property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_learning</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
```
*Note: Never commit your real database passwords to version control!*

### Option B: PostgreSQL Setup
1. Create a database `hibernate_learning` in pgAdmin/psql.
2. Update `hibernate.cfg.xml`:
```xml
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/hibernate_learning</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
```

---

## Module 1: SQL Fundamentals

Before diving into Hibernate, check out `01-SQL-Fundamentals/TVD_Characters.sql`. 
It contains practical SQL covering:

```sql
-- CREATE TABLE
CREATE TABLE students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    age INT
);

-- INSERT (Create)
INSERT INTO students (name, email, age) 
VALUES ('Elena Gilbert', 'elena@example.com', 22);

-- SELECT (Read)
SELECT * FROM students WHERE age > 20;

-- UPDATE (Update)
UPDATE students SET age = 24 WHERE name = 'Elena Gilbert';

-- DELETE (Delete)
DELETE FROM students WHERE name = 'Caroline Forbes';
```
*⚠️ Always use a `WHERE` clause in `UPDATE` and `DELETE` queries to prevent modifying the entire table!*

---

## Module 2: Entity Mapping

In `04-Entity-Mapping`, we map the `Student` Java class to the `students` table.

```java
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
}
```
- `@Entity`: Marks class as a persistent entity.
- `@Table`: Specifies table name.
- `@Id`: Marks primary key.
- `@GeneratedValue`: Auto-increments the ID.

---

## Module 3: CRUD Operations

See `05-CRUD-Operations` for complete examples.

### CREATE
```java
Student student = new Student("Damon Salvatore", "damon@example.com", 25);
session.persist(student);
```
**Hibernate Generated SQL:**
`INSERT INTO students (age, email, name) VALUES (?, ?, ?)`

### READ
```java
Student student = session.get(Student.class, 1L);
```
**Hibernate Generated SQL:**
`SELECT * FROM students WHERE id = ?`

### UPDATE
```java
Student student = session.get(Student.class, 1L);
student.setAge(26);
session.merge(student);
```

### DELETE
```java
Student student = session.get(Student.class, 1L);
session.remove(student);
```

---

## Module 4: HQL Queries

In `06-HQL-Queries`, we learn **Hibernate Query Language**. HQL works with Java Objects and properties, NOT tables and columns!

```java
// Select all students
Query<Student> query = session.createQuery("FROM Student", Student.class);
List<Student> students = query.list();

// Select with condition
Query<Student> query2 = session.createQuery("FROM Student WHERE age > 22", Student.class);
```

---

## Module 5: Native SQL

In `07-Native-SQL`, we use raw database SQL queries when HQL isn't enough (e.g., complex joins or DB-specific functions).

```java
String sql = "SELECT * FROM students";
NativeQuery<Student> query = session.createNativeQuery(sql, Student.class);
List<Student> students = query.list();
```

---

## 🧠 SQL vs Hibernate Comparison

| Operation | SQL (Manual) | Hibernate (Automatic) |
|---|---|---|
| **Insert** | `INSERT INTO students (name, email) VALUES ('Bonnie Bennett', 'bonnie@example.com');` | `session.persist(student);` |
| **Read** | `SELECT * FROM students WHERE id = 1;` | `session.get(Student.class, 1L);` |
| **Update** | `UPDATE students SET age = 23 WHERE id = 1;` | `student.setAge(23); session.merge(student);` |
| **Delete** | `DELETE FROM students WHERE id = 1;` | `session.remove(student);` |

---

## 💡 Best Practices

- **Use Meaningful Domain Names:** Avoid generic names like "Test" or "Alien". Use `Student`, `Employee`, `Character`.
- **Transactions:** Always wrap database modifications (`persist`, `merge`, `remove`) in a `Transaction`.
- **Auto DDL:** Use `hibernate.hbm2ddl.auto=update` for development, but switch to `validate` or `none` in production.
- **DTOs:** Do not expose raw entities to your REST API endpoints; convert them to Data Transfer Objects (DTOs) first.

---

## 👨‍💻 Author

**Mohammad Asfin**  
*AI & Full Stack Developer*  
Java | Spring Boot | Hibernate | React | AI/ML  

[GitHub: Mohammad-Asfin](https://github.com/Mohammad-Asfin)

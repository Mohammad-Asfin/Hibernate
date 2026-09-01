# 01 - SQL Fundamentals

Before diving into Hibernate and Object-Relational Mapping (ORM), you must understand the underlying language that Hibernate generates: **Structured Query Language (SQL)**.

## 📖 Concept
A Relational Database stores data in tables. Tables consist of rows (records) and columns (attributes). We use SQL to interact with this data.

## 🤔 Why Do We Need It?
Even though Hibernate writes SQL for us, we need to understand SQL to:
1. Design efficient database schemas.
2. Debug performance issues when Hibernate generates unexpected or slow queries.
3. Write Native SQL queries when HQL (Hibernate Query Language) isn't enough.

## 🧠 How It Works
```text
Database (e.g., MySQL)
  └── Tables (e.g., students)
        ├── Columns (id, name, age)
        └── Rows (1, "Elena Gilbert", 22)
```

## 💻 SQL Explanations

### 1. CREATE DATABASE
```sql
CREATE DATABASE hibernate_learning;
```
*Creates a new database specifically for our learning repository.*

### 2. CREATE TABLE
```sql
CREATE TABLE students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE,
    age INT
);
```
- **PRIMARY KEY**: Uniquely identifies each row.
- **AUTO_INCREMENT**: The database automatically generates the next ID (MySQL). For PostgreSQL, use `SERIAL`.
- **VARCHAR**: A string with a variable length.
- **NOT NULL**: The column cannot be empty.
- **UNIQUE**: No two students can have the same email.

### 3. INSERT (Create)
```sql
INSERT INTO students (name, email, age) 
VALUES ('Elena Gilbert', 'elena@example.com', 22);
```

### 4. SELECT (Read)
```sql
-- Read everything
SELECT * FROM students;

-- Read specific columns
SELECT name, email FROM students;

-- Read with condition
SELECT * FROM students WHERE age > 20;
```

### 5. UPDATE (Update)
```sql
UPDATE students SET age = 23 WHERE name = 'Elena Gilbert';
```

### 6. DELETE (Delete)
```sql
DELETE FROM students WHERE name = 'Caroline Forbes';
```

## ▶️ How to Run
1. Install MySQL (or PostgreSQL).
2. Open a database client (like MySQL Workbench, DBeaver, or pgAdmin).
3. Connect to your local server.
4. Open `TVD_Characters.sql` from this folder and execute the scripts.

## ⚠️ Common Mistakes
- **Forgetting the WHERE clause in UPDATE/DELETE**: If you run `DELETE FROM students;`, it will delete **every** record in the table! Always use a `WHERE` clause.
- **Mismatching Data Types**: Trying to insert a string into an `INT` column will throw an error.

## 💡 Key Takeaway
SQL is the foundation of data persistence. Hibernate is just a tool that generates this SQL for you. Master SQL, and you will master Hibernate.

# 06 - CRUD Operations

## 📖 Concept
CRUD stands for **Create, Read, Update, Delete**. These are the four basic functions of persistent storage.

## 🤔 Why Do We Need It?
Instead of writing manual SQL `INSERT`, `SELECT`, `UPDATE`, and `DELETE` queries using JDBC, Hibernate allows us to simply call methods on the `Session` object.

## 🧠 How It Works
```text
Java Method              Hibernate Action           Generated SQL
session.persist(obj)  -> Saves to DB             -> INSERT INTO...
session.get(class,id) -> Fetches from DB         -> SELECT * FROM...
session.merge(obj)    -> Updates DB              -> UPDATE...
session.remove(obj)   -> Deletes from DB         -> DELETE FROM...
```

## 💻 Code Examples & 🗄️ SQL Concepts

### 1. CREATE (`CreateExample.java`)
```java
Student student = new Student("Stefan Salvatore", "stefan@example.com", 162);
session.persist(student);
```
**Hibernate Generated SQL:**
`INSERT INTO students (age, email, name) VALUES (?, ?, ?)`

### 2. READ (`ReadExample.java`)
```java
Student student = session.get(Student.class, 1L);
```
**Hibernate Generated SQL:**
`SELECT * FROM students WHERE id = ?`
*(If the ID doesn't exist, `get()` returns `null`)*

### 3. UPDATE (`UpdateExample.java`)
```java
Student student = session.get(Student.class, 1L);
student.setAge(163);
// In a transaction, Hibernate automatically detects changes (Dirty Checking)
session.merge(student);
```
**Hibernate Generated SQL:**
`UPDATE students SET age=?, email=?, name=? WHERE id=?`

### 4. DELETE (`DeleteExample.java`)
```java
Student student = session.get(Student.class, 1L);
session.remove(student);
```
**Hibernate Generated SQL:**
`DELETE FROM students WHERE id=?`

## ▶️ How to Run
Run each file individually to see how Hibernate manipulates the database. 
1. Run `CreateExample.java` first to add a record.
2. Run `ReadExample.java` to fetch it.
3. Run `UpdateExample.java` to modify it.
4. Run `DeleteExample.java` to remove it.

## ⚠️ Common Mistakes
- **Forgetting Transactions**: You **MUST** start and commit a transaction for Create, Update, and Delete operations. If you forget `transaction.commit()`, nothing will be saved!
- **Using `update()` instead of `merge()`**: In Hibernate 6/7, `update()` is deprecated/removed. Use `merge()` or rely on automatic Dirty Checking.

## 💡 Key Takeaway
CRUD in Hibernate is incredibly simple. You interact with Java objects and methods, and Hibernate takes care of the raw SQL.

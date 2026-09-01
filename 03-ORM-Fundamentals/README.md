# 03 - ORM Fundamentals

## 📖 Concept
**ORM** stands for **Object-Relational Mapping**. It is a programming technique that converts data between incompatible type systems using object-oriented programming languages.

In Java, we deal with **Objects** (`Student`, `Course`). In relational databases, we deal with **Tables** (`students`, `courses`). ORM is the bridge between the two.

## 🤔 Why Do We Need It?
We need ORM to solve the **Object-Relational Impedance Mismatch**.

### The Impedance Mismatch
Java and Relational Databases handle data completely differently:
1. **Granularity**: Sometimes you have an object in Java (e.g., `Address`) that doesn't correspond to a specific table in the database (it might just be columns inside the `users` table).
2. **Inheritance**: Java heavily uses inheritance (`Employee` extends `Person`). Relational databases do not understand inheritance natively.
3. **Identity**: Java defines object equality by `==` (memory address) and `equals()` (value). Databases define equality via Primary Keys.
4. **Associations**: Java represents associations via object references (a `Student` has a `List<Course>`). Databases represent associations via Foreign Keys.
5. **Data Navigation**: In Java, you navigate data by calling methods (`student.getDepartment().getName()`). In databases, you join tables (`SELECT d.name FROM departments d JOIN students s...`).

## 🧠 How It Works
ORM acts as an invisible mapping layer.

**JAVA WORLD** <---- ORM (Hibernate) ----> **DATABASE WORLD**
`Class` <--------------------------------> `Table`
`Object` <-------------------------------> `Row`
`Field / Property` <---------------------> `Column`
`Object Reference` <---------------------> `Foreign Key`

### Example
Instead of writing SQL to save a student:
```sql
INSERT INTO students (name, email) VALUES ('Damon Salvatore', 'damon@example.com');
```

You just tell the ORM to save the Java Object:
```java
Student student = new Student("Damon Salvatore", "damon@example.com");
session.persist(student);
```
Hibernate intercepts `session.persist()`, reads the metadata annotations (`@Entity`, `@Table`), generates the SQL `INSERT` statement, and sends it to the database via JDBC.

## 💡 Key Takeaway
ORM frees developers from writing repetitive JDBC boilerplate and manual SQL. It allows you to think in terms of Business Objects rather than Database Tables. **Hibernate** is the most popular ORM framework in the Java ecosystem.

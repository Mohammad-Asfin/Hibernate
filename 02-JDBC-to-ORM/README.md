# 02 - JDBC to ORM

Before ORM frameworks like Hibernate existed, Java developers used **JDBC (Java Database Connectivity)** to interact with databases. 

## 📖 Concept
JDBC is the core API in Java for connecting to relational databases. It allows you to execute raw SQL queries, retrieve a `ResultSet`, and manually map the data into Java objects.

## 🤔 Why Do We Need It?
JDBC is incredibly fast and gives you ultimate control over the SQL being executed. However, for large applications, it becomes difficult to maintain.

## 🧠 How It Works
```text
Java Application
       │
     JDBC API (Connection, PreparedStatement, ResultSet)
       │
 Database Driver (e.g., MySQL Connector/J)
       │
 Relational Database (MySQL, PostgreSQL)
```

## 💻 Code Example
Look at `JDBCExample.java` in this module. Notice how much code is required just to perform a simple `SELECT` query:
1. Open Connection.
2. Prepare Statement.
3. Pass variables to the statement manually.
4. Execute Query.
5. Loop through the `ResultSet`.
6. Extract each column by name (`rs.getString("name")`).
7. Create a Java Object manually.
8. Manually close `ResultSet`, `PreparedStatement`, and `Connection` in a `finally` block to prevent memory leaks.

## ⚠️ The Problem with JDBC
If you have 50 tables, you have to write this **boilerplate code** hundreds of times. 
- ❌ Too much boilerplate code.
- ❌ Hardcoded SQL queries (if the DB changes from MySQL to Oracle, you have to rewrite queries).
- ❌ Manual `ResultSet` mapping is prone to typos (e.g., typing `"nam"` instead of `"name"`).
- ❌ Connection leaks are common if developers forget to close resources.

## 💡 Key Takeaway
JDBC is powerful, but it's tedious for standard CRUD operations. We need a tool that can automatically map Database Rows to Java Objects. That tool is **ORM (Object Relational Mapping)**.

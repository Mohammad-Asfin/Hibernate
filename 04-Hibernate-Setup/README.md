# 04 - Hibernate Setup

This module contains minimal, working configurations for both **MySQL** and **PostgreSQL**.

## 📖 Concept
Before Hibernate can map objects to tables, it needs to know how to connect to your database. This is configured in a file typically named `hibernate.cfg.xml`.

## 🤔 Why Do We Need It?
Hibernate is database-agnostic. The exact same Java code can save an object to MySQL or PostgreSQL. All you have to do is change the connection URL, credentials, and the **Dialect** in the configuration file.

## 🧠 How It Works (Hibernate Architecture)

```text
       Java Application
              │
              ▼
          Hibernate
              │
       ├── Configuration (Reads hibernate.cfg.xml)
       ├── SessionFactory (Heavyweight, created once per DB)
       ├── Session (Lightweight, created per transaction)
       ├── Transaction (Unit of work)
              │
              ▼
            JDBC
              │
              ▼
       MySQL / PostgreSQL
```

- **Configuration**: Reads the `hibernate.cfg.xml` and mapping files.
- **SessionFactory**: A heavy, thread-safe object. You should only create ONE SessionFactory per database in your application.
- **Session**: A lightweight, non-thread-safe object that represents a single unit of work (like a database connection).
- **Transaction**: Used to wrap operations (save, update, delete) to ensure ACID properties.

## 💻 Configurations Provided

We have provided two separate projects to demonstrate setup:

### 🐬 Option A: MySQL Setup
Check the `MySQL/` folder.
**Key Properties:**
```xml
<property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_learning</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
```

### 🐘 Option B: PostgreSQL Setup
Check the `PostgreSQL/` folder.
**Key Properties:**
```xml
<property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/hibernate_learning</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
<property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
```

## ⚠️ Common Mistakes
- **Committing Passwords**: Never commit your real database passwords to version control (like GitHub).
- **Wrong Dialect**: If you use the MySQL dialect for a PostgreSQL database, Hibernate might generate invalid SQL.
- **Creating multiple SessionFactories**: Creating a `SessionFactory` is very slow. Create it once when your application starts and reuse it.

## 💡 Key Takeaway
Setting up Hibernate requires configuring the JDBC driver, the connection URL, credentials, and the SQL Dialect. Once configured, Hibernate handles the rest!

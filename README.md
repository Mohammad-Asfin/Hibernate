<div align="center">

# 🚀 Hibernate & ORM – Complete Learning Guide

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Hibernate](https://img.shields.io/badge/Hibernate-7.0.0.Beta3-green.svg)](https://hibernate.org/)
[![Database](https://img.shields.io/badge/Database-MySQL%20%7C%20PostgreSQL-blue.svg)](https://www.mysql.com/)
[![Maven](https://img.shields.io/badge/Build-Maven-C71A36.svg)](https://maven.apache.org/)

> A beginner-to-advanced repository for learning Object Relational Mapping (ORM), Hibernate, database persistence, entity mapping, CRUD operations, HQL, Native SQL, and Performance Tuning.

</div>

Welcome to the **Complete Beginner-to-Advanced Hibernate & ORM Learning Repository**! 

This repository is designed to teach you Hibernate step by step. Even if you have **never** used Hibernate, Maven, or a database before, this guide will hold your hand through the entire setup and learning process.

---

# ▶️ How to Run This Repository

To run the examples in this repository, you will need a few tools installed on your computer. Different examples may require:
- ☕ **Java** (JDK 21)
- 📦 **Maven**
- 🗄️ **MySQL** OR **PostgreSQL**
- 💻 **Eclipse** or **IntelliJ IDEA**

Please follow the setup instructions below carefully.

---

## 1️⃣ INSTALL JAVA

**What is Java/JDK?**
Java is the programming language we are using. The **JDK (Java Development Kit)** provides the tools to write, compile, and run Java code.

This project requires **Java 21**.

**How to verify your installation:**
Open your terminal/command prompt and run:
```bash
java -version
```
*This checks your Java Runtime (can it run Java programs?).*

```bash
javac -version
```
*This checks your Java Compiler (can it turn your code into runnable programs?).*

---

## 2️⃣ INSTALL MAVEN

### 🤔 What is Maven?
Maven is a build automation tool. Instead of you manually downloading every single library your project needs (like Hibernate and the MySQL driver) and putting them in a folder, Maven does it for you.

```text
Java Project
      ↓
Maven
      ├── Downloads Dependencies
      ├── Compiles Code
      ├── Runs Tests
      └── Builds Project
```

**For example:**
```text
Your Java Project
        ↓
Needs Hibernate
        ↓
Needs Database Driver
        ↓
Maven Downloads Them Automatically
```

You normally do NOT manually download every `.jar` file when Maven is configured correctly.

**How to verify Maven:**
```bash
mvn -version
```

---

## 3️⃣ CLONE THE REPOSITORY

To get these files on your computer, you need to use `git clone`.

```bash
git clone https://github.com/Mohammad-Asfin/Hibernate.git
```
*`git clone` downloads the repository files from GitHub to your computer.*

```bash
cd Hibernate
```
*`cd Hibernate` moves your terminal into the newly downloaded project folder.*

---

## 4️⃣ UNDERSTAND THE PROJECT STRUCTURE

This repository is broken down into 18 logical learning modules.

```text
Hibernate/
│
├── 01-SQL-Fundamentals/             # Learn pure SQL before learning Hibernate
├── 02-JDBC-to-ORM/                  # The boilerplate of JDBC
├── 03-ORM-Fundamentals/             # What is Object-Relational Mapping?
├── 04-Hibernate-Setup/              # Minimal configurations for MySQL & PostgreSQL
├── 05-Entity-Mapping/               # @Entity, @Id, @Column annotations
├── 06-CRUD-Operations/              # Create, Read, Update, Delete with Hibernate
├── 07-Entity-Lifecycle/             # Transient, Persistent, Detached, Removed
├── 08-Relationships/                # One-to-One, One-to-Many, etc.
├── 09-Fetching-and-Cascading/       # Lazy vs Eager fetching
├── 10-HQL-and-Queries/              # Hibernate Query Language examples
├── 11-Native-SQL/                   # Raw SQL execution via Hibernate
├── 12-Persistence-Context/          # 1st Level Cache & Dirty Checking
├── 13-Transactions/                 # ACID properties
├── 14-ID-Generation/                # AUTO, IDENTITY, SEQUENCE
├── 15-Caching/                      # 2nd Level Cache
├── 16-Performance/                  # N+1 Problem, Batching, Locking
├── 17-Advanced-Hibernate/           # Embeddable, Inheritance
├── 18-JPA-vs-Hibernate/             # Ecosystem context
│
├── .gitignore                       # Tells Git which files to ignore
└── README.md                        # The file you are reading now!
```

**Inside each module folder**, you will find a standard Maven structure:
```text
ModuleName/
│
├── src/
│   ├── main/
│   │   ├── java/         <-- Java source code here
│   │   └── resources/    <-- Configuration files (hibernate.cfg.xml) here
│
└── pom.xml               <-- Maven configuration for this specific module
```

---

# 📦 DEPENDENCIES SECTION

### 🤔 What Are Dependencies?
Dependencies are external libraries written by other developers that your project needs to function.

```text
Your Application
        │
        ├── Hibernate Library (Does the ORM mapping)
        │
        ├── MySQL JDBC Driver (Connects Java to MySQL)
        │
        └── PostgreSQL JDBC Driver (Connects Java to PostgreSQL)
```

---

# 📄 EXPLAIN pom.xml

The `pom.xml` (Project Object Model) is the heart of a Maven project. It tells Maven how to build the project and what dependencies to download.

```text
pom.xml
    ↓
Project Configuration
    ↓
Dependencies
    ↓
Build Configuration
    ↓
Java Version
```

### Important Dependencies in this Repository:

1. **Hibernate Core (`hibernate-core`)**
   - **Why is it needed?** It is the actual ORM framework doing all the work.
   - **What happens if missing?** Your code will not recognize annotations like `@Entity`.

2. **MySQL Connector (`mysql-connector-j`)**
   - **Why is it needed?** Allows Java to talk to a MySQL database.
   - **What happens if missing?** Hibernate will fail to connect, throwing a "JDBC Driver Not Found" error.

3. **PostgreSQL Driver (`postgresql`)**
   - **Why is it needed?** Allows Java to talk to a PostgreSQL database.

**How does Maven download it?**
Maven reads the `pom.xml`, connects to the Maven Central Repository on the internet, and downloads the `.jar` files into a hidden `.m2` folder on your computer.

---

# 🔄 HOW TO DOWNLOAD DEPENDENCIES

If you are using the Command Line:
```bash
mvn clean install
```

```text
mvn
↓
Runs Maven

clean
↓
Removes previous generated build files (deletes target/ folder)

install
↓
Compiles the project
Downloads required dependencies
Creates the final build output in the target/ folder
```

*(Note: Most modern IDEs like Eclipse and IntelliJ will run this automatically for you when you open the project!)*

---

# 🟣 ECLIPSE — HOW TO IMPORT AND RUN

## Step 1: Open Eclipse
## Step 2: Import Project
Select:
```text
File
↓
Import
↓
Maven
↓
Existing Maven Projects
```
## Step 3: Select the cloned Hibernate project folder.
You can import the root folder or individual module folders.
## Step 4: Wait for Maven to download dependencies.
Watch the bottom right corner of Eclipse for a progress bar.
## Step 5: If dependencies show errors...
```text
Right Click Project
        ↓
Maven
        ↓
Update Project
```
## Step 6: Configure the database.
Open `src/main/resources/hibernate.cfg.xml` and add your database password.
## Step 7: Find the example's main class.
Look inside `src/main/java`. Find a file with:
```java
public static void main(String[] args)
```
## Step 8: Run
Right-click the class file in the Package Explorer:
```text
Run As
   ↓
Java Application
```
## Step 9: Check Console Output.
Verify that Hibernate successfully executed the SQL.
## Step 10: Verify the database.
Open MySQL/PostgreSQL and verify the data was actually inserted.

---

# 🔵 INTELLIJ IDEA — HOW TO IMPORT AND RUN

```text
Open
    ↓
Select Hibernate Project Folder
    ↓
IntelliJ Detects pom.xml
    ↓
Maven Dependencies Download Automatically
```

1. **Configure the JDK**: Go to `File > Project Structure` and ensure JDK 21 is selected.
2. **Reload Maven**: If dependencies are red, right-click `pom.xml` -> `Maven` -> `Reload project`.
3. **Configure Database**: Update your password in `hibernate.cfg.xml`.
4. **Find `main()`**: Open a Java file containing `public static void main`.
5. **Run**: Click the green Play button next to the line numbers.
6. **Check Console**: Ensure no errors occurred.

---

# 💻 COMMAND LINE — HOW TO RUN

Each module is a separate Maven project. To run an example from the command line, navigate into the specific module folder.

First, compile the code and download dependencies:
```bash
cd 06-CRUD-Operations
mvn clean install
```

Then, run the specific main class:
```bash
mvn exec:java -Dexec.mainClass="com.hibernate.learning.crud.CreateExample"
```
> **Note**: Each example has its own `main()` method and should be run individually. There is no "global" command to run everything at once.

---

# 🗄️ DATABASE SETUP

Before running any Java code, your database must be running. You can choose either MySQL or PostgreSQL. 

> You only need to configure the database that the specific example uses.

## 🐬 Option A — MySQL (Beginner Setup)

### Step 1 — Install MySQL
Ensure MySQL Server and MySQL Workbench (or another client) are installed.
### Step 2 — Start MySQL Server
Verify the service is running (e.g., via Task Manager on Windows or Activity Monitor on Mac).
### Step 3 — Create Database
Open MySQL Workbench and execute:
```sql
CREATE DATABASE hibernate_learning;
USE hibernate_learning;
```
*(This creates the database container where our tables will live, and tells MySQL we want to use it.)*

### Step 4 — Configure Hibernate
Open `hibernate.cfg.xml` in your module.
```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_learning</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
```
**Understanding the URL:**
```text
jdbc:mysql      --> Protocol and Driver type
localhost       --> The database is on this computer
3306            --> Default MySQL port
hibernate_learning -> The database name we just created
```

### Step 5 — Run the Example
Run your `Main.java` class.

### Step 6 — Verify Database Data
In MySQL Workbench, run:
```sql
SELECT * FROM students;
```
```text
Java Application
        ↓
Hibernate
        ↓
MySQL
        ↓
Table Created / Data Inserted!
```

---

## 🐘 Option B — PostgreSQL (Beginner Setup)

### Step 1 — Install PostgreSQL
Ensure PostgreSQL and pgAdmin are installed and running.
### Step 2 — Start Server
Verify the PostgreSQL service is active.
### Step 3 — Create Database
In pgAdmin, right click "Databases" -> Create -> Database named `hibernate_learning`.

### Step 4 — Configure Hibernate
```xml
<property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/hibernate_learning</property>
<property name="hibernate.connection.username">postgres</property>
<property name="hibernate.connection.password">YOUR_PASSWORD</property>
```
**Understanding the URL:**
```text
jdbc:postgresql --> Protocol and Driver type
localhost       --> Database location
5432            --> Default PostgreSQL port
hibernate_learning -> Database Name
```

---

# 🚨 THE `.gitignore` SECTION

## 🙈 What is .gitignore?
`.gitignore` tells Git which files and folders should **not** normally be tracked and uploaded to the repository (GitHub).

```text
Your Project
│
├── Source Code          ✅ Upload to GitHub
├── README.md            ✅ Upload to GitHub
├── pom.xml              ✅ Upload to GitHub
│
├── target/              ❌ Ignore
├── *.class              ❌ Ignore
└── IDE Files            ❌ Usually Ignore
```

## 🤔 WHY DO WE IGNORE `target/`?

```text
Source Code
     ↓
Maven Build
     ↓
target/
     ↓
Compiled Files (.class, .jar)
```

The `target/` folder contains generated files that take up a lot of space. Because these files can always be generated again from the source code, we don't upload them to GitHub.

## 🔥 VERY IMPORTANT QUESTION
### ❓ If `target/` is ignored, how do we get it again?

You do **NOT** download `target/` from GitHub. Instead, you generate it yourself!

```bash
mvn clean install
```

```text
GitHub Repository
        ↓
Clone (Download)
        ↓
Source Code + pom.xml
        ↓
Run: mvn clean install
        ↓
Maven Downloads Dependencies
        ↓
Maven Compiles Code
        ↓
target/ Created Automatically!
```

## 📦 RECOMMENDED `.gitignore`
Here is the file used in this repository:
```gitignore
# Compiled class files
*.class

# Maven build output (Contains compiled code, do not track!)
target/
pom.xml.tag
pom.xml.releaseBackup

# Eclipse IDE files (Specific to your computer)
.classpath
.project
.settings/
.metadata/

# IntelliJ IDEA files (Specific to your computer)
.idea/
*.iml

# MacOS generated files
.DS_Store
```

## ⚠️ VERY IMPORTANT: `.gitignore` DOES NOT REMOVE ALREADY TRACKED FILES
If you accidentally uploaded `target/` to GitHub *before* you created the `.gitignore`, Git will continue to track it!

```text
target/
        ↓
Already uploaded to GitHub
        ↓
Add target/ to .gitignore
        ↓
Git may still track it ❌
```

**How to fix it:**
You must remove it from Git's tracking index manually:
```bash
git rm -r --cached target
```
Then commit and push:
```bash
git commit -m "Remove generated build files from repository"
git push
```
```text
--cached
        ↓
Removes files from Git tracking
BUT
Keeps local files on your computer!
```

## 🔍 HOW TO CHECK IF A FILE IS IGNORED
Run:
```bash
git status
```
*Shows what files Git is currently tracking or trying to commit.*

```bash
git check-ignore -v target
```
*Tells you exactly which rule in your `.gitignore` is telling Git to ignore the `target` folder.*

---

# 🧪 EVERY MODULE'S RUNNING FORMAT

Every single learning module inside this repository (from `01` to `18`) follows a strict structure to help you learn. In their respective `README.md` files, you will find:

```text
📖 What You Will Learn / Concept
🤔 Why Do We Need It?
🧠 How It Works (Internal concepts)
💻 Code Example
🗄️ SQL Generation Concept
▶️ How to Run
📊 Expected Output
⚠️ Common Mistakes
💡 Key Takeaway
```

*(Go into any folder like `06-CRUD-Operations` to see this format in action!)*

---

# ❌ COMPLETE TROUBLESHOOTING

If you hit a roadblock, check here first:

## ❌ Maven Dependencies Not Downloading
**Cause**: Maven failed to sync.
**Solution**:
```bash
mvn clean install
```
**Eclipse**: Right Click Project -> Maven -> Update Project.
**IntelliJ**: Right Click `pom.xml` -> Maven -> Reload Project.

## ❌ Database Connection Failed
**Checklist**:
- [ ] Database Server is Running (Check Task Manager/Activity Monitor)
- [ ] Correct Port (3306 for MySQL, 5432 for Postgres)
- [ ] Correct Database Name (`hibernate_learning`) created in your DB client.
- [ ] Correct Username (`root` / `postgres`)
- [ ] Correct Password updated in `hibernate.cfg.xml`
- [ ] Correct JDBC URL

## ❌ JDBC Driver Not Found
**Cause**: The database driver is missing from your project.
**Solution**:
```text
Check pom.xml
        ↓
Verify MySQL/PostgreSQL Dependency exists
        ↓
Reload Maven
```

## ❌ Unknown Entity
**Cause**: Hibernate doesn't recognize your Java class.
**Solution**:
1. Ensure the class has the `@Entity` annotation.
2. Ensure the class is registered in `hibernate.cfg.xml` via `<mapping class="com.yourpackage.YourClass"/>`.

## ❌ Table Does Not Exist
**Cause**: The database doesn't have the table created yet.
**Solution**: Ensure `<property name="hibernate.hbm2ddl.auto">update</property>` is set in your configuration, so Hibernate creates the table for you.

## ❌ `target/` Folder Missing
**Cause**: You just cloned the repository. This is normal!
**Solution**: Run your code in your IDE, or run `mvn clean install`. Maven will generate the `target/` folder automatically.

## ❌ LazyInitializationException
**Cause**: You tried to fetch data related to an entity *after* the `Session` was closed.
**Solution**: Initialize the data while the session is open, or use a `JOIN FETCH` query in HQL.

## ❌ Transaction Required
**Cause**: You called `persist()`, `merge()`, or `remove()` without an active transaction.
**Solution**: Wrap your modifications in `session.beginTransaction()` and `transaction.commit()`.

---

# 🎓 INTERVIEW PREPARATION

### Beginner Level
- **What is ORM?** Object Relational Mapping. It bridges the gap between object-oriented Java classes and relational database tables.
- **What is Hibernate?** An ORM framework for Java that implements the JPA specification.
- **What is an Entity?** A Java class mapped to a database table using the `@Entity` annotation.
- **What is Session?** A single-threaded, short-lived object representing a conversation between the application and the database.
- **What is SessionFactory?** A thread-safe, heavyweight object that creates `Session` instances. Usually, there is one per database.

### Intermediate Level
- **What is the entity lifecycle?** The states an entity goes through: Transient, Persistent (Managed), Detached, and Removed.
- **What is LAZY loading?** Related entities are only fetched from the database when their getter method is explicitly called.
- **What is cascading?** Propagating entity state transitions (like persist or remove) from a parent entity to its child entities.
- **What is dirty checking?** Hibernate automatically detects modifications to managed entities within a transaction and executes UPDATE statements upon commit.
- **What is HQL?** Hibernate Query Language. An object-oriented language that queries Java objects and properties instead of tables and columns.

### Advanced Level
- **What is the N+1 problem?** Executing 1 query to fetch a list of parent entities, and then N additional queries to fetch their related children. Solved via `JOIN FETCH`.
- **What is the second-level cache?** A cache scoped to the `SessionFactory` that stores entity data across multiple sessions to reduce database hits.
- **What is optimistic locking?** Using a `@Version` field to prevent lost updates in highly concurrent applications without locking database rows.
- **How do you improve Hibernate performance?** Avoid N+1 queries, use pagination, enable batch inserts/updates, prefer LAZY fetching, and utilize caching.
- **What is the persistence context?** The first-level cache. A staging area within a `Session` where Hibernate manages persistent entities.

---

## 👨‍💻 Author

**Mohammad Asfin**  
*AI & Full Stack Developer*  
Java | Spring Boot | Hibernate | React | AI/ML  

[GitHub: Mohammad-Asfin](https://github.com/Mohammad-Asfin)

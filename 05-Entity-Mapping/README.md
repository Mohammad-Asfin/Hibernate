# 05 - Entity Mapping

## 📖 Concept
Entity Mapping is the process of telling Hibernate how a specific Java class connects to a specific database table.

## 🤔 Why Do We Need It?
Without mapping, Hibernate doesn't know which class belongs to which table, or which property belongs to which column. We provide this metadata using **JPA Annotations**.

## 🧠 How It Works
```text
JAVA CLASS                       DATABASE TABLE
@Entity
@Table(name="students")  ====>   Table: students
class Student {

  @Id                    ====>   Primary Key
  @GeneratedValue        ====>   AUTO_INCREMENT
  Long id;

  @Column(name="name")   ====>   Column: name
  String name;
}
```

## 💻 Code Example
Look at `Student.java` in this module.

```java
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "email", unique = true)
    private String email;
    
    @Column(name = "age")
    private int age;
    
    // Getters and Setters...
}
```

## 🗄️ SQL Concept
When Hibernate starts, if `hibernate.hbm2ddl.auto` is set to `update`, it generates this SQL automatically based on the annotations:
```sql
CREATE TABLE students (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    age INT,
    PRIMARY KEY (id)
);
```

## ▶️ How to Run
1. Run `Main.java` in this module.
2. It simply builds the `SessionFactory`.
3. Check your database or console output. You will see Hibernate generate the `CREATE TABLE` query automatically!

## ⚠️ Common Mistakes
- **Forgetting `@Entity`**: If you forget this, Hibernate will throw an `UnknownEntityException`.
- **Forgetting `@Id`**: Every entity *must* have a primary key!
- **Missing No-Argument Constructor**: Hibernate requires a default, no-argument constructor (e.g., `public Student() {}`) to instantiate objects via reflection.

## 💡 Key Takeaway
Mapping is done via simple JPA annotations. Once mapped, Hibernate can automatically translate between your Java objects and database rows.

# One-to-One Relationship

## 📖 Concept
A One-to-One relationship means that one row in Table A is linked to exactly one row in Table B.
For example, one `Student` has exactly one `StudentProfile`.

## 🤔 Why Do We Need It?
Instead of putting 50 columns into a single `students` table, it is often better database design to split the data into smaller, logical tables (like `student_profiles` for extended data). Hibernate maps this structure into separate Java Objects.

## 🧠 How It Works
```text
Table: students               Table: student_profiles
+----+---------------+        +----+--------------------+
| id | name          |        | id | bio                |
+----+---------------+        +----+--------------------+
| 1  | Elena Gilbert | -----> | 1  | Human/Doppelgänger |
+----+---------------+        +----+--------------------+
        (Foreign Key: profile_id)
```

## 💻 Code Example
Look at `Student.java`:
```java
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "profile_id")
private StudentProfile profile;
```
- `@OneToOne`: Tells Hibernate about the relationship.
- `@JoinColumn`: Tells Hibernate *this* table (`students`) will hold the foreign key named `profile_id`.

## 🗄️ SQL Concept
When you run `session.persist(student);`:
1. Hibernate generates: `INSERT INTO student_profiles (bio, linkedInUrl) VALUES (?, ?)`
2. It grabs the generated profile ID.
3. Hibernate generates: `INSERT INTO students (name, profile_id) VALUES (?, ?)`

## ▶️ How to Run
Run `OneToOneExample.java` and observe the SQL output in the console.

## ⚠️ Common Mistakes
- **Forgetting Cascade**: If you don't use `cascade = CascadeType.ALL`, you will have to manually save the `profile` before saving the `student`. If you don't, Hibernate throws a `TransientPropertyValueException`.
- **Wrong Owning Side**: Always put the `@JoinColumn` on the class that corresponds to the database table containing the Foreign Key.

## 💡 Key Takeaway
One-to-One is the simplest relationship. The class that has the `@JoinColumn` is the **Owning Side** and controls the Foreign Key in the database.

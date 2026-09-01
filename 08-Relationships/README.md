# 08 - Relationships

## 📖 Concept
In a relational database, tables are connected via Foreign Keys. In Java, objects are connected via object references (e.g., `student.getProfile()`). Hibernate bridges these two paradigms using **Relationship Annotations**.

## 🤔 Why Do We Need It?
Without relationships, you would have to manually fetch the `Student` object, manually extract a foreign key, and manually execute another query to get their `Profile`. Hibernate can do all of this automatically if you define the relationship correctly.

## 📁 Sub-Modules
This module is divided into 4 sub-directories, covering the four cardinalities of relationships:

### 1. [One-to-One](./OneToOne)
- **Concept**: One `Student` has exactly one `StudentProfile`.
- **Annotations**: `@OneToOne`, `@JoinColumn`
- **Example**: `Elena Gilbert` -> `Profile Details`

### 2. [One-to-Many](./OneToMany)
- **Concept**: One `Department` has multiple `Employees`.
- **Annotations**: `@OneToMany` (often paired with `@ManyToOne` for bidirectionality)
- **Example**: `Vampire Department` -> `Stefan`, `Damon`

### 3. [Many-to-One](./ManyToOne)
- **Concept**: Multiple `Employees` belong to one `Department`.
- **Annotations**: `@ManyToOne`, `@JoinColumn`
- **Example**: `Klaus Mikaelson` -> `Originals Department`

### 4. [Many-to-Many](./ManyToMany)
- **Concept**: Multiple `Students` enroll in multiple `Courses`.
- **Annotations**: `@ManyToMany`, `@JoinTable`
- **Example**: `Bonnie Bennett`, `Caroline Forbes` -> `Witchcraft 101`, `Vampirism 101`

## ⚠️ Important Rule: The "Owning Side"
In any bidirectional relationship, one side must be the "owner" of the relationship (the table that actually holds the Foreign Key). The non-owning side must use the `mappedBy` attribute.
If you don't define `mappedBy` correctly, Hibernate might create unnecessary join tables!

*Navigate into each subfolder to see the runnable Java examples and database mappings.*

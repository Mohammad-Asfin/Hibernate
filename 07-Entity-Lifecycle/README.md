# 07 - Entity Lifecycle

## 📖 Concept
An entity in Hibernate exists in one of four states at any given time. This is known as the **Entity Lifecycle**.
The states are: **Transient**, **Persistent (Managed)**, **Detached**, and **Removed**.

## 🤔 Why Do We Need It?
Understanding the lifecycle is crucial because Hibernate behaves differently depending on the state of the entity. If you try to update a "Detached" entity, Hibernate won't track the changes automatically!

## 🧠 How It Works

```text
       new()
         │
         ▼
    TRANSIENT  ──────┐
         │           │
     persist()       │
         │           │
         ▼           │
    PERSISTENT       │
         │           │
close() / detach()   │
         │           │
         ▼           │
     DETACHED        │
         │           │
      remove()       │
         │           │
         ▼           │
      REMOVED  <─────┘
```

1. **Transient**: An object is instantiated using `new()`, but it has no connection to the Hibernate `Session` and has no database representation (no ID).
2. **Persistent (Managed)**: The object is currently associated with an active `Session`. Any changes to its properties will automatically trigger an `UPDATE` in the database upon commit (Dirty Checking).
3. **Detached**: The `Session` has been closed or cleared. The object still exists in Java memory, but Hibernate is no longer tracking its changes.
4. **Removed**: The object has been scheduled for deletion via `session.remove()`.

## 💻 Code Example
Look at `EntityLifecycleExample.java`. It practically demonstrates moving an entity through all 4 stages.

## ▶️ How to Run
1. Configure `hibernate.cfg.xml`.
2. Run `EntityLifecycleExample.java`.
3. Check the console output to see how the ID is generated during the Persistent state, and how the object is finally removed.

## ⚠️ Common Mistakes
- **Updating Detached Entities**: If you change the `name` of a Student *after* `session.close()`, the change will **not** be saved. You must re-attach it using `session.merge()`.
- **Calling `persist()` on Detached Objects**: Calling `persist()` on an object that already has an ID will throw an exception. Use `merge()` instead.

## 💡 Key Takeaway
Hibernate tracks objects, not just SQL queries. If an object is **Persistent**, you don't even need to call `session.update()`—Hibernate automatically knows it changed!

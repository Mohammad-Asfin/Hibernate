-- ==========================================
-- 01: SQL Fundamentals - Database Setup
-- ==========================================

-- 1. CREATE DATABASE
-- Creating a new database specifically for our Hibernate learning examples.
CREATE DATABASE IF NOT EXISTS hibernate_learning;

-- 2. USE DATABASE
-- Selecting the database to perform our table creations and queries.
USE hibernate_learning;

-- ==========================================
-- 02: CREATE TABLE (Student Entity)
-- ==========================================
-- This maps conceptually to our Java 'Student' class in later chapters.
CREATE TABLE students (
    id BIGINT PRIMARY KEY AUTO_INCREMENT, -- Unique identifier, auto-generated
    name VARCHAR(100) NOT NULL,           -- Character's full name, cannot be null
    email VARCHAR(150) UNIQUE,            -- Email address, must be unique across all rows
    age INT                               -- Character's age (vampire age is complicated, we'll use physical age)
);

-- ==========================================
-- 03: INSERT DATA (Create)
-- ==========================================
-- Adding our characters into the database.
INSERT INTO students (name, email, age) 
VALUES 
    ('Elena Gilbert', 'elena@example.com', 22),
    ('Bonnie Bennett', 'bonnie@example.com', 23),
    ('Caroline Forbes', 'caroline@example.com', 22),
    ('Damon Salvatore', 'damon@example.com', 25),
    ('Stefan Salvatore', 'stefan@example.com', 24);

-- ==========================================
-- 04: SELECT DATA (Read)
-- ==========================================
-- A. Select all students
SELECT * FROM students;

-- B. Select specific columns
SELECT name, email FROM students;

-- C. Select with a condition (WHERE clause)
SELECT * FROM students WHERE age > 22;

-- D. Select and sort data (ORDER BY)
SELECT * FROM students ORDER BY name ASC;

-- E. Limit the number of returned rows
SELECT * FROM students LIMIT 3;

-- ==========================================
-- 05: UPDATE DATA (Update)
-- ==========================================
-- Important: Always use a WHERE clause when updating, otherwise ALL rows will be updated!
UPDATE students 
SET age = 24 
WHERE name = 'Elena Gilbert';

-- ==========================================
-- 06: DELETE DATA (Delete)
-- ==========================================
-- Important: Always use a WHERE clause when deleting. 
-- 'DELETE FROM students;' would delete every row in the table!
DELETE FROM students 
WHERE name = 'Stefan Salvatore';

-- ==========================================
-- 07: RELATIONSHIP EXAMPLES (Preview)
-- ==========================================
-- 1-to-1 Relationship Preview: Student Profiles
CREATE TABLE student_profiles (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT UNIQUE,            -- Foreign Key linking uniquely to students
    bio TEXT,
    FOREIGN KEY (student_id) REFERENCES students(id)
);

-- 1-to-Many Relationship Preview: Departments and Employees
CREATE TABLE departments (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(100)
);

CREATE TABLE employees (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department_id BIGINT,                -- Foreign Key linking many employees to one department
    FOREIGN KEY (department_id) REFERENCES departments(id)
);

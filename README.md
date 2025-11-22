# Student Management System (Core Java)

A simple console-based **Student Management System** built using **Core Java**, demonstrating:

- OOP (classes, objects, encapsulation)
- Collections (`List`, streams)
- File handling with serialization
- Basic console menu and user input
- Separation of concerns (model, service, util)

## How to Run

1. Compile the project:

   ```bash
   javac -d out src/model/Student.java src/util/FileUtil.java src/service/StudentService.java src/Main.java
   ```

2. Run the application:

   ```bash
   cd out
   java Main
   ```

A file named `students.dat` will be created in the same directory to store student records.

## Features

- Add a new student
- Update existing student details
- Delete a student
- Search a student by ID
- List all students
- Data persistence using file storage

## Project Structure

```text
StudentManagementSystem/
├── src/
│   ├── Main.java
│   ├── model/
│   │   └── Student.java
│   ├── service/
│   │   └── StudentService.java
│   └── util/
│       └── FileUtil.java
├── screenshots/
│   └── console-sample.png
└── README.md
```

## Screenshot

See `screenshots/console-sample.png` for a sample of the console menu.
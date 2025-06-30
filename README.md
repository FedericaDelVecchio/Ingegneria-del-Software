# School Management System (Sistema di Gestione Istituto Scolastico)

A comprehensive school management system built with Java and MySQL, developed as part of the Software Engineering course (2023) at the University of Naples "Federico II".

## 📋 Overview

This project implements a complete management system for educational institutions, providing role-based access for principals, teachers, students, parents, and administrative staff. The system follows a layered architecture pattern with clear separation between presentation, business logic, and data access layers.

## 🗂️ Project Structure

```
├── Progetto/
│   ├── Gestione Istituto Scolastico.pdf        # Complete project documentation
│   └── Altro/
│       ├── Class_GestioneIstitutoScolastico_JavaDoc.pdf
│       ├── Traccia A.15.docx                    # Project requirements
│       └── CFG/                                 # Control Flow Graphs
├── Programma/
│   ├── GestioneIstitutoScolastico.zip          # Java application source code
│   └── Database MySQL/
│       ├── GestioneIstitutoScolastico_SCHEMA.sql
│       ├── GestioneIstitutoScolastico_DATI.sql
│       ├── GestioneIstitutoScolastico.mwb       # MySQL Workbench model
│       └── Tabelle del Database.jpg
└── Visual Paradigm/
    ├── GestioneIstitutoScolastico.vpp           # UML project file
    └── Immagini dei diagrammi UML/
        ├── Diagramma dei Casi d'Uso/
        ├── Diagrammi di Classe/
        └── Diagrammi di Sequenza/
```

## 🎯 Key Features

### User Role Management
- **Principal (Preside)**: Full system access, class and teacher management
- **Teachers (Docenti)**: Grade management, activity logging, class consultation
- **Students (Alunni)**: Academic record viewing, grade consultation
- **Parents (Genitori)**: Child's academic progress monitoring
- **Administrative Staff (Segreteria)**: User registration and management

### Core Functionalities
- **Grade Management**: Complete grading system with average calculations
- **Electronic Registry**: Digital class registers for attendance and activities
- **Report Cards**: Automated generation and approval of student report cards
- **Activity Tracking**: Recording and viewing of classroom activities
- **User Authentication**: Secure login system for all user types
- **Academic Records**: Comprehensive student career tracking

## 🏗️ System Architecture

### Database Design
The system uses a **MySQL database** with normalized tables ensuring data integrity:

#### Core Tables
- **Presidi**: Principal accounts and credentials
- **Classi**: Class information (year, section, assigned principal)
- **Alunni**: Student records with personal and academic data
- **Docenti**: Teacher profiles and credentials
- **Genitori**: Parent accounts linked to students
- **RegistriElettronici**: Electronic class registers
- **Voti**: Individual grades with metadata
- **Attivita**: Classroom activities and assignments
- **Pagelle**: Student report cards with approval status
- **Medie**: Grade averages by subject

#### Relationship Tables
- **Genitori_has_Alunni**: Parent-student relationships
- **Docenti_has_Classi**: Teacher-class-subject assignments

### Software Architecture
The application follows a **layered architecture pattern**:

- **Boundary Layer** (`src/boundary/`): User interface components (Swing GUI)
- **Control Layer** (`src/control/`): Business logic and system operations
- **Entity Layer** (`src/entity/`): Domain model and data entities
- **Database Layer** (`src/database/`): Data access objects and persistence

## 🛠️ Technical Implementation

### Technology Stack
- **Programming Language**: Java (JDK 8+)
- **Database**: MySQL 8.0+
- **GUI Framework**: Java Swing
- **IDE**: Eclipse
- **Database Design**: MySQL Workbench
- **UML Modeling**: Visual Paradigm

### Key Design Patterns
- **Entity Pattern**: Separate entity classes for each domain object
- **Data Access Object (DAO)**: Database abstraction layer
- **Model-View-Controller (MVC)**: Clear separation of concerns
- **Facade Pattern**: Simplified interface through control classes

### Main Classes
- **GestioneIstitutoScolastico**: Central control class managing system operations
- **EntityAlunno, EntityDocente, EntityPreside**: Core user entities
- **EntityVoto, EntityAttivita, EntityPagella**: Academic data entities
- **MainFrame**: Primary user interface controller

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK 8 or higher)
- MySQL Server 8.0+
- MySQL Workbench (optional, for database management)
- Eclipse IDE (recommended)

### Installation

1. **Database Setup**
   ```sql
   -- Create the database schema
   source GestioneIstitutoScolastico_SCHEMA.sql;
   
   -- Insert sample data
   source GestioneIstitutoScolastico_DATI.sql;
   ```

2. **Application Setup**
   - Extract `GestioneIstitutoScolastico.zip`
   - Import the project into Eclipse
   - Configure database connection parameters
   - Compile and run the application

3. **Launch Application**
   ```bash
   java -cp bin boundary.MainFrame
   ```

## 📊 System Capabilities

### For Principals
- View all classes and enrolled students
- Manage teacher assignments
- Approve student report cards
- Access comprehensive academic data

### For Teachers
- Input and modify student grades
- Record classroom activities
- Consult electronic class registers
- View assigned classes and subjects

### For Students
- View personal grades and averages
- Access academic career information
- Consult approved report cards

### For Parents
- Monitor child's academic progress
- View grades and report cards
- Access communication from school

## 📈 Usage Examples

### Grade Management
```java
// Insert a new grade for a student
GestioneIstitutoScolastico sistema = new GestioneIstitutoScolastico();
sistema.inserisciVoto("alunno1", "Matematica", 8, "2023-10-15");
```

### Class Consultation
```java
// View all students in a class
String studenti = sistema.stampaAlunni("III", "C");
System.out.println(studenti);
```

### Report Card Generation
```java
// Generate report card for a student
sistema.generaPagella("alunno1");
```

## 🔧 Database Features

### Data Integrity
- **Foreign Key Constraints**: Ensure referential integrity
- **Primary Key Enforcement**: Unique identification for all entities
- **Data Validation**: Type checking and constraint enforcement

### Sample Data Includes
- **5 Classes**: From year I to V with different sections
- **25+ Students**: Distributed across various classes
- **Multiple Teachers**: With subject assignments
- **Parent-Student Relationships**: Family structure modeling

## 📚 Documentation

Complete project documentation is available in:
- `Gestione Istituto Scolastico.pdf`: Comprehensive system documentation
- `Class_GestioneIstitutoScolastico_JavaDoc.pdf`: JavaDoc API documentation
- UML Diagrams: Complete system modeling with use cases, class diagrams, and sequence diagrams

## 🏆 Academic Context

This project was developed for the **Software Engineering** course (2023) at the University of Naples "Federico II" as part of the Computer Engineering degree program. The system demonstrates:

- **Requirements Analysis**: Complete use case modeling
- **System Design**: UML-based architectural design
- **Implementation**: Object-oriented programming principles
- **Database Design**: Normalized relational database structure
- **Testing**: Comprehensive system validation

## 🤝 Team

- **[Federica Del Vecchio]** 
- **[Claudia Antonella Esposito](https://github.com/ClaudiaEspo)** -
- **Saida Benwadih**

---

**Institution**: Università degli Studi di Napoli "Federico II"  
**Course**: Ingegneria del Software  
**Academic Year**: 2023  
**Degree Program**: Ingegneria Informatica

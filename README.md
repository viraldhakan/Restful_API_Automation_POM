![Java](https://img.shields.io/badge/Language-Java-blue)
![Maven](https://img.shields.io/badge/Build-Maven-brightgreen)
![TestNG](https://img.shields.io/badge/TestFramework-TestNG-orange)

# 🧪 Restful Booker API Automation Framework

A robust and scalable **API Automation Testing Framework** built to perform **CRUD operations** on the **Restful Booker API** using Java and RestAssured. The framework is structured with the **Page Object Model (POM)** design for easy maintenance, reusability, and scalability.

---

## 🚀 Tech Stack

| Tool/Library | Purpose                                      |
|------------|----------------------------------------------|
| Java       | Programming Language                         |
| RestAssured | API Testing Library                          |
| TestNG     | Testing Framework                            |
| Maven      | Build and Dependency Management              |
| AssertJ    | Fluent Assertion Library                     |
| Jackson    | JSON Serialization and Deserialization       |
| Jenkins    | CI/CD Pipeline Integration                   |
| Allure Report | Rich HTML Test Reporting                     |

---

## 📁 Project Structure

````

src
│
├── main/java/restfulbooker
│ ├── endpoints # Contains all endpoint-related classes
│ ├── payload # POJOs and request body builders
│ ├── modules # Reusable utility and business logic
│
├── test/java/restfulbooker
│ ├── tests # TestNG test classes
│ ├── actions # Test step wrappers and validations
│ └── resources # Config files and test data
│
├── pom.xml # Maven configuration file
├── Jenkinsfile # Jenkins pipeline script
├── README.md # Project documentation

````

---

## ✅ Features

- End-to-end integration of Create, Read, Update, and Delete (CRUD) operations with automated API test flows
- Modular and maintainable Page Object Model (POM)
- Strong assertions with AssertJ
- JSON handling with both Jackson
- Supports parallel test execution with TestNG
- Allure report integration for detailed test results
- CI/CD-ready with Jenkins file included

---



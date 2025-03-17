# 📖 Books API Test Automation

![GitHub Actions](https://github.com/Dimitris-karavasilis/books-api/actions/workflows/ci.yml/badge.svg)
![Allure Report](https://img.shields.io/badge/Allure-Report-blue)

## 📌 Overview

This project automates API testing for the Books API (from mock site: https://fakerestapi.azurewebsites.net/index.html) using **Java, Junit, RestAssured, and Allure Reports**. The tests are executed in **GitHub Actions**, and reports are published using **Allure**.

## 🚀 Tech Stack

- **Java 11**
- **Maven 4**
- **JUnit 5**
- **RestAssured 5** (for API Testing)
- **Allure Reports 2.13**
- **GitHub Actions** (for CI/CD)

---

## 🔧 Setup & Installation

### 1️⃣ Prerequisites
Ensure you have the following installed:
- [Java 11+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)
- [IntellijIDE (or any IDE)](https://www.jetbrains.com/idea/)

### 2️⃣ Clone the Repository
```sh
git clone https://github.com/your-username/books-api.git
cd books-api
```

### Install dependencies
```mvn clean install ```
### 🚦 Running Tests
 1️⃣ Run All Tests
```mvn test```

 2️⃣ Generate Allure Report
```mvn allure:report```

 3️⃣ Open Allure Report in browser
```mvn allure:serve```

### 🔄 CI/CD with GitHub Actions
This project includes a GitHub Actions workflow (.github/workflows/ci.yml) to run tests automatically on every push.

✅ Workflow Steps
Checkout repository
Set up Java & Maven
Run tests
Generate and deploy Allure Report


📊 Allure Reports are generated in the target/allure-results directory.
GitHub Actions automatically updates Allure history.

Check the latest test report: Allure Report
https://dimitris-karavasilis.github.io/books-api/41/
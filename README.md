# Amazon Automation Tests

Automated test cases for searching iPhone and Samsung Galaxy on Amazon,
adding them to cart, and printing the price to console.

Built with: **Java + Selenium + TestNG + WebDriverManager**

---

## Project Structure
amazon-automation/
├── pom.xml
├── testng-parallel.xml
├── README.md
└── src/
└── test/
└── java/
└── tests/
├── BaseTest.java
├── IPhoneTest.java
└── GalaxyTest.java

---

## Test Cases

| Test | Description |
|------|-------------|
| IPhoneTest | Searches iPhone on Amazon, adds to cart, prints price |
| GalaxyTest | Searches Samsung Galaxy on Amazon, adds to cart, prints price |

Both tests run in **parallel** simultaneously.

---

## Prerequisites

Make sure you have the following installed:

- Java 8 or higher
- Maven (or use IntelliJ IDEA built-in Maven)
- Google Chrome browser

---

## How to Run

### Option 1: Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA
2. Wait for Maven to download dependencies
3. Open Maven panel (right side)
4. Go to Lifecycle → double click **test**

### Option 2: Using Command Line

```bash
# Go to project folder
cd amazon-automation

# Run all tests (parallel)
mvn test

# Run only iPhone test
mvn test -Dtest=IPhoneTest

# Run only Galaxy test
mvn test -Dtest=GalaxyTest
```

---

## Expected Console Output
[iPhone Test] Amazon open hua
[iPhone Test] Search kiya: iPhone
[iPhone Test] PRODUCT: Apple iPhone 15 (128 GB) - Black
[iPhone Test] PRICE: Rs. 79,900
[Galaxy Test] Amazon open hua
[Galaxy Test] Search kiya: Samsung Galaxy
[Galaxy Test] PRODUCT: Samsung Galaxy S24 5G
[Galaxy Test] PRICE: Rs. 54,999

---

## Parallel Execution

Tests are configured to run in parallel using TestNG.
Configuration is in `testng-parallel.xml`:

- Thread count: 2
- Both IPhoneTest and GalaxyTest run simultaneously
- Each test gets its own browser instance (ThreadLocal WebDriver)

---

## Technologies Used

- **Java** - Programming language
- **Selenium WebDriver 4.18.1** - Browser automation
- **TestNG 7.8.0** - Test framework with parallel execution
- **WebDriverManager 5.7.0** - Automatic ChromeDriver management
- **Maven** - Build and dependency management

---

## Author

Tanuj Kumar  
Customer Engineering Intern Assignment  
LambdaTest (TestMu AI)

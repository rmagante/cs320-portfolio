# CS320 Portfolio - Developer: Ryan Magante

## Welcome to my CS320 Portfolio

## About this Course

**Course:** CS320 - Software Testing, Automation, and Quality Assurance  
**Institution:** Southern New Hampshire University

---

## Assignments

### 🔹 Project One: Mobile Application Services

This project focused on developing core services for a mobile application, including Contact, Task, and Appointment management.

It demonstrates requirement-driven development and the creation of unit tests using JUnit to validate functional constraints, enforce input validation, and prevent defects through automated testing.

**Included artifacts:**
- `Contact.java`
- `ContactService.java`
- `ContactTest.java`
- `ContactServiceTest.java`

### 🔹 Project Two: Testing Strategy & Reflection

This project analyzes various software testing approaches and applies appropriate testing strategies based on requirements.

The summary and reflection report explains how unit testing, validation, coverage analysis, and requirement traceability were used to ensure functional and secure software.

---

---

## Reflection

### How can I ensure that my code, program, or software is functional and secure?

I ensure functionality by aligning each requirement directly with validation logic and corresponding unit tests. Both positive and negative test cases are written to confirm expected behavior and controlled failure conditions. High test coverage and branch testing ensure that validation rules are actively enforced.

Security and reliability are strengthened by validating inputs at object construction, enforcing constraints such as non-null identifiers, character limits, uniqueness checks, and date validation. Automated testing helps reduce regression risk and technical debt.

---

### How do I interpret user needs and incorporate them into a program?

User needs are translated into measurable constraints and implemented directly in constructors and service-layer logic. Each written requirement becomes an enforceable rule in code, and each rule is verified through testing. This creates traceability between requirements, implementation, and validation.

---

### How do I approach designing software?

I approach software design by separating responsibilities between model and service classes. Validation is enforced at the object level, while services handle orchestration and collection management. This separation improves maintainability, reduces complexity, and makes the system easier to test and scale.
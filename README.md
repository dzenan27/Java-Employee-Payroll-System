# 💼 Java Payroll System (Serialization Project)

## This is a class project that I recently expanded from my INFSYS 3806 & Applied Programming 6806 course. This is a simple but fully functional payroll system that creates, calculates, saves, and loads employee accounts. 
### This project demonstrates:

- 🧩 Object-Oriented Programming  
- 💾 Java Serialization  
- 🧮 Payroll Calculations (Gross, Tax, Net)  
- 🧠 Protected vs Public Methods  
- 📝 Menus & User Input  
- 🔄 File Persistence  

---

## 🚀 Features:

### 👨‍💼 Employee Management:
- Add (populate) employees into an array  
- Store first/last name, hours worked, hourly rate  
- Supports **overtime at 1.5x** past 40 hours  
- Prevent repopulation if employees are loaded from file  

### 📊 Payroll Calculations (Inside Employee Menu):
Each employee has a built-in menu with:

- 1️⃣ Calculate Gross Pay  
- 2️⃣ Calculate Tax  
- 3️⃣ Calculate Net Pay  
- 4️⃣ Calculate Net Percent  
- 5️⃣ Display Full Employee Info  
- 6️⃣ Return to Main Menu  

All payroll calculations follow the assignment requirements.

---

## 💽 Saving & Loading (Serialization)

The system supports **saving** and **loading** all employees using Java’s built-in serialization:

- 💾 `saveEmployees()` → writes `Employee[]` to file  
- 📂 `loadEmployees()` → restores the array exactly as it was  
- 🔒 Prevents repopulating after loading via a boolean flag  

This ensures persistence across program runs.

---

## 🧱 Project Structure:

 === PAYROLL MENU ===
 1) Populate Employees
 2) Select Employee
 3) Show all Employees
 4) Save Employees
 5) Load Employees
 6) Exit

 Employee Menu for: John Doe
 1) Calculate Gross Pay
 2) Calculate Tax
 3) Calculate Net Pay
 4) Calculate Net Percent
 5) Display Employee
 6) Go Back

## 📌 Setup Requirements Implemented:

- ✔ Populate Employee Objects  
- ✔ Hours, Rate, & Overtime Calculations  
- ✔ Employee Selection  
- ✔ Sub-Menu for Employee Calculations  
- ✔ Compute Gross Pay  
- ✔ Compute Tax  
- ✔ Compute Net Pay  
- ✔ Compute Net Percent  
- ✔ Display Employee Information  
- ✔ Save Employees (Serialized Object)  
- ✔ Load Employees (Serialized Object)  
- ✔ Prevent Repopulation After Load  
- ✔ Show All Employees  

---

## 🛠 How to Run:

### 1. Compile the project:
```bash
javac Payroll.java Employee.java



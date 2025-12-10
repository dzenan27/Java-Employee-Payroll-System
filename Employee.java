/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dzeno
 */
import java.io.Serializable;
import java.util.Scanner;

public class Employee implements Serializable {
   
    String Fname;
    String Lname;
    float rate=30.0f;

    float taxrate=0.2f;

    int hours=45;

    float gross=0.0f;

    float tax=0.0f;

    float net=0.0f;

    float net_percent=0.0f;
    
    public Employee() {
    }    
    public Employee(String Fname, String Lname, int hours, float rate) {    
        this.Fname = Fname;
        this.Lname = Lname;
        this.hours = hours;
        this.rate = rate;
    } 
    
    public void menu() {   
        Scanner sc = new Scanner(System.in);
        int choice;
    
        do { 
            System.out.println("\nEmployee Menu for: " + Fname + " " + Lname);
            System.out.println("1) Calculate Gross Pay");
            System.out.println("2) Calculate Tax");
            System.out.println("3) Calculate Net Pay");
            System.out.println("4) Calculate Net Percent");
            System.out.println("5) Display Employee");
            System.out.println("6) Go Back");
            System.out.print("Enter Your Choice: ");

            try {
            choice = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
            choice = -1;
            }
    
            switch (choice) {
                case 1:
                    computeGross();
                    System.out.println("Gross pay calculated: " + gross);
                break;
                
             case 2: 
                 computeGross();
                 computeTax();
                 System.out.println("Tax calculated: " + tax);
                break;
                
                case 3:
                    computeGross();
                    computeTax();
                    computeNet();
                    System.out.println("Net pay calculated: " + net);
                break;
                
                case 4:
                    computeGross();
                    computeTax();
                    computeNet();
                    computeNetperc();
                    System.out.println("Net percent calculated: " + net_percent + "%");
                break;
                
                case 5:
                    displayEmployee();
                break;
                
                case 6:
                    System.out.println("Returning to main menu...");
                break;
                    default: System.out.println("Invalid choice.");
            }        
    
        } while (choice != 6);
    }

    public String getFullName() {
    return Fname + " " + Lname;
}
    
    public void computeGross() {
        if (hours <= 40) {
        gross = hours * rate;
        } else { 
            int overtime = hours - 40;
            gross = (40 * rate) + (overtime * rate * 1.5f);
        }
    }     
    

    protected void computeTax() {
       tax = gross * taxrate; 
    }

    protected void computeNet() {
        net = gross - tax;
    }

    protected void computeNetperc() {
        if (gross > 0) {
            net_percent = (net / gross) * 100f;
        } else { 
            net_percent = 0f;
        }
    }
    
    protected void displayEmployee() {
        computeGross();
        computeTax();
        computeNet();
        computeNetperc();
        
        System.out.println("=========================");
        System.out.println("Employee: " + Fname + " " + Lname);
        System.out.println("Hours Worked: " + hours);
        System.out.println("Hourly Rate: " + rate);
        System.out.println("Gross Pay: " + gross);
        System.out.println("Tax: " + tax);
        System.out.println("Net Pay: " + net);
        System.out.println("Net Percent: " + net_percent + "%");
        System.out.println("=========================");
    }
}
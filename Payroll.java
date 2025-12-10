/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dzeno
 */
import java.util.Scanner;
import java.io.*;

public class Payroll {
    
    Scanner sc = new Scanner(System.in); 
    
    Employee[] myEmployees = new Employee[3];
    boolean employeesLoaded = false;
    String filename = "employees.dat";
    
    public static void main(String[] args){
        Payroll pr = new Payroll();
        pr.menu();
    }
    
    public void menu() {
        int input;
    
    
        do {
            System.out.println("\n=== PAYROLL MENU ===");
            System.out.println("1) Populate Employees");
            System.out.println("2) Select Employee");
            System.out.println("3) Show all Employees");        
            System.out.println("4) Save Employees");        
            System.out.println("5) Load Employees");        
            System.out.println("6) Exit");        
            System.out.print("Enter Choice: "); 
            
            try { 
                input = Integer.parseInt(sc.next());
            } catch (NumberFormatException e) {
                input = -1;
            }
            
            if (input == 1) {
                if (employeesLoaded) {
                    System.out.println("Employees already loaded from file. Cannot repopulate.");
                } else {
                    populateEmployees();
                }
            } else if (input == 2) {
                selectEmployee();
            } else if (input == 3) {
                showEmployees();
            } else if (input == 4) {
                saveEmployees();
            } else if (input == 5) {
                loadEmployees();
            }
        } while (input != 6);
        
        System.out.println("Exiting Payroll...");
    }    
        
    public void populateEmployees() {
        
        String tempFname;
        String tempLname;
        int tempHours;
        float tempRate;
        
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < myEmployees.length; i++)
        {
            if(myEmployees[i] == null)
            {
                System.out.println("Please enter first name: ");
                tempFname = sc.next();

                System.out.println("Please enter last name: ");
                tempLname = sc.next();

                System.out.println("Please enter hours worked: ");
                tempHours = Integer.parseInt(sc.next());

                System.out.println("Please enter hourly rate: ");
                tempRate = Float.parseFloat(sc.next());

                myEmployees[i] = new Employee(tempFname, tempLname, tempHours, tempRate);

                break;
        }
    }        
}    
    
    public void selectEmployee() {
        String tempName;
        int index = -99;
        
        
        System.out.println("Enter name to find:");
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        try
        {
        tempName = br.readLine();
        }
        catch(IOException ioe)
        {
        System.out.println("Something went wrong with your input name try again");
        return;
        }
        
        for(int i = 0; i < myEmployees.length; i++) {
            
            
        if(myEmployees[i] == null) {
            continue;
        }
        
        if (myEmployees[i].getFullName().equalsIgnoreCase(tempName)) {
            index = i;
            break;
        } 
            if (index != -99) {    
                myEmployees[index].menu();
            } else {
                System.out.println("Employee not found, please try again.");
            }
        }
        
        
        if(index != -99)
        {
        myEmployees[index].menu();
        }
        else
        {
        System.out.println("Student not found, please try again.");
}
    }     
    
    public void showEmployees() {
        for (int i = 0; i < myEmployees.length; i++)
        {
            if (myEmployees[i] != null)
            {
                myEmployees[i].displayEmployee();
            }
        }    
    }    
    
    public void saveEmployees() {
        
        try 
        {   FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(myEmployees);
            
            oos.close();
            fos.close();
            
            System.out.println("Employees saved successfully.");
               
        }
        catch (Exception e)
        {
            System.out.println("Error saving employees.");
        }
    }
    
    public void loadEmployees() {
        
        try 
        {   FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            myEmployees = (Employee[]) ois.readObject();
            employeesLoaded = true;
            
            ois.close();
            fis.close();
            
            System.out.println("Employees loaded successfully.");
               
        }
        catch (Exception e)
        {
            System.out.println("Error loading employees.");
        }
    }
            
}

    

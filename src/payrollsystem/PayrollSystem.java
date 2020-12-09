package payrollsystem;

import java.util.Scanner;

/**
 * MC120 Major Project - Payroll System menu-driven
 * @author Christian AUGUSTYN
 */
public class PayrollSystem {
    final int MANAGERS_PAYCODE = 1;
    final int HOURLY_WORKERS_PAYCODE = 2;
    final int COMMISSION_WORKERS_PAYCODE = 3;
    final int TAX = 7; // in percentage
    
    Employee employee;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name;
        int paycode, days;
        double wages = 0, sales = 0, salary = 0, rate, dailyRate, hourlyRate, gross = 0;
        
        Scanner input = new Scanner(System.in);

//        employee = new Employee();
//        employee.getName();
        
        /** 
         * Algorithm
         * 
         * [Menu]
         * Displays menu and asks user to choose an action
         * if action == 1 
         *  Ask user to enter employee details
         *  stores user info on an array of string data type
         * if action == 2
         * Ask user to remove employee using Employee ID.
         * if action == 3
         * Ask user to edit employee's detail using Employee ID.
         * if action == 4
         * Performs payroll
         * if action == 5
         * Exits the program
         * 
         * 1 hour work = K10
         * 8 hours for weekdays
         * 1(1/2) pay for overtime
         * 1(1/2) pay for Saturday
         */
        
        /**
         * Calculation of fortnightly pay for managers
         * fixed weekly salary * 2;
         * 
         * Calculation of fortnightly pay for hourly workers
         * fixed weekly salary
         * if worked overtime on Saturdays
         * then fixed weekly salary * K1.5
         * if worked overtime on Sundays
         * then fixed weekly salary * K2
         * 
         * Calculation of fortnightly pay for commission workers
         * K250 + 5.7% of (gross weekly sale)
         * 
         */
        
        System.out.println("Welcome to TechSavvy Payroll System\n");
        System.out.println("Fill the form to calculate salary.");
        
        System.out.print("Paycode: ");
        paycode = input.nextInt();
        
        // only accept paycode from 0 up to 3
        if (paycode > 0 && paycode < 4) {        
            System.out.print("Employee name: ");
            name = input.next();
            
            // if paycode is 1 then perform salary calculation for manager
            if (paycode == 1) {
                System.out.print("Rate per day: ");
                dailyRate = input.nextDouble();
                salary = calculateManagersPay(14, dailyRate);
            }
            // if paycode is 1 then perform salary calculation for hourly worker
            else if (paycode == 2) {
                System.out.print("Rate per hour: ");
                hourlyRate = input.nextDouble();

                System.out.println("Enter number of days worked for two weeks");
                System.out.print("Working days worked: ");
                days = input.nextInt();
                if (days > 0) {
                    salary += hourlyRate * 8 * days;
                }

                System.out.print("Saturdays worked: ");
                days = input.nextInt();
                if (days > 0 && days < 3) {
                    salary += 1.5 * hourlyRate * days;
                }

                System.out.print("Sundays worked: ");
                days = input.nextInt();
                if (days > 0 && days < 3) {
                    salary += 2 * hourlyRate * days;
                }
            }
            // if paycode is 1 then perform salary calculation for manager
            else if (paycode == 3) {
                System.out.print("Sales: ");
                sales = input.nextInt();
                salary = calculateCommissions(sales);
            }

            System.out.println(
                "\n------Payslips------\n" +
                "Employee name: " + name + "\n" +
                "Employee pay code: " + paycode + "\n" +
                "Net salary: K " + salary + "\n" +
                "Gross salary: K " + gross + "\n"
            );
        }
        else {
            System.out.println("The paycode entered does not match the expected employee paycodes.");
            System.out.println(
                "-----Valid codes-----\n" +
                "[1] - Manager\n" +
                "[2] - Hourly worker\n" +
                "[3] - Commissions worker"
            );
        }
    }
 
    // Calculates pay for hourly workers
    public static double calculateHourlyPay(int days, double rate) {
        double wages = days * rate;
        return wages;
    }
    
    // Calculates pay for managers
    public static double calculateManagersPay(int days, double rate) {
        double wages = days * rate;
        return wages;
    }
    
    // Calculates pay for commossion workers
    public static double calculateCommissions(double sales) {
        double wages = 250 + (5.7/100) * sales;
        return wages;
    }
}

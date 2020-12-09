package payrollsystem;

/**
 * Payroll System
 * @author Christian AUGUSTYN
 * @duedate 
 */
public class Employee {
    private String name;
    private int payCode;
    private double salary;
    private int days;
    
    public Employee() {}
    
    public Employee(String name, int payCode) {
        this.name = name;
        this.payCode = payCode;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPayCode() {
        return this.payCode;
    }
    
    public void setPayCode(int payCode) {
        this.payCode = payCode;
    }
}
import java.util.ArrayList;

abstract class Employee{ // abstraction
    private String name;
    private int id;

    public Employee(String name, int id){ // constructor
        this.name = name;
        this.id = id;
    }

    public String getName(){ // getter, encapsulation
        return name;
    }

    public int getId() { // getter
        return id;
    }

    public abstract double calculateSalary(); // abstract method defined

    @Override
    public   String toString(){
        return "Employee[name="+name+", id="+id+", salary="+calculateSalary()+"]";

    }

}

class FullTimeEmployee extends Employee{ // inheritance
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary){
        super(name, id); // parent class constructor
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary(){ // implementation
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{ // inheritance
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate){
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary(){ //implementation
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem{
    private ArrayList<Employee> employeeList;

    public PayrollSystem(){ // constructor
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee : employeeList){
            if (employee.getId() == id){
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null){
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployeeList(){
        for (Employee employee: employeeList){
            System.out.println(employee);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Harry", 2, 40, 100);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee details: ");
        payrollSystem.displayEmployeeList();
        System.out.println("Removing employees: ");
        payrollSystem.removeEmployee(2);
        System.out.println("Remaining employees details: ");
        payrollSystem.displayEmployeeList();
    }
}
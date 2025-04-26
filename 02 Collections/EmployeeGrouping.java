import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class EmployeeGrouping {
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            departmentMap.computeIfAbsent(employee.department, k -> new ArrayList<>()).add(employee);
        }

        return departmentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"),
                new Employee("David", "Finance")
        );

        Map<String, List<Employee>> groupedEmployees = groupByDepartment(employees);
        groupedEmployees.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
    }
}

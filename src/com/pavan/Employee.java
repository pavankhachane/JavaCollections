package com.pavan;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee>{

    private long id;
    private long salary;
    private String firstName;
    private String lastName;

    public Employee(long id, long salary, String firstName, String lastName) {
        this.id = id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                salary == employee.salary &&
                firstName.equalsIgnoreCase(employee.firstName) &&
                lastName.equalsIgnoreCase(employee.lastName);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(id, salary, firstName, lastName);

        int result = 17;
        result = 31 * result * getFirstName().toLowerCase().hashCode();
        result = 31 * result * getLastName().toLowerCase().hashCode();
        return result;

    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
      //  return this.id == o.getId() ? 0 : (this.id > o.getId() ? 1 : -1);
       // return this.getSalary() == o.getSalary() ? 0 : (this.getSalary() > o.getSalary() ? 1 : -1);
        return this.getFirstName().compareToIgnoreCase(o.getFirstName());
    }
}

class EmployeeComparator implements Comparator<Employee>{
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}

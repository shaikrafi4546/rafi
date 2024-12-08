package com.employee_management.Model;
import jakarta.persistence.*;
import java.util.Base64;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private String encodedSalary; // Store the salary as Base64 encoded


    public Employee() {}

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.encodedSalary = encodeSalaryToBase64(salary);
    }

    // Convert salary to Base64 encoded string
    public String encodeSalaryToBase64(double salary) {
        return Base64.getEncoder().encodeToString(String.valueOf(salary).getBytes());
    }

    // Decode Base64 encoded salary
    public double decodeSalaryFromBase64() {
        String decodedSalary = new String(Base64.getDecoder().decode(this.encodedSalary));
        return Double.parseDouble(decodedSalary);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEncodedSalary() {
        return encodedSalary;
    }

    public void setEncodedSalary(String encodedSalary) {
        this.encodedSalary = encodedSalary;
    }


    public double getSalary() {
        return decodeSalaryFromBase64();
    }

    public void setSalary(double salary) {
        this.encodedSalary = encodeSalaryToBase64(salary);
    }
}

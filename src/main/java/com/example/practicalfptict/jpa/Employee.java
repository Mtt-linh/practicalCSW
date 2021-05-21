package com.example.practicalfptict.jpa;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@EqualsAndHashCode(exclude = {"employee"})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String name;

    private String salary;

    public Employee() {
    }

    public Employee(int id, @NotNull String name, String salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}

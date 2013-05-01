package com.dgg.java.funprogdemos.employees;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
public class EmployeesCollection {


    public List<Employee> filterCollection(List<Employee> elements, Predicate<Employee> test) {
        if (test == null) {
            throw new IllegalArgumentException("Predicate used to filter cannot be null");
        }
        return elements.stream().filter(test).collect(Collectors.<Employee>toList());
    }

    public Integer calculateTotalSalary(List<Employee> data) {
        return data.stream().map(Employee::getSalary).reduce(0, (subtotal, curr) -> subtotal + curr);
    }


}

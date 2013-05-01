package com.dgg.java.funprogdemos.employees;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Comparators.comparing;

/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
public class EmployeeComparator {

    private final List<Employee> data;
    private Comparator<Employee> comparator;


    public EmployeeComparator(List<Employee> data) {
        this.data = data;
        comparator = comparing(Employee.ComparatorFunctions.doNothingComparator);
    }


    public List<Employee> sortedList() {
        return data.stream().sorted(comparator).collect(Collectors.<Employee>toList());
    }


    public EmployeeComparator addComparator(Function<Employee, Integer> cmp) {
        comparator = comparator.thenComparing(cmp);
        return this;
    }
}

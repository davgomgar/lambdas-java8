package com.dgg.java.funprogdemos.employees;

import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
public class Employee {
    private final int age;
    private final int clearanceLevel;
    private final int salary;
    private final String name;

    /**
     * @param age
     * @param clearanceLevel
     * @param salary
     * @param name
     */
    Employee(int age, int clearanceLevel, int salary, String name) {
        this.age = age;
        this.clearanceLevel = clearanceLevel;
        this.name = name;
        this.salary = salary;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class ComparatorFunctions {
        public static final Function<Employee, Integer> doNothingComparator = employee -> 0;
        public static final Function<Employee, Integer> bySalary = Employee::getSalary;
        public static final Function<Employee, Integer> byAge = Employee::getAge;
        public static final Function<Employee, String> byName = Employee::getName;
        public static final Function<Employee, Integer> byClearanceLevel = Employee::getClearanceLevel;
    }
}

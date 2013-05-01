package com.dgg.java.funprogdemos.employees;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.dgg.java.funprogdemos.employees.Employee.ComparatorFunctions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
public class EmployeeComparatorTest {

    private static EmployeeComparator demo;
    private static List<Employee> data;

    private final Employee john = new Employee(18, 1, 22000, "John");
    private final Employee sarah = new Employee(21, 2, 35000, "Sarah");
    private final Employee ben = new Employee(33, 5, 40000, "Ben");
    private final Employee sam = new Employee(21, 3, 40000, "Sam");
    private final Employee paul = new Employee(21, 1, 40000, "Paul");
    private final Employee jeff = new Employee(50, 8, 80000, "Jeff");
    private final Employee greg = new Employee(33, 6, 65000, "Greg");

    @Before
    public void setup() {
        data = Arrays.asList(john, sarah, ben, sam, jeff, greg, paul);
        demo = new EmployeeComparator(data);
    }


    @Test
    public void testDefaultOrder() {
        assertThat(data, is(demo.sortedList()));
    }


    @Test
    public void testAddSingleComparator() {
        demo.addComparator(byClearanceLevel);
        final List<Employee> expectedData = Arrays.asList(john, paul, sarah, sam, ben, greg, jeff);

        assertThat(expectedData, is(demo.sortedList()));
    }

    @Test
    public void testCompareBySalaryAndThenByAge() {
        demo.addComparator(bySalary).addComparator(byAge);
        final List<Employee> expectedData = Arrays.asList(john, sarah, sam, paul, ben, greg, jeff);
        assertThat(expectedData, is(demo.sortedList()));
    }

    @Test
    public void testCompareBySalaryThenByAgeAndThenByClearanceLevel() {
        demo.addComparator(bySalary).addComparator(byAge).addComparator(byClearanceLevel);
        final List<Employee> expectedData = Arrays.asList(john, sarah, paul, sam, ben, greg, jeff);
        assertThat(expectedData, is(demo.sortedList()));
    }
}

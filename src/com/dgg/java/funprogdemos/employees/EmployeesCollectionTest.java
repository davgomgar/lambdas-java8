package com.dgg.java.funprogdemos.employees;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.either;

/**
 * Created with IntelliJ IDEA.
 * User: davgomgar
 */
public class EmployeesCollectionTest {

    private static EmployeesCollection testSubject;
    private static List<Employee> data;

    private static final Employee john = new Employee(18, 1, 22000, "John");
    private static final Employee sarah = new Employee(21, 2, 35000, "Sarah");
    private static final Employee ben = new Employee(33, 5, 40000, "Ben");
    private static final Employee sam = new Employee(21, 3, 40000, "Sam");
    private static final Employee paul = new Employee(21, 1, 40000, "Paul");
    private static final Employee jeff = new Employee(50, 8, 80000, "Jeff");
    private static final Employee greg = new Employee(33, 6, 65000, "Greg");

    @BeforeClass
    public static void setup() {
        data = Arrays.asList(john, sarah, ben, sam, jeff, greg, paul);
        testSubject = new EmployeesCollection();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFilterCollectionThrowsExceptionIfNullCollectionIsPassed() {
        testSubject.filterCollection(null, null);
    }

    @Test
    public void testSarahSamIfNameStartWithS() {
        List<Employee> expected = Arrays.asList(sarah, sam);
        List<Employee> expected2 = Arrays.asList(sam, sarah);
        assertThat(testSubject.filterCollection(data, em -> em.getName().startsWith("S")),
                is(either(equalTo(expected)).or(equalTo(expected2))));

    }

    @Test
    public void testJeffGregAreReturnedIfFilterSalaryGreaterThan60k() {
        List<Employee> expected = Arrays.asList(jeff, greg);
        assertThat(testSubject.filterCollection(data, e -> e.getSalary() > 60000), is(equalTo(expected)));
    }

    @Test
    public void testTotalSalary() {
        Integer expected = 22000 + 35000 + 40000 + 40000 + 40000 + 80000 + 65000;
        assertThat(expected, is(equalTo(testSubject.calculateTotalSalary(data))));
    }


}

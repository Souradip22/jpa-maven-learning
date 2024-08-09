package ch.souradip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JPAPersistenceContextDemo {
    public static void main(String[] args) {


        Employee employee = new Employee();
        employee.setName("New test User");
        employee.setSsn("1223");
        employee.setDob(new Date());
        employee.setEmployeeType(EmployeeType.FULL_TIME);

        System.out.println("************** Created Employee Instance");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        System.out.println("************** Starting transaction");
        entityManager.persist(employee);

        // Notice the actual insert query happens after calling the commit
        // but, how can we get the data before even calling insert?
        // EntityManager keeps it in a cache and handle the insert at most optimal state
        Employee employeeFound = entityManager.find(Employee.class, 1);

        // Getting it from the cache
        // THis kind of management is happing in management context - persistence context
        System.out.println("Employee found - " + employeeFound);
        System.out.println("employee - " + employee);
        System.out.println(employeeFound == employee);

        System.out.println("************** After persist method called");

        transaction.commit();
        System.out.println("************** After transaction called");
        entityManager.close();
        entityManagerFactory.close();


    }
}
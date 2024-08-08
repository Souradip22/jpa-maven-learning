package ch.souradip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, 2);
        System.out.println(employee);

        //Delete operation example
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.remove(employee);
//        transaction.commit();

        //Update operation example
//        employee.setName("Updated Name");
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(employee);
//
//        transaction.commit();


        // Perform Insert/create operation example
//        System.out.println("Hello world!");
//        Employee employee = new Employee();
//        employee.setName("Test User");
//        employee.setSsn("1223");
//        employee.setDob(new Date());
//        employee.setEmployeeType(EmployeeType.FULL_TIME);
//
//        Employee employee2 = new Employee();
//        employee2.setName("Test User 2");
//        employee2.setSsn("234");
//        employee2.setDob(new Date());
//        employee2.setEmployeeType(EmployeeType.CONTRACTOR);
//
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//        entityManager.persist(employee);
//        entityManager.persist(employee2);
//
//        transaction.commit();
//        entityManager.close();
//        entityManagerFactory.close();

    }
}
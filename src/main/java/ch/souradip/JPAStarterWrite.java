package ch.souradip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JPAStarterWrite {
    public static void main(String[] args) {






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

        Employee employee = new Employee();
        employee.setName("Test User");
        employee.setSsn("1223");
        employee.setDob(new Date());
        employee.setEmployeeType(EmployeeType.FULL_TIME);

        Employee employee2 = new Employee();
        employee2.setName("Test User 2");
        employee2.setSsn("234");
        employee2.setDob(new Date());
        employee2.setEmployeeType(EmployeeType.CONTRACTOR);


        AccessCard card1 = new AccessCard();
        card1.setIssuedDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.0.0");
        card1.setOwner(employee);
        employee.setAccessCard(card1);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setOwner(employee2);
        employee2.setAccessCard(card2);


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        entityManager.persist(employee2);

        entityManager.persist(card1);
        entityManager.persist(card2);

        transaction.commit();


    }
}
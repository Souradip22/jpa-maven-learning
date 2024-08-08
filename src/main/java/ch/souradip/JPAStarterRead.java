package ch.souradip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Employee employee = entityManager.find(Employee.class, 1);
//        System.out.println("************ Fetch Employee");
//        System.out.println("Employee : " + employee.getName());
//
//        System.out.println("************ Fetch AccessCard");
//        System.out.println(employee.getAccessCard());

//        AccessCard card = entityManager.find(AccessCard.class, 3);
//        System.out.println(card.getOwner());

//        PayStub payStub = entityManager.find(PayStub.class, 5);
//        System.out.println(payStub.getEmployee());

//        Employee employee = entityManager.find(Employee.class, 1);
//        System.out.println("Employee Paystubs" + employee.getPayStubs());

    }
}

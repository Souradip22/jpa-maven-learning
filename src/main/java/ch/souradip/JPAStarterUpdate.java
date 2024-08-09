package ch.souradip;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAStarterUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // using JPA we are trying to update relationship
        // we first reflect the required changes in the instances
        // then calling persist to tell JPA make the changes in db side also.
        // we are trying to add employee 1 to email group 8
        Employee employee = entityManager.find(Employee.class, 1);
        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 8);

        employee.addToEmailGroups(emailGroup);
        emailGroup.addMembers(employee);


        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee);
        entityManager.persist(emailGroup);

        transaction.commit();


    }
}

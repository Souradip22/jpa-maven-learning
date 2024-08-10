package ch.souradip;

import javax.persistence.*;
import java.util.List;

public class JPQLExample {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // "select e from Employee e where e.id < 2"
        // "select e from Employee e order by e.name desc"
        // "select e from Employee e where e.name like '%doe'" for name='Test User 2'
        // "select e from Employee e where e.age between 22 and 32"
        // join - "select e from Employee e where e.accessCard.firmwareVersion='1.0.0'"
        TypedQuery<Employee> query = entityManager.createQuery(
                "select e from Employee e",
                Employee.class
        );

        TypedQuery<String> query2 = entityManager.createQuery(
                "select e.name from Employee e",
                String.class
        );

        TypedQuery<Integer> query3 = entityManager.createQuery(
                "select e.age from Employee e",
                Integer.class
        );

        TypedQuery<Object[]> query4 = entityManager.createQuery(
                "select e.name, e.age, e.dob from Employee e",
                Object[].class
        );

        TypedQuery<Object[]> query5 = entityManager.createQuery(
                "select e.name, a.firmwareVersion from Employee e, AccessCard a where e.accessCard.id = a.id",
                Object[].class
        );
        // Better of way write query 5
        TypedQuery<Object[]> query6 = entityManager.createQuery(
                "select e.name, e.accessCard.firmwareVersion from Employee e",
                Object[].class
        );
        // Avoid SQL injection with JPQL parameters
        Integer minAge = 25;
        TypedQuery<Employee> query7 = entityManager.createQuery(
                "select e from Employee e where e.age > :minAge",
                Employee.class
        );

        // example using named query
        TypedQuery<Employee> query8 = entityManager.createNamedQuery("emp name asc", Employee.class);
        TypedQuery<Employee> query9 = entityManager.createNamedQuery("emp name desc", Employee.class);

//        Query query = entityManager.createNativeQuery(
//                "SELECT e.* FROM EMPLOYEE_DATA e JOIN AccessCard a ON e.accessCard_id = a.id WHERE a.isActive = true",
//                Employee.class
//        );
        List<Employee> resultList = query.getResultList();
        resultList.forEach(System.out::println);

        List<String> resultList2 = query2.getResultList();
        resultList2.forEach(System.out::println);

        List<Integer> resultList3 = query3.getResultList();
        resultList3.forEach(System.out::println);


        List<Object[]> resultList4 = query4.getResultList();
        resultList4.forEach(e -> System.out.println(e[0] + " " + e[1] + " " + e[2]));

        List<Object[]> resultList5 = query5.getResultList();
        resultList5.forEach(e -> System.out.println(e[0] + " " + e[1]));
        System.out.println("BETTER WAY OF QUERY 5");
        List<Object[]> resultList6 = query6.getResultList();
        resultList6.forEach(e -> System.out.println(e[0] + " " + e[1]));

        query7.setParameter("minAge", minAge);
        List<Employee> resultList7 = query7.getResultList();
        resultList7.forEach(System.out::println);

        List<Employee> resultList8 = query8.getResultList();
        resultList8.forEach(System.out::println);


        List<Employee> resultList9 = query9.getResultList();
        resultList9.forEach(System.out::println);



        entityManager.close();
        entityManagerFactory.close();


//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
    }
}

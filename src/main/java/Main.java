import az.code.models.Address;
import az.code.models.Person;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("az.code.testing");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person p = Person.builder().name("Ali1").surname("Huseynli1").build();
        List<Address> addresses = List.of(
                        Address.builder().fullAddress("A1").build(),
                        Address.builder().fullAddress("A2").build(),
                        Address.builder().fullAddress("A3").build());
        p.setAddresses(addresses);

        em.persist(p);
        em.getTransaction().commit();
        em.close();


        //Add new Employee object




    }

}
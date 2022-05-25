import entinty.Cimage;
import entinty.Sensors;
import entinty.Spacetime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.Date;
import java.sql.Time;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            Spacetime spacetime = new Spacetime();
            Sensors sensors = new Sensors();
            Cimage cimage = new Cimage();

            spacetime.setAgentId("agentCoz123");
            spacetime.setDate(Date.valueOf("2022-05-23"));
            spacetime.setTime(Time.valueOf("10:29:54"));
            spacetime.setCoordinates("[-65.51776,47.90295]");

            sensors.setHeight(7.25);
            sensors.setTemperature(30.87);
            sensors.setHumidity(1261.9);
            sensors.setWind(39);

            cimage.setLatent("[0.143123,0.341123,0.98667]");

            System.out.println("The data updated is: ");
            System.out.println("Agent: " + spacetime.getAgentId());
            System.out.println("Date: " + spacetime.getDate());
            System.out.println("Time: " + spacetime.getTime());
            System.out.println("Coordinates: " + spacetime.getCoordinates());
            System.out.println("Height: " + sensors.getHeight());
            System.out.println("Temperature: " + sensors.getTemperature());
            System.out.println("Humidity: " + sensors.getHumidity());
            System.out.println("Wind speed: " + sensors.getWind());
            System.out.println("Compressed image: " + cimage.getLatent());

            entityManager.persist(spacetime);
            entityManager.persist(sensors);
            entityManager.persist(cimage);

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

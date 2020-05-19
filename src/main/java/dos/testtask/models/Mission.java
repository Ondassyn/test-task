package dos.testtask.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Long flight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFlight() {
        return flight;
    }

    public void setFlight(Long flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "name='" + name + '\'' +
                ", flight=" + flight +
                '}';
    }
}

package entinty;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Sensors {
    //@Basic
    //@Column(name = "AgentId")
    //private String agentId;
    @Basic
    @Column(name = "Height")
    private double height;
    @Basic
    @Column(name = "Temperature")
    private double temperature;
    @Basic
    @Column(name = "Humidity")
    private double humidity;
    @Basic
    @Column(name = "Wind")
    private int wind;
    @ManyToOne
    @JoinColumn(name = "AgentId", referencedColumnName = "AgentId", nullable = false)
    private Spacetime spacetimeByAgentId;
    @Id
    private Long id;

    //public String getAgentId() {
    //    return agentId;
    //}

    //public void setAgentId(String agentId) {
    //    this.agentId = agentId;
    //}

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sensors sensors = (Sensors) o;

        if (Double.compare(sensors.height, height) != 0) return false;
        if (Double.compare(sensors.temperature, temperature) != 0) return false;
        if (Double.compare(sensors.humidity, humidity) != 0) return false;
        //if (agentId != null ? !agentId.equals(sensors.agentId) : sensors.agentId != null) return false;
        if (!Objects.equals(wind, sensors.wind)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) height;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(temperature);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(humidity);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        // result = 31 * result + (wind != null ? wind.hashCode() : 0);
        return result;
    }

    public Spacetime getSpacetimeByAgentId() {
        return spacetimeByAgentId;
    }

    public void setSpacetimeByAgentId(Spacetime spacetimeByAgentId) {
        this.spacetimeByAgentId = spacetimeByAgentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

package entinty;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

@Entity
public class Spacetime {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "AgentId")
    private String agentId;
    @Basic
    @Column(name = "Date")
    private Date date;
    @Basic
    @Column(name = "Time")
    private Time time;
    @Basic
    @Column(name = "Coordinates")
    private String coordinates;
    @OneToMany(mappedBy = "spacetimeByAgentId")
    private Collection<Cimage> cimagesByAgentId;
    @OneToMany(mappedBy = "spacetimeByAgentId")
    private Collection<Sensors> sensorsByAgentId;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spacetime spacetime = (Spacetime) o;

        if (agentId != null ? !agentId.equals(spacetime.agentId) : spacetime.agentId != null) return false;
        if (date != null ? !date.equals(spacetime.date) : spacetime.date != null) return false;
        if (time != null ? !time.equals(spacetime.time) : spacetime.time != null) return false;
        if (coordinates != null ? !coordinates.equals(spacetime.coordinates) : spacetime.coordinates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = agentId != null ? agentId.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        return result;
    }

    public Collection<Cimage> getCimagesByAgentId() {
        return cimagesByAgentId;
    }

    public void setCimagesByAgentId(Collection<Cimage> cimagesByAgentId) {
        this.cimagesByAgentId = cimagesByAgentId;
    }

    public Collection<Sensors> getSensorsByAgentId() {
        return sensorsByAgentId;
    }

    public void setSensorsByAgentId(Collection<Sensors> sensorsByAgentId) {
        this.sensorsByAgentId = sensorsByAgentId;
    }
}

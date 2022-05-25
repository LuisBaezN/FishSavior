package entinty;

import javax.persistence.*;

@Entity
public class Cimage {
    //@Basic
    //@Column(name = "AgentId")
    //private String agentId;
    @Basic
    @Column(name = "latent")
    private String latent;
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

    public String getLatent() {
        return latent;
    }

    public void setLatent(String latent) {
        this.latent = latent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cimage cimage = (Cimage) o;

        //if (agentId != null ? !agentId.equals(cimage.agentId) : cimage.agentId != null) return false;
        if (latent != null ? !latent.equals(cimage.latent) : cimage.latent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        //int result = agentId != null ? agentId.hashCode() : 0;
        int result = 31 + (latent != null ? latent.hashCode() : 0);
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

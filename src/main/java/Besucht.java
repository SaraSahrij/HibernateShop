/*
import jakarta.persistence.*;

@Entity(name="Hib_Besucht")
@IdClass (BesuchtPK.class)
public class Besucht{

	@ManyToOne
	@JoinColumn(name="spielNr", referencedColumnName = "spielNr", insertable = false, updatable=false)
	private Spiel spiel;
	@ManyToOne
	@JoinColumn(name="zuschauerId", referencedColumnName = "zuschauerId", insertable = false, updatable=false)
	private Zuschauer zuschauer;
	@Column(name="EintrittPreis", nullable=false)
	private Long eintrittPreis;
	@Id
	@Column(name="spielNr", nullable=false)
	private Long spielNr;
	@Id
	@Column(name="zuschauerId", nullable=false)
	private Long zuschauerId;

	public Besucht() {
	}
	
	public Besucht(Spiel spiel, Zuschauer zuschauer, Long eintrittPreis) {
		this.eintrittPreis = eintrittPreis;
		this.spiel = spiel;
		this.zuschauer = zuschauer;
		this.spielNr = spiel.getNr();
		this.zuschauerId = zuschauer.getId();
	}

	
	public void setSpielNr(Long spielNr)
	{
		this.spielNr = spielNr;
	}
	
	public void setZuschauerId(Long zuschauerId)
	{
		this.zuschauerId = zuschauerId;
	}
	
	public Spiel getSpiel() {
		return spiel;
	}
	
	public Zuschauer getZuschauer() {
		return zuschauer;
	}

}*/

import jakarta.persistence.*;

@Entity(name = "Hib_Besucht")
@IdClass(BesuchtPK.class)
public class Besucht {
    @ManyToOne
    @JoinColumn(name = "SpielNr", referencedColumnName = "SpielNr", insertable = false, updatable = false)
    private Spiel spiel;
    @ManyToOne
    @JoinColumn(name = "ZuschauerId", referencedColumnName = "ZuschauerId", insertable = false, updatable = false)
    private Zuschauer zuschauer;
    @Column(name = "EintrittPreis", nullable = false)
    private Long eintrittPreis;
    @Id
    @Column(name = "SpielNr", nullable = false)
    private Long spielNr;
    @Id
    @Column(name = "ZuschauerId", nullable = false)
    private Long zuschauerId;

    public Besucht() {
    }

    public Besucht(Spiel spiel, Zuschauer zuschauer, Long eintrittPreis) {
        this.eintrittPreis = eintrittPreis;
        this.spiel = spiel;
        this.zuschauer = zuschauer;
        this.spielNr = spiel.getNr();
        this.zuschauerId = zuschauer.getId();
    }

    public void setSpielNr(Long spielNr) {
        this.spielNr = spielNr;
    }

    public void setZuschauerId(Long zuschauerId) {
        this.zuschauerId = zuschauerId;
    }

    public Spiel getSpiel() {
        return spiel;
    }

    public Zuschauer getZuschauer() {
        return zuschauer;
    }

}
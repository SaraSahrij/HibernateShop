/*
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Hib_Stadion")
public class Stadion {
	@Column(name="StadionId")
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String ort;
	@Column
	private String zuschauersKapazit�t;
	@Column
	private String name;
	
	Stadion(){
		
	}

	Stadion(String ort, String zuschauersKapazit�t, String name){
		this.ort = ort;
		this.zuschauersKapazit�t = zuschauersKapazit�t;
		this.name = name;
	}
	
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getZuschauersKapazit�t() {
		return zuschauersKapazit�t;
	}

	public void setZuschauersKapazit�t(String zuschauersKapazit�t) {
		this.zuschauersKapazit�t = zuschauersKapazit�t;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}


}
*/

import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hib_Stadion")
public class Stadion extends Entitaet {
    @ManyToOne
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    private Spiel spiel;
    @Column(name = "StadionId")
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String ort;
    @Column
    private String zuschauersKapazitaet;
    @Column
    private String name;

    public Stadion() {

    }

    public Stadion(String ort, String zuschauersKapazitaet, String name, Spiel spiel) {
        this.ort = ort;
        this.zuschauersKapazitaet = zuschauersKapazitaet;
        this.name = name;
        this.spiel = spiel;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getZuschauersKapazitaet() {
        return zuschauersKapazitaet;
    }

    public void setZuschauersKapazitaet(String zuschauersKapazitaet) {
        this.zuschauersKapazitaet = zuschauersKapazitaet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void describeSelf() {
        System.out.println("Id: " + id + " Ort: " + ort + " Zuschauerskapazit�t: " + zuschauersKapazitaet + " Name: " + name);
    }

    public Stadion createInstance() {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Geben sie ein Land ein");
        this.ort = scan.nextLine();  // Read user input
        System.out.println("Geben sie ein Land ein");
        this.zuschauersKapazitaet = scan.nextLine();  // Read user input
        System.out.println("Geben sie ein Land ein");
        this.name = scan.nextLine();  // Read user input
        return this;
    }


}
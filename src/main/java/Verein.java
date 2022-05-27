/*
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Hib_Verein")
public class Verein {
	@Id
	@Column(nullable= false)
	//@GeneratedValue
	private Long vereinId;
	@ElementCollection
	private List<String> sportarten;
	@Column
	private String land;
	@OneToMany(mappedBy= "verein", fetch=FetchType.EAGER)
	private List<Spiel> spiel = new ArrayList<Spiel>();
	@Id
	@Column(name="SpielId")
	private Long spielId;
	
	Verein(){
		
	}

	Verein(List<String> sportarten, String land){
		this.sportarten = sportarten;
		this.land = land;
	}
	
	public List<String> getSportarten() {
		return sportarten;
	}

	public void setSportarten(List<String> sportarten) {
		this.sportarten = sportarten;
	}

	public String getLand() {
		return land;
	}

	public void setSportarten(String land) {
		this.land = land;
	}
	
	public long getId() {
		return vereinId;
	}


}
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hib_Verein")
public class Verein extends Entitaet {
    @ManyToOne
    @JoinColumn(name = "Id", referencedColumnName = "Id", insertable = false, updatable = false)
    private Mitglieder mitglieder;
    @Column(name = "Id")
    @Id
    @GeneratedValue
    private Long id;
    @ElementCollection
    private List<String> sportarten;
    @Column
    private String land;
    @OneToMany(mappedBy = "verein", fetch = FetchType.EAGER)
    private List<Spiel> spiel = new ArrayList<Spiel>();

    public Verein() {

    }

    public Verein(List<String> sportarten, String land, Mitglieder mitglieder) {
        this.sportarten = sportarten;
        this.land = land;
    }

    public List<String> getSportarten() {
        return sportarten;
    }

    public void setSportarten(List<String> sportarten) {
        this.sportarten = sportarten;
    }

    public String getLand() {
        return land;
    }

    public void setSportarten(String land) {
        this.land = land;
    }

    public long getId() {
        return id;
    }

    public void describeSelf() {
        System.out.println("Id: " + id + " Sportarten: " + sportarten + " Land: " + land);
    }

    public Verein createInstance() {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Geben sie ein Name ein");
        //do while
        this.sportarten.add(scan.nextLine());
        System.out.println("Geben sie ein Land ein");
        this.land = scan.nextLine();  // Read user input
        return this;
    }


}
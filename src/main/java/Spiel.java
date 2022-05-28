/*
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Hib_Spiel")
public class Spiel {
	@Id
	@Column(nullable= false)
	//@GeneratedValue
	private Long spielNr;
	@Column
	private Date datum;
	@Column
	private Time zeit;
	@Column
	private String highlight;
	@OneToMany(mappedBy= "spiel", fetch=FetchType.EAGER)
	private List<Stadion> stadion = new ArrayList<Stadion>();
	@OneToMany(mappedBy= "spiel", fetch=FetchType.EAGER)
	private List<Besucht> besucht;
	@Id
	@Column(name="StadionId")
	private Long stadionId;
	
	Spiel(){
		
	}

	Spiel(Date datum, Time zeit, String highlight){
		this.datum = datum;
		this.zeit= zeit;
		this.highlight = highlight;
	}
	
	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date date) {
		this.datum = date;
	}

	public Time getNachname() {
		return zeit;
	}

	public void setZeit(Time zeit) {
		this.zeit = zeit;
	}

	public long getNr() {
		return spielNr;
	}


	


}
*/

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Hib_Spiel")
public class Spiel extends Entitaet{
	@ManyToOne
	@JoinColumn(name="Id", referencedColumnName = "Id", insertable = false, updatable=false)
	private Score score;
	@ManyToOne
	@JoinColumn(name="Id", referencedColumnName = "Id", insertable = false, updatable=false)
	private Verein verein;
	@Id
	@Column(name="SpielNr")
	@GeneratedValue
	private int nr;
	@Column
	private String datum;
	@Column
	private String zeit;
	@OneToMany(mappedBy= "spiel", fetch=FetchType.EAGER)
	private List<Stadion> stadion = new ArrayList<Stadion>();
	
	public Spiel(){
		
	}

	public Spiel(int nr, String datum, String zeit, Score score, Verein verein){
		this.nr = nr;
		this.datum = datum;
		this.zeit= zeit;
		this.score = score;
		this.verein = verein;
	}
	
	public String getDatum() {
		return datum;
	}

	public void setDatum(String date) {
		this.datum = date;
	}

	public String getNachname() {
		return zeit;
	}

	public void setZeit(String zeit) {
		this.zeit = zeit;
	}

	public long getNr() {
		return nr;
	}
	
	public void describeSelf() {
		System.out.println("SpielNr: "+ nr + " Datum: "+ datum + " Zeit: "+ zeit);
	}

	public Spiel createInstance(){
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Geben sie ein Datum ein dd-MM-yyyy");
	    this.datum = scan.nextLine();  // Read user input
	    System.out.println("Geben sie ein Uhr ein hh-mm");
	    this.zeit = scan.nextLine();  // Read user input
		return this;
	}
	
	public Spiel modifyData() {
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Geben sie das neue Datum ein:");
		String ans = scan.nextLine();
	    if(ans != "")this.datum = ans;  // Read user input
	    System.out.println("Geben sie dei neue Zeit ein:");
	    ans = scan.nextLine();
	    if(ans != "")this.zeit = ans;  // Read user input
	    return this;
	}
}

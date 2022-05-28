import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Hib_Stadion")
public class Stadion extends Entitaet {
	@ManyToOne
	@JoinColumn(name="Id", referencedColumnName = "Id", insertable = false, updatable=false)
	private Spiel spiel;
	@Column(name="StadionId")
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String ort;
	@Column
	private int zuschauersKapazität;
	@Column
	private String name;
	
	public Stadion(){
		
	}

	public Stadion(String ort, int zuschauersKapazität, String name, Spiel spiel){
		this.ort = ort;
		this.zuschauersKapazität = zuschauersKapazität;
		this.name = name;
		this.spiel = spiel;
	}
	
	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public int getZuschauersKapazität() {
		return zuschauersKapazität;
	}

	public void setZuschauersKapazität(int zuschauersKapazitaet) {
		this.zuschauersKapazität = zuschauersKapazitaet;
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
		System.out.println("Id: "+ id + " Ort: "+ ort + " Zuschauers kapazität: "+ zuschauersKapazität + " Name: "+ name);
	}
	
	public Stadion createInstance(){
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Geben sie ein Ort ein");
	    this.ort = scan.next();  // Read user input
	    System.out.println("Geben sie die Zuschauer Kapazität ein");
	    this.zuschauersKapazität = scan.nextInt();  // Read user input
	    System.out.println("Geben sie eine Name ein");
	    this.name = scan.next();  // Read user input

		return this;
	}

	public Stadion modifyData() {
		Scanner scan = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Geben sie die neue Name ein:");
		String ans= scan.nextLine();
	    if(ans != "")this.name = ans;  // Read user input
	    System.out.println("Geben sie dei neue Ort ein:");
	    ans = scan.nextLine();
	    if(ans != "")this.ort = ans;  // Read user input
	    System.out.println("Geben sie dei neue zuschauersKapazität ein:");
	    ans = scan.nextLine();
	    if(ans != "")this.zuschauersKapazität = Integer.parseInt(ans);  // Read user input
	    return this;
	}
	
}
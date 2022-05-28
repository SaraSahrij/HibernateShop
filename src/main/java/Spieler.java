import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name ="Hib_Spieler")
public class Spieler extends Mitglieder{
	@Column(name= "nummer")
	private int nummer;
	
	public Spieler(){
		
	}

	public Spieler(String name, String sport, int nummer)
	{
		super(name, sport);
		this.nummer = nummer;
	}
	

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public long getId() {
		return getId();
	}
	
	public void describeSelf() {
		System.out.println("Id: "+ super.getId() + " Name: "+ super.getName() + " Sport: "+ super.getSport() + " Nummer: "+ nummer);
	}
	
	public Spieler createInstance(){
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Geben sie eine Name ein");
	    super.setName(scan.nextLine());  // Read user input
	    System.out.println("Geben sie ein Sport ein");
	    super.setSport(scan.nextLine());  // Read user input
	    System.out.println("Geben sie ein nummer ein");
	    this.nummer = scan.nextInt();  // Read user input
		return this;
	}

	public Spieler modifyData() {
		Spieler spieler = modifyData();
	    System.out.println("Geben sie der neue Nummer ein:");
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    spieler.setNummer(scan.nextInt());  // Read user input
	    return spieler;
	}
	
	
}
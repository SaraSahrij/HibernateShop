import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Hib_Zuschauer")
public class Zuschauer extends Entitaet {
	@Id
	@GeneratedValue
	@Column(nullable= false)
	private Long zuschauerId;
	@Column
	private int gefarhdungsKategorie;
	@OneToMany(mappedBy= "zuschauer", fetch=FetchType.EAGER)
	private List<Besucht> besucht = new ArrayList<Besucht>();
	
	public Zuschauer(){
		
	}

	public Zuschauer(int gefarhdungsKategorie){
		this.gefarhdungsKategorie = gefarhdungsKategorie;
	}

	public long getId() {
		return zuschauerId;
	}
	
	public void describeSelf() {
		System.out.println("Id: "+ zuschauerId + " Gefährdungskategorie: "+ gefarhdungsKategorie );
	}
	
	public Zuschauer createInstance(){
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Geben sie eine Gefährdungskategorie ein (1= normal / 2= VIP)");
	    this.gefarhdungsKategorie = scan.nextInt();  // Read user input
		return this;
	}

	public Zuschauer modifyData() {
	    System.out.println("Geben sie die neue Gefarhdungskategorie ein:");
	    Scanner scan = new Scanner(System.in);  // Create a Scanner object
	    gefarhdungsKategorie = scan.nextInt();  // Read user input
	    return this;
	}

}

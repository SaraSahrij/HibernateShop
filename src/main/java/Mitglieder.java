/*
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name ="Hib_Mitglieder")
public class Mitglieder {
	@Column(name="MitgliederId")
	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String name;
	@Column
	private String sport;
	@OneToMany(mappedBy= "mitglieder", fetch=FetchType.EAGER)
	private List<Verein> verein = new ArrayList<Verein>();
	@Id
	@Column(name="VereinId")
	private Long vereinId;
	
	Mitglieder(){
		
	}
	
	Mitglieder(String name, String sport)
	{
		this.name = name;
		this.sport = sport;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public long getId() {
		return id;
	}

}

*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Hib_Mitglieder")
public abstract class Mitglieder extends Entitaet {
    @Column(name = "Id")
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String sport;
    @OneToMany(mappedBy = "mitglieder", fetch = FetchType.EAGER)
    private List<Verein> verein = new ArrayList<Verein>();

    public Mitglieder() {

    }

    public Mitglieder(String name, String sport) {
        this.name = name;
        this.sport = sport;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public long getId() {
        return id;
    }

    public void describeSelf() {
        System.out.println("Id: " + id + " Name: " + name + " Sport: " + sport);
    }

    public abstract Mitglieder createInstance();

}
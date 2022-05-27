import java.util.Scanner;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Hib_Staff")
public class Staff extends Mitglieder {
    @Column
    private String bereich;

    public Staff() {

    }

    public Staff(String name, String sport, String bereich) {
        super(name, sport);
        this.bereich = bereich;
    }


    public String getBereich() {
        return bereich;
    }

    public void setBereich(String bereich) {
        this.bereich = bereich;
    }

    public long getId() {
        return getId();
    }

    public Staff createInstance() {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Geben sie eine Name ein");
        super.setName(scan.nextLine());  // Read user input
        System.out.println("Geben sie ein Sport ein");
        super.setSport(scan.nextLine());  // Read user input
        System.out.println("Geben sie eine Bereiche ein");
        this.bereich = scan.nextLine();  // Read user input
        return this;

    }

}

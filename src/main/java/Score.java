import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hib_Score")
public class Score {
    @Id
    private int Id;
    @Column
    private String Tormacher;
    @Column
    private Time Zeit;

    @OneToMany(mappedBy = "score", fetch = FetchType.EAGER)
    private List<Spiel> spiel = new ArrayList<Spiel>();

    public Score() {

    }

    public Score(int Id, String Tormacher, Time Zeit) {
        this.Id = Id;
        this.Tormacher = Tormacher;
        this.Zeit = Zeit;
    }

    public int getId() {
        return Id;
    }


    public String getTormacher() {
        return Tormacher;
    }

    public void setTormacher(String Tormacher) {
        this.Tormacher = Tormacher;
    }

    public Time getZeit() {
        return Zeit;
    }

    public void setZeit(Time Zeit) {
        this.Zeit = Zeit;
    }


}
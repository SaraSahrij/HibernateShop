import java.io.Serializable;
import java.util.Objects;

public class BesuchtPK implements Serializable {

    private Long spielNr;
    private Long zuschauerId;

    public boolean equals(Object other) {
        if (other instanceof BesuchtPK) {
            final BesuchtPK otherWarenkorbPK = (BesuchtPK) other;
            final boolean areEqual =
                    (otherWarenkorbPK.spielNr.equals(spielNr))
                            && otherWarenkorbPK.zuschauerId.equals(zuschauerId);
            return areEqual;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zuschauerId, spielNr);
    }
}

package parametrage.modele;

import annotations.ValueObject;

import java.util.Objects;

@ValueObject
public class Cle {

    private final String cle;

    public Cle(){
        this.cle = "";
    }

    public Cle(String commentaire){
        this.cle = commentaire;
    }

    public String visualiserCle(){
        return this.cle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cle that = (Cle) o;
        return Objects.equals(cle, that.cle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cle);
    }

    @Override
    public String toString() {
        return "cle{" +
                "cle=" + cle;
    }

}

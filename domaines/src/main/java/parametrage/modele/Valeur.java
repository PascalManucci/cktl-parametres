package parametrage.modele;

import annotations.ValueObject;

import java.util.Objects;

@ValueObject
public class Valeur {

    private final String valeur;

    public Valeur(){
        this.valeur = "";
    }

    public Valeur(String valeur){
        this.valeur = valeur;
    }

    public String visualiserValeur(){
        return this.valeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valeur that = (Valeur) o;
        return Objects.equals(valeur, that.valeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valeur);
    }

    @Override
    public String toString() {
        return "valeur{" +
                "valeur=" + valeur;
    }

}

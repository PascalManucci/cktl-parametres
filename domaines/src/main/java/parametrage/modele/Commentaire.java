package parametrage.modele;

import annotations.ValueObject;

import java.util.Objects;

@ValueObject
public class Commentaire {

    private final String commentaire;

    public Commentaire(){
        this.commentaire = "";
    }

    public Commentaire(String commentaire){
        this.commentaire = commentaire;
    }

    public String visualiserCommentaire(){
        return this.commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentaire that = (Commentaire) o;
        return Objects.equals(commentaire, that.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentaire);
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "commentaire=" + commentaire;
    }


}

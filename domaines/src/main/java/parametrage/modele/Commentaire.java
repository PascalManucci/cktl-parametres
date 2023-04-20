package parametrage.modele;

import annotations.ValueObject;

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

}

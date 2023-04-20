package parametrage.modele;

import annotations.Aggregate;
import annotations.SideEffect;

import java.util.Date;

@Aggregate
public class Parametre {

    protected Boolean controle = false;
    protected Boolean isValide = true;

    private Integer ordre;
    private String cle;
    private String valeur;
    private Commentaire commentaires;
    private Date dateCreation;
    private Date dateModification;
    private Integer typeId;
    private Commentaire commentaireLocal;
    private String temLocal;
    private Origine origine;
    private String profile;

    public Parametre(){

    }

    public Parametre(Integer ordre, String cle, String valeur, Commentaire commentaires, Date dateCreation, Date dateModification, Integer typeId, Commentaire commentaireLocal, String temLocal, Origine origine, String profile){
        this.ordre = ordre;
        this.cle = cle;
        this.valeur = valeur;
        this.commentaires = commentaires;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.typeId = typeId;
        this.commentaireLocal = commentaireLocal;
        this.temLocal = temLocal;
        this.origine = origine;
        this.profile = profile;

    }

    public Integer ordre(){return this.ordre;}
    public String  cle(){return this.cle;}
    public String  valeur(){return this.valeur;}
    public Commentaire commentaire(){return this.commentaires;};
    public Date dateCreation(){return this.dateCreation;}
    public Date dateModification(){return this.dateModification;}
    public Integer typeId(){return this.typeId;}
    public Commentaire commentaireLocal(){return this.commentaireLocal;}
    public String temLocal(){return this.temLocal;}
    public Origine origine(){return this.origine;}
    public String profile(){return this.profile;}


    // A voir cette expérimentation de gestion de side effect / CQRS plus tard ....
    @SideEffect
    public Parametre controler(){ // On applique tous les contrôle de l'agrégat qui vont émerger au fil du temps.
        return this;
    }

    @SideEffect
    public Parametre envoyer(){ // On envoie et on peut conditionner sur l'application service de manière élégante.
        return this;
    }

    @SideEffect
    public Parametre isValide(){
        controle = isValide || controle; // A vérifier que ça marche bien
        return this;
    }

    @SideEffect
    public Parametre enregistrer(){ // Pour enregistrer en fonction, en particulier si c'est valide.
        return this;
    }


}

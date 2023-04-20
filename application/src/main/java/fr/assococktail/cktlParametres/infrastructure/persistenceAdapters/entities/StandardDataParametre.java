package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities;

import lombok.Data;
import lombok.Getter;
import parametrage.modele.Origine;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Getter
public class StandardDataParametre {
    private Integer ordre;
    private String key;
    private String value;
    private String commentaires;
    private Integer persidcreation;
    private Integer persidmodification;
    private Date dcreation;
    private Date dmodification;
    private Integer typeid;
    private String commentairelocal;
    private String temlocal;
    private String profile;
    private Origine origine;

    public StandardDataParametre(){

    }

    public StandardDataParametre(Integer ordre, String key, String value, String commentaire, Integer persidcreation, Integer persidmodification, Date dateCreation, Date dateModification, Integer typeid, String commentairelocal, String temlocal, String profile, Origine origine){
        this.ordre = ordre;
        this.key = key;
        this.value = value;
        this.commentaires = commentaire;
        this.persidcreation = persidcreation;
        this.persidmodification = persidmodification;
        this.dcreation = dateCreation;
        this.dmodification = dateModification;
        this.typeid = typeid;
        this.commentairelocal = commentairelocal;
        this.temlocal = temlocal;
        this.profile = profile;
        this.origine = origine;

    }

}

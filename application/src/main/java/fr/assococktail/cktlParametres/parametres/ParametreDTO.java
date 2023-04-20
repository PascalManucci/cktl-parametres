package fr.assococktail.cktlParametres.parametres;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ParametreDTO extends JsonDTO {

    @JsonIgnore
    private Integer id;

    @JsonProperty(required = true)
    private String ordre;

    @JsonProperty(required = true)
    private String cle;

    @JsonProperty(required = true)
    private String valeur;

    @JsonProperty
    private String commentaires;

    @JsonProperty
    private String dateCreation;

    @JsonProperty
    private String dateModification;

    @JsonProperty
    private String typeId;

    @JsonProperty
    private String commentaireLocal;

    @JsonProperty
    private String temLocal;

    @JsonProperty
    private String origine;

    public ParametreDTO(){

    }

    public ParametreDTO(ParametreDTO parametreDTO){
        this.ordre = parametreDTO.getOrdre();
        this.cle = parametreDTO.getCle();
        this.valeur = parametreDTO.getValeur();
        this.commentaires = parametreDTO.getCommentaires();
        this.dateCreation = parametreDTO.getDateCreation();
        this.dateModification = parametreDTO.getDateModification();
        this.typeId = parametreDTO.getTypeId();
        this.commentaireLocal = parametreDTO.getCommentaireLocal();
        this.temLocal = parametreDTO.getTemLocal();
        this.origine = parametreDTO.getOrigine();

    }

    public ParametreDTO(String ordre, String cle, String valeur, String commentaires, String dateCreation, String dateModification, String typeId, String commentaireLocal, String temLocal, String origine){
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

    }

}

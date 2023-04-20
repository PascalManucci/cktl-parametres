package fr.assococktail.cktlParametres.applicationservice.mapperdto;

import fr.assococktail.cktlParametres.parametres.ParametreDTO;
import parametrage.modele.Parametre;

import java.util.Objects;

public class MapperParametreDTO {

    private String EMPTY = "";

    public MapperParametreDTO(){

    }

    public ParametreDTO mapParameter(Parametre parametre){
        String ordre = Objects.nonNull(parametre.ordre())?parametre.ordre().toString():EMPTY;
        String cle = Objects.nonNull(parametre.cle())?parametre.cle():EMPTY;
        String valeur = Objects.nonNull(parametre.valeur())?parametre.valeur():EMPTY;
        String commentaire = Objects.nonNull(parametre.commentaire())?parametre.commentaire().visualiserCommentaire():EMPTY;
        String dcreation = Objects.nonNull(parametre.dateCreation())?parametre.dateCreation().toString():EMPTY;
        String dModification = Objects.nonNull(parametre.dateModification())?parametre.dateModification().toString():EMPTY;
        String typeId = Objects.nonNull(parametre.typeId())?parametre.typeId().toString():EMPTY;
        String commentLoc = Objects.nonNull(parametre.commentaireLocal())?parametre.commentaireLocal().visualiserCommentaire():EMPTY;
        String temlocal = Objects.nonNull(parametre.temLocal())?parametre.temLocal():EMPTY;
        String origine = Objects.nonNull(parametre.origine())?parametre.origine().getCode():EMPTY;

        return new ParametreDTO(ordre,cle,valeur,commentaire,dcreation,dModification,typeId, commentLoc, temlocal,origine);

    }

}

package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.mappers;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.GrhumDataParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.StandardDataParametre;
import org.springframework.context.annotation.Bean;
import parametrage.modele.*;

import java.util.Date;

public class MapperGrhumParametre {

    public MapperGrhumParametre(){

    }

    public Parametre mapParameter(StandardDataParametre params){
        Commentaire commentaire = new Commentaire(params.getCommentaires());
        Commentaire commentairelocal = new Commentaire(params.getCommentairelocal());
        Valeur valeur = new Valeur(params.getValue());
        Cle cle = new Cle(params.getKey());
        Parametre parametre = new Parametre(params.getOrdre(),cle,valeur,commentaire,params.getDcreation(),params.getDmodification(),params.getTypeid(), commentairelocal, params.getTemlocal(), params.getOrigine(),params.getProfile());
        return parametre;

    }

    public StandardDataParametre mapGrhumParametre(GrhumDataParametre grhumDataParametre){
        StandardDataParametre parametre = new StandardDataParametre(grhumDataParametre.getOrdre(),grhumDataParametre.getKey(),grhumDataParametre.getValue(), grhumDataParametre.getCommentaires(),grhumDataParametre.getPersidcreation(),grhumDataParametre.getPersidmodification(),grhumDataParametre.getDcreation(),grhumDataParametre.getDmodification(),grhumDataParametre.getTypeid(), grhumDataParametre.getCommentairelocal(), grhumDataParametre.getTemlocal(), "" ,Origine.GRHUM);
        return parametre;

    }

}

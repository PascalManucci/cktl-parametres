package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.mappers;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.GrhumDataParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.StandardDataParametre;
import org.springframework.context.annotation.Bean;
import parametrage.modele.Commentaire;
import parametrage.modele.Origine;
import parametrage.modele.Parametre;

import java.util.Date;

public class MapperGrhumParametre {

    public MapperGrhumParametre(){

    }

    public Parametre mapParameter(StandardDataParametre params){
        Commentaire commentaire = new Commentaire(params.getCommentaires());
        Commentaire commentairelocal = new Commentaire(params.getCommentairelocal());
        Parametre parametre = new Parametre(params.getOrdre(),params.getKey(),params.getValue(),commentaire,params.getDcreation(),params.getDmodification(),params.getTypeid(), commentairelocal, params.getTemlocal(), params.getOrigine(),params.getProfile());
        return parametre;

    }

    public StandardDataParametre mapGrhumParametre(GrhumDataParametre grhumDataParametre){
        StandardDataParametre parametre = new StandardDataParametre(grhumDataParametre.getOrdre(),grhumDataParametre.getKey(),grhumDataParametre.getValue(), grhumDataParametre.getCommentaires(),grhumDataParametre.getPersidcreation(),grhumDataParametre.getPersidmodification(),grhumDataParametre.getDcreation(),grhumDataParametre.getDmodification(),grhumDataParametre.getTypeid(), grhumDataParametre.getCommentairelocal(), grhumDataParametre.getTemlocal(), "" ,Origine.GRHUM);
        return parametre;

    }

}

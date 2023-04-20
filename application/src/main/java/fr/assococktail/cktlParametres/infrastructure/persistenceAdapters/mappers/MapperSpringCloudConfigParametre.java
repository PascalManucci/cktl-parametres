package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.mappers;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.GrhumDataParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.SpringCloudConfigDataParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.StandardDataParametre;
import parametrage.modele.Commentaire;
import parametrage.modele.Origine;
import parametrage.modele.Parametre;

public class MapperSpringCloudConfigParametre {

    public MapperSpringCloudConfigParametre() {

    }

    public StandardDataParametre mapParameter(SpringCloudConfigDataParametre springCloudConfigDataParametre) {
        StandardDataParametre parametre = new StandardDataParametre(springCloudConfigDataParametre.getId(), springCloudConfigDataParametre.getKey(), springCloudConfigDataParametre.getValue(), springCloudConfigDataParametre.getApplication() + springCloudConfigDataParametre.getLabel(),new Integer(0), new Integer(0), null, null, new Integer(0), "", "",springCloudConfigDataParametre.getProfile(),Origine.CLOUDCONFIG);
        return parametre;

    }
}

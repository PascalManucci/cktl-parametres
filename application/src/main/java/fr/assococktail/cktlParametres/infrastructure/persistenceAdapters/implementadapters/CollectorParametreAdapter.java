package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.implementadapters;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.GrhumDataParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.StandardDataParametre;

import java.util.ArrayList;
import java.util.List;

abstract public class CollectorParametreAdapter {

    protected List<StandardDataParametre> parametres = new ArrayList<>();

    public CollectorParametreAdapter(){

    }

    protected List<StandardDataParametre> getAllParametres(){
        return this.parametres;
    }

    protected CollectorParametreAdapter collect(CollectorParametreAdapter collect) {
        return null;
    }


    public boolean anticorruption(StandardDataParametre parametre){
        // Futur "anticorruption layer" générique à tous flux
        return true;

    }

}

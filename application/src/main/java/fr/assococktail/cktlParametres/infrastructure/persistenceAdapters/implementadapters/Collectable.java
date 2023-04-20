package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.implementadapters;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.GrhumDataParametre;

import java.util.List;

public interface Collectable {
    CollectorParametreAdapter collect(CollectorParametreAdapter collect);
    CollectorParametreAdapter collect();
}

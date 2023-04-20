package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.implementadapters;

import fr.assococktail.cktlParametres.annotations.Adapter;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.jparepositories.GrhumParametresJpaRepository;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.jparepositories.SpringCloudConfigJpaRepository;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.mappers.MapperGrhumParametre;
import org.springframework.beans.factory.annotation.Autowired;
import parametrage.modele.Parametre;
import parametrage.repositories.ParametreRepository;

import java.util.List;
import java.util.stream.Collectors;

@Adapter
public class ServiceCollecteurAdapter implements ParametreRepository {

    @Autowired
    private GrhumCollectorParameterAdapter collecteurGrhum;

    @Autowired
    private SpringCloudCollectorParameterAdapter collecteurSpringConf;

    @Override
    public List<Parametre> listerLesParametres() {
        MapperGrhumParametre mapperGrhumParametre = new MapperGrhumParametre();
        collecteurSpringConf.collect(collecteurGrhum.collect());
        return collecteurSpringConf.getAllParametres().stream().map(s-> mapperGrhumParametre.mapParameter(s)).collect(Collectors.toList());
    }

}

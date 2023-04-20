package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.implementadapters;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.jparepositories.GrhumParametresJpaRepository;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.mappers.MapperGrhumParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.mappers.MapperSpringCloudConfigParametre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GrhumCollectorParameterAdapter extends CollectorParametreAdapter implements Collectable{

    @Autowired
    private GrhumParametresJpaRepository jpaRepository;

    public GrhumCollectorParameterAdapter(){

    }

    @Override
    public CollectorParametreAdapter collect(CollectorParametreAdapter collect) {
        MapperGrhumParametre mapper = new MapperGrhumParametre();
        this.parametres = collect.getAllParametres();
        this.parametres.addAll(jpaRepository.findAll().stream().map(s-> mapper.mapGrhumParametre(s)).collect(Collectors.toList()));
        return this;

    }

    @Override
    public CollectorParametreAdapter collect() {
        MapperGrhumParametre mapper = new MapperGrhumParametre();
        this.parametres = jpaRepository.findAll().stream().map(s-> mapper.mapGrhumParametre(s)).collect(Collectors.toList());
        return this;
    }

}

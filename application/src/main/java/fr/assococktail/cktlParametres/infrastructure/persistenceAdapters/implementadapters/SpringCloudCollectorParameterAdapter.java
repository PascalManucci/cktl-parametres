package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.implementadapters;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.GrhumDataParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.SpringCloudConfigDataParametre;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.jparepositories.GrhumParametresJpaRepository;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.jparepositories.SpringCloudConfigJpaRepository;
import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.mappers.MapperSpringCloudConfigParametre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpringCloudCollectorParameterAdapter extends CollectorParametreAdapter implements Collectable{

    @Autowired
    private SpringCloudConfigJpaRepository jpaRepository;

    public SpringCloudCollectorParameterAdapter(){

    }

    @Override
    public CollectorParametreAdapter collect(CollectorParametreAdapter collect) {
        List<SpringCloudConfigDataParametre> test = jpaRepository.findAll();
        MapperSpringCloudConfigParametre mapper = new MapperSpringCloudConfigParametre();

        this.parametres = collect.getAllParametres();
        this.parametres.addAll(jpaRepository.findAll().stream().map(s-> mapper.mapParameter(s)).collect(Collectors.toList()));
        return this;

    }

    @Override
    public CollectorParametreAdapter collect() {
        List<SpringCloudConfigDataParametre> params = jpaRepository.findAll();


        MapperSpringCloudConfigParametre mapper = new MapperSpringCloudConfigParametre();
        this.parametres = jpaRepository.findAll().stream().map(s-> mapper.mapParameter(s)).collect(Collectors.toList());
        return this;
    }


}

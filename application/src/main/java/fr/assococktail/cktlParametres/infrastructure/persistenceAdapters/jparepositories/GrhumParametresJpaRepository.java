package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.jparepositories;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.GrhumDataParametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrhumParametresJpaRepository extends JpaRepository<GrhumDataParametre, Long>{
}

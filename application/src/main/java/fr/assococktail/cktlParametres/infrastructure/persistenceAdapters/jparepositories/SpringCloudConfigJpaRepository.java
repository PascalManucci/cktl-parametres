package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.jparepositories;

import fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities.SpringCloudConfigDataParametre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCloudConfigJpaRepository extends JpaRepository<SpringCloudConfigDataParametre, Long> {
}

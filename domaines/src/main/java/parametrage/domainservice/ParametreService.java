package parametrage.domainservice;

import annotations.DomainService;
import parametrage.modele.Parametre;
import parametrage.repositories.ParametreRepository;

import java.util.List;

@DomainService
public class ParametreService {

    private final ParametreRepository repository;

    public ParametreService(ParametreRepository repository){
        this.repository = repository;

    }

    public List<Parametre> listerParametragePgi() {
        return repository.listerLesParametres();
    }
}

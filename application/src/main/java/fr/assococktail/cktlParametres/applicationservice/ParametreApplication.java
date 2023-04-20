package fr.assococktail.cktlParametres.applicationservice;

import fr.assococktail.cktlParametres.annotations.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import parametrage.domainservice.ParametreService;
import parametrage.modele.Parametre;
import parametrage.repositories.ParametreRepository;

import java.util.List;

@ApplicationService
public class ParametreApplication {

    private final ParametreService parametreService;

    @Autowired
    public ParametreApplication(ParametreRepository repository){
        this.parametreService = new ParametreService(repository);
    }

    public List<Parametre> listerParametragePgi(){
        return this.parametreService.listerParametrage();
    }


}

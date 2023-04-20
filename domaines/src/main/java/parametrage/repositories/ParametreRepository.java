package parametrage.repositories;


import annotations.Port;
import parametrage.modele.Parametre;

import java.util.List;

@Port
public interface ParametreRepository {

    List<Parametre> listerLesParametres();

}

package fr.assococktail.cktlParametres.parametres;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ParametrageDTO extends JsonDTO{
    /*
      Pour pouvoir faire une liste de DTO (on peut mieux faire ... ) et bénéficier de la sérialisation json.
     */

    @JsonProperty(required = true)
    private List<ParametreDTO> parametres;

    public ParametrageDTO(){

    }

    public ParametrageDTO(List<ParametreDTO> parametres){
        this.parametres = parametres;

    }

    public void setParametres(List<ParametreDTO> parametres){
        this.parametres = parametres;
    }

}

package fr.assococktail.cktlParametres.parametres;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.assococktail.cktlParametres.parametres.JsonDTO;

public class PseudoString extends JsonDTO {

    @JsonProperty(required = true)
    public String pseudoString;

    public PseudoString(){

    }

    public PseudoString(String pseudoString){
        this.pseudoString = pseudoString;
    }

    @Override
    public String toString() {

        return pseudoString;
    }

}

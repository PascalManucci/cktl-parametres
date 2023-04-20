package fr.assococktail.cktlParametres.parametres;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.assococktail.cktlParametres.parametres.JsonDTO;

public class JsonString extends JsonDTO {

    @JsonProperty(required = true)
    public String pseudString = "";

    public JsonString(){

    }

    public JsonString(String string){
        this.pseudString = string;

    }
    
}

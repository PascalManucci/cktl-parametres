package fr.assococktail.cktlParametres.restcontrollers;

import fr.assococktail.cktlParametres.applicationservice.ParametreApplication;
import fr.assococktail.cktlParametres.applicationservice.mapperdto.MapperParametreDTO;
import fr.assococktail.cktlParametres.exceptions.TechnicalParametreException;
import fr.assococktail.cktlParametres.parametres.JsonString;
import fr.assococktail.cktlParametres.parametres.ParametrageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import parametrage.repositories.ParametreRepository;

import java.io.IOException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/parametrage/api/v1")
public class ParametreRestController {

    private static String SUCCESS = "health check success";
    private static String FAILED = "health check failed";

    private static final Logger logger = LoggerFactory.getLogger(ParametreRestController.class);

    @Autowired
    private ParametreRepository parametreRepository;

    @Autowired
    private ParametreApplication service;

    @RequestMapping(value="/healthcheck",method = RequestMethod.GET,produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public String healthcheck() throws TechnicalParametreException{

        try{
            return new JsonString(SUCCESS).toJson();
        }catch(IOException ioException){
            throw new TechnicalParametreException(ioException);
        }

    }

    @GetMapping(params = { "page", "size" })
    @RequestMapping(value="/parametres",method = RequestMethod.GET,produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public String parametre() throws TechnicalParametreException{
        try{
            MapperParametreDTO mapperdto = new MapperParametreDTO();
            return new ParametrageDTO(service.listerParametragePgi().stream().map(s -> mapperdto.mapParameter(s)).collect(Collectors.toList())).toJson();

        }catch(IOException ioException){ // A préciser
            throw new TechnicalParametreException(ioException);
        }

    }

}

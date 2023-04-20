package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "GRHUM_PARAMETRES")
public class GrhumDataParametre {

    @Id
    @Column(name = "PARAM_ORDRE", updatable = false, unique = true)
    private Integer ordre;

    @Column(name = "PARAM_KEY", columnDefinition = "VARCHAR2(2000)", nullable = false, updatable = false)
    private String key;

    @Column(name = "PARAM_VALUE", columnDefinition = "VARCHAR2(2000)", nullable = false, updatable = false)
    private String value;

    @Column(name = "PARAM_COMMENTAIRES", columnDefinition = "VARCHAR2(500)", nullable = true, updatable = false)
    private String commentaires;

    @Column(name = "PERS_ID_CREATION", columnDefinition = "integer", nullable = true, updatable = false)
    private Integer persidcreation;

    @Column(name = "PERS_ID_MODIFICATION", columnDefinition = "integer", nullable = true, updatable = false)
    private Integer persidmodification;

    @Column(name = "D_CREATION", columnDefinition = "date", nullable = true, updatable = false)
    private Date dcreation;

    @Column(name = "D_MODIFICATION", columnDefinition = "date", nullable = true, updatable = false)
    private Date dmodification;

    @Column(name = "PARAM_TYPE_ID", columnDefinition = "integer", nullable = false, updatable = false)
    private Integer typeid;

    @Column(name = "COMMENTAIRE_LOCAL", columnDefinition = "VARCHAR2(1000)", nullable = true, updatable = false)
    private String commentairelocal;

    @Column(name = "TEM_LOCAL", columnDefinition = "CHAR(1)", nullable = false, updatable = false)
    private String temlocal;


}

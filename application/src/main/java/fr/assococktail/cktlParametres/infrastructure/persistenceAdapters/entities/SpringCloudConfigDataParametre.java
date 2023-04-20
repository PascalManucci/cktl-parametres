package fr.assococktail.cktlParametres.infrastructure.persistenceAdapters.entities;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "PROPERTIES")
public class SpringCloudConfigDataParametre {

    @Id
    @Column(name = "ID", updatable = false, unique = true)
    private Integer id;

    @Column(name = "APPLICATION", columnDefinition = "VARCHAR2(255)", nullable = false, updatable = false)
    private String application;

    @Column(name = "PROFILE", columnDefinition = "VARCHAR2(255)", nullable = false, updatable = false)
    private String profile;

    @Column(name = "LABEL", columnDefinition = "VARCHAR2(255)", nullable = false, updatable = false)
    private String label;

    @Column(name = "PROP_KEY", columnDefinition = "VARCHAR2(255)", nullable = false, updatable = false)
    private String key;

    @Column(name = "VALUE", columnDefinition = "VARCHAR2(255)", nullable = false, updatable = false)
    private String value;

}

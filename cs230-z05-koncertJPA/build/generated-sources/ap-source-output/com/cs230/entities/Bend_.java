package com.cs230.entities;

import com.cs230.entities.Koncert;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-12T16:49:11")
@StaticMetamodel(Bend.class)
public class Bend_ { 

    public static volatile SingularAttribute<Bend, String> bendOpis;
    public static volatile SingularAttribute<Bend, BigDecimal> bendCena;
    public static volatile SingularAttribute<Bend, Long> bendId;
    public static volatile CollectionAttribute<Bend, Koncert> koncertCollection;
    public static volatile SingularAttribute<Bend, String> bendNaziv;

}
package com.cs230.entities;

import com.cs230.entities.Koncert;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-12T16:49:11")
@StaticMetamodel(Oprema.class)
public class Oprema_ { 

    public static volatile SingularAttribute<Oprema, Long> opreId;
    public static volatile SingularAttribute<Oprema, String> opreOpis;
    public static volatile SingularAttribute<Oprema, String> opreNaziv;
    public static volatile SingularAttribute<Oprema, BigDecimal> opreCena;
    public static volatile CollectionAttribute<Oprema, Koncert> koncertCollection;

}
package com.cs230.entities;

import com.cs230.entities.Koncert;
import com.cs230.entities.Korisnik;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-12T16:49:11")
@StaticMetamodel(Karta.class)
public class Karta_ { 

    public static volatile SingularAttribute<Karta, Long> kartId;
    public static volatile SingularAttribute<Karta, String> kartStatus;
    public static volatile SingularAttribute<Karta, String> kartNapomena;
    public static volatile SingularAttribute<Karta, BigDecimal> kartCena;
    public static volatile CollectionAttribute<Karta, Koncert> koncertCollection;
    public static volatile SingularAttribute<Karta, Korisnik> koriId;
    public static volatile SingularAttribute<Karta, Integer> kartMesto;

}
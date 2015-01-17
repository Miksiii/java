package com.cs230.entities;

import com.cs230.entities.Bend;
import com.cs230.entities.Karta;
import com.cs230.entities.Oprema;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-12T16:49:11")
@StaticMetamodel(Koncert.class)
public class Koncert_ { 

    public static volatile SingularAttribute<Koncert, Date> koncDatum;
    public static volatile SingularAttribute<Koncert, Karta> kartId;
    public static volatile SingularAttribute<Koncert, Long> koncId;
    public static volatile SingularAttribute<Koncert, Integer> koncBrojMesta;
    public static volatile SingularAttribute<Koncert, Oprema> opreId;
    public static volatile SingularAttribute<Koncert, String> koncAdresa;
    public static volatile SingularAttribute<Koncert, String> koncNaziv;
    public static volatile SingularAttribute<Koncert, Bend> bendId;
    public static volatile SingularAttribute<Koncert, String> koncKontakt;
    public static volatile SingularAttribute<Koncert, String> koncOpis;

}
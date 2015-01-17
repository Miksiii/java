package com.cs230.entities;

import com.cs230.entities.Karta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-04-12T16:49:11")
@StaticMetamodel(Korisnik.class)
public class Korisnik_ { 

    public static volatile SingularAttribute<Korisnik, String> koriUsername;
    public static volatile CollectionAttribute<Korisnik, Karta> kartaCollection;
    public static volatile SingularAttribute<Korisnik, String> koriPassword;
    public static volatile SingularAttribute<Korisnik, String> koriRola;
    public static volatile SingularAttribute<Korisnik, String> koriTelefon;
    public static volatile SingularAttribute<Korisnik, String> koriAdresa;
    public static volatile SingularAttribute<Korisnik, Long> koriId;

}
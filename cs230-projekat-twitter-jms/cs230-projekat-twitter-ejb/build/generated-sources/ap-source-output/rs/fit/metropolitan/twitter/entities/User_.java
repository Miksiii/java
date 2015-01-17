package rs.fit.metropolitan.twitter.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.fit.metropolitan.twitter.entities.Follow;
import rs.fit.metropolitan.twitter.entities.Post;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-03T12:47:23")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> userPassword;
    public static volatile CollectionAttribute<User, Post> postCollection;
    public static volatile CollectionAttribute<User, Follow> followCollection;
    public static volatile SingularAttribute<User, String> userEmail;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Integer> userId;

}
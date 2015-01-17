package rs.fit.metropolitan.twitter.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.fit.metropolitan.twitter.entities.User;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-03T12:47:23")
@StaticMetamodel(Follow.class)
public class Follow_ { 

    public static volatile SingularAttribute<Follow, Integer> followId;
    public static volatile SingularAttribute<Follow, Integer> followUser;
    public static volatile SingularAttribute<Follow, String> userName;
    public static volatile SingularAttribute<Follow, User> userId;
    public static volatile SingularAttribute<Follow, String> followUserName;

}
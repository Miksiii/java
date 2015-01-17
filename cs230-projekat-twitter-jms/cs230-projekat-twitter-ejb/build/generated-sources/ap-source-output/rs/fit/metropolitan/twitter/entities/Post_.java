package rs.fit.metropolitan.twitter.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import rs.fit.metropolitan.twitter.entities.User;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-03T12:47:23")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> postMessage;
    public static volatile SingularAttribute<Post, Date> postDate;
    public static volatile SingularAttribute<Post, Integer> postId;
    public static volatile SingularAttribute<Post, String> userName;
    public static volatile SingularAttribute<Post, User> userId;

}
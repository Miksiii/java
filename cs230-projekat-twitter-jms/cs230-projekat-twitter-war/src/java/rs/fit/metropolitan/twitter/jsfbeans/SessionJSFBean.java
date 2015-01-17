    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.jsfbeans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;
import rs.fit.metropolitan.twitter.beans.BusinessStatelessBeanLocal;
import rs.fit.metropolitan.twitter.beans.UserStatelessBeanLocal;
import rs.fit.metropolitan.twitter.entities.Follow;
import rs.fit.metropolitan.twitter.entities.Post;
import rs.fit.metropolitan.twitter.entities.User;
import rs.fit.metropolitan.twitter.models.MessageModel;

@ManagedBean(name = "sesija")
@SessionScoped
public class SessionJSFBean {
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    @Resource(lookup = "jms/myTwitterQueue")
    private Queue queue;
    private List<MessageModel> queueMessages = new ArrayList<>();
    
    @EJB
    private BusinessStatelessBeanLocal businessStatelessBean;
    @EJB
    private UserStatelessBeanLocal userStatelessBean;
    private String message;
    private int id;
    private String username;
    private String email;
    private String password;
    private Date date;
    private User currentUser = null;
    
    
    public SessionJSFBean() {
    }
    
    /**
     * Geter za poruku koju korisnik salje
     * @return string
     */
    public String getMessage() {
        return message;
    }

    /**
     * Seter za poruku koju korisnik salje (post message)
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
    /**
     * Metoda koja vraca objekat korisnika koji je trenutno ulogovan
     * @return 
     */
    public User getCurrentUser() {
        return currentUser;
    }
    
    /**
     * seter identifikatora
     * @param userId 
     */
    public void setId(int userId) {
        this.id = userId;
    }
    
    /**
     * geter identifikatora
     * @return 
     */
    public int getId() {
        return id;
    }
    
    /**
     * seter korisnickog imena
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * geter korisnickog imena
     * @return 
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * seter emaila
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * geter emaila
     * @return 
     */
    public String getEmail() {
        return email;
    }
    /**
     * seter passworda
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * geter passworda
     * @return 
     */
    public String getPassword() {
        return password;
    }

    /**
     * seter datuma
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * Geter datuma
     * @return 
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Metoda koja se poziva prilikom submitovanja forme za logovanje. 
     * Najpre se vrsi provera da li su sva polja popunjena, zatim validacija
     * konkretnog korisnika nakon cega ukoliko je korisnik uneo prave login
     * podatke vrednosti njegovih atributa iz baze setuju vrednosti atributa u 
     * userStatefulBean-u
     * @return String
     * @throws IOException 
     */
    public String getSignInResponse() throws IOException {
        if(email != null && password != null) {
            if(businessStatelessBean.validateUser(email, password) == true){
                currentUser = businessStatelessBean.currentUser(email, password);
                
                System.out.println("*** SUCCESSFULL LOGGED IN ***");
                System.out.println("*** SETTING USER PARAMETERS ***");
                
                userStatelessBean.setSession(true);
                setId(currentUser.getUserId());
                userStatelessBean.setId(currentUser.getUserId());
                setUsername(currentUser.getUserName());
                userStatelessBean.setUsername(currentUser.getUserName());
                setEmail(currentUser.getUserEmail());
                userStatelessBean.setEmail(currentUser.getUserEmail());
                setPassword(currentUser.getUserPassword());
                userStatelessBean.setPassword(currentUser.getUserPassword());
                
                /* redirektovanje korisnika u dashboard */
                ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
                context.redirect("dashboard.xhtml");
            } else {
                return "Username or password incorrect.";
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Metoda koja vraca listu korisnika
     * @return users list
     */
    public List<User> getUsersList() {
        List<User> list = new ArrayList<User>();
        list = businessStatelessBean.usersList();
        
        for (Iterator<User> it = list.iterator(); it.hasNext(); ) {
            User user = it.next();
            if (user.getUserEmail().equals(currentUser.getUserEmail())) {
                it.remove();
            }
        }
        return list;
    }

    
    /**
     * Metoda preko koje se korisnik subscribeuje na nekog korisnika
     * @param followId => id korisnika kojeg korisnik zeli da prati
     * @param followUsername  => ime korisnika kojeg korisnik zeli da prati
     */
    public void subscribe(int followId, String followUsername) {
        businessStatelessBean.subscribe(currentUser, currentUser.getUserName(), followId, followUsername);
    }
    
    /**
     * Na osnovu prosledjenog ID-a korisnika on se brise iz liste osoba koje 
     * trenutni korisnik prati.
     * @param unfollowId
     */
    public void unsubscribe(int unfollowId){
        businessStatelessBean.unsubscribe(currentUser, unfollowId);
    }
    
    /**
     * Metoda koja vraca listu korisnika na koje smo se pretplatili
     * @return subscribed To list
     */
    public List<Follow> getSubscribedList() {
        return businessStatelessBean.subscribedList(currentUser);
    }
    
    /**
     * Metoda vraca velicinu liste odnosno ukupan broj korisnika koji prate 
     * trenutno ulogovanog.
     * @return 
     */
    public String getSubscribersList() {
        int followersNumber = businessStatelessBean.subscribersList(currentUser.getUserId()).size();
        String text;
        if(followersNumber == 1) {
            text = "person follows you.";
        } else if (followersNumber == 2) {
            text = "persons follows you.";
        } else {
            text = "people follows you";
        }
        return (followersNumber == 0) ? "No followers so far :(" : followersNumber + " " + text;
    }
    
    /**
     * Metoda koja dovlaci sve poruke za koje se korisnik pretplatio
     * @return followed posts
     */
    public List<Post> getPostsList() {
        List<Post> posts = new ArrayList<>();
        List<Follow> publishTo = new ArrayList<>();
        posts = businessStatelessBean.postsList();
      
        return posts; 
    }
    
    
     /**
     * Kada korisnik zeli da napise novu poruku prilikom sabmitovanja iste 
     * poziva se ovaj metod koji dalje poziva metodu session beana 
     * odnosnno dao sloja za upis te poruke u bazu.
     * @return 
     */
    public String getSentMessageResponse() {

        if (message != null) {
            //userStatelessBean.sentMessageToQueue(message);
            businessStatelessBean.createPost(currentUser, message);
            sendJMSMessage();
            message = null;
            return null;
        } else { 
            return null;
        }
    }
    
    /**
     * Metoda koja salje JMS poruku u queue. Ovaj metod se poziva kada je pritisnuto
     * dugme sent message.
     */
    public void sendJMSMessage() {
        System.out.println(" **** SEND JMS MESSAGE METHOD CALLED **** ");
        System.out.println("JMS Producer username!: " + username);
        System.out.println("JMS Producer message!: " + message);
        
        userStatelessBean.sendJMSMessageToMyTwitterQueue(message, username);
    }
        
    
    /**
     * Metoda koja kreira JMS konzumer objekat i metodom receive preuzima 
     * poruku iz Queuea, deli je na dva dela: Prvi deo poruke predstavlja ime
     * korisnika koji je tu poruku poslao dok drugi deo predstavlja samu poruku.
     * Ukoliko ta poruka nije = null ona se dodaje u listu poruka (queueMessages)
     */
    public void checkQueue() {
        //subscribersList();
        try {
            JMSConsumer receiver = context.createConsumer(queue);
            String text = receiver.receiveBody(String.class, 1000);

            if (text != null) {
                
                String[] find          = text.split("#");
                String   userSender    = find[1].trim();
                String   senderMessage = find[2].trim();
                
                //datum 
                Calendar cal = java.util.Calendar.getInstance(); 
                Date timeNow = new Date(cal.getTimeInMillis()); 
                
                queueMessages.add(new MessageModel(
                        userSender,
                        senderMessage,
                        timeNow)
                );
                
            } else {
                FacesMessage facesMessage
                        = new FacesMessage("No message received after 1 second");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }
        } catch (JMSRuntimeException t) {
            System.out.println("Exception occured in getMessage() " + t.toString());
        }
    }
    
    /**
     * Metoda koja vraca Message Queue listu sa porukama i to samo one poruke 
     * koje pisu korisnici koji su se subscribeovali.
     * @return queue Messages list
     */
    public List<MessageModel> getQueueMessages() {
        
            for(Iterator<MessageModel> itQueue = queueMessages.iterator(); itQueue.hasNext();) {
                MessageModel mModel = itQueue.next();
                for(Follow messageConsumers : subscribersList()) {
                    if(!mModel.getUsername().equals(messageConsumers.getUserName())) {
                        System.out.println(messageConsumers.getUserName() + " removed from the list.");
                        itQueue.remove();
                    }
                }
            }
        
        return queueMessages;
    }
    
    /**
     * Lista svih korisnika koji su se subscribeovali na korisnikov akaunt.
     * @return 
     */
    public List<Follow> subscribersList() {
        return businessStatelessBean.followers(id);
    }
        
    /**
     * Ova metoda poziva se na svakoj stranici na kojoj je potrebno proveriti
     * da li je korisnik ulogovan ili ne. Ova metoda dopusta ili zabranjuje pristup
     * odredjenoj stranici u zavisnosti od toga da li je korisnik ulogovan ili ne.
     * @throws IOException 
     */
    public void permission() throws IOException {
        
        if(userStatelessBean.getSession() == false) {
            System.out.println("*** The user has no permission to visit this page. No logon.. *** ");
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext(); 
            context.redirect("login.xhtml");
        } else {
            System.out.println("*** Logged in. Permissions granted.. *** ");
        }
    }
    
    /**
     * Korisnik poziva ovaj metod kroz commandLink koji unistava trenutnu sesiju
     * i redirektuje korisnika na pocetnu stranicu
     * @throws IOException 
     */
    public void destroy() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        userStatelessBean.setSession(false);
        context.redirect("index.xhtml");
        System.out.println("*** Session destroyed ***");
    }
    
}

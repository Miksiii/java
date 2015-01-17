/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rs.fit.metropolitan.twitter.jsfbeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;
import rs.fit.metropolitan.twitter.beans.BusinessStatelessBeanLocal;
import rs.fit.metropolitan.twitter.beans.UserStatelessBean;
import rs.fit.metropolitan.twitter.beans.UserStatelessBeanLocal;
import rs.fit.metropolitan.twitter.entities.Follow;
import rs.fit.metropolitan.twitter.models.MessageModel;

/**
 *
 * @author Milan
 */
@Stateless
@ManagedBean(name = "receiver")
@RequestScoped
public class ReceiverBean {
    @EJB
    private UserStatelessBeanLocal userStatelessBean;
    @EJB
    private BusinessStatelessBeanLocal businessStatelessBean;

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    @Resource(lookup = "jms/myTwitterQueue")
    private Queue queue;
    private List<MessageModel> queueMessages = new ArrayList<>();
    
    /**
     * Creates a new instance of ReceiverBean
     */
    public ReceiverBean() {
    }
    
    /**
     * Metoda koja kreira JMS konzumer objekat i metodom receive preuzima 
     * poruku iz Queuea, deli je na dva dela: Prvi deo poruke predstavlja ime
     * korisnika koji je tu poruku poslao dok drugi deo predstavlja samu poruku.
     * Ukoliko ta poruka nije = null ona se dodaje u listu poruka (queueMessages)
     */
    public void getMessage() {
        subscribersList();
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
                
                System.out.println("Cela poruka: " + text);
                System.out.println("Poruku poslao: " + userSender);
                System.out.println("Poruka sadrzine: " + senderMessage);
                System.out.println("Queue duzine: " + queueMessages.size());
                
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
     * Metoda koja vraca Queue listu sa porukama
     * @return queue Messages list
     */
    public List<MessageModel> getQueueMessages() {
        return queueMessages;
    }
    
    public List<Follow> subscribersList() {
        System.out.println("Generating list for specific user..");
        List<Follow> lista = new ArrayList<>();
        lista = businessStatelessBean.followers(userStatelessBean.getId());
        for(Follow list : lista) {
            System.out.println("Trenutni korisnik je pracen od strane: " + list.getUserName());
        }
        System.out.println("prosao" + userStatelessBean.getId());
        return businessStatelessBean.subscribersList(userStatelessBean.getId());
    }
    
}

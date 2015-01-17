/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jms.demo;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;

/**
 *
 * @author student
 */
@ManagedBean
@Dependent
public class ReceiverBean {

    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    @Resource(lookup = "jms/myQueue")
    private Queue queue;

    /**
     * Creates a new instance of ReceiverBean
     */
    public ReceiverBean() {
    }

    public void getMessage() {
        try {
            System.out.println("context======= " + context);
            
            JMSConsumer receiver = context.createConsumer(queue);
            String text = receiver.receiveBody(String.class, 1000);

            if (text != null) {
                FacesMessage facesMessage
                        = new FacesMessage("Reading message: " + text);
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            } else {
                FacesMessage facesMessage
                        = new FacesMessage("No message received after 1 second");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }
        } catch (JMSRuntimeException t) {

            System.out.println(t.toString());
        }
    }
}

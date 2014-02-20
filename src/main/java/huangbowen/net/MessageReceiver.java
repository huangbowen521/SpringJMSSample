package huangbowen.net;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by twer on 2/20/14.
 */
public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
        if(message instanceof MapMessage) {
            MapMessage mapMessage = (MapMessage) message;
            try {
                String name = mapMessage.getString("name");
                System.out.println(name);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

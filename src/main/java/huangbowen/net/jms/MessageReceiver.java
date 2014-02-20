package huangbowen.net.jms;

import javax.jms.*;

/**
 * Created by twer on 2/20/14.
 */
public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.println(String.format("Received: %s",text));
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

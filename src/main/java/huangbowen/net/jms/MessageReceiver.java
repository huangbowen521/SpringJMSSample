package huangbowen.net.jms;

import javax.jms.*;

public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
        if(message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                String text = textMessage.getText();
                System.out.println(String.format("Received: %s",text));
                try {
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}

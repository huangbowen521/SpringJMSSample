package huangbowen.net.jms;

import org.springframework.jms.core.JmsTemplate;

/**
 * Created by twer on 2/20/14.
 */
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final String text) {
        jmsTemplate.convertAndSend(text);
    }
}

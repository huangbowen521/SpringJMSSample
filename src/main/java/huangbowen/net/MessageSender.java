package huangbowen.net;

import org.springframework.jms.core.JmsTemplate;

import java.util.Map;

/**
 * Created by twer on 2/20/14.
 */
public class MessageSender {

    private final JmsTemplate jmsTemplate;

    public MessageSender(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final Map map) {
        jmsTemplate.convertAndSend(map);
    }
}

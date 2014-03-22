package huangbowen.net;

import huangbowen.net.jms.MessageSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.BrowserCallback;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.jms.JMSException;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import java.util.Enumeration;

@ContextConfiguration(locations = {"/concurrent/activeMQConnection.xml"})
@DirtiesContext
public class ConcurrentConsumerFunctionIntegrationTest extends AbstractJUnit4SpringContextTests {

    private final static String DLQ = "bar";
    @Autowired
    public JmsTemplate jmsTemplate;

    @Autowired
    public MessageSender messageSender;


    private int getMessagesInDLQ() {
        return jmsTemplate.browse(DLQ, new BrowserCallback<Integer>() {
            @Override
            public Integer doInJms(Session session, QueueBrowser browser) throws JMSException {
                Enumeration messages = browser.getEnumeration();
                int total = 0;
                while(messages.hasMoreElements()) {
                    messages.nextElement();
                    total++;
                }

                return  total;
            }
        });
    }


    @Test
    public void shouldHandleMessageConcurrently() throws Exception {


        for (int i = 0; i < 100; i++) {
            messageSender.send(String.format("message %d",i));
        }

        while(getMessagesInDLQ() > 0) {

        }
    }
}

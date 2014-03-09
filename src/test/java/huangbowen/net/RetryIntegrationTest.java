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

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 3/9/14.
 */
@ContextConfiguration(locations = {"/retry/activeMQConnection.xml"})
@DirtiesContext
public class RetryIntegrationTest extends AbstractJUnit4SpringContextTests {


    @Autowired
    public JmsTemplate jmsTemplate;

    @Autowired
    public MessageSender messageSender;


    private int getMessagesInQueue() {
        return jmsTemplate.browse("bar", new BrowserCallback<Integer>() {
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
    public void shouldRetryIfExceptionHappened() throws Exception {
        messageSender.send("this is a message");
        Thread.sleep(5000);

        assertThat(getMessagesInQueue(), is(1));
    }
}

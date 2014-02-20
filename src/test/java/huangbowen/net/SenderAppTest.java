package huangbowen.net;

import huangbowen.net.jms.MessageSender;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple SenderApp.
 */
public class SenderAppTest {

    @Test
    public void shouldGetMessageSender() throws Exception {
        MessageSender messageSender = SenderApp.getMessageSender();
        assertNotNull("MessageSender shouldn't be null.",messageSender);
    }
}

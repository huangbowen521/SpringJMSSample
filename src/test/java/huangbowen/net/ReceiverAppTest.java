package huangbowen.net;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Unit test for simple ReceiverApp.
 */
public class ReceiverAppTest {

    @Test
    public void shouldGetMessageSender() throws Exception {
        MessageSender messageSender = ReceiverApp.getMessageSender();
        assertNotNull("MessageSender shouldn't be null.",messageSender);
    }
}

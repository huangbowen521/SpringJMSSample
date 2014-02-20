package huangbowen.net;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class ReceiverApp
{
    public static void main( String[] args )
    {
        MessageSender sender = getMessageSender();
        Map map = new HashMap<String, String>();
        map.put("name", "Bowen");
        sender.send(map);
    }

    public static MessageSender getMessageSender() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springJMSSender.xml");
       return (MessageSender) context.getBean("messageSender");
    }
}

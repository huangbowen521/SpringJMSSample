package huangbowen.net;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by twer on 2/20/14.
 */
public class ReceiverApp {
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext("springJMSConfiguration.xml", "springJMSReceiver.xml");
    }
}

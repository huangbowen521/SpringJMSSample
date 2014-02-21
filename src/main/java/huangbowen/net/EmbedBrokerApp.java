package huangbowen.net;

import java.io.IOException;

import static huangbowen.net.SenderApp.start;

public class EmbedBrokerApp
{
    public static void main( String[] args ) throws IOException {
        start("embedBroker.xml");
    }
}

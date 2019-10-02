import com.lloseng.ocsf.client.AbstractClient;

class ClientImpl extends AbstractClient {

    ClientImpl(String h, int p) {

        super(h,p);
    }

    protected void connectionClosed() {

        System.out.println("Client: Closed");
        System.out.println("Client.isConnected()="+isConnected());
    }

    protected void connectionException(Exception exception) {

        System.out.println("Client exception: " + exception);
    }

    protected void connectionEstablished() {

        System.out.println("Client: Connected");
        System.out.println("Client.isConnected()="+isConnected());
    }

    protected void handleMessageFromServer(Object msg){

        System.out.println("Client: Message received=" +msg);
    }
}

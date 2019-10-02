import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;

class ServerImpl extends AbstractServer {

    ServerImpl(int p) {

        super(p);
    }

    protected void serverStarted() {

        System.out.println("Server: Started");
        System.out.println("Server.isListening()="+isListening());
        System.out.println("Server.isClosed()="+isClosed());
        System.out.println("Server.getNumberOfClients()="+getNumberOfClients());
    }

    protected void serverStopped() {

        System.out.println("Server: Stopped");
        System.out.println("Server.isListening()="+isListening());
        System.out.println("Server.isClosed()="+isClosed());
        System.out.println("Server.getNumberOfClients()="+getNumberOfClients());
    }

    protected void serverClosed() {

        System.out.println("Server: Closed");
        System.out.println("Server.isListening()="+isListening());
        System.out.println("Server.isClosed()="+isClosed());
        System.out.println("Server.getNumberOfClients()="+getNumberOfClients());
    }

    protected void clientConnected(ConnectionToClient client) {

        System.out.println("Server: client #" + getNumberOfClients() + " connected");
    }

    synchronized protected void clientDisconnected(
            ConnectionToClient client) {

        System.out.println("Server: client disconnected");
    }

    synchronized protected void clientException(
            ConnectionToClient client, Throwable exception) {

        System.out.println("Connection to client exception: " + exception);
    }

    protected void listeningException(Throwable exception) {

        System.out.println("Listening exception: " + exception);
    }

    protected void handleMessageFromClient(Object msg,
                                           ConnectionToClient client){

        System.out.println("Server: Message received=" + msg);
        this.sendToAllClients(msg);
    }
}

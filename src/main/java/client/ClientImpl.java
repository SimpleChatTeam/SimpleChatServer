package client;
import com.lloseng.ocsf.client.AbstractClient;

class ClientImpl extends AbstractClient {
	
	private int user_id;
	
	/**
	 * Création client 
	 * @param adresse : String
	 * @param port : int
	 */
    ClientImpl(String h, int p) {
        super(h, p);
    }
    
    /**
     * A la connexion
     */
    protected void connectionEstablished() {
        System.out.println("Client: Connected");
        System.out.println("Client.isConnected() = " + isConnected());
    }
    
    /**
     * A la déconnexion
     */
    protected void connectionClosed() {
        System.out.println("Client: Closed");
        System.out.println("Client.isConnected() = " + isConnected());
    }
    
    /**
     * Exception lors de la connexion
     */
    protected void connectionException(Exception exception) {
        System.out.println("Client exception: " + exception);
    }
    
    /**
     * Reception d'un message du serveur
     * @param msg : String
     */
    protected void handleMessageFromServer(Object msg){
        System.out.println("Client: Message received = " + msg);
    }
}

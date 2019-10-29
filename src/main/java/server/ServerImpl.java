package server;
import com.lloseng.ocsf.server.AbstractServer;
import com.lloseng.ocsf.server.ConnectionToClient;

class ServerImpl extends AbstractServer {
	
	/**
	 * Création serveur
	 * @param port : int
	 */
    ServerImpl(int p) {
        super(p);
    }

    /**
     * Au lancement du serveur
     */
    protected void serverStarted() {
        System.out.println("Server: Started");
        System.out.println("Server.isListening() = " + isListening());
        System.out.println("Server.isClosed() = " + isClosed());
        System.out.println("Server.getNumberOfClients() = " + getNumberOfClients());
    }
    
    /**
     * A l'arrêt du serveur
     */
    protected void serverStopped() {
        System.out.println("Server: Stopped");
        System.out.println("Server.isListening() = " + isListening());
        System.out.println("Server.isClosed() = " + isClosed());
        System.out.println("Server.getNumberOfClients() = " + getNumberOfClients());
    }

    /**
     * A la fermeture du serveur
     */
    protected void serverClosed() {
        System.out.println("Server: Closed");
        System.out.println("Server.isListening() = " + isListening());
        System.out.println("Server.isClosed()="+isClosed());
        System.out.println("Server.getNumberOfClients()="+getNumberOfClients());
    }

    /**
     * Renvoie le nombre de clients connectés à chaque nouvelle connexion
     */
    protected void clientConnected(ConnectionToClient client) {
        System.out.println("Server: client #" + getNumberOfClients() + " connected");
    }
    
    /**
     * A la Déconnexion d'un client
     */
    synchronized protected void clientDisconnected(ConnectionToClient client) {
        System.out.println("Server: client disconnected");
    }
    
    /**
     * Excpetion lors de la connexion
     */
    synchronized protected void clientException(ConnectionToClient client, Throwable exception) {
        System.out.println("Connection to client exception: " + exception);
    }
    
    /**
     * Excpetion lors de l'écoute
     */
    protected void listeningException(Throwable exception) {
        System.out.println("Listening exception: " + exception);
    }
    
    /**
     * A la reception d'un message
     * @param message : String
     * @param client : ConnectionToCLient
     */
    protected void handleMessageFromClient(Object msg, ConnectionToClient client){
        System.out.println("Server: Message received=" + msg);
        this.sendToAllClients(msg); // Il faudrait qu'il ne le retourne pas à celui qui a envoyé le message
    }
}
package server;
import java.io.IOException;

public class ServerRun implements Runnable {
	
	/**
	 * Lancement du serveur
	 * @param args
	 */
    public static void main(String[] args) {
        ServerRun server = new ServerRun(new ServerImpl(12345));
        server.run();
    }

    private ServerImpl server;

    public ServerRun(ServerImpl server) {
        this.server = server;
    }

    @Override
    public void run() {
        try {
            server.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

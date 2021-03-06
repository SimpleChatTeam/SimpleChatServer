package client;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientRun implements Runnable {
	
	/**
	 * Lancement du client
	 * @param args
	 */
    public static void main(String[] args) {
        ClientRun clientRun = new ClientRun(new ClientImpl("localhost", 12345));
        clientRun.run();
    }

    private ClientImpl client;

    private ClientRun(ClientImpl client) {
        this.client = client;
    }

    @Override
    public void run() {
        String msg = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while(!msg.equals("q"))
        {
            try {
                client.isConnected();
                client.openConnection();
                System.out.println("Message or q to quit");
                msg=in.readLine();
                client.sendToServer(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


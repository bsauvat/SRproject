package fr.esir.sr.SRproject.Server;

import fr.esir.sr.SRproject.Client.ClientCallBack;
import fr.esir.sr.SRproject.Game.GameImpl;

import java.io.Serializable;
import java.rmi.Naming;	//Import naming classes to bind to rmiregistry
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server, Serializable {

    private List<ClientCallBack> clients = new ArrayList<>();

    public ServerImpl() {
        super();
    }

    public String sayHello() throws RemoteException {
        return "Hello from server!";
    }

    public void registerClientCallBack(ClientCallBack callback) throws RemoteException {
        clients.add(callback);
    }

    private void notifyClients(String message) {
        for (ClientCallBack client : clients) {
            try {
                client.notifyClient(message);
            } catch (RemoteException e) {
                // Handle RemoteException (e.g., client disconnected)
                // Optionally remove the client from the list
            }
        }
    }

    public static void main(String args[]) {
        try {
            ServerImpl server = new ServerImpl();
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            java.rmi.Naming.rebind("//localhost/MyServer", server);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}

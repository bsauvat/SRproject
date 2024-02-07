package fr.esir.sr.SRproject.Client;

import fr.esir.sr.SRproject.Client.ClientCallBack;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientCallBackImpl extends UnicastRemoteObject implements ClientCallBack {
    public ClientCallBackImpl() throws RemoteException {
        super();
    }

    @Override
    public void notifyClient(String message) throws RemoteException {
        System.out.println("Received message from server: " + message);
        // Handle the message as needed
    }
}

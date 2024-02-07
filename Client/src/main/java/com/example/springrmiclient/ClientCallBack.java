package fr.esir.sr.SRproject.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote {
    void notifyClient(String message) throws RemoteException;
}


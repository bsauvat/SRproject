package fr.esir.sr.SRproject.Server;

import fr.esir.sr.SRproject.Client.ClientCallBack;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    void registerClientCallBack(ClientCallBack callback) throws RemoteException;
}

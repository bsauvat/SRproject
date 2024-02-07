package fr.esir.sr.SRproject.Client.RemoteServices;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServices extends Remote {
    String sayHello() throws RemoteException;
}


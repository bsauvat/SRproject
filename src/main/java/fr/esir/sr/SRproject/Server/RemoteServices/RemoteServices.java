package fr.esir.sr.SRproject.Server.RemoteServices;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteServices{
    public String sayHello() throws RemoteException;
}


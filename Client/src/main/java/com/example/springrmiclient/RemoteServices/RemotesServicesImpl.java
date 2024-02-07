package fr.esir.sr.SRproject.Client.RemoteServices;

import fr.esir.sr.SRproject.Server.RemoteServices.RemoteServices;

import java.rmi.RemoteException;

public class RemotesServicesImpl implements RemoteServices {

    @Override
    public String sayHello() throws RemoteException {
        return "Hello !";
    }
}

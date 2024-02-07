package fr.esir.sr.SRproject.Game;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Game extends Remote {


    public void MovePlayer(int playerID, int[] delta) throws RemoteException;

    public boolean IsOnCoin(int playerID) throws RemoteException;

    public void SpawnCoin() throws RemoteException;

    public void RemoveCoin(Coin c) throws RemoteException;

}


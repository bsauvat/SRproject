package fr.esir.sr.SRproject.Game;

import fr.esir.sr.SRproject.Game.Player;

import java.awt.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class GameImpl extends UnicastRemoteObject implements Game {

    int cellSize = 20 ;
    int gridSize = 20 ;
    int [] playerIDs;
    Player[] players;
    Coin[][] coinMap = new Coin[gridSize][gridSize];
    Container myContainer ;
    Display display = new Display();


    public GameImpl() throws RemoteException {
        super();
    }

    public void CreatePlayer(){
        // Création du player
        playerIDs[playerIDs.length] = playerIDs.length;
        players[players.length] = new Player(display);
    }

    public void InitClient() throws RemoteException{

    }

    public Player getPlayerById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null; // Return null if no player with the specified ID is found
    }

    @Override
    public void MovePlayer(int playerID, int[] delta) throws RemoteException {
        getPlayerById(playerID).moveRect(delta);
    }

    @Override
    public boolean IsOnCoin(int playerID) throws RemoteException {
        Player player = getPlayerById(playerID);
        return (coinMap[player.x][player.y]!=null);
    }

    public void RemoveCoin(Coin c){
        myContainer.remove(c);
        //pack();
        coinMap = new Coin[gridSize][gridSize];
    }

    @Override
    public void SpawnCoin() throws RemoteException {
        Random rand = new Random();
        int i = rand.nextInt(gridSize);
        int j = rand.nextInt(gridSize);
        coinMap[i][j] = new Coin(display);
        coinMap[i][j].setGridPos(i,j);
    }
}

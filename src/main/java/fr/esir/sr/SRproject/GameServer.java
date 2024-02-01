package fr.esir.sr.SRproject;
import java.rmi.Naming;	//Import naming classes to bind to rmiregistry

public class GameServer {

    public GameServer() {
        try {
            GameImpl g = new GameImpl();
            Naming.rebind("rmi://localhost/game", g);
            System.out.println("Server started");
        }
        catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    }

    public static void main(String args[]) {
        new GameServer();;
    }
}

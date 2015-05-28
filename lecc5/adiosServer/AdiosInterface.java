package adiosServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AdiosInterface extends Remote{
   String sayAdios() throws RemoteException ;
}
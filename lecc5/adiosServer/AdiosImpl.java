package adiosServer;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;
import log.MiLog;

public class AdiosImpl extends UnicastRemoteObject implements AdiosInterface {
    
    static MiLog serverLog = new MiLog();
    
   public AdiosImpl() throws RemoteException {
          super();
   }
   public AdiosImpl(int puerto, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
            super(puerto, csf, ssf);
   }

   public String sayAdios() throws RemoteException {
       
        serverLog.info("Mensaje recibido por el usuario: Hasta luego, mundo!");
        return "Hasta luego, mundo!";
   }

   public static void main(String[] args) {
      try {
        
        //Registry registro = LocateRegistry.createRegistry(1099);
        RMIClientSocketFactory rmicsf = new SslRMIClientSocketFactory();
        RMIServerSocketFactory rmissf = new SslRMIServerSocketFactory();

        Registry registro = LocateRegistry.createRegistry(1099, rmicsf, rmissf);

        AdiosImpl oRemoto = new AdiosImpl(0, rmicsf, rmissf);

        registro.rebind("ObjetoAdios", oRemoto) ;

        serverLog.info("Servidor preparado");
        System.err.println("Servidor preparado");
        
       
      } catch (Exception e) {
        serverLog.info("Excepción del servidor: " + e.toString());
        System.err.println("Excepción del servidor: " + e.toString()); e.printStackTrace();
      }
   }
} 
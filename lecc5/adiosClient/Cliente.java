package adiosClient;

import adiosServer.AdiosInterface;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Cliente {
    
    private Cliente() { }

    public static void main(String[] args) {
        
        String host = (args.length < 1) ? null : args[0];

        try {
            
            RMIClientSocketFactory rmicsf = new SslRMIClientSocketFactory();
            
            //Registry registro = LocateRegistry.getRegistry(1099);
            Registry registro = LocateRegistry.getRegistry("localhost", 1099, rmicsf);
            
            AdiosInterface stub = (AdiosInterface) registro.lookup("ObjetoAdios");

            String response = stub.sayAdios();
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
} 
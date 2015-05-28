package log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author adrcalv
 */

public class MiLog {
    
    Logger logger;  
    FileHandler fh;  

    public MiLog(){
        try{ 
            logger = Logger.getLogger("MyLog");
            fh = new FileHandler("C:/temp/test/MyLogFile.log");  
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();  
            fh.setFormatter(formatter); 
        }catch(IOException e){
            logger.info("Excepcion de E/S");
        }catch(SecurityException a){
            logger.info("Excepcion de Seguridad");
        }
    }

    public void info(String mensaje){
        
        logger.info(mensaje);
    }
    
}

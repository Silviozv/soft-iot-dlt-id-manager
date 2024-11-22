package dlt.id.manager.model;

import dlt.id.manager.services.IIDManagerService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uellington Damasceno
 */
public class IDManager implements IIDManagerService {

    private String id;
    private String ip;
    private Logger log;

    public IDManager() {
        this.id = UUID.randomUUID().toString();
    }

    public void start() {
        try {
            this.ip = this.getEnvOrDefault("GATEWAY_REAL_IP", InetAddress.getLocalHost().getHostAddress().trim());
            this.id = UUID.randomUUID().toString();
            this.log = Logger.getLogger(IDManager.class.getName());

            this.log.log(Level.INFO, "IP: {0}", this.ip);
        } catch (UnknownHostException ex) {
            Logger.getLogger(IDManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stop() {
    }

    @Override
    public String getIP() {
        return this.ip;
    }

    @Override
    public String getID() {
        return this.id;
    }
    
    private String getEnvOrDefault(String env, String defaultValue){
        String value = System.getenv(env);
        return value == null ? defaultValue : value;
    }

}

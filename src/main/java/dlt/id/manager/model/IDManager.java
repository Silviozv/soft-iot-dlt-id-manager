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

    public IDManager() {
        this.id = UUID.randomUUID().toString();
    }

    public void start() {
        try {
            this.ip = InetAddress.getLocalHost().getHostAddress().trim();
        } catch (UnknownHostException ex) {
            Logger.getLogger(IDManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getIP() {
        return this.ip;
    }

    @Override
    public String getID() {
        return this.id;
    }

}

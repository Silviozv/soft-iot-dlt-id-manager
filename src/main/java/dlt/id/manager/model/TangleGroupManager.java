package dlt.id.manager.model;

import dlt.id.manager.services.IDLTGroupManager;

/**
 *
 * @author Uellington Damasceno
 */
public class TangleGroupManager implements IDLTGroupManager {

    private String group;
    
    public TangleGroupManager(String group){
        this.group = group;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public void setGroup(String group) {
        this.group = group;
    }

}

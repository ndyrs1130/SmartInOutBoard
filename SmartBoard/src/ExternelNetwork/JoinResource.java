/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternelNetwork;

import MinTFramework.ExternalDevice.DeviceType;
import MinTFramework.Network.Request;
import MinTFramework.storage.ThingProperty;

/**
 *
 * @author Shin
 */
public class JoinResource extends ThingProperty{
    public JoinResource(){
        super("Join",DeviceType.NONE);
    }

    @Override
    public void set(Request rqst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(Request rqst) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

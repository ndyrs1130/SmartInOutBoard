/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternelNetwork;

/**
 *
 * @author Shin
 */
import MinTFramework.ExternalDevice.DeviceType;
import MinTFramework.Network.Request;
import MinTFramework.storage.ThingInstruction;
import MinTFramework.storage.ThingProperty;
import org.json.simple.JSONObject;
import smartboard.DBconnector;
import smartboard.InOutBoard;
import smartboard.MessageBox;

public class MessageCheckResource extends ThingInstruction {


    public MessageCheckResource() {
        super("msgcheck", DeviceType.NONE);
    }

    @Override
    public void set(Request rqst) {
        int msgid = rqst.getResourceInt();
        System.out.println("messageCheckResource: "+rqst.getResourceInt());
        InOutBoard.getInstance().updateMSGcheck(msgid);
        //db.updateMSGcheck(msgid);

    }

    @Override
    public Object get(Request rqst) {

        return null;
    }

}

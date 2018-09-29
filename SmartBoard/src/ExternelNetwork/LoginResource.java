/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternelNetwork;

import MinTFramework.ExternalDevice.DeviceType;
import MinTFramework.Network.Request;
import MinTFramework.storage.ThingProperty;
import java.util.ArrayList;
import smartboard.DBconnector;
import smartboard.InOutBoard;
import smartboard.MessageBox;
import smartboard.Researcherinfo;

/**
 *
 * @author Shin
 */
public class LoginResource extends ThingProperty {

    DBconnector db;
    ArrayList<Researcherinfo> reinfo = new ArrayList<>();

    public LoginResource() {
        super("LoginResource", DeviceType.NONE);
    }

    @Override
    public void set(Request rqst) {

    }

    @Override
    public Object get(Request rqst) {
        String msg = rqst.getResourceString();
        InOutBoard board = InOutBoard.getInstance();

//        db = new DBconnector();
//        reinfo = db.getResearcherInfo();
        reinfo = board.researcherinfolist;
        System.out.println("Message from " + rqst.getRequestNode().getAddress() + " / msg : " + msg + " / / ");

        String loginInfo[] = msg.split("|");
        for (String mm : loginInfo) {
            System.out.println("str : " + mm);
        }
        for (int i = 0; i < reinfo.size(); i++) {
            if ((loginInfo[0].equals(reinfo.get(i).getLoginId()) && loginInfo[2].equals(reinfo.get(i).getLoginPwd()))) {
                reinfo.get(i).setipAddress(rqst.getRequestNode().getAddress());
                return 0;
            }
        }
        return 1;

    }

}

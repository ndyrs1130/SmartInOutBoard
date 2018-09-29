/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternelNetwork;

import MinTFramework.ExternalDevice.DeviceType;
import MinTFramework.MinT;
import MinTFramework.Network.NetworkProfile;
import MinTFramework.Network.NetworkType;
import MinTFramework.Network.Request;
import MinTFramework.Network.ResponseData;
import MinTFramework.Network.ResponseHandler;
import MinTFramework.SystemScheduler.Service;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import smartboard.InOutBoard;
import smartboard.MessageBox;
import smartboard.Researcherinfo;

/**
 *
 * @author Shin
 */
public class MessageService extends Service {
    
    static ArrayList<MessageBox> meinfo = new ArrayList<>();
    static ArrayList<String> sendMessage = new ArrayList<>();
    
    static ArrayList<Researcherinfo> reinfo = new ArrayList<>();
    
    public MessageService(String name) {
        super(name);
    }
    
    @Override
    public void execute() {
        while (true) {
            try {
//                System.out.println("Start Send Meesage Box");
                String ipAddress;
                MinT frame = MinT.getInstance();
                meinfo = InOutBoard.getInstance().messageboxlist;
                reinfo = InOutBoard.getInstance().researcherinfolist;
                
                for (int i = 0; i < reinfo.size(); i++) {
                    sendMessage = new ArrayList<>();
                    for (int j = 0; j < meinfo.size(); j++) {
                        if ((meinfo.get(j).getRid() == reinfo.get(i).getId()) && (meinfo.get(j).getMsgcheck() == 0)) {
                            sendMessage.add(meinfo.get(j).toString());
                            
                        }
                        
                    }

//                    System.out.println("sendmsg: " + sendMessage);
//                    System.out.println("rid:" + reinfo.get(i).getId() + " / ip: " + reinfo.get(i).getipAdress());
                    if (reinfo.get(i).getipAdress().equals("")) {
                        continue;
                    } else {
//                        System.out.println("Send to PC");
                        NetworkProfile dst = new NetworkProfile("MessageRe", reinfo.get(i).getipAdress(), NetworkType.UDP);
                        //NetworkProfile dst = new NetworkProfile("MessageRe", "210.115.47.196:8888", NetworkType.UDP);
                        if (sendMessage != null && !sendMessage.isEmpty()) {
                            for (int x = 0; x < sendMessage.size(); x++) {
                                frame.REQUEST_SET(dst, new Request("MessageRe", sendMessage.get(x)), new ResponseHandler() {
                                    @Override
                                    public void Response(ResponseData rd) {
                                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                                    }
                                });
                            }
                        }
                    }
                }
                
                sleep(3000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

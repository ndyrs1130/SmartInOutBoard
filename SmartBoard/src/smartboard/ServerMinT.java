/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

import ExternelNetwork.CurrentStateService;
import ExternelNetwork.ExcelDataResource;
import ExternelNetwork.JoinResource;
import ExternelNetwork.LoginResource;
import ExternelNetwork.MessageCheckResource;
import ExternelNetwork.MessageService;
import ExternelNetwork.PixelResource;

import MinTFramework.MinT;
import MinTFramework.Network.NetworkType;

/**
 *
 * @author Shin
 */
public class ServerMinT extends MinT{
    public ServerMinT(){
        addNetwork(NetworkType.UDP, "210.115.49.38",6513);
        putService(new MessageService("MessageService"));
        putService(new CurrentStateService("CurrentStateService"));
        addResource(new LoginResource());
        addResource(new MessageCheckResource());
        addResource(new ExcelDataResource());
        addResource(new PixelResource());
        //addResource(new JoinResource());
        
    }
}

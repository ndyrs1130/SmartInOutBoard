/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

import MinTFramework.MinT;
import MinTFramework.Network.NetworkType;

/**
 *
 * @author Shin
 */
public class Smartboard extends MinT{
    
    public Smartboard(){
        //new frame
        //mint -> request -> frame
        this.addNetwork(NetworkType.UDP);
    }
    
    public static void main(String args[]) {
        Smartboard sm = new Smartboard();
        sm.Start();
    }
}

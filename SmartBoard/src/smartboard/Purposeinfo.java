/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

/**
 *
 * @author Shin
 */
public class Purposeinfo {
    int rid;
    int purid;
    String content;
    public Purposeinfo(int rid, int purid,String content){
        this.rid = rid;
        this.purid = purid;
        this.content = content;
    }
    public int getrId(){
        return rid;
    }
    public int getpurId(){
        return purid;
    }
    public String getContent(){
        return content;
    }
}

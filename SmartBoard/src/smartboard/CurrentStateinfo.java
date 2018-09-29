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
public class CurrentStateinfo {

    int stateid;
    String state;

    public CurrentStateinfo(int stateid,String state) {
        this.stateid = stateid;
        this.state = state;
    }

    public int getStateId() {
        return stateid;
    }

    public void setStateId(int stateid) {
        this.stateid = stateid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}

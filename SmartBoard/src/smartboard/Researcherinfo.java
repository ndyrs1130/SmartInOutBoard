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
public class Researcherinfo {

    private int rid;
    private String loginid;
    private String rname;
    private int rnumber;
    private String email;
    private String state;
    private int lectureid;

    public Researcherinfo(int rid, String loginid, String rname, int rnumber, String email, int lectureid, String state) {
        
        this.rid = rid;
        this.loginid = loginid;
        this.rname = rname;
        this.rnumber = rnumber;
        this.email = email;
        this.lectureid = lectureid;
        this.state = state;

    }

    public int getId() {
        return rid;
    }


    public String getLoginId() {
        return loginid;
    }

    public String getName() {
        return rname;
    }

    public void setName(String rname) {
        this.rname = rname;
    }

    public int getNumber() {
        return rnumber;
    }

    public void setNumber(int rnumber) {
        this.rnumber = rnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getLectureId() {
        return lectureid;
    }

    public void setLectureId(int lectureid) {
        this.lectureid = lectureid;
    }

    public String toString() {
        return "Memberinfo [id=" + rid + ", name=" + rname
                + ", snumber=" + rnumber + ",email=" + email
                + "]";
    }
}

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
     int rid;
    private String loginid;
    private String rname;
    private int rnumber;
    private String email;
    //private String state;
    private int lectureid;
    private String loginpwd;
    String ipAddress;
    int stateid;
    public Researcherinfo() {
        rid = 0;
        loginid = "";
        loginpwd = "";
        rname = "";
        rnumber = 0;
        email = "";
        lectureid = 0;
        //state = "";
        stateid = 0;
        
    }

    public Researcherinfo(int rid, String loginid, String loginpwd, String rname, int rnumber, String email, int lectureid, int stateid) {

        this.ipAddress = "";
        this.rid = rid;
        this.loginid = loginid;
        this.loginpwd = loginpwd;
        this.rname = rname;
        this.rnumber = rnumber;
        this.email = email;
        this.lectureid = lectureid;
        //this.state = state;
        this.stateid = stateid;
    }

    public String getipAdress() {
        return ipAddress;
    }

    public void setipAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getId() {
        return rid;
    }

    public String getLoginId() {
        return loginid;
    }

    public void setLoginId(String loginid) {
        this.loginid = loginid;
    }

    public String getLoginPwd() {
        return loginpwd;
    }

    public void setLoginPwd(String loginpwd) {
        this.loginpwd = loginpwd;
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

    public int getStateid() {
        return stateid;
    }

    public void setStateid(int stateid) {
        this.stateid = stateid;
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

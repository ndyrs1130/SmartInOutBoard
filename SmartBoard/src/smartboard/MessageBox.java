/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

/**
 * MessageBox Class
 * msgid : ID for each message
 * sname : student name who send this message
 * rid : researcher id who receive this meesage
 * msgcheck : Flag check whether researcher read
 *      When researcher read message 1 or 0 
 * purposeString
 * lectureName
 * date
 * 
 * @author Shin
 */
public class MessageBox {

    int msgid;
    String sname;
    int rid;
    int msgcheck;
    String purposeString;
    String lectureName;
    String date;

    public MessageBox(int msgid, String sname, int rid, int msgcheck, String purposeString, String lectureName,String date) {
        this.msgid = msgid;
        this.sname = sname;
        this.rid = rid;
        this.msgcheck = msgcheck;
        this.purposeString = purposeString;
        this.lectureName = lectureName;
        this.date = date;
    }

    public MessageBox() {
        this.msgid = 0;
        this.sname = "";
        this.rid = 0;
        this.msgcheck = 0;
        this.purposeString = "";
        this.lectureName = "";
        this.date = "";
    }

    public int getMsgId() {
        return msgid;
    }

    public void setMsgid(int msgid) {
        this.msgid = msgid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMsgcheck() {
        return msgcheck;
    }

    public void setMsgcheck(int msgcheck) {
        this.msgcheck = msgcheck;
    }

    public String getPurposeString() {
        return purposeString;
    }

    public void setPurposeString(String purposeString) {
        this.purposeString = purposeString;
    }

    public String getLecturename() {
        return lectureName;
    }

    public void setLecturename(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        return  msgid + date + "-학생 이름 : " + sname + "-용무 : " + purposeString + "-강의 이름 : " + lectureName ;
    }
}

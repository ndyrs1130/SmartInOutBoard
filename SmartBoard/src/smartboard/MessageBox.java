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
public class MessageBox {
    private int msgid;
    private String sname;
    private int rid;
    private int msgcheck;
    private String purposestring;
    private String lecturename;
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
		return purposestring;
	}
	public void setPurposeString(String purposestring) {
		this.purposestring = purposestring;
	}
        public String getLecturename() {
		return lecturename;
	}
	public void setLecturename(String lecturename) {
		this.lecturename = lecturename;
	}
	public String toString() {
		return "";
	}
}

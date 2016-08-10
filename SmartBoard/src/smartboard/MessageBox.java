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
    private String msgid;
    private String sname;
    private String rname;
    private String msgcheck;
    private String purid;
    public String getMsgId() {
		return msgid;
	}
	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}
	public String getSname() {
		return sname;
	}
   
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getMsgcheck() {
		return msgcheck;
	}
	public void setMsgcheck(String msgcheck) {
		this.msgcheck = msgcheck;
	}

	public String getPurid() {
		return purid;
	}
	public void setPurid(String purid) {
		this.purid = purid;
	}
	public String toString() {
		return "";
	}
}

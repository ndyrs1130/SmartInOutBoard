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
        private String rid;
	private String rpwd;
	private String rname;
	private String rnumber;
	private String email;
        private int state;
        private int lectureid;
	
        
	public Researcherinfo(String rname){
            this.rname = rname;
        }
        
        
	public String getId() {
		return rid;
	}
	public void setId(String rid) {
		this.rid = rid;
	}
	public String getPwd() {
		return rpwd;
	}

	public void setPwd(String rpwd) {
		this.rpwd = rpwd;
	}
	public String getName() {
		return rname;
	}
	public void setName(String rname) {
		this.rname = rname;
	}
	public String getNumber() {
		return rnumber;
	}
	public void setNumber(String rnumber) {
		this.rnumber = rnumber;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
        public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	  public int getLectureId() {
		return lectureid;
	}
	public void setLectureId(int lectureid) {
		this.lectureid = lectureid;
	}
	
	public String toString() {
		return "Memberinfo [id=" + rid + ", pwd=" + rpwd + ", name=" + rname
				+ ", snumber=" + rnumber + ",email=" + email
				+ "]";
	}
}
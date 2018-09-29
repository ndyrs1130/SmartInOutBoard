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
public class StudentInfo {
    int snumber;
    String sname;
    int lectureid;
    public StudentInfo(){
        this.sname = "";
        this.snumber = 0;
        this.lectureid = 0;
    }
    public StudentInfo(int snumber,String sname,int lectureid){
        this.snumber = snumber;
        this.sname = sname;
        this.lectureid = lectureid;
    }
    public int getSnumber(){
        return snumber;
    }
    public String getSname(){
        return sname;
    }
    public int getLectureID(){
        return lectureid;
    }
    public void setSNumber(int n){
        this.snumber = n;
    }
    public void setSName(String n){
        this.sname = n;
    }
    public void setLectureID(int i){
        this.lectureid = i;
    }
}

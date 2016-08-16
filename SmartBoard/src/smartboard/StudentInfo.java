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
}

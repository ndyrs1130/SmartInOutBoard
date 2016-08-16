/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

import java.util.ArrayList;

/**
 *
 * @author Shin
 */
public class Lectureinfo {

    int lectureid;
    String lecture;
    int seperateclass;
    //ArrayList<StudentInfo> slist;
    public Lectureinfo(int lectureid, String lecture,int seperateclass){
        this.lectureid = lectureid;
        this.lecture = lecture;
        this.seperateclass = seperateclass;
    }
    public int getLectureID() {
        return lectureid;
    }
    public String getLecture() {
        return lecture;
    }
     public int getSeperateclass() {
        return seperateclass;
    }

}

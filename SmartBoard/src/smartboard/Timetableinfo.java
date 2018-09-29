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
public class Timetableinfo {

    int timetableid;
    int rid;
    int classStartHour;
    int classStartMin;
    int classEndHour;
    int classEndMin;
    String classday;
    String classname;

    public Timetableinfo() {

    }

    public Timetableinfo(int timetableid, int classStartHour,int classStartMin,int classEndHour,int classEndMin,int rid,String classday,String classname) {
        this.timetableid = timetableid;
        this.rid = rid;
        this.classday = classday;
        this.classname = classname;
        this.classStartHour = classStartHour;
        this.classStartMin = classStartMin;
        this.classEndHour = classEndHour;
        this.classEndMin = classEndMin;
    }

    public int getTimetableId() {
        return timetableid;
    }

    public void setTimeTableId(int timetableid) {
        this.timetableid = timetableid;
    }

    public int getRId() {
        return rid;
    }

    public void setRId(int rid) {
        this.rid = rid;
    }
    public int getClassStartHour() {
        return classStartHour;
    }

    public void setrClassStartHour(int classStartHour) {
        this.classStartHour = classStartHour;
    }
        public int getClassStartMin() {
        return classStartMin;
    }

    public void setClassStartMin(int classStartMin) {
        this.classStartMin = classStartMin;
    }
   public int getClassEndHour() {
        return classEndHour;
    }

    public void setrClassEndHour(int classEndHour) {
        this.classEndHour = classEndHour;
    }
        public int getClassEndMin() {
        return classEndMin;
    }

    public void setClassEndMin(int classEndMin) {
        this.classEndMin = classEndMin;
    }
  

    public String getClassday() {
        return classday;
    }

    public void setClassday(String classday) {
        this.classday = classday;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }
}

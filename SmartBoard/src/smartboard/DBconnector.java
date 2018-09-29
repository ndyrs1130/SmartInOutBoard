/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 * *
 * 디비 커넥터 정리하기! 1. 생성자 : con 변수에 DB커넥션 만들기 2. ArrayList<ResearcherList>
 * getResearcherInfo() 3. ArrayList<LectureList> getLectureList() 4.
 * ArrayList<StudentList> getStudentList()
 *
 * @author Shin
 */
//DB 처리
public class DBconnector {

    static ArrayList<Researcherinfo> RList;
    static ArrayList<CurrentStateinfo> stateList;
    static ArrayList<StudentInfo> SList;
    static ArrayList<Lectureinfo> lecList;
    static ArrayList<Purposeinfo> purposeinfoList;
    static ArrayList<String> purposeList;
    static ArrayList<MessageBox> messageboxList;
    static ArrayList<Timetableinfo> timetableinfoList;
    private Connection con;
    private static final String DRIVER
            = "SQLite.JDBCDriver";
    private static final String URL = "jdbc:sqlite://home/pi/smartboard.db";
    //private static final String URL = "jdbc:mysql://210.115.47.193:3306";

//private static final String URL = "jdbc:sqlite:/smartboard.db";
    String str1, str2;

    public DBconnector() {
        con = getConn();
    }

    //DB연결 메소드
    private Connection getConn() {
        Connection con = null;
        try {
            Class.forName(DRIVER).newInstance(); //1. 드라이버 로딩
            con = DriverManager.getConnection(URL); //2. 드라이버 연결
            System.out.println("DBConnection Success!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    /**
     * RList에 모든 연구원 정보 저장
     */
    public ArrayList<Researcherinfo> getResearcherInfo() {
        RList = new ArrayList<>();
        stateList = new ArrayList<>();
        PreparedStatement ps = null;

        try {

           
            //연구원 정보를 불러옴
            String sql = "select * from researcher";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Researcherinfo tmp = new Researcherinfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
                RList.add(tmp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("RList 사이즈는" + RList.size());
        return RList;
    }

    public ArrayList<CurrentStateinfo> getCurrentstateinfo() {
        stateList = new ArrayList<>();

        PreparedStatement ps = null;
        try {

            //메시지 정보를 불러옴
            String sql = "select * from currentstate";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                CurrentStateinfo cs = new CurrentStateinfo(rs.getInt(1), rs.getString(2));
                stateList.add(cs);

            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("stateList 사이즈는" + stateList.size());
        return stateList;
    }

    public ArrayList<StudentInfo> getStudentInfo() {
        SList = new ArrayList<>();

        PreparedStatement ps = null;
        try {

            //학생 정보를 불러옴
            String sql = "select * from student ORDER BY sname ASC";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                StudentInfo sinfo = new StudentInfo(rs.getInt(1), rs.getString(2), rs.getInt(3));
                SList.add(sinfo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("SList 사이즈는" + SList.size());
        return SList;
    }

    public ArrayList<Timetableinfo> getTimetableInfo() {
        timetableinfoList = new ArrayList<>();

        PreparedStatement ps = null;
        try {

            //시간표 정보를 가지고 옴
            String sql = "select * from timetable";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                Timetableinfo tinfo = new Timetableinfo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getInt(6),rs.getString(7), rs.getString(8));
                timetableinfoList.add(tinfo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("timetable List 사이즈는" + timetableinfoList.size());
        return timetableinfoList;
    }

    public ArrayList<MessageBox> getMessageBoxinfo() {
        messageboxList = new ArrayList<>();

        PreparedStatement ps = null;
        try {

            //메시지 정보를 불러옴
            String sql = "select * from messagebox";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while (rs.next()) {
                MessageBox mb = new MessageBox(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7));
                messageboxList.add(mb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("SList 사이즈는" + messageboxList.size());
        return messageboxList;
    }

    /**
     * 강의리스트를반환
     */
    public ArrayList<Lectureinfo> getLectureList() {

        lecList = new ArrayList<>();

        PreparedStatement ps = null;
        try {
            //강의 정보를 불러옴
            String sql = "select * from lecture";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()) {
                Lectureinfo linfo = new Lectureinfo(rs.getInt(1), rs.getString(2), rs.getInt(3));
                lecList.add(linfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("lectureList 사이즈는" + lecList.size());
        return lecList;

    }

    /**
     * 용무리스트를 반환
     */
    public ArrayList<Purposeinfo> getPurposeinfo() {
        purposeinfoList = new ArrayList<>();
        purposeList = new ArrayList<>();
        PreparedStatement ps = null;
        try {

            //용무 종류를 불러옴
            String sql1 = "select * from purpose";
            ps = con.prepareStatement(sql1);
            ResultSet rs = ps.executeQuery(sql1);

            while (rs.next()) {
                purposeList.add(rs.getString(2));
            }
            System.out.println(purposeList);

            //연구원 정보를 불러옴
            String sql = "select * from studentpurpose";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Purposeinfo purinfo = new Purposeinfo(rs.getInt(1), rs.getInt(2), purposeList.get(rs.getInt(3)));
                purposeinfoList.add(purinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("purposeinfoList 사이즈는" + purposeinfoList.size());
        return purposeinfoList;
    }

    public boolean sendMessage(MessageBox mb) {

        boolean ok = false;

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령

        try {

            con = getConn();
            String sql = "insert into messagebox (sname,rid,content,lecture,msgcheck,msgid,date) values (?,?,?,?,?,null,?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, mb.getSname());
            ps.setInt(2, mb.getRid());
            ps.setString(3, mb.getPurposeString());
            ps.setString(4, mb.getLecturename());
            ps.setInt(5, 0);
            ps.setString(6, mb.getDate());
            int r = ps.executeUpdate(); //실행 -> 저장

            if (r > 0) {
                System.out.println("보내기 성공");
                ok = true;
            } else {
                System.out.println("보내기 실패");
                ok = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public boolean insertStudent(StudentInfo sinfo) {

        boolean ok = false;

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령

        try {

            con = getConn();
            String sql = "insert into student (snumber,sname,lectureid) values (?,?,?)";

            ps = con.prepareStatement(sql);
            ps.setInt(1, sinfo.getSnumber());
            ps.setString(2, sinfo.getSname());
            ps.setInt(3, sinfo.getLectureID());

            int r = ps.executeUpdate(); //실행 -> 저장

            if (r > 0) {
                System.out.println("보내기 성공");
                ok = true;
            } else {
                System.out.println("보내기 실패");
                ok = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public boolean updateMSGcheck(int msgid) {
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConn();
            String sql = "update messagebox set msgcheck=1 where msgid=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, msgid);

            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패

            if (r > 0) {
                ok = true; //수정이 성공되면 ok값을 true로 변경
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public boolean updateCurrentState(int rid,int csid) {
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConn();
            String sql = "update researcher set csid=? where rid=?";

            ps = con.prepareStatement(sql);
            ps.setInt(1, csid);
            ps.setInt(2, rid);

            int r = ps.executeUpdate(); //실행 -> 수정
            // 1~n: 성공 , 0 : 실패

            if (r > 0) {
                ok = true; //수정이 성공되면 ok값을 true로 변경
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return ok;
    }

}

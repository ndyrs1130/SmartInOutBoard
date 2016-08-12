/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

//DB 처리
public class DBconnector {
    

    String snameMessage, rnameMessage, puridMessage;
    String snumber, sname, totalStudent,remail;
   int lectureid;

    private static final String DRIVER
            = "com.mysql.jdbc.Driver";
    private static final String URL
            = "jdbc:mysql://210.115.47.194:3306/";

    private static final String USER = "sjshin"; //DB ID
    private static final String PASS = "snslab"; //DB 패스워드
    String str1, str2;
    //DB연결 메소드

    public Connection getConn() {
        Connection con = null;

        try {
            Class.forName(DRIVER); //1. 드라이버 로딩
            con = DriverManager.getConnection(URL, USER, PASS); //2. 드라이버 연결
            System.out.println("DBConnection Success!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
    /**
     * 연구원이름반환
     * arraylist에 researcher 디비에 있는 모든 연구원이름을 저장
     */
    public ArrayList<String> getResearcherName(){
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<String> rename = new ArrayList<String>();
           try{
            con = getConn();
            String sql = "select rname from inoutboard.researcher";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                rename.add(rs.getString(1));
                        }
                System.out.print(rename);
        }
           catch(Exception e){
			e.printStackTrace();
		}
 
        return rename;
    }
    /**
     * 연구원의 정보를 반환
     */
    public Researcherinfo getResearInfo(String rname){
        Researcherinfo info = new Researcherinfo(rname);
       
        Connection con = null;       
        PreparedStatement ps = null; 
        ResultSet rs = null;
        try{
            con = getConn();
            String sql = "select lectureid,csid from inoutboard.researcher where rname like "+"'"+rname+"'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                info.setLectureId(rs.getInt(1));
                info.setState(rs.getInt(2));
                //info.setEmail(rs.getString(3));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return info;

    }
   public ArrayList<String> getResearcherInfo(){
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<String> rename = new ArrayList<String>();
           try{
            con = getConn();
            String sql = "select rname from inoutboard.researcher";
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            while(rs.next()){
                rename.add(rs.getString(1));
                        }
                System.out.print(rename);
        }
           catch(Exception e){
			e.printStackTrace();
		}
 
        return rename;
    }
    
//    /**
//     * 연구원의 조교수업을 반환해줌
//     */
//    public int getResarcherLecture(String rname){
//        Connection con = null;
//        PreparedStatement ps = null;
//        try{
//            con = getConn();
//            String sql = "select lectureid from inoutboard.researcher where rname = "+"'"+rname+"'";
//            ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery(sql);
//            if(rs.next()){
//            lectureid = rs.getInt(1);
//            }
//            System.out.println(lectureid);
//      
//            
//       }catch(Exception e){
//			e.printStackTrace();
//		}
//        return lectureid;
//    }
    /**
     * lectureid를 주면 id에 있는 과목이름을 가져온다 
     */
    public String getLecture(int lectureid) {

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령
        String lname = "";
        HashMap<Integer, String> lecturemap;
        lecturemap = new HashMap<>();

        try {
            System.out.println("lec id : "+lectureid);
            con = getConn();
            //String sql = "select sname,rname,purid from inoutboard.messagebox";
           // String sql = "select * from inoutboard.lecture";
            String sql = "select lecture from inoutboard.lecture where lectureid = "+lectureid;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
                lname = rs.getString(1);
                System.out.println(lectureid+"에 해당하는 수업은 "+lname);
            }
        } catch (Exception e) {
            e.printStackTrace();
            lname = "ERROR!";
        }
        return lname;
    }
    /**
     * csid로 현재상태를 가져온다.
     */
     public String getCurrentState(int csid) {

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령
        String state = "";
        HashMap<Integer, String> statemap;
        statemap = new HashMap<>();

        try {
            con = getConn();
            //String sql = "select sname,rname,purid from inoutboard.messagebox";
           // String sql = "select * from inoutboard.lecture";
            String sql = "select state from inoutboard.currentstate where csid = "+Integer.toString(csid);
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if(rs.next()){
            state = rs.getString(1);
            System.out.println(csid+"에 해당하는 수업은 "+state);
            }
        } catch (Exception e) {
            e.printStackTrace();
            state = "ERROR!";
        }
        return state;
    }
/**
    public String getStudentsList(int lectureId) {
  

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령

        try {

            con = getConn();
            String sql = "select * from inoutboard.student where lectureid = "+Integer.toString(lectureId);

            ps = con.prepareStatement(sql);
      

            int r = ps.executeUpdate(); //실행 -> 저장

            if (r > 0) {
                System.out.println("메시지 전송 성공");
                //ok = true;
            } else {
                System.out.println("메시지 전송 실패");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }
    */
    

}

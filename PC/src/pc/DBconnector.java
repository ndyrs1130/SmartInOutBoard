/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

//DB 처리
public class DBconnector {

    String rid, rpwd, rname, sname, msgcheck, purid;

    private static final String DRIVER
            = "com.mysql.jdbc.Driver";
    private static final String URL
            = "jdbc:mysql://210.115.47.194:3306/";

    private static final String USER = "sjshin"; //DB ID
    private static final String PASS = "snslab"; //DB 패스워드

    //DB연결 메소드
    public Connection getConn() {
        Connection con = null;

        try {
            Class.forName(DRIVER); //1. 드라이버 로딩
            con = DriverManager.getConnection(URL, USER, PASS); //2. 드라이버 연결

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    //회원 등록
    public boolean insertMember(Memberinfo dto) {

        boolean ok = false;

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령

        try {

            con = getConn();
            String sql = "insert into inoutboard.researcher (loginid,loginpwd,rname,rnumber,email) values (?,?,?,?,?)";

            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getPwd());
            ps.setString(3, dto.getName());
            ps.setString(4, dto.getNumber());
            ps.setString(5, dto.getEmail());

            int r = ps.executeUpdate(); //실행 -> 저장

            if (r > 0) {
                System.out.println("가입 성공");
                ok = true;
            } else {
                System.out.println("가입 실패");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ok;
    }

    public void loginMember() {

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령

        try {
            con = getConn();
            String sql = "select loginid, loginpwd,rname from inoutboard.researcher";

            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            rs.next();

            rid = rs.getString(1);
            rpwd = rs.getString(2);
            rname = rs.getString(3);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean updateMember(Memberinfo uMem) {
        System.out.println("dto=" + uMem.toString());
        boolean ok = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = getConn();
            String sql = "update inoutboard.researcher set rid=?, rpwd=?, rname=?, rnumber=?, e-mail=?" + "where id=? and pwd=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, uMem.getId());
            ps.setString(2, uMem.getPwd());
            ps.setString(3, uMem.getName());
            ps.setString(4, uMem.getNumber());
            ps.setString(5, uMem.getEmail());

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

    public void message() {

        Connection con = null; 		 //연결
        PreparedStatement ps = null; //명령

        try {
            con = getConn();
            String sql = "select sname,msgcheck,purid from inoutboard.message";

            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            rs.next();

            sname = rs.getString(1);
            msgcheck = rs.getString(2);
            purid = rs.getString(3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

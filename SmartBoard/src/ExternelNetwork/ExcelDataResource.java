/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternelNetwork;

import MinTFramework.ExternalDevice.DeviceType;
import MinTFramework.Network.Request;
import MinTFramework.storage.ThingInstruction;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import smartboard.DBconnector;
import smartboard.InOutBoard;
import smartboard.Lectureinfo;
import smartboard.StudentInfo;

/**
 *
 * @author Shin
 */
public class ExcelDataResource extends ThingInstruction {

    String[] excelData;
    int[] snumber;
    String[] sname;
    String[] lecture;
    ArrayList<StudentInfo> stlist;

    public ExcelDataResource() {
        super("ExcelDataResource", DeviceType.NONE);
        snumber = new int[100];
        sname = new String[100];
        lecture = new String[100];
        stlist = new ArrayList<>();

    }

    @Override
    public void set(Request rqst) {
        synchronized (stlist) {
            System.out.println("엑셀에서 가져온 데이터" + rqst.getResourceString());
            excelData = rqst.getResourceString().split(",");
            StudentInfo st = new StudentInfo();
            for (int i = 0; i < excelData.length - 1; i++) {
                if (!excelData.equals("")) {
                    switch (i % 3) {
                        case 0:
//                        System.out.println(i + "th : " + excelData[i]);
                            st = new StudentInfo();
                            st.setSNumber(Integer.parseInt(excelData[i]));
                            break;
                        case 1:

//                        System.out.println(i + "th : " + excelData[i]);
                            st.setSName(excelData[i]);
                            break;
                        case 2:
                            int lectureid = 0;

//                        System.out.println(i + "th : " + excelData[i]);
                            for (Lectureinfo li : InOutBoard.getInstance().getLectureInfoList()) {
                                String str = li.getLecture()+" "+li.getSeperateclass()+"분반";
                                System.out.println(str+" vs "+excelData[i]);
                                if (str.equals(excelData[i])) {
                                    lectureid = li.getLectureID();
                                }
                            }
                            st.setLectureID(lectureid);
                            stlist.add(st);
                            break;
                        default:
                            break;
                    }
                }
            }
            int index = 0;
            for (StudentInfo tmp : stlist) {
                System.out.println(index++ + "/" + tmp.getSnumber() + tmp.getSname() + tmp.getLectureID());
                new DBconnector().insertStudent(tmp);
            }
            InOutBoard.getInstance().refleshAllList();
        }
//        for (int i = 0; i < excelData.length - 3; i += 3) {
//            System.out.println(i+" 번째" + "split excel data: " + excelData[i]+"/"+excelData[i+1]+"/"+excelData[i+2]);
//            if (excelData[i] != null) {
//                snumber[i] = Integer.parseInt(excelData[i]);
//                System.out.println("snumber:" + snumber[i]);
//
//                sname[i] = excelData[i+1];
//                System.out.println("sname:" + sname[i]);
//
//                lecture[i] = excelData[i+2];
//                System.out.println("lecture:" + lecture[i]);
//            }
//        }
    }

    @Override
    public Object get(Request rqst) {
        return null;
    }

}

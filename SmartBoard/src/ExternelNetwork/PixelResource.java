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
import java.util.StringTokenizer;
import org.json.simple.JSONObject;
import smartboard.CurrentStateinfo;
import smartboard.DBconnector;
import smartboard.InOutBoard;
import smartboard.Researcherinfo;

/**
 *
 * @author Shin
 */
public class PixelResource extends ThingInstruction {

    ArrayList<CurrentStateinfo> allstate = new ArrayList<>();
    ArrayList<Researcherinfo> allrinfo = new ArrayList<>();

    DBconnector db;
    int pixelX;
    int pixelY;
    // String[] pixelArray;
    String seatNum;
    String[] seatStringArray;
    int[] seatArray;

    public PixelResource() {
        super("Pixel", DeviceType.NONE);
    }

    @Override
    public void set(Request rqst) {
        InOutBoard iob = InOutBoard.getInstance();
        allstate = iob.currentstatelist;
        allrinfo = iob.researcherinfolist;
        seatNum = rqst.getResourceString();
        seatStringArray = seatNum.split(" ");
        StringTokenizer st = new StringTokenizer(seatNum, "s");

        seatArray = new int[seatStringArray.length];

        System.out.println("Receved String : " + seatNum);
        System.out.print("Splited String : ");
        for (String s : seatStringArray) {
            System.out.print("/" + s);
        }
        System.out.println("");
//        
//        for (int i = 0; i < seatArray.length; i++) {
//            seatArray[i] = Integer.parseInt(seatStringArray[i]);
//        }

        boolean doSeat[] = new boolean[allrinfo.size()];
        for (int i = 0; i < doSeat.length; i++) {
            doSeat[i] = false;
        }
        while (st.hasMoreElements()) {
            String tkn = st.nextToken();
            System.out.println("NextToken = \"" + tkn + "\"");
            if (tkn.length() > 1) {
                doSeat[Integer.parseInt(tkn.substring(0, 1))] = true;
            }
        }

//        for (int i = 0; i < seatStringArray.length; i++) {
//            System.out.println("seatStringArray = " + seatStringArray[i]);
//            if (seatStringArray[i].length() > 0) {
//                doSeat[Integer.parseInt(seatStringArray[i])] = true;
//            }
//        }
        //  System.out.println("pixelResource = " + pixel);
        String setText = "";
        System.out.print("doSeat Status: ");
        for (boolean t : doSeat) {
            if (t) {
                System.out.print("T");
            } else {
                System.out.print("F");
            }
        }
        System.out.println("");
        for (int i = 0; i < doSeat.length; i++) {
            if (doSeat[i] == true) {
                setText = allrinfo.get(i).getName() + " " + allstate.get(2).getState();
                iob.updateCurrentState(i, 2);
                iob.buttonSetText(i, setText);
                //J번 연구원을 재실상태로 변경
            } else if (doSeat[i] == false) {
                setText = allrinfo.get(i).getName() + " " + allstate.get(1).getState();
                iob.updateCurrentState(i, 1);
                iob.buttonSetText(i, setText);
                //J번 연구원을 퇴실or수업중으로 변경
            }
//                if (allrinfo.get(i).getStateid() != 2) {
//                    for (int x = 0; x < allstate.size(); x++) {
//                        setText = allrinfo.get(i).getName() + " " + allstate.get(2).getState();
//                        iob.updateCurrentState(i, 2);
//                        iob.buttonSetText(j, setText);
//                    }
//                }
//            } else if (allrinfo.get(i).getStateid() == 2) {
//                for (int x = 0; x < allstate.size(); x++) {
//                    setText = allrinfo.get(i).getName() + " " + allstate.get(1).getState();
//                    iob.updateCurrentState(i, 1);
//                    iob.buttonSetText(j, setText);
//                }
//            }

//            else if(allrinfo.get(i).getId() != pixel){
//                if (allrinfo.get(i).getStateid() == 2) {
//                for (int x = 0; x < allstate.size(); x++) {
//                    setText = allrinfo.get(i).getName() + " " + allstate.get(1).getState();
//                    iob.updateCurrentState(i, 1);
//                    iob.buttonSetText(i, setText);
//                }
//            } //System.out.println("pixelX = "+pixelX+" pixelY = "+pixelY);
//        }
        }

    }

    @Override
    public Object get(Request rqst
    ) {
        return null;
    }

}

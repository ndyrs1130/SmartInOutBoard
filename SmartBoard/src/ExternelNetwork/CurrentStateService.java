/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExternelNetwork;

/**
 *
 * @author Shin
 */
import static ExternelNetwork.MessageService.meinfo;
import MinTFramework.MinT;
import MinTFramework.Network.NetworkProfile;
import MinTFramework.Network.NetworkType;
import MinTFramework.SystemScheduler.Service;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartboard.CurrentStateinfo;
import smartboard.DBconnector;
import smartboard.InOutBoard;
import smartboard.MainPanelManualConfiguired;
import smartboard.Researcherinfo;
import smartboard.Timetableinfo;

public class CurrentStateService extends Service {

    ArrayList<CurrentStateinfo> allstate = new ArrayList<>();
    ArrayList<Researcherinfo> allrinfo = new ArrayList<>();
    ArrayList<Timetableinfo> alltimetableinfo = new ArrayList<>();
    DBconnector db;
    int pHour;
    int pMinute;

    //MainPanelManualConfiguired mainpanel;
    public CurrentStateService(String name) {
        super(name);
        
    }

    @Override
    public void execute() {

        InOutBoard iob = InOutBoard.getInstance();
        pHour = 9;
        pMinute = 5;

        while (true) {
            try {
                System.out.println("time=" + pHour + ":" + pMinute + " start reflesh researcher state");
                Calendar cal = Calendar.getInstance();
                allrinfo = iob.researcherinfolist;
                allstate = iob.currentstatelist;
                alltimetableinfo = iob.timetablelist;
//                pHour = cal.get(cal.HOUR_OF_DAY);
//                pMinute = cal.get(cal.MINUTE);

                pMinute += 1;
                if (pMinute == 00) {
                    pHour += 1;
                    pMinute = 0;
                    if(pHour == 11){
                        pHour = 9;
                    }

                }
                String setText = "";
                for (int i = 0; i < allrinfo.size(); i++) {
                    //수업 <-> 재실 갱신
                    for (int j = 0; j < alltimetableinfo.size(); j++) {
                        //퇴실or재실 -> 수업 갱신

                        if (allrinfo.get(i).getId() == alltimetableinfo.get(j).getRId()) {

                            if ((pHour >= alltimetableinfo.get(j).getClassStartHour() && pMinute >= alltimetableinfo.get(j).getClassStartMin())
                                    && ((pHour < alltimetableinfo.get(j).getClassEndHour()) || (pHour == alltimetableinfo.get(j).getClassEndHour() && pMinute <= alltimetableinfo.get(j).getClassEndMin()))) {
                                if (allrinfo.get(i).getStateid() != 2) {
                                    setText = allrinfo.get(i).getName() + " " + allstate.get(0).getState();
                                    iob.updateCurrentState(i, 0);
                                    iob.buttonSetText(i, setText);
                                }
                            }

                        }
                    }

                    /**
                     * *
                     * @TODO : 수업->퇴실 갱신
                     */
//                        if (allrinfo.get(i).getId() == alltimetableinfo.get(j).getRId() && (pHour == alltimetableinfo.get(j).getClassEndHour()) && (pMinute == alltimetableinfo.get(j).getClassEndMin())&&allrinfo.get(i).getStateid()==0) {
//                            for (int x = 0; x < allstate.size(); x++) {
//                                
//                                setText = allrinfo.get(i).getName() + " " + allstate.get(1).getState();
//                                iob.updateCurrentState(i, 1);
//                                iob.buttonSetText(i, setText);
//                            }
//                        }
                }

                //Thread.sleep(30000);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

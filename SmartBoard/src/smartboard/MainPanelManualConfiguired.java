/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Shin
 */
public class MainPanelManualConfiguired extends JPanel {
    int count = 0;
    Container ct;
    GridBagConstraints c;
    GridBagLayout gb;
    GridBagConstraints gbc;
    InOutBoard iob = null;
    DBconnector db;
    Researcherinfo info;
    public int buttonNum;
    //String rname;
    ArrayList<String> rname = new ArrayList<String>();
    ArrayList<String> rstate = new ArrayList<String>();
    static ArrayList<Researcherinfo> allinfo = new ArrayList<>();

    /**
     * Creates new form MainPanel
     */
    public MainPanelManualConfiguired() {
        this.setSize(800, 480);
        initComponents();

    }

    public MainPanelManualConfiguired(InOutBoard iob) {

        this.iob = iob;
        initComponents();
        //ButtonAdd();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        GridBagLayout gridbag = new GridBagLayout();
        setLayout(new BorderLayout());

        c = new GridBagConstraints();
        c.weightx = 1.0;
        c.weighty = 1.0;
        jLabel1 = new javax.swing.JLabel();
        namePanel = new javax.swing.JPanel();
        jLabel1.setText("연구원의 이름을 눌러주세요");
        this.setSize(800, 480);
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        //setLayout(gb);

        db = new DBconnector();
        //rname = db.getResearcherName();
        int buttonNum = rname.size();
        //namePanel.setLayout();

        JPanel labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(800, 50));
        labelPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        labelPanel.add(jLabel1);
        jLabel1.setSize(800, 100);

        labelPanel.add(jLabel1);
        this.add(labelPanel, BorderLayout.NORTH);

        ButtonAdd();
        System.out.println("in Main Pannel : " + rname);

        namePanel.setVisible(true);
        namePanel.setSize(800, 300);
        namePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        this.add(namePanel, BorderLayout.CENTER);
        super.setVisible(true);

    }

    public void ButtonAdd() {
        /**
         * for(int i=0;i<RList.size();i++){
         * button[i].setText(RList.get(i).getName()+"-"+RList.get(i).getState());
         * }
         */
        db = new DBconnector();
//        rname = db.getResearcherName();
//        buttonNum = rname.size();
//        JButton[] jbtn = new JButton[buttonNum];
//////////////////////////////////////////////////////////////
        allinfo = db.getResearcherInfo();
        buttonNum = allinfo.size();

        JButton[] jbtn = new JButton[buttonNum];
        for (int i = 0; i < buttonNum; i++) {

            namePanel.add(jbtn[i] = new JButton());
            jbtn[i].setText(allinfo.get(i).getName() + " " + allinfo.get(i).getState());
            jbtn[i].setVisible(true);
            jbtn[i].setSize(20, 20);
            super.setVisible(true);
            jbtn[i].setPreferredSize(new Dimension(250, 120));
            jbtn[i].setFont(new Font("굴림", Font.PLAIN, 20));
            jbtn[i].repaint();
            jbtn[i].addActionListener(new ResearcherButtonActionListener(jbtn, iob));
        }
//////////////////////////////////////////////////////////////

        //System.out.println("in Main Pannel : " + rname);
//        for (int i = 0; i < buttonNum; i++) {
//            //Researcherinfo info = new Researcherinfo(rname.get(i));
////            Researcherinfo info=db.getResearInfo(rname.get(i));
////            String[] state = new String[buttonNum];
////            db.getResearInfo(rname.get(i));
////            state[i]=db.getCurrentState(info.getState());
//            
//            namePanel.add(jbtn[i] = new JButton());
////            jbtn[i].setText(rname.get(i)+""+state[i]);
//            jbtn[i].setVisible(true);
//            jbtn[i].setSize(20, 20);
//            super.setVisible(true);
//            jbtn[i].setPreferredSize(new Dimension(250, 120));
//            jbtn[i].setFont(new Font("굴림", Font.PLAIN, 20));
//            jbtn[i].repaint();
//            jbtn[i].addActionListener(new ResearcherButtonActionListener(jbtn, iob));
//
//        }
    }

    public void layout(Component obj, int x, int y, int width, int height) {
        c.gridx = x; // 시작위치 x
        c.gridy = y; // 시작위치 y
        c.gridwidth = width; // 컨테이너 너비
        c.gridheight = height;  // 컨테이너 높이
        add(obj, c);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel namePanel;

    // End of variables declaration               
    class ResearcherButtonActionListener implements ActionListener {

        JButton[] jbtn;
        DBconnector db;
        InOutBoard iob = null;
        MainPanelManualConfiguired mainpanel;
        ArrayList <String> statearray = new ArrayList<>();
        public ResearcherButtonActionListener(JButton[] jbtn, InOutBoard iob) {
            super();
            this.jbtn = jbtn;
            this.iob = iob;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
           db = new DBconnector(); 
            if (iob == null) {
                System.out.println("IOB IS NULL");
                return;
            }
            
            for(int j = 0; j<allinfo.size();j++){
                statearray.add(allinfo.get(j).getState());
            }
             
            for (int i = 0; i < buttonNum; i++) {
                if (e.getSource().equals(jbtn[i])) {
                    
                    String rname = allinfo.get(i).getName();
                    
                    
                    System.out.println("ResearcherButtonActionListener: rname is " + rname);
                    /**
                     * 버튼을 계속 누르게 되면 연구원 상태가 디비에 저장된 현황만큼 변함 
                    jbtn[i].setText(rname + "  " +statearray.get(count));
                    count++;
                    count = count%3;
                  **/
                    iob.changePanel(new SendMessagePanel(iob, i));
                    break;
                }
            }
            /**
             * for(JButton bt : jbtn){ if(e.getSource().equals(bt)){ String
             * rname = info.getName();
             * System.out.println("ResearcherButtonActionListener: rname is
             * "+rname); iob.changePanel(new SendMessage(iob, rname)); break; }
             * }
             */
            System.out.println("THERE IS BUTTON ACTION LISTENER");
        }

    }
}

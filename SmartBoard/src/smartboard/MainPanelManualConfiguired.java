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

    Container ct;
    GridBagConstraints c;
    GridBagLayout gb;
    GridBagConstraints gbc;
    InOutBoard iob = null;
    DBconnector db;
    
    public int buttonNum;
    //String rname;
    ArrayList<String> rname = new ArrayList<String>();

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
        rname = db.getResearcherName();
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
//        JButton[] jbtn = new JButton[buttonNum];
//        for (int i = 0; i < buttonNum; i++) {
//            namePanel.add(jbtn[i] = new JButton(rname.get(i)));
////            add(jbtn[i] = new JButton(rname.get(i)));
//        }
        System.out.println("in Main Pannel : " + rname);

//        setVisible(true);
//        setSize(800,480);
        namePanel.setVisible(true);
        namePanel.setSize(800, 300);
        namePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        this.add(namePanel, BorderLayout.CENTER);
        //layout(labelPanel,1,1,3,1);
        //layout(namePanel,0,2,5,5);
        super.setVisible(true);

    }

    public void ButtonAdd() {
        db = new DBconnector();
        rname = db.getResearcherName();
        buttonNum = rname.size();
        JButton[] jbtn = new JButton[buttonNum];
//        int x=0;
//        int y=0;
//        int width=0;
//        int height=0;
//        for (int i = 0; i < buttonNum; i++) {
//            namePanel.add(jbtn[i] = new JButton(rname.get(i)));
//        }
        System.out.println("in Main Pannel : " + rname);

        for (int i = 0; i < buttonNum; i++) {
            namePanel.add(jbtn[i] = new JButton(rname.get(i)));
            jbtn[i].setVisible(true);
            jbtn[i].setSize(20, 20);
            super.setVisible(true);
            jbtn[i].setPreferredSize(new Dimension(200, 100));
            jbtn[i].setFont(new Font("굴림", Font.PLAIN, 40));
            jbtn[i].repaint();
            jbtn[i].addActionListener(new ResearcherButtonActionListener(jbtn, iob));
//            layout(jbtn[i],x,y,width,height);
//            x++;
//            y++;
//            width++;
//            height++;
//            //System.out.println(rname);
        }

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
        int buttonnum;
        InOutBoard iob = null;
        public ResearcherButtonActionListener(JButton[] jbtn, InOutBoard iob) {
            super();
            this.jbtn = jbtn;
            this.iob = iob;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //buttonnum = jbtn.length;
            if (iob == null){
                System.out.println("IOB IS NULL");
            }
            for(JButton bt : jbtn){
                if(e.getSource().equals(bt)){
                    String rname = bt.getText();
                    System.out.println("ResearcherButtonActionListener: rname is "+rname);
                    iob.changePanel(new MemberStatePanel(iob, rname));
                    break;
                }
            }
            System.out.println("THERE IS BUTTON ACTION LISTENER");
        }
        
    }
}
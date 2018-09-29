/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc;

import ExternelNetwork.ExcelDataService;
import ExternelNetwork.LoginService;
import ExternelNetwork.MessageCheckService;
import ExternelNetwork.MessageResource;
import MinTFramework.ExternalDevice.DeviceType;
import MinTFramework.MinT;
import MinTFramework.Network.NetworkProfile;
import MinTFramework.Network.NetworkType;
import MinTFramework.Network.Request;
import MinTFramework.Network.ResponseData;
import MinTFramework.Network.ResponseHandler;
import MinTFramework.storage.ThingInstruction;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Shin
 */
public class MainPanel extends javax.swing.JPanel {

    NewJFrame mainFrame;
    static MainPanel mp;
    JoinPanel jp;
    public DefaultListModel<String> model;
    MinT frame;
    String[] msgArray;
    public String selectedmsg;
    ArrayList<String> excelData;
    String path = "";
    String value = "";

    /**
     * Creates new form MainPanel
     */
    public MainPanel() {
        initComponents();
        this.setSize(1000, 1000);
        frame = MinT.getInstance();
        //MessageResource mr = new MessageResource(msgArray,msgList);
        mp = this;
        model = new DefaultListModel<>();
        msgList.setModel(model);
        excelData = new ArrayList<>();
//        msgList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//        msgListHandler handler = new msgListHandler();

    }

    public static MainPanel getInstance() {
        return mp;
    }

//    public class msgListHandler implements ListSelectionListener {
//
//        @Override
//        public void valueChanged(ListSelectionEvent e) {
//
//        }
//
//    }

    /*
    public MainPanel(NewJFrame mainFrame) {
        initComponents();
        this.setSize(900, 500);
        this.mainFrame = mainFrame;
        mainFrame.setSize(1000, 600);
  
        MinT frame = MinT.getInstance();
        MessageResource mr = new MessageResource();

        msgList = new JList<String>(model);
        //model = (DefaultListModel) msgList.getModel();
        model = new DefaultListModel<>();
        for (int i = 0; i < msgarray.length; i++) {
            model.addElement(msgarray[i]);
            System.out.println("mainPanel :" + msgarray[i]);
        }
 

    }
     */
    private void selectInputFile() throws IOException {
        DataFormatter fmt = new DataFormatter();
        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(jPanel2);
        if (returnVal == chooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            fileChooserFiled.setText(file.toString());

        }

        String prevPath = this.fileChooserFiled.getText();
        if (!prevPath.isEmpty()) {
            path = new File(prevPath).getAbsolutePath();
        }
//        System.out.println("파일이 있는 경로:" + path);
//        String value = "";
//        FileInputStream fis = new FileInputStream(path);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        int rowindex = 0;
//        int columnindex = 0;
//        //시트 수 (첫번째에만 존재하므로 0을 준다)
//        //만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
//        XSSFSheet sheet = workbook.getSheetAt(0);
//        //행의 수
//        int rows = sheet.getPhysicalNumberOfRows();
//        int listindex = 0;
//        for (rowindex = 0; rowindex < rows; rowindex++) {
//            //행을읽는다
//
//            XSSFRow row = sheet.getRow(rowindex);
//            if (rowindex % (7 + 1) == 0 && rowindex != 0) {
//                listindex++;
//            }
//            if (row != null) {
//                //셀의 수
//                int cells = row.getPhysicalNumberOfCells();
//                for (columnindex = 0; columnindex <= cells; columnindex++) {
//                    //셀값을 읽는다
//                    XSSFCell cell = row.getCell(columnindex);
//
//                    //셀이 빈값일경우를 위한 널체크
//                    if (cell == null) {
//                        continue;
//                    } else {
//                        //타입별로 내용 읽기
//
//                        switch (cell.getCellType()) {
//                            case XSSFCell.CELL_TYPE_FORMULA:
//                                value = cell.getCellFormula();
//                                break;
//                            case XSSFCell.CELL_TYPE_NUMERIC:
//                                value = (int) cell.getNumericCellValue() + "";
//                                break;
//                            case XSSFCell.CELL_TYPE_STRING:
//                                value = cell.getStringCellValue() + "";
//                                break;
//                            case XSSFCell.CELL_TYPE_BLANK:
//                                value = cell.getBooleanCellValue() + "";
//                                break;
//                            case XSSFCell.CELL_TYPE_ERROR:
//                                value = cell.getErrorCellValue() + "";
//                                break;
//                        }
//                    }
//                    System.out.print("row:" + rowindex + "/" + "listindex: " + listindex);
//                    System.out.println(" contents: " + value);
//                    if (excelData.isEmpty() || excelData.size() == listindex) {
//                        excelData.add(value + ",");
//                    } else {
//                        String tmp;
//                        tmp = excelData.get(listindex);
//                        tmp += value + ",";
//                        excelData.set(listindex, tmp);
//                    }
//                }
//
//            }
//        }
//        for (String t : excelData) {
//            System.out.println("Stored Data : " + t);
//        }
//        System.out.println("각 셀 내용 :" + excelData);

//        chooser.setCurrentDirectory(new java.io.File(path));
//        chooser.setDialogTitle("Select output folder");
//        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        chooser.setAcceptAllFileFilterUsed(false);
//        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            this.fileChooserFiled.setText(chooser.getSelectedFile().getAbsolutePath());
//        }
    }

    public void messageBox() {
        DBconnector db = new DBconnector();
        Memberinfo mi = new Memberinfo();
        db.message();

        if (db.rname.equals(mi.getName())) {
            //jTextField1.append(TOOL_TIP_TEXT_KEY);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        msgList = new javax.swing.JList<>();
        removemsgButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        openButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        storeButton = new javax.swing.JButton();
        fileChooserFiled = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        storebutton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        stateButton = new javax.swing.JButton();
        timetableButton = new javax.swing.JButton();
        withdrawal = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        jLabel1.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        jLabel1.setText("메시지");

        msgList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                msgListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(msgList);

        removemsgButton.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        removemsgButton.setText("메시지 삭제");
        removemsgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removemsgButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(removemsgButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removemsgButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        openButton.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        openButton.setText("열기");
        openButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        jLabel2.setText("수강생 일괄추가");

        storeButton.setFont(new java.awt.Font("굴림", 0, 18)); // NOI18N
        storeButton.setText("저장");
        storeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fileChooserFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(storeButton))
                    .addComponent(jLabel2))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(openButton)
                    .addComponent(storeButton)
                    .addComponent(fileChooserFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        storebutton.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        storebutton.setText("저장");
        storebutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storebuttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        jLabel3.setText("시간표 저장");

        jLabel4.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        jLabel4.setText("연구원 정보");

        jLabel5.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        jLabel5.setText("회원정보수정");

        jLabel6.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        jLabel6.setText("현황추가");

        stateButton.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        stateButton.setText("수정");
        stateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateButtonActionPerformed(evt);
            }
        });

        timetableButton.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        timetableButton.setText("추가");
        timetableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timetableButtonActionPerformed(evt);
            }
        });

        withdrawal.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        withdrawal.setText("탈퇴");

        logoutButton.setFont(new java.awt.Font("굴림", 0, 20)); // NOI18N
        logoutButton.setText("로그아웃");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(72, 72, 72))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(logoutButton))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(storebutton)
                                    .addComponent(withdrawal))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(stateButton)
                                .addContainerGap())))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timetableButton)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(storebutton))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timetableButton))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(withdrawal)
                    .addComponent(logoutButton))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void openButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openButtonActionPerformed
        if (evt.getSource() == openButton) {
            try {
                this.selectInputFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_openButtonActionPerformed

    private void stateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateButtonActionPerformed
        //mainFrame.changePanel(jp);


    }//GEN-LAST:event_stateButtonActionPerformed

    private void msgListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_msgListMouseClicked

    }//GEN-LAST:event_msgListMouseClicked

    private void removemsgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removemsgButtonActionPerformed
        if (evt.getSource() == removemsgButton) {
        selectedmsg = msgList.getSelectedValue().toString();
        System.out.println("mainpanel seletvalue" + selectedmsg);
        MessageCheckService msgcheck = new MessageCheckService("msgcheckService");
        frame.executeService(msgcheck);
        int index = msgList.getSelectedIndex();
        if (index != -1) {
            model.remove(index);
        }
        }
    }//GEN-LAST:event_removemsgButtonActionPerformed

    private void storeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeButtonActionPerformed
        if (evt.getSource() == storeButton) {
        ExcelDataRead excel = new ExcelDataRead(path, excelData);
        try {
            excel.ExcelDataRead();
        } catch (IOException ex) {
        }
        frame.executeService(new ExcelDataService(excelData));
        }
    }//GEN-LAST:event_storeButtonActionPerformed

    private void storebuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storebuttonActionPerformed
        
    }//GEN-LAST:event_storebuttonActionPerformed

    private void timetableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timetableButtonActionPerformed
            if (evt.getSource() == storebutton) {
            TimeTableFrame ttf = new TimeTableFrame();
            ttf.setVisible(true);
        }
    }//GEN-LAST:event_timetableButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fileChooserFiled;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JList<String> msgList;
    private javax.swing.JButton openButton;
    private javax.swing.JButton removemsgButton;
    private javax.swing.JButton stateButton;
    private javax.swing.JButton storeButton;
    private javax.swing.JButton storebutton;
    private javax.swing.JButton timetableButton;
    private javax.swing.JButton withdrawal;
    // End of variables declaration//GEN-END:variables
}

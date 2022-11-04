/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital_office_management_system;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author USER
 */
public class AdminHomePage extends javax.swing.JFrame {
    private CardLayout cardLayout;
    
    Color panedefault;
    Color paneclick;
    Color paneenter;
    
    String tableid;
    
    public AdminHomePage() {
        initComponents();
    }
    
    public AdminHomePage(String uname) {
        initComponents();
        
        panedefault = new Color(218,223,225);
        paneclick = new Color(51,110,123);
        paneenter = new Color(255,51,51);
        pane1.setBackground(panedefault);
        pane2.setBackground(panedefault);
        pane3.setBackground(panedefault);
        pane4.setBackground(panedefault);
        
        showname.setText(uname);
        
        takeimage();
    }
    
    void takeimage() {
        String[] bImages = {"pic1.jpg", "pic2.jpg", "pic3.jpg", "pic4.jpg", "pic5.jpg", "pic6.jpg", "pic7.jpg"};
        for (String s : bImages) {
            Icon icon = new ImageIcon("src/homeimages/" + s);
            JLabel label = new JLabel(icon);
            Label1.add(label);
        }
        cardLayout = new CardLayout();
        Label1.setLayout(cardLayout);
    }
    
    void loadsampledata(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital Office Management System","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT `ID`, `Username`, `Password`, `Gender`, `Hired Date`, `Phone No`, `Email`, `Department`, `Basic Salary` FROM `staffs`");
            
            while(jTable1.getRowCount()>0){
                ((DefaultTableModel)jTable1.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object [] rows = new Object[col];
                for(int i = 1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable1.getModel()).insertRow(rs.getRow()-1, rows);
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
        
        }
    }
    
    void loadreqtable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital Office Management System","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT `ID`, `Emp_ID`, `Name` FROM `leave_request`");
            
            while(jTable2.getRowCount()>0){
                ((DefaultTableModel)jTable2.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Object [] rows = new Object[col];
                for(int i = 1;i<=col;i++){
                    rows[i-1] = rs.getObject(i);
                }
                ((DefaultTableModel)jTable2.getModel()).insertRow(rs.getRow()-1, rows);
            }
            rs.close();
            st.close();
        } catch (Exception ex) {
            
        }
    }
    
    void Update_table() {
        try{
            PreparedStatement st;
            ResultSet rs; 
            String sql ="SELECT * FROM `allowance`";
            st = MyConnection.getConnection().prepareStatement(sql);                    
            rs = st.executeQuery();
            table_allowance.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jHomeButtonPanel = new javax.swing.JPanel();
        pane1 = new javax.swing.JPanel();
        jHomeButtonLabel = new javax.swing.JLabel();
        jEmployeesButtonPanel = new javax.swing.JPanel();
        pane2 = new javax.swing.JPanel();
        jUserProfileButtonLabel = new javax.swing.JLabel();
        jNoticeButtonPanel = new javax.swing.JPanel();
        pane3 = new javax.swing.JPanel();
        jNoticeButtonLabel = new javax.swing.JLabel();
        jSalarySlipButtonPanel = new javax.swing.JPanel();
        pane4 = new javax.swing.JPanel();
        jEventsButtonLabel2 = new javax.swing.JLabel();
        jLogOutButtonPanel = new javax.swing.JPanel();
        pane5 = new javax.swing.JPanel();
        jEventsButtonLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        HomePage = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        showname = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        nextbutton = new javax.swing.JLabel();
        prevbutton = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        Employees = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Remove = new javax.swing.JButton();
        phoneno = new javax.swing.JTextField();
        update = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        search_emp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Password = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Department = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        Basic = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Notice = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Title = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        Contant = new javax.swing.JTextArea();
        Salary_Slip = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        t_allow = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        reset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        txt_search1 = new javax.swing.JTextField();
        dept = new javax.swing.JTextField();
        hired = new javax.swing.JTextField();
        s_basic = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        t_ded = new javax.swing.JTextField();
        t_sal = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        Allowance = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        txt_empid = new javax.swing.JTextField();
        txt_salary = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_dept = new javax.swing.JTextField();
        txt_hired = new javax.swing.JTextField();
        txt_uname = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txt_med = new javax.swing.JTextField();
        txt_bonus = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txt_hw = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_total_overtime = new javax.swing.JTextField();
        txt_per = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        table_allowance = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        txt_cal = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        Deduction = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        Did = new javax.swing.JTextField();
        Duname = new javax.swing.JTextField();
        Dbirth = new javax.swing.JTextField();
        Dphone = new javax.swing.JTextField();
        Demail = new javax.swing.JTextField();
        Dhired = new javax.swing.JTextField();
        Ddept = new javax.swing.JTextField();
        Dbasic = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        r_percentage = new javax.swing.JRadioButton();
        jLabel38 = new javax.swing.JLabel();
        r_amount2 = new javax.swing.JRadioButton();
        txt_deduction = new javax.swing.JTextField();
        txt_percentage = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        total_ded = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lbl_sal = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_reason = new javax.swing.JTextField();
        calculate = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        txt_Save = new javax.swing.JButton();
        Request = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        stafid = new javax.swing.JTextField();
        nm = new javax.swing.JTextField();
        lt = new javax.swing.JTextField();
        sd = new javax.swing.JTextField();
        ed = new javax.swing.JTextField();
        rsn1 = new javax.swing.JTextField();
        cm = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        aRadioButton = new javax.swing.JRadioButton();
        rRadioButton = new javax.swing.JRadioButton();
        svbtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        requestbtn = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(33, 49, 63));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Office_icon.png"))); // NOI18N

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText(" X");
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseExited(evt);
            }
        });

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setText(" -");
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelMinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelMinMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Digital Office Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(258, 258, 258)
                .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelClose)
                            .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(11, 11, 11))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 90));

        jPanel3.setBackground(new java.awt.Color(44, 62, 80));

        jHomeButtonPanel.setBackground(new java.awt.Color(218, 223, 225));
        jHomeButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jHomeButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jHomeButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jHomeButtonPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pane1Layout = new javax.swing.GroupLayout(pane1);
        pane1.setLayout(pane1Layout);
        pane1Layout.setHorizontalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pane1Layout.setVerticalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jHomeButtonLabel.setBackground(new java.awt.Color(255, 255, 255));
        jHomeButtonLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jHomeButtonLabel.setForeground(new java.awt.Color(36, 37, 42));
        jHomeButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_icon.png"))); // NOI18N
        jHomeButtonLabel.setText(" Home");

        javax.swing.GroupLayout jHomeButtonPanelLayout = new javax.swing.GroupLayout(jHomeButtonPanel);
        jHomeButtonPanel.setLayout(jHomeButtonPanelLayout);
        jHomeButtonPanelLayout.setHorizontalGroup(
            jHomeButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jHomeButtonPanelLayout.createSequentialGroup()
                .addComponent(pane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jHomeButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jHomeButtonPanelLayout.setVerticalGroup(
            jHomeButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jHomeButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jEmployeesButtonPanel.setBackground(new java.awt.Color(218, 223, 225));
        jEmployeesButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEmployeesButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jEmployeesButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jEmployeesButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jEmployeesButtonPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pane2Layout = new javax.swing.GroupLayout(pane2);
        pane2.setLayout(pane2Layout);
        pane2Layout.setHorizontalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pane2Layout.setVerticalGroup(
            pane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jUserProfileButtonLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jUserProfileButtonLabel.setForeground(new java.awt.Color(36, 37, 42));
        jUserProfileButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/staffs_icon.png"))); // NOI18N
        jUserProfileButtonLabel.setText(" Employees");

        javax.swing.GroupLayout jEmployeesButtonPanelLayout = new javax.swing.GroupLayout(jEmployeesButtonPanel);
        jEmployeesButtonPanel.setLayout(jEmployeesButtonPanelLayout);
        jEmployeesButtonPanelLayout.setHorizontalGroup(
            jEmployeesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEmployeesButtonPanelLayout.createSequentialGroup()
                .addComponent(pane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUserProfileButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        jEmployeesButtonPanelLayout.setVerticalGroup(
            jEmployeesButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jUserProfileButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jNoticeButtonPanel.setBackground(new java.awt.Color(218, 223, 225));
        jNoticeButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNoticeButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jNoticeButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jNoticeButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jNoticeButtonPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pane3Layout = new javax.swing.GroupLayout(pane3);
        pane3.setLayout(pane3Layout);
        pane3Layout.setHorizontalGroup(
            pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pane3Layout.setVerticalGroup(
            pane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jNoticeButtonLabel.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jNoticeButtonLabel.setForeground(new java.awt.Color(36, 37, 42));
        jNoticeButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/events_icon.png"))); // NOI18N
        jNoticeButtonLabel.setText(" Notice");

        javax.swing.GroupLayout jNoticeButtonPanelLayout = new javax.swing.GroupLayout(jNoticeButtonPanel);
        jNoticeButtonPanel.setLayout(jNoticeButtonPanelLayout);
        jNoticeButtonPanelLayout.setHorizontalGroup(
            jNoticeButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jNoticeButtonPanelLayout.createSequentialGroup()
                .addComponent(pane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jNoticeButtonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
        );
        jNoticeButtonPanelLayout.setVerticalGroup(
            jNoticeButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jNoticeButtonLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jSalarySlipButtonPanel.setBackground(new java.awt.Color(218, 223, 225));
        jSalarySlipButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSalarySlipButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSalarySlipButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSalarySlipButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSalarySlipButtonPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pane4Layout = new javax.swing.GroupLayout(pane4);
        pane4.setLayout(pane4Layout);
        pane4Layout.setHorizontalGroup(
            pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pane4Layout.setVerticalGroup(
            pane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jEventsButtonLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jEventsButtonLabel2.setForeground(new java.awt.Color(36, 37, 42));
        jEventsButtonLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salary_icon.png"))); // NOI18N
        jEventsButtonLabel2.setText(" Salary Slip");

        javax.swing.GroupLayout jSalarySlipButtonPanelLayout = new javax.swing.GroupLayout(jSalarySlipButtonPanel);
        jSalarySlipButtonPanel.setLayout(jSalarySlipButtonPanelLayout);
        jSalarySlipButtonPanelLayout.setHorizontalGroup(
            jSalarySlipButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSalarySlipButtonPanelLayout.createSequentialGroup()
                .addComponent(pane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jEventsButtonLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jSalarySlipButtonPanelLayout.setVerticalGroup(
            jSalarySlipButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jEventsButtonLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
        );

        jLogOutButtonPanel.setBackground(new java.awt.Color(218, 223, 225));
        jLogOutButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLogOutButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLogOutButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLogOutButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLogOutButtonPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pane5Layout = new javax.swing.GroupLayout(pane5);
        pane5.setLayout(pane5Layout);
        pane5Layout.setHorizontalGroup(
            pane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        pane5Layout.setVerticalGroup(
            pane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 74, Short.MAX_VALUE)
        );

        jEventsButtonLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jEventsButtonLabel1.setForeground(new java.awt.Color(36, 37, 42));
        jEventsButtonLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout_icon.png"))); // NOI18N
        jEventsButtonLabel1.setText(" Log Out");

        javax.swing.GroupLayout jLogOutButtonPanelLayout = new javax.swing.GroupLayout(jLogOutButtonPanel);
        jLogOutButtonPanel.setLayout(jLogOutButtonPanelLayout);
        jLogOutButtonPanelLayout.setHorizontalGroup(
            jLogOutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLogOutButtonPanelLayout.createSequentialGroup()
                .addComponent(pane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLogOutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLogOutButtonPanelLayout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(jEventsButtonLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        jLogOutButtonPanelLayout.setVerticalGroup(
            jLogOutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLogOutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jEventsButtonLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jHomeButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jEmployeesButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLogOutButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSalarySlipButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jNoticeButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jHomeButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jEmployeesButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jNoticeButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSalarySlipButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLogOutButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 290, 680));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(880, 88));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText(" Home");

        name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        name.setForeground(new java.awt.Color(102, 102, 102));
        name.setText("Logged in as:");

        showname.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        showname.setText("ABC");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(showname, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(showname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(51, 110, 123));

        nextbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right_icon.png"))); // NOI18N
        nextbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextbuttonMouseClicked(evt);
            }
        });

        prevbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/left_icon.png"))); // NOI18N
        prevbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prevbuttonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prevbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(nextbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(prevbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(nextbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomePageLayout = new javax.swing.GroupLayout(HomePage);
        HomePage.setLayout(HomePageLayout);
        HomePageLayout.setHorizontalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HomePageLayout.setVerticalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePageLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", HomePage);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password", "Gender", "Hired Date", "Phone No", "Email", "Department", "Basic Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setInheritsPopupMenu(true);
        jTable1.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jTable1.setRowHeight(35);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Password");
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Gender");
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Hired Date");
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(35);
            jTable1.getColumnModel().getColumn(5).setHeaderValue("Phone No");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("Email");
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(7).setHeaderValue("Department");
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(8).setHeaderValue("Basic Salary");
        }

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(880, 88));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText(" Employees");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(672, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(36, 37, 42));
        jLabel11.setText(" Employee ID :");

        ID.setEditable(false);
        ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        Remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_16x16.gif"))); // NOI18N
        Remove.setText("Delete Record");
        Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update icon.png"))); // NOI18N
        update.setText("Update Record");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText(" Search :");

        search_emp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_emp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_empKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText(" Phone No :");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText(" Password :");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText(" Email :");

        Email.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText(" Department :");

        Department.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText(" Basic Salary :");

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Allowance.png"))); // NOI18N
        jButton3.setText("Allowance");
        jButton3.setPreferredSize(new java.awt.Dimension(197, 59));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Deduction.png"))); // NOI18N
        jButton4.setText("Deduction");
        jButton4.setPreferredSize(new java.awt.Dimension(197, 59));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EmployeesLayout = new javax.swing.GroupLayout(Employees);
        Employees.setLayout(EmployeesLayout);
        EmployeesLayout.setHorizontalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(EmployeesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(EmployeesLayout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(update)
                                .addGap(42, 42, 42)
                                .addComponent(Remove))
                            .addGroup(EmployeesLayout.createSequentialGroup()
                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EmployeesLayout.createSequentialGroup()
                                        .addGap(208, 474, Short.MAX_VALUE)
                                        .addComponent(jLabel16))
                                    .addGroup(EmployeesLayout.createSequentialGroup()
                                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(EmployeesLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(74, 74, 74)
                                                .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(EmployeesLayout.createSequentialGroup()
                                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel15))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(phoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(EmployeesLayout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(Basic, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(23, 23, 23))))
        );
        EmployeesLayout.setVerticalGroup(
            EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeesLayout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(search_emp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Basic, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(EmployeesLayout.createSequentialGroup()
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("tab2", Employees);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText(" Notice");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(672, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(204, 255, 102));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(51, 255, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jButton2.setForeground(new java.awt.Color(36, 37, 42));
        jButton2.setText("SEND");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        Title.setBackground(new java.awt.Color(102, 102, 255));
        Title.setFont(new java.awt.Font("Tahoma", 0, 26)); // NOI18N

        Contant.setBackground(new java.awt.Color(255, 204, 0));
        Contant.setColumns(20);
        Contant.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        Contant.setForeground(new java.awt.Color(36, 37, 42));
        Contant.setLineWrap(true);
        Contant.setRows(5);
        Contant.setWrapStyleWord(true);
        jScrollPane3.setViewportView(Contant);

        javax.swing.GroupLayout NoticeLayout = new javax.swing.GroupLayout(Notice);
        Notice.setLayout(NoticeLayout);
        NoticeLayout.setHorizontalGroup(
            NoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(NoticeLayout.createSequentialGroup()
                .addGroup(NoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NoticeLayout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(NoticeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(NoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(NoticeLayout.createSequentialGroup()
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 618, Short.MAX_VALUE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        NoticeLayout.setVerticalGroup(
            NoticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoticeLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", Notice);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(880, 88));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText(" Salary Slip");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Employee Name :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Employee ID :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Total Allowance :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Date of Birth :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Phone No. :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Email :");

        dob.setEditable(false);
        dob.setPreferredSize(new java.awt.Dimension(69, 37));

        phone.setEditable(false);
        phone.setPreferredSize(new java.awt.Dimension(69, 37));

        t_allow.setEditable(false);
        t_allow.setPreferredSize(new java.awt.Dimension(69, 37));

        id.setEditable(false);
        id.setPreferredSize(new java.awt.Dimension(69, 37));

        uname.setEditable(false);
        uname.setPreferredSize(new java.awt.Dimension(69, 37));

        email.setEditable(false);
        email.setPreferredSize(new java.awt.Dimension(69, 37));

        reset.setFont(new java.awt.Font("Times New Roman", 0, 17)); // NOI18N
        reset.setText("Clear");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Calculate.png"))); // NOI18N
        jButton1.setText("Calculate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N

        jLabel43.setText("Employee ID:");

        txt_search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_search1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43)
                .addGap(18, 18, 18)
                .addComponent(txt_search1)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dept.setEditable(false);

        hired.setEditable(false);

        s_basic.setEditable(false);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel44.setText("Department :");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel45.setText("Hired Date :");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel46.setText("Basic Salary :");

        t_ded.setEditable(false);

        t_sal.setEditable(false);

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setText("Total Deduction :");

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel56.setText("Total Salary :");

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/slip.png"))); // NOI18N
        jToggleButton1.setText("Generate Slip");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Salary_SlipLayout = new javax.swing.GroupLayout(Salary_Slip);
        Salary_Slip.setLayout(Salary_SlipLayout);
        Salary_SlipLayout.setHorizontalGroup(
            Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Salary_SlipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Salary_SlipLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Salary_SlipLayout.createSequentialGroup()
                                .addComponent(jLabel44)
                                .addGap(102, 102, 102)
                                .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Salary_SlipLayout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hired, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Salary_SlipLayout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(s_basic, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Salary_SlipLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(t_allow, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Salary_SlipLayout.createSequentialGroup()
                                .addComponent(jLabel55)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(t_ded, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14)))
                .addContainerGap())
            .addGroup(Salary_SlipLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(jLabel56)
                .addGap(104, 104, 104)
                .addComponent(t_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Salary_SlipLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jToggleButton1)
                .addGap(44, 44, 44)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        Salary_SlipLayout.setVerticalGroup(
            Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Salary_SlipLayout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE)
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(dept, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel45)
                    .addComponent(hired, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel46)
                    .addComponent(s_basic, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(t_allow, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel55)
                    .addComponent(t_ded, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(t_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Salary_SlipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(214, 214, 214))
        );

        jLabel4.getAccessibleContext().setAccessibleName("Total Salary :");

        jTabbedPane1.addTab("tab4", Salary_Slip);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(880, 88));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText(" Allowance");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(672, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N

        jLabel18.setText("Employee ID:");

        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(txt_search)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_empid.setEditable(false);

        txt_salary.setEditable(false);

        jLabel23.setText("Basic Salary :");

        jLabel24.setText("Hired Date :");

        jLabel25.setText("Username :");

        jLabel26.setText("Employee ID :");

        jLabel27.setText("Department :");

        txt_dept.setEditable(false);

        txt_hired.setEditable(false);

        txt_uname.setEditable(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24)
                    .addComponent(jLabel23)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_dept, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_uname)
                        .addComponent(txt_empid)
                        .addComponent(txt_hired)
                        .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txt_empid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txt_uname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txt_hired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txt_salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_dept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_med.setText("0");

        txt_bonus.setText("0");

        jLabel29.setText("Medical :");

        jLabel30.setText("Bouns :");

        jLabel32.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel32.setText("Please enter the amounts");

        txt_hw.setText("0");

        jLabel33.setText("Overtime (hr) :");

        txt_total_overtime.setEditable(false);
        txt_total_overtime.setText("0");

        txt_per.setEditable(false);
        txt_per.setText("0");

        jLabel34.setText("Total Overtime :");

        jLabel35.setText("Rate Per Hour :");

        jLabel36.setText("Total Amount :");

        lbl_total.setEditable(false);
        lbl_total.setText("0.00");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_med, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txt_bonus)
                            .addComponent(txt_hw, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(151, 151, 151))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel35)
                                    .addComponent(jLabel36))))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_per, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(txt_total_overtime))
                    .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(114, 114, 114))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(txt_hw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_med, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(txt_total_overtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txt_per, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_bonus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel36)
                        .addComponent(lbl_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table_allowance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(table_allowance);

        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        txt_cal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Calculate.png"))); // NOI18N
        txt_cal.setText("Calculate");
        txt_cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_calActionPerformed(evt);
            }
        });

        clearButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase-128.png"))); // NOI18N
        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AllowanceLayout = new javax.swing.GroupLayout(Allowance);
        Allowance.setLayout(AllowanceLayout);
        AllowanceLayout.setHorizontalGroup(
            AllowanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(AllowanceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AllowanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AllowanceLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cal, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(AllowanceLayout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AllowanceLayout.setVerticalGroup(
            AllowanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AllowanceLayout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AllowanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(AllowanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cal, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab5", Allowance);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(880, 88));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText(" Deduction");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(672, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        jPanel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Employee ID :");

        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addComponent(search)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Employee ID :");

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Username :");

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Date of Birth :");

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Phone No. :");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Email :");

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("Hired Date :");

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Department :");

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Basic Salary :");

        Did.setEditable(false);
        Did.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Duname.setEditable(false);
        Duname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Dbirth.setEditable(false);
        Dbirth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Dphone.setEditable(false);
        Dphone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Demail.setEditable(false);
        Demail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Dhired.setEditable(false);
        Dhired.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Ddept.setEditable(false);
        Ddept.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Dbasic.setEditable(false);
        Dbasic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        r_percentage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        r_percentage.setText("Percentage (%)");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Update Salary by :");

        r_amount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        r_amount2.setText("Amount");

        txt_deduction.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_percentage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Percentage :");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Amount:");

        total_ded.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_ded.setText("0.00");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel40.setText("Total Deduction:");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setText("Salary after deduction:");

        lbl_sal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_sal.setText("0.00");

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel42.setText("Reason:");

        txt_reason.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        calculate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Calculate.png"))); // NOI18N
        calculate.setText("Calculate");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });

        clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase-128.png"))); // NOI18N
        clear.setText("Clear");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        txt_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        txt_Save.setText("Save");
        txt_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addGap(52, 52, 52)
                                .addComponent(r_percentage))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(txt_percentage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel39)
                                        .addGap(13, 13, 13)))))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(r_amount2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_deduction, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(total_ded, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(jLabel41)
                                        .addGap(31, 31, 31)
                                        .addComponent(lbl_sal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(54, 54, 54)
                                .addComponent(txt_reason, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(197, 197, 197))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(296, 296, 296))))))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(r_amount2)
                    .addComponent(r_percentage)
                    .addComponent(jLabel40)
                    .addComponent(total_ded))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lbl_sal)
                    .addComponent(txt_deduction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39)
                    .addComponent(txt_percentage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37))
                .addGap(36, 36, 36)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_reason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout DeductionLayout = new javax.swing.GroupLayout(Deduction);
        Deduction.setLayout(DeductionLayout);
        DeductionLayout.setHorizontalGroup(
            DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DeductionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DeductionLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeductionLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DeductionLayout.createSequentialGroup()
                        .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Duname, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DeductionLayout.createSequentialGroup()
                                .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel48)
                                    .addComponent(jLabel49)
                                    .addComponent(jLabel50))
                                .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DeductionLayout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(Did, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeductionLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Dbirth, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Dphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(133, 133, 133)
                        .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DeductionLayout.createSequentialGroup()
                                .addComponent(jLabel54)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Dbasic, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeductionLayout.createSequentialGroup()
                                .addComponent(jLabel53)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Ddept, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeductionLayout.createSequentialGroup()
                                .addComponent(jLabel52)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Dhired, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DeductionLayout.createSequentialGroup()
                                .addComponent(jLabel51)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Demail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73))))
        );
        DeductionLayout.setVerticalGroup(
            DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeductionLayout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(Did, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(Demail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Duname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jLabel52)
                    .addComponent(Dhired, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dbirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jLabel53)
                    .addComponent(Ddept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DeductionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(jLabel54)
                    .addComponent(Dbasic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", Deduction);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(880, 88));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setText(" Leave Request");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leave Requests", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 21), new java.awt.Color(0, 0, 255))); // NOI18N

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setInheritsPopupMenu(true);
        jTable2.setIntercellSpacing(new java.awt.Dimension(10, 10));
        jTable2.setRowHeight(35);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(35);
        }

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Request Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 21), new java.awt.Color(0, 0, 255))); // NOI18N

        stafid.setEditable(false);
        stafid.setBackground(new java.awt.Color(255, 255, 255));
        stafid.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        nm.setEditable(false);
        nm.setBackground(new java.awt.Color(255, 255, 255));
        nm.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        lt.setEditable(false);
        lt.setBackground(new java.awt.Color(255, 255, 255));
        lt.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sd.setEditable(false);
        sd.setBackground(new java.awt.Color(255, 255, 255));
        sd.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        ed.setEditable(false);
        ed.setBackground(new java.awt.Color(255, 255, 255));
        ed.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        rsn1.setEditable(false);
        rsn1.setBackground(new java.awt.Color(255, 255, 255));
        rsn1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        cm.setBackground(new java.awt.Color(255, 255, 255));
        cm.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setText("Employee ID:");

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel59.setText("Name:");

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel60.setText("Leave Type:");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel61.setText("Start Date:");

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel62.setText("End Date:");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel63.setText("Reason:");

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel64.setText("Command:");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel65.setText("Status:");

        aRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        aRadioButton.setText("Accept");

        rRadioButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rRadioButton.setText("Reject");

        svbtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        svbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-save-as-40.png"))); // NOI18N
        svbtn.setText("Save");
        svbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel58)
                    .addComponent(jLabel59)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jLabel62)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                            .addComponent(cm, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ed, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rsn1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(sd, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap()))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stafid, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(aRadioButton)
                                .addGap(49, 49, 49)
                                .addComponent(rRadioButton)))
                        .addGap(69, 69, 69))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(svbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stafid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ed, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rsn1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65)
                    .addComponent(aRadioButton)
                    .addComponent(rRadioButton))
                .addGap(18, 18, 18)
                .addComponent(svbtn)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RequestLayout = new javax.swing.GroupLayout(Request);
        Request.setLayout(RequestLayout);
        RequestLayout.setHorizontalGroup(
            RequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(RequestLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        RequestLayout.setVerticalGroup(
            RequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestLayout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(RequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab7", Request);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 885, 710));

        requestbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leave_icon-17.png"))); // NOI18N
        requestbtn.setText("Leave");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leaving-req-icon-17.png"))); // NOI18N
        jMenuItem1.setText("Leave Request");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        requestbtn.add(jMenuItem1);

        jMenuBar1.add(requestbtn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jHomeButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jHomeButtonPanelMouseClicked

    private void jHomeButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMouseEntered
        jHomeButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jHomeButtonPanelMouseEntered

    private void jHomeButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMouseExited
        jHomeButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jHomeButtonPanelMouseExited

    private void jHomeButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMousePressed
        pane1.setBackground(paneclick);
        pane2.setBackground(panedefault);
        pane3.setBackground(panedefault);
        pane4.setBackground(panedefault);
        pane5.setBackground(panedefault);
    }//GEN-LAST:event_jHomeButtonPanelMousePressed

    private void jEmployeesButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEmployeesButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(1);
        loadsampledata();
        ID.setText("");
        Password.setText("");
        phoneno.setText("");
        Email.setText("");
        Department.setText("");
        Basic.setText("");
    }//GEN-LAST:event_jEmployeesButtonPanelMouseClicked

    private void jEmployeesButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEmployeesButtonPanelMouseEntered
        jEmployeesButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jEmployeesButtonPanelMouseEntered

    private void jEmployeesButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEmployeesButtonPanelMouseExited
        jEmployeesButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jEmployeesButtonPanelMouseExited

    private void jEmployeesButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEmployeesButtonPanelMousePressed
        pane2.setBackground(paneclick);
        pane1.setBackground(panedefault);
        pane3.setBackground(panedefault);
        pane4.setBackground(panedefault);
        pane5.setBackground(panedefault);
    }//GEN-LAST:event_jEmployeesButtonPanelMousePressed

    private void jLogOutButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogOutButtonPanelMouseClicked
        int x = JOptionPane.showConfirmDialog(this, "Are you sure to logout", "Confirm Logout", JOptionPane.YES_NO_OPTION);
        if(x == 0)
        {
            AdminLogin_form adlgf = new AdminLogin_form();
            adlgf.setVisible(true);
            adlgf.pack();
            adlgf.setLocationRelativeTo(null);
            adlgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
    }//GEN-LAST:event_jLogOutButtonPanelMouseClicked

    private void jLogOutButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogOutButtonPanelMouseEntered
        jLogOutButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jLogOutButtonPanelMouseEntered

    private void jLogOutButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogOutButtonPanelMouseExited
        jLogOutButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jLogOutButtonPanelMouseExited

    private void jLogOutButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogOutButtonPanelMousePressed
        pane5.setBackground(paneclick);
        pane1.setBackground(panedefault);
        pane2.setBackground(panedefault);
        pane3.setBackground(panedefault);
        pane4.setBackground(panedefault);
    }//GEN-LAST:event_jLogOutButtonPanelMousePressed

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setForeground(Color.red);
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelMinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseEntered
        jLabelMin.setForeground(Color.gray);
    }//GEN-LAST:event_jLabelMinMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setForeground(Color.white);
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelMinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseExited
        jLabelMin.setForeground(Color.white);
    }//GEN-LAST:event_jLabelMinMouseExited

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jSalarySlipButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalarySlipButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_jSalarySlipButtonPanelMouseClicked

    private void jSalarySlipButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalarySlipButtonPanelMouseEntered
        jSalarySlipButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jSalarySlipButtonPanelMouseEntered

    private void jSalarySlipButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalarySlipButtonPanelMouseExited
        jSalarySlipButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jSalarySlipButtonPanelMouseExited

    private void jSalarySlipButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalarySlipButtonPanelMousePressed
        pane4.setBackground(paneclick);
        pane1.setBackground(panedefault);
        pane2.setBackground(panedefault);
        pane3.setBackground(panedefault);
        pane5.setBackground(panedefault);
    }//GEN-LAST:event_jSalarySlipButtonPanelMousePressed

    private void jNoticeButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jNoticeButtonPanelMouseClicked

    private void jNoticeButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMouseEntered
        jNoticeButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jNoticeButtonPanelMouseEntered

    private void jNoticeButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMouseExited
        jNoticeButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jNoticeButtonPanelMouseExited

    private void jNoticeButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMousePressed
        pane3.setBackground(paneclick);
        pane1.setBackground(panedefault);
        pane2.setBackground(panedefault);
        pane4.setBackground(panedefault);
    }//GEN-LAST:event_jNoticeButtonPanelMousePressed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        txt_search1.setText("");
        id.setText("");
        dept.setText("");
        uname.setText("");
        hired.setText("");
        dob.setText("");
        s_basic.setText("");
        phone.setText("");
        t_allow.setText("");
        email.setText("");
        t_ded.setText("");
        t_sal.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void nextbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextbuttonMouseClicked
        cardLayout.next(Label1);
    }//GEN-LAST:event_nextbuttonMouseClicked

    private void prevbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevbuttonMouseClicked
        cardLayout.previous(Label1);
    }//GEN-LAST:event_prevbuttonMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        double bs = Double.parseDouble(s_basic.getText());
        double ta = Double.parseDouble(t_allow.getText());
        double td = Double.parseDouble(t_ded.getText());
        
        double ts = bs+ta-td;
        //System.out.println(ts);
        t_sal.setText(String.valueOf(ts));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Writing to file
        String title_file = Title.getText();
        String contant_file = Contant.getText();
        
        FileWriter fileWriter;
        FileWriter fileWriter1;
        
        try{
            fileWriter = new FileWriter("Title.txt");
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(title_file);
            }
            
            fileWriter1 = new FileWriter("Contant.txt");
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter1)) {
                bufferedWriter.write(contant_file);
            }
        } catch (Exception e) {
            System.out.println(""+e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveActionPerformed
        PreparedStatement st;   
        String id = ID.getText();
        
        String query = "DELETE FROM `staffs` WHERE `ID` = ?";
        if(id.trim().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Enter a valid ID to remove", "Empty ID", 2);
        }
        else
        {
            int x = JOptionPane.showConfirmDialog(this, "Are you sure to remove this staff", "Remove Staff", JOptionPane.YES_NO_OPTION);

            if (x == 0) {
                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String value1 = dateString;
                String date = value0 + " / " + value1;
                String status = "Deleted Record";
                
                try{
                    PreparedStatement ps;
                    ResultSet rs;
                    String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                    ps = MyConnection.getConnection().prepareStatement(reg);
                    ps.setString(1, id);
                    ps.setString(2, date);
                    ps.setString(3, status);
                    ps.executeUpdate();
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                try {
                    st = MyConnection.getConnection().prepareStatement(query);
                    st.setString(1, id);
                    st.execute();
                    JOptionPane.showMessageDialog(null,"Record Deleted");
                    loadsampledata();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_RemoveActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        if (ID.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Employee ID Field is empty");
        } else if (Password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password Field is empty");
        } else if (phoneno.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Phone No Field is empty");
        } else if (Email.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Email Field is empty");
        } else if (Department.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Department Field is empty");
        } else if (Basic.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Basic Salary Field is empty");
        } else {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure to update?","Update Record",JOptionPane.YES_NO_OPTION);
            if(p == 0) {
                try {
                    String value0 = Password.getText();
                    String value1 = phoneno.getText().toString();
                    String value2 = Basic.getText();
                    
                    PreparedStatement ps;
                    String sql = "UPDATE `staffs` SET `Password`="+value0+", `Phone No`="+value1+", `Basic Salary`="+value2+" WHERE `ID`="+ID.getText();
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Updated");
                    loadsampledata();
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String value1 = dateString;
                String date = value0 + " / " + value1;
                String status = "Updated Record";

                try{
                    PreparedStatement ps;
                    ResultSet rs;
                    String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                    ps = MyConnection.getConnection().prepareStatement(reg);
                    ps.setString(1, ID.getText());
                    ps.setString(2, date);
                    ps.setString(3, status);
                    ps.executeUpdate();
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                ID.setText("");
                Password.setText("");
                phoneno.setText("");
                Email.setText("");
                Department.setText("");
                Basic.setText("");
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void search_empKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_empKeyReleased
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search_emp.getText().trim()));
    }//GEN-LAST:event_search_empKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        Update_table();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        try{
            PreparedStatement st;
            ResultSet rs; 
            String sql = "SELECT * FROM `staffs` WHERE `ID` = ?";

            st = MyConnection.getConnection().prepareStatement(sql);
            st.setString(1,txt_search.getText());
            rs = st.executeQuery();
            
            if (rs.next()) {
                String add1 = rs.getString("ID");
                txt_empid.setText(add1);

                String add2 = rs.getString("Username");
                txt_uname.setText(add2);

                String add3 = rs.getString("Hired Date");
                txt_hired.setText(add3);

                String add4 = rs.getString("Basic Salary");
                txt_salary.setText(add4);

                String add5 = rs.getString("Department");
                txt_dept.setText(add5);
            }
            rs.close();
            st.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_calActionPerformed
        int salary = Integer.parseInt(txt_salary.getText());
        int overtime = Integer.parseInt(txt_hw.getText());

        double eight = 8;
        double days = 25;
        double dbop = 0;
        double overtimeRate = 1.5;

        //calculate the total hours of overtime
        double Total_Overtime = overtime * overtimeRate;
        String x = String.valueOf(Total_Overtime);
        txt_total_overtime.setText(x);

        //calculate overall overtime
        dbop = salary / days / eight;
        String s = String.valueOf(dbop);
        txt_per.setText(s);

        int med = Integer.parseInt(txt_med.getText());
        int bonus = Integer.parseInt(txt_bonus.getText());
        int f = med + bonus;
        double calc = Total_Overtime * dbop + f;
        String c = String.valueOf(Math.ceil(calc));
        lbl_total.setText(c);
    }//GEN-LAST:event_txt_calActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        txt_search.setText("");
        txt_empid.setText("");
        txt_uname.setText("");
        txt_salary.setText("");
        txt_hired.setText("");
        txt_dept.setText("");
        txt_med.setText("0");
        txt_bonus.setText("0");
        txt_hw.setText("0");
        txt_per.setText("0");
        txt_total_overtime.setText("0");
        lbl_total.setText("0.00");
    }//GEN-LAST:event_clearButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (txt_empid.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Employee ID Field is empty");
        } else if (txt_uname.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Username Field is empty");
        } else if (txt_hired.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Hired Date Field is empty");
        } else if (txt_salary.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Salary Field is empty");
        } else if (txt_dept.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Department Field is empty");
        } else {       
            int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to save record?","Add Record",JOptionPane.YES_NO_OPTION);
            if(p == 0){
                try {
                    //int value = Emp.empId;
                    String value1 =  txt_salary.getText();
                    String value2 =  txt_bonus.getText();
                    String value3 =  txt_med.getText();
                    String value4 =  txt_per.getText();
                    String value5 =  txt_hw.getText();
                    String value6 =  lbl_total.getText();  
                    String value7 =  txt_empid.getText();
                    String value8 =  txt_uname.getText();

                    PreparedStatement ps;
                    String sql= "INSERT INTO `allowance`(`Emp_ID`, `Username`, `Overtime (in hr)`, `Medical`, `Bonus`, `Basic Salary`, `Rate (in hr)`, `Total Allowance`) VALUES (?,?,?,?,?,?,?,?)";
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    ps.setString(1, value7);
                    ps.setString(2, value8);
                    ps.setString(3, value5);
                    ps.setString(4, value3);
                    ps.setString(5, value2);
                    ps.setString(6, value1);
                    ps.setString(7, value4);
                    ps.setString(8, value6);
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "Allowance Added");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,e);
                }
                
                try {
                    Date currentDate = GregorianCalendar.getInstance().getTime();
                    DateFormat df = DateFormat.getDateInstance();
                    String dateString = df.format(currentDate);

                    Date d = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                    String timeString = sdf.format(d);

                    String value0 = timeString;
                    String value1 = dateString;
                    String date = value0 + " / " + value1;
                    String status = "Updated Allowance Record";
                    String id =  txt_empid.getText();
                    
                    PreparedStatement ps;
                    String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                    ps = MyConnection.getConnection().prepareStatement(reg);
                    ps.setString(1, id);
                    ps.setString(2, date);
                    ps.setString(3, status);
                    ps.executeUpdate();
                } catch (Exception e) {
                       JOptionPane.showMessageDialog(null,e);
                }
            }
        }
        Update_table();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int i = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        ID.setText(model.getValueAt(i, 0).toString());
        Password.setText(model.getValueAt(i, 2).toString());
        phoneno.setText(model.getValueAt(i, 5).toString());
        Email.setText(model.getValueAt(i, 6).toString());
        Department.setText(model.getValueAt(i, 7).toString());
        Basic.setText(model.getValueAt(i, 8).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        try{
            PreparedStatement st1;
            ResultSet rs1; 
            String sql = "SELECT * FROM `staffs` WHERE `ID` = ?";

            st1 = MyConnection.getConnection().prepareStatement(sql);
            st1.setString(1,search.getText());
            rs1 = st1.executeQuery();
            
            if (rs1.next()) {
                String add1 = rs1.getString("ID");
                Did.setText(add1);
                
                String add2 = rs1.getString("Username");
                Duname.setText(add2);
        
                String add3 = rs1.getString("Birth Date");
                Dbirth.setText(add3);
        
                String add4 = rs1.getString("Phone No");
                Dphone.setText(add4);
        
                String add5 = rs1.getString("Email");
                Demail.setText(add5);

                String add6 = rs1.getString("Department");
                Ddept.setText(add6);

                String add7 = rs1.getString("Hired Date");
                Dhired.setText(add7);

                String add8 = rs1.getString("Basic Salary");
                Dbasic.setText(add8);
            }    
            rs1.close();
            st1.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_searchKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jTabbedPane1.setSelectedIndex(5);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed
        int salary = Integer.parseInt(Dbasic.getText());

        if(r_percentage.isSelected()== true){
            int percentage = Integer.parseInt(txt_percentage.getText());
            //calculate the total hours of overtime
            int total_percentage_deduction = salary / 100 * percentage;
            String x = String.valueOf(total_percentage_deduction);
            int sal = salary - total_percentage_deduction;
            total_ded.setText(x);
            lbl_sal.setText(String.valueOf(sal));
        }

        if(r_amount2.isSelected()== true){
            int deduction = Integer.parseInt(txt_deduction.getText());
            //calculate the total hours of overtime
            int total_amount_deduction =  salary - deduction;
            String s = String.valueOf(total_amount_deduction);

            lbl_sal.setText(s);
            total_ded.setText(String.valueOf(deduction));
        }
    }//GEN-LAST:event_calculateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        Did.setText("");
        Duname.setText("");
        Dbirth.setText("");
        Dphone.setText("");
        Demail.setText("");
        Ddept.setText("");
        Dhired.setText("");
        Dbasic.setText("");
        total_ded.setText("0.00");
        txt_percentage.setText("");
        txt_deduction.setText("");
        txt_reason.setText(""); 
        search.setText(""); 
        lbl_sal.setText("0.00");
    }//GEN-LAST:event_clearActionPerformed

    private void txt_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SaveActionPerformed
        int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?","Add Record",JOptionPane.YES_NO_OPTION);
        if(p == 0){
            String id = Did.getText();
            try {
                PreparedStatement ps;
                String sql = "INSERT INTO `deduction`(`Emp_ID`, `Username`, `Basic Salary`, `Deduction Amount`, `Deduction Reason`) VALUES (?,?,?,?,?)";
                ps = MyConnection.getConnection().prepareStatement(sql);
                ps.setString(1,id);
                ps.setString(2,Duname.getText());
                ps.setString(3,Dbasic.getText());
                ps.setString(4,total_ded.getText());
                ps.setString(5,txt_reason.getText());
                ps.execute();
                JOptionPane.showMessageDialog(null,"Data is saved successfully");
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            
            try{
                Date currentDate = GregorianCalendar.getInstance().getTime();
                DateFormat df = DateFormat.getDateInstance();
                String dateString = df.format(currentDate);

                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String timeString = sdf.format(d);

                String value0 = timeString;
                String value1 = dateString;
                String date = value0 + " / " + value1;
                String status = "Updated Deduction Record";

                PreparedStatement ps;
                String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                ps = MyConnection.getConnection().prepareStatement(reg);
                ps.setString(1, id);
                ps.setString(2, date);
                ps.setString(3, status);
                ps.executeUpdate();
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_txt_SaveActionPerformed

    private void txt_search1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search1KeyReleased
        try{
            PreparedStatement st;
            ResultSet rs; 
            String sql = "SELECT * FROM `staffs` WHERE `ID` = ?";
            st = MyConnection.getConnection().prepareStatement(sql);
            st.setString(1,txt_search1.getText());
            rs = st.executeQuery();
            
            if (rs.next()) {
                String add1 = rs.getString("ID");
                id.setText(add1);                
                String add2 = rs.getString("Username");
                uname.setText(add2);        
                String add3 = rs.getString("Birth Date");
                dob.setText(add3);       
                String add4 = rs.getString("Phone No");
                phone.setText(add4);       
                String add5 = rs.getString("Email");
                email.setText(add5);
                String add6 = rs.getString("Department");
                dept.setText(add6);
                String add7 = rs.getString("Hired Date");
                hired.setText(add7);
                String add8 = rs.getString("Basic Salary");
                s_basic.setText(add8);
            }    
            rs.close();
            st.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            PreparedStatement st;
            ResultSet rs;
            String sql = "SELECT `Total Allowance` FROM `allowance` WHERE `Emp_ID` = ?";
            st = MyConnection.getConnection().prepareStatement(sql);
            st.setString(1,txt_search1.getText());
            rs = st.executeQuery();
            if (rs.next()){
                String a = rs.getString("Total Allowance");
                t_allow.setText(a);
            }
            rs.close();
            st.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            PreparedStatement st;
            ResultSet rs;
            String sql = "SELECT `Deduction Amount` FROM `deduction` WHERE `Emp_ID` = ?";
            st = MyConnection.getConnection().prepareStatement(sql);
            st.setString(1,txt_search1.getText());
            rs = st.executeQuery();
            if (rs.next()){
                String b = rs.getString("Deduction Amount");
                t_ded.setText(b);
            }
            rs.close();
            st.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    
    }//GEN-LAST:event_txt_search1KeyReleased

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        String value = id.getText();
        String value0 = uname.getText();
        String value1 = phone.getText();
        String value2 = email.getText();
        String value3 = s_basic.getText();
        String value4 = dept.getText();
        String value5 = t_allow.getText();
        String value6 = t_ded.getText();
        String value7 = t_sal.getText();
         
        JFileChooser dialog = new JFileChooser();
        dialog.setSelectedFile(new File(value +" "+ value0+"-Salary Slip"+".pdf"));
        int dialogResult = dialog.showSaveDialog(null);
        if (dialogResult == JFileChooser.APPROVE_OPTION){
            String filePath = dialog.getSelectedFile().getPath();
            String overtime = null, medical = null, bonus = null, reason = null;
            
            try{
                PreparedStatement ps;
                ResultSet rs;
                String sql = "SELECT * FROM `allowance` WHERE `Emp_ID` =" + value;
                ps = MyConnection.getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()){
                    overtime = rs.getString("Overtime (in hr)");
                    medical = rs.getString("Medical");
                    bonus = rs.getString("Bonus");
                }
                rs.close();
                ps.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            
            try{
                PreparedStatement ps;
                ResultSet rs;
                String sql = "SELECT * FROM `deduction` WHERE `Emp_ID` =" + value;
                ps = MyConnection.getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()){
                    reason = rs.getString("Deduction Reason");
                }
                rs.close();
                ps.close();
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
                
            try{    
                Document myDocument = new Document();
                PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
                myDocument.open();
                
                myDocument.add(new Paragraph("PAY SLIP",FontFactory.getFont(FontFactory.TIMES_BOLD,20,Font.BOLD )));
                myDocument.add(new Paragraph(new Date().toString()));
                myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                myDocument.add((new Paragraph("EMPLOYEE DETAILS",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD))));
                myDocument.add((new Paragraph("Name of Employee: " +value0,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
                myDocument.add((new Paragraph("Department: "+value4,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN))));
                myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                myDocument.add(new Paragraph("SALARY",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
                myDocument.add(new Paragraph("Basic Salary: $"+value3,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("Overtime: "+overtime+" Hours",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("Medical: $"+medical,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("Bonus: $"+bonus,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                myDocument.add(new Paragraph("DEDUCTION",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
                myDocument.add(new Paragraph("Deduction Details: "+reason,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("Total Deductions : $"+value6,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                myDocument.add(new Paragraph("TOTAL PAYMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD)));
                myDocument.add(new Paragraph("Total Earnings: $"+value5,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("Net Pay : $" +value7,FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.PLAIN)));
                myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
                myDocument.add(new Paragraph("\n"));
                myDocument.add(new Paragraph("\n"));
                myDocument.add(new Paragraph("                                                                                       ------------------"));
                myDocument.add(new Paragraph("                                                                                                     Signature",FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD)));
                
                myDocument.newPage();
                myDocument.close();  
                JOptionPane.showMessageDialog(null,"Report was successfully generated");
            } catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jTabbedPane1.setSelectedIndex(6);
        loadreqtable();
        stafid.setText("");
        nm.setText("");
        lt.setText("");
        sd.setText("");
        ed.setText("");
        rsn1.setText("");
        cm.setText("");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void svbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svbtnActionPerformed
        if(aRadioButton.isSelected() == false && rRadioButton.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Please select any status");
        } else if (stafid.getText().equals("") | nm.getText().equals("") | lt.getText().equals("") | sd.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill up the empty fields");
        } else if (ed.getText().equals("") | rsn1.getText().equals("") | cm.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill up the empty fields");
        } else {
            String comma = cm.getText();
            if (aRadioButton.isSelected() == true) {
                String stat = "Accepted";
                try {
                    PreparedStatement ps;
                    String sql = "UPDATE `leave_report` SET `Status` = ?, `Command` = ? WHERE `ID`= ?";
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    ps.setString(1, stat);
                    ps.setString(2, comma);
                    ps.setString(3, tableid);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    PreparedStatement ps;
                    String sql = "DELETE FROM `leave_request` WHERE `ID` = ?";
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    ps.setString(1, tableid);
                    ps.executeUpdate();
                    loadreqtable();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (rRadioButton.isSelected() == true) {
                String stat = "Rejected";
                try {
                    PreparedStatement ps;
                    String sql = "UPDATE `leave_report` SET `Status` = ?, `Command` = ? WHERE `ID`= ?";
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    ps.setString(1, stat);
                    ps.setString(2, comma);
                    ps.setString(3, tableid);
                    ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                try {
                    PreparedStatement ps;
                    String sql = "DELETE FROM `leave_request` WHERE `ID` = ?";
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    ps.setString(1, tableid);
                    ps.executeUpdate();
                    loadreqtable();
                } catch (SQLException ex) {
                    Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_svbtnActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int i = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        tableid = model.getValueAt(i, 0).toString();
        stafid.setText(model.getValueAt(i, 1).toString());
        
        try {
            PreparedStatement ps;
            ResultSet rs; 
            String sql = "SELECT `Name`, `Leave Type`, `Start Date`, `End Date`, `Reason` FROM `leave_request`  WHERE `ID` = ?";
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setString(1, tableid);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                String nam = rs.getString("Name");
                nm.setText(nam);
                String ltype = rs.getString("Leave Type");
                lt.setText(ltype);
                String sdate = rs.getString("Start Date");
                sd.setText(sdate);
                String edate = rs.getString("End Date");
                ed.setText(edate);
                String rsn = rs.getString("Reason");
                rsn1.setText(rsn);
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminHomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Allowance;
    private javax.swing.JTextField Basic;
    private javax.swing.JTextArea Contant;
    private javax.swing.JTextField Dbasic;
    private javax.swing.JTextField Dbirth;
    private javax.swing.JTextField Ddept;
    private javax.swing.JPanel Deduction;
    private javax.swing.JTextField Demail;
    private javax.swing.JTextField Department;
    private javax.swing.JTextField Dhired;
    private javax.swing.JTextField Did;
    private javax.swing.JTextField Dphone;
    private javax.swing.JTextField Duname;
    private javax.swing.JTextField Email;
    private javax.swing.JPanel Employees;
    private javax.swing.JPanel HomePage;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel Label1;
    private javax.swing.JPanel Notice;
    private javax.swing.JTextField Password;
    private javax.swing.JButton Remove;
    private javax.swing.JPanel Request;
    private javax.swing.JPanel Salary_Slip;
    private javax.swing.JTextField Title;
    private javax.swing.JRadioButton aRadioButton;
    private javax.swing.JButton calculate;
    private javax.swing.JButton clear;
    private javax.swing.JButton clearButton;
    private javax.swing.JTextField cm;
    private javax.swing.JTextField dept;
    private javax.swing.JTextField dob;
    private javax.swing.JTextField ed;
    private javax.swing.JTextField email;
    private javax.swing.JTextField hired;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jEmployeesButtonPanel;
    private javax.swing.JLabel jEventsButtonLabel1;
    private javax.swing.JLabel jEventsButtonLabel2;
    private javax.swing.JLabel jHomeButtonLabel;
    private javax.swing.JPanel jHomeButtonPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jLogOutButtonPanel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jNoticeButtonLabel;
    private javax.swing.JPanel jNoticeButtonPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jSalarySlipButtonPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel jUserProfileButtonLabel;
    private javax.swing.JLabel lbl_sal;
    private javax.swing.JTextField lbl_total;
    private javax.swing.JTextField lt;
    public static final javax.swing.JLabel name = new javax.swing.JLabel();
    private javax.swing.JLabel nextbutton;
    private javax.swing.JTextField nm;
    private javax.swing.JPanel pane1;
    private javax.swing.JPanel pane2;
    private javax.swing.JPanel pane3;
    private javax.swing.JPanel pane4;
    private javax.swing.JPanel pane5;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField phoneno;
    private javax.swing.JLabel prevbutton;
    private javax.swing.JRadioButton rRadioButton;
    private javax.swing.JRadioButton r_amount2;
    private javax.swing.JRadioButton r_percentage;
    private javax.swing.JMenu requestbtn;
    private javax.swing.JButton reset;
    private javax.swing.JTextField rsn1;
    private javax.swing.JTextField s_basic;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField sd;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search_emp;
    private javax.swing.JLabel showname;
    private javax.swing.JTextField stafid;
    private javax.swing.JButton svbtn;
    private javax.swing.JTextField t_allow;
    private javax.swing.JTextField t_ded;
    private javax.swing.JTextField t_sal;
    private javax.swing.JTable table_allowance;
    private javax.swing.JLabel total_ded;
    private javax.swing.JButton txt_Save;
    private javax.swing.JTextField txt_bonus;
    private javax.swing.JButton txt_cal;
    private javax.swing.JTextField txt_deduction;
    private javax.swing.JTextField txt_dept;
    private javax.swing.JTextField txt_empid;
    private javax.swing.JTextField txt_hired;
    private javax.swing.JTextField txt_hw;
    private javax.swing.JTextField txt_med;
    private javax.swing.JTextField txt_per;
    private javax.swing.JTextField txt_percentage;
    private javax.swing.JTextField txt_reason;
    private javax.swing.JTextField txt_salary;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_search1;
    private javax.swing.JTextField txt_total_overtime;
    private javax.swing.JTextField txt_uname;
    private javax.swing.JTextField uname;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}

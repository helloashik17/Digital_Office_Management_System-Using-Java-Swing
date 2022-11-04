/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digital_office_management_system;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class HomePage_form extends javax.swing.JFrame {

    private CardLayout cardLayout;

    Color panedefault;
    Color paneclick;
    Color paneenter;

    int cas = 0;
    int ann = 0;
    int med = 0;
    int yr;

    public HomePage_form() {
        initComponents();
    }

    public HomePage_form(String uname) {
        initComponents();

        panedefault = new Color(218, 223, 225);
        paneclick = new Color(51, 110, 123);
        paneenter = new Color(255, 51, 51);
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

    public int countLeapYears(int m, int y) {
        int years = y;

        // Check if the current year needs to be considered for the count of leap years or not
        if (m <= 2) {
            years--;
        }

        // An year is a leap year if it is a multiple of 4, multiple of 400 and not a multiple of 100.
        return years / 4 - years / 100 + years / 400;
    }

    public int getDifference(int d1, int m1, int y1, int d2, int m2, int y2) {
        int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // COUNT TOTAL NUMBER OF DAYS BEFORE FIRST DATE initialize count using years and day
        int n1 = y1 * 365 + d1;

        // Add days for months in given date
        for (int i = 0; i < m1 - 1; i++) {
            n1 += monthDays[i];
        }

        // Since every leap year is of 366 days, Add a day for every leap year
        n1 += countLeapYears(m1, y1);

        // SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE SECOND DATE
        int n2 = y2 * 365 + d2;
        for (int i = 0; i < m2 - 1; i++) {
            n2 += monthDays[i];
        }
        n2 += countLeapYears(m2, y2);

        // return difference between two counts
        return (n2 - n1);
    }

    void Loadleave(int y) {
        String empno = Uid.getText();
        try {
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM `leaves` WHERE `Emp_ID` = ? AND `Year` = ?";
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setString(1, empno);
            ps.setInt(2, y);
            rs = ps.executeQuery();

            if (rs.next()) {
                cas = rs.getInt("Casual");
                ann = rs.getInt("Annual");
                med = rs.getInt("Medical");
            } else {
                JOptionPane.showMessageDialog(this, "Leave Information Error");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void Loadleavereport(int y) {
        String empno = Uid.getText();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Digital Office Management System", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT `Leave Type`, `Start Date`, `End Date`, `Reason`, `Status`, `Command` FROM `leave_report` WHERE `Emp_ID` ="+empno+" AND `Start Date` like '%"+y+"%'");

            while (leavedetailsTable.getRowCount() > 0) {
                ((DefaultTableModel) leavedetailsTable.getModel()).removeRow(0);
            }
            int col = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] rows = new Object[col];
                for (int i = 1; i <= col; i++) {
                    rows[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) leavedetailsTable.getModel()).insertRow(rs.getRow() - 1, rows);
            }

            rs.close();
            st.close();
        } catch (Exception ex) {

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

        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jUserProfileButtonPanel = new javax.swing.JPanel();
        pane2 = new javax.swing.JPanel();
        jUserProfileButtonLabel = new javax.swing.JLabel();
        jNoticeButtonPanel = new javax.swing.JPanel();
        pane3 = new javax.swing.JPanel();
        jNoticeButtonLabel = new javax.swing.JLabel();
        jHomeButtonPanel = new javax.swing.JPanel();
        pane1 = new javax.swing.JPanel();
        jHomeButtonLabel = new javax.swing.JLabel();
        jSkillsButtonPanel = new javax.swing.JPanel();
        pane4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLogOutButtonPanel = new javax.swing.JPanel();
        pane5 = new javax.swing.JPanel();
        jEventsButtonLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        HomePage = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        showname = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        nextbutton = new javax.swing.JLabel();
        prevbutton = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        UserProfilePage = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Uid = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldPhone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldBirthdate = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldGender = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldDepartment = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Upass = new javax.swing.JTextField();
        updatepass = new javax.swing.JButton();
        NoticePage = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        Title = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Content = new javax.swing.JTextArea();
        SkillsPage = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        LeavePage = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        casual = new javax.swing.JRadioButton();
        annual = new javax.swing.JRadioButton();
        medical = new javax.swing.JRadioButton();
        sdate = new javax.swing.JTextField();
        edate = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        day = new javax.swing.JTextField();
        cal = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        rsn = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ltype = new javax.swing.JTextField();
        fdate = new javax.swing.JTextField();
        tdate = new javax.swing.JTextField();
        lstat = new javax.swing.JTextField();
        comm = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        casl = new javax.swing.JTextField();
        annl = new javax.swing.JTextField();
        medl = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        refresh = new javax.swing.JButton();
        LeaveReportPage = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        leavedetailsTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        leavesbtn = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        reportbtn = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(33, 49, 63));
        jPanel10.setPreferredSize(new java.awt.Dimension(1170, 90));

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setText(" X");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Office_icon.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Digital Office Management System");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
                .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelMin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelClose))
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 90));

        jPanel1.setBackground(new java.awt.Color(44, 62, 80));

        jUserProfileButtonPanel.setBackground(new java.awt.Color(218, 223, 225));
        jUserProfileButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jUserProfileButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jUserProfileButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jUserProfileButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jUserProfileButtonPanelMousePressed(evt);
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
        jUserProfileButtonLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_icon.png"))); // NOI18N
        jUserProfileButtonLabel.setText(" User Profile");

        javax.swing.GroupLayout jUserProfileButtonPanelLayout = new javax.swing.GroupLayout(jUserProfileButtonPanel);
        jUserProfileButtonPanel.setLayout(jUserProfileButtonPanelLayout);
        jUserProfileButtonPanelLayout.setHorizontalGroup(
            jUserProfileButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jUserProfileButtonPanelLayout.createSequentialGroup()
                .addComponent(pane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jUserProfileButtonLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        jUserProfileButtonPanelLayout.setVerticalGroup(
            jUserProfileButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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

        jSkillsButtonPanel.setBackground(new java.awt.Color(218, 223, 225));
        jSkillsButtonPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSkillsButtonPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jSkillsButtonPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jSkillsButtonPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSkillsButtonPanelMousePressed(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 37, 42));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/skills_icon.png"))); // NOI18N
        jLabel4.setText(" Skills");

        javax.swing.GroupLayout jSkillsButtonPanelLayout = new javax.swing.GroupLayout(jSkillsButtonPanel);
        jSkillsButtonPanel.setLayout(jSkillsButtonPanelLayout);
        jSkillsButtonPanelLayout.setHorizontalGroup(
            jSkillsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jSkillsButtonPanelLayout.createSequentialGroup()
                .addComponent(pane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jSkillsButtonPanelLayout.setVerticalGroup(
            jSkillsButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
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
                    .addContainerGap(26, Short.MAX_VALUE)
                    .addComponent(jEventsButtonLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );
        jLogOutButtonPanelLayout.setVerticalGroup(
            jLogOutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLogOutButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jEventsButtonLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jUserProfileButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jHomeButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSkillsButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLogOutButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jNoticeButtonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jHomeButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jUserProfileButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jNoticeButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSkillsButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLogOutButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 290, 680));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(643, 74));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText(" Home");

        name.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        name.setForeground(new java.awt.Color(102, 102, 102));
        name.setText("Logged in as:");

        showname.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
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
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(51, 110, 123));
        jPanel6.setPreferredSize(new java.awt.Dimension(880, 599));

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(prevbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(nextbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(prevbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(nextbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout HomePageLayout = new javax.swing.GroupLayout(HomePage);
        HomePage.setLayout(HomePageLayout);
        HomePageLayout.setHorizontalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        HomePageLayout.setVerticalGroup(
            HomePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomePageLayout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", HomePage);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setOpaque(true);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("ID");

        Uid.setEditable(false);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(Uid, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(Uid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Phone No");

        jTextFieldPhone.setEditable(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldPhone)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Employee Name");

        jTextFieldName.setEditable(false);
        jTextFieldName.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Birth Date");

        jTextFieldBirthdate.setEditable(false);
        jTextFieldBirthdate.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldBirthdate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Email");

        jTextFieldEmail.setEditable(false);
        jTextFieldEmail.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldEmail.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel16.setBackground(new java.awt.Color(204, 204, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Gender");

        jTextFieldGender.setEditable(false);
        jTextFieldGender.setBackground(new java.awt.Color(204, 204, 255));
        jTextFieldGender.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldGender, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldGender, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel14.setPreferredSize(new java.awt.Dimension(561, 60));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Department");

        jTextFieldDepartment.setEditable(false);
        jTextFieldDepartment.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jTextFieldDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldDepartment, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText(" User Profile");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Change Password:");

        Upass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Upass.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        updatepass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatepass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update icon.png"))); // NOI18N
        updatepass.setText("Update Password");
        updatepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatepassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UserProfilePageLayout = new javax.swing.GroupLayout(UserProfilePage);
        UserProfilePage.setLayout(UserProfilePageLayout);
        UserProfilePageLayout.setHorizontalGroup(
            UserProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UserProfilePageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(UserProfilePageLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(UserProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(updatepass)
                    .addGroup(UserProfilePageLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(82, 82, 82)
                        .addComponent(Upass, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UserProfilePageLayout.setVerticalGroup(
            UserProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UserProfilePageLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(UserProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(UserProfilePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Upass, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updatepass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", UserProfilePage);

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
                .addContainerGap(667, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(204, 255, 102));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );

        jPanel13.setBackground(new java.awt.Color(51, 255, 0));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        Title.setEditable(false);
        Title.setBackground(new java.awt.Color(102, 102, 255));
        Title.setFont(new java.awt.Font("Times New Roman", 1, 26)); // NOI18N
        Title.setText(" ");

        Content.setEditable(false);
        Content.setBackground(new java.awt.Color(255, 204, 0));
        Content.setColumns(20);
        Content.setFont(new java.awt.Font("Times New Roman", 1, 17)); // NOI18N
        Content.setLineWrap(true);
        Content.setRows(5);
        Content.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Content);

        javax.swing.GroupLayout NoticePageLayout = new javax.swing.GroupLayout(NoticePage);
        NoticePage.setLayout(NoticePageLayout);
        NoticePageLayout.setHorizontalGroup(
            NoticePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NoticePageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
            .addGroup(NoticePageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NoticePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(NoticePageLayout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        NoticePageLayout.setVerticalGroup(
            NoticePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NoticePageLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", NoticePage);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText(" Skills");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(667, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel32.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel32.setText("jLabel32");

        jLabel33.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel33.setText("jLabel33");

        jLabel34.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel34.setText("jLabel34");

        jLabel35.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel35.setText("jLabel35");

        jLabel36.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel36.setText("jLabel36");

        jLabel37.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel37.setText("jLabel37");

        jLabel38.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel38.setText("jLabel38");

        jLabel39.setFont(new java.awt.Font("Book Antiqua", 0, 20)); // NOI18N
        jLabel39.setText("jLabel39");

        javax.swing.GroupLayout SkillsPageLayout = new javax.swing.GroupLayout(SkillsPage);
        SkillsPage.setLayout(SkillsPageLayout);
        SkillsPageLayout.setHorizontalGroup(
            SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SkillsPageLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addGap(215, 215, 215))
        );
        SkillsPageLayout.setVerticalGroup(
            SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SkillsPageLayout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel36))
                .addGap(44, 44, 44)
                .addGroup(SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel37))
                .addGap(45, 45, 45)
                .addGroup(SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel38))
                .addGap(49, 49, 49)
                .addGroup(SkillsPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(jLabel39))
                .addGap(0, 318, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", SkillsPage);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText(" Leave");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(667, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leave Apply", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 21), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Leave Type:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Start Date:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("End Date:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Reason:");

        casual.setText("Casual");

        annual.setText("Annual");

        medical.setText("Medical");

        sdate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sdate.setForeground(new java.awt.Color(153, 153, 153));
        sdate.setText("dd-mm-yyyy");
        sdate.setPreferredSize(new java.awt.Dimension(106, 40));
        sdate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sdateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sdateFocusLost(evt);
            }
        });

        edate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        edate.setForeground(new java.awt.Color(153, 153, 153));
        edate.setText("dd-mm-yyyy");
        edate.setPreferredSize(new java.awt.Dimension(106, 40));
        edate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                edateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                edateFocusLost(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("Days:");

        day.setEditable(false);
        day.setBackground(new java.awt.Color(255, 255, 255));
        day.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Calculate.png"))); // NOI18N
        cal.setText("Calculate");
        cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calActionPerformed(evt);
            }
        });

        submit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/submit.jpg"))); // NOI18N
        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        rsn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel22))
                .addGap(43, 43, 43)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(edate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                        .addComponent(sdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(casual)
                        .addGap(18, 18, 18)
                        .addComponent(annual)
                        .addGap(18, 18, 18)
                        .addComponent(medical))
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rsn, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(cal, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addGap(48, 48, 48))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(casual)
                    .addComponent(annual)
                    .addComponent(medical))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(edate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rsn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leave Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 21), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Leave Type:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setText("From Date:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("To Date:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Status:");

        ltype.setEditable(false);
        ltype.setBackground(new java.awt.Color(255, 255, 255));
        ltype.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        fdate.setEditable(false);
        fdate.setBackground(new java.awt.Color(255, 255, 255));
        fdate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        tdate.setEditable(false);
        tdate.setBackground(new java.awt.Color(255, 255, 255));
        tdate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lstat.setEditable(false);
        lstat.setBackground(new java.awt.Color(255, 255, 255));
        lstat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        comm.setEditable(false);
        comm.setBackground(new java.awt.Color(255, 255, 255));
        comm.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Command:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lstat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fdate, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ltype, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(ltype, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(fdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tdate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lstat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comm, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Available Leaves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 21), new java.awt.Color(0, 0, 255))); // NOI18N

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Casual Leave:");

        casl.setEditable(false);
        casl.setBackground(new java.awt.Color(255, 255, 255));
        casl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        annl.setEditable(false);
        annl.setBackground(new java.awt.Color(255, 255, 255));
        annl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        medl.setEditable(false);
        medl.setBackground(new java.awt.Color(255, 255, 255));
        medl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("Annual Leave:");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("Medical Leave:");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30))
                .addGap(81, 81, 81)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(medl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casl, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(casl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(annl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(medl, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        refresh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update icon.png"))); // NOI18N
        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeavePageLayout = new javax.swing.GroupLayout(LeavePage);
        LeavePage.setLayout(LeavePageLayout);
        LeavePageLayout.setHorizontalGroup(
            LeavePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LeavePageLayout.createSequentialGroup()
                .addGroup(LeavePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(LeavePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeavePageLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeavePageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh)
                        .addContainerGap())))
        );
        LeavePageLayout.setVerticalGroup(
            LeavePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeavePageLayout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeavePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(LeavePageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 46, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab5", LeavePage);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText(" Leave Report");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Leave Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Book Antiqua", 1, 21), new java.awt.Color(0, 0, 255))); // NOI18N

        leavedetailsTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        leavedetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Leave Type", "Start Date", "End Date", "Reason", "Status", "Command"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leavedetailsTable.setGridColor(new java.awt.Color(255, 255, 255));
        leavedetailsTable.setInheritsPopupMenu(true);
        leavedetailsTable.setIntercellSpacing(new java.awt.Dimension(10, 10));
        leavedetailsTable.setRowHeight(35);
        jScrollPane5.setViewportView(leavedetailsTable);
        if (leavedetailsTable.getColumnModel().getColumnCount() > 0) {
            leavedetailsTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            leavedetailsTable.getColumnModel().getColumn(1).setPreferredWidth(30);
            leavedetailsTable.getColumnModel().getColumn(2).setPreferredWidth(30);
            leavedetailsTable.getColumnModel().getColumn(4).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LeaveReportPageLayout = new javax.swing.GroupLayout(LeaveReportPage);
        LeaveReportPage.setLayout(LeaveReportPageLayout);
        LeaveReportPageLayout.setHorizontalGroup(
            LeaveReportPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LeaveReportPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        LeaveReportPageLayout.setVerticalGroup(
            LeaveReportPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeaveReportPageLayout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab6", LeaveReportPage);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 880, 710));

        jMenu2.setText("Leave");

        leavesbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leave_icon-17.png"))); // NOI18N
        leavesbtn.setText("Leaves");
        leavesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leavesbtnActionPerformed(evt);
            }
        });
        jMenu2.add(leavesbtn);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Report");

        reportbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report_icon-17.png"))); // NOI18N
        reportbtn.setText("Leaves Report");
        reportbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportbtnActionPerformed(evt);
            }
        });
        jMenu1.add(reportbtn);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1170, 770));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseEntered
        jLabelClose.setForeground(Color.red);
    }//GEN-LAST:event_jLabelCloseMouseEntered

    private void jLabelCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseExited
        jLabelClose.setForeground(Color.white);
    }//GEN-LAST:event_jLabelCloseMouseExited

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jLabelMinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseEntered
        jLabelMin.setForeground(Color.gray);
    }//GEN-LAST:event_jLabelMinMouseEntered

    private void jLabelMinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseExited
        jLabelMin.setForeground(Color.white);
    }//GEN-LAST:event_jLabelMinMouseExited

    private void jHomeButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMousePressed
        pane1.setBackground(paneclick);
        pane2.setBackground(panedefault);
        pane3.setBackground(panedefault);
        pane4.setBackground(panedefault);
    }//GEN-LAST:event_jHomeButtonPanelMousePressed

    private void jUserProfileButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserProfileButtonPanelMousePressed
        pane2.setBackground(paneclick);
        pane1.setBackground(panedefault);
        pane3.setBackground(panedefault);
        pane4.setBackground(panedefault);
    }//GEN-LAST:event_jUserProfileButtonPanelMousePressed

    private void jNoticeButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMousePressed
        pane3.setBackground(paneclick);
        pane1.setBackground(panedefault);
        pane2.setBackground(panedefault);
        pane4.setBackground(panedefault);
    }//GEN-LAST:event_jNoticeButtonPanelMousePressed

    private void jHomeButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jHomeButtonPanelMouseClicked

    private void jHomeButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMouseEntered
        jHomeButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jHomeButtonPanelMouseEntered

    private void jHomeButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeButtonPanelMouseExited
        jHomeButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jHomeButtonPanelMouseExited

    private void jUserProfileButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserProfileButtonPanelMouseEntered
        jUserProfileButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jUserProfileButtonPanelMouseEntered

    private void jUserProfileButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserProfileButtonPanelMouseExited
        jUserProfileButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jUserProfileButtonPanelMouseExited

    private void jNoticeButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMouseEntered
        jNoticeButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jNoticeButtonPanelMouseEntered

    private void jNoticeButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMouseExited
        jNoticeButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jNoticeButtonPanelMouseExited

    private void jUserProfileButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jUserProfileButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(1);
        PreparedStatement st;
        ResultSet rs;

        String name = showname.getText();

        String query = "SELECT * FROM `staffs` WHERE `Username` = ?";

        try {
            st = MyConnection.getConnection().prepareStatement(query);

            st.setString(1, name);
            rs = st.executeQuery();

            if (rs.next()) {
                String sid = rs.getString("ID");
                Uid.setText(sid);
                String empname = rs.getString("Username");
                jTextFieldName.setText(empname);
                String gender = rs.getString("Gender");
                jTextFieldGender.setText(gender);
                String birth = rs.getString("Birth Date");
                jTextFieldBirthdate.setText(birth);
                String phnNo = rs.getString("Phone No");
                jTextFieldPhone.setText(phnNo);
                String email = rs.getString("Email");
                jTextFieldEmail.setText(email);
                String dept = rs.getString("Department");
                jTextFieldDepartment.setText(dept);
                byte[] image = rs.getBytes("Picture");
                format = new ImageIcon(image);
                jLabel14.setIcon(format);
                rs.close();
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jUserProfileButtonPanelMouseClicked

    private void jNoticeButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNoticeButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(2);

        try {
            String title = new Scanner(new File("Title.txt")).useDelimiter("\\Z").next();
            Title.setText(title);

            String content = new Scanner(new File("Contant.txt")).useDelimiter("\\Z").next();
            Content.setText(content);
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jNoticeButtonPanelMouseClicked

    private void jSkillsButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSkillsButtonPanelMouseClicked
        jTabbedPane1.setSelectedIndex(3);
        
        String dept = jTextFieldDepartment.getText();
        if (dept.trim().equals("Sales")) {
            jLabel32.setText("i. Fluent in English");
            jLabel33.setText("ii. Active listening");
            jLabel34.setText("iii. Effective communication");
            jLabel35.setText("iv. Public speaking");
            jLabel36.setText("v. Emotional intelligence");
            jLabel37.setText("vi. Growth mindset");
            jLabel38.setText("vii. Product Expertise");
            jLabel39.setText("viii. Honesty");
        } else if (dept.trim().equals("HR")) {
            jLabel32.setText("i. Fluent in English");
            jLabel33.setText("ii. Leadership");
            jLabel34.setText("iii. Teamwork");
            jLabel35.setText("iv. Time management");
            jLabel36.setText("v. Recruitment and selection");
            jLabel37.setText("vi. Commercial awareness");
            jLabel38.setText("vii. Command of technology");
            jLabel39.setText("viii. Being analytical and data-driven");
        } else if (dept.trim().equals("Marketing")) {
            jLabel32.setText("i. Fluent in English");
            jLabel33.setText("ii. Communication");
            jLabel34.setText("iii. Data Analysis & Analytics");
            jLabel35.setText("iv. Project Management");
            jLabel36.setText("v. SEO/SEM");
            jLabel37.setText("vi. Analytical and critical thinking");
            jLabel38.setText("vii. Copywriting and design ability");
            jLabel39.setText("viii. Content development");
        }
    }//GEN-LAST:event_jSkillsButtonPanelMouseClicked

    private void jSkillsButtonPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSkillsButtonPanelMouseEntered
        jSkillsButtonPanel.setBackground(paneenter);
    }//GEN-LAST:event_jSkillsButtonPanelMouseEntered

    private void jSkillsButtonPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSkillsButtonPanelMouseExited
        jSkillsButtonPanel.setBackground(panedefault);
    }//GEN-LAST:event_jSkillsButtonPanelMouseExited

    private void jSkillsButtonPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSkillsButtonPanelMousePressed
        pane4.setBackground(paneclick);
        pane1.setBackground(panedefault);
        pane2.setBackground(panedefault);
        pane3.setBackground(panedefault);
    }//GEN-LAST:event_jSkillsButtonPanelMousePressed

    private void jLogOutButtonPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogOutButtonPanelMouseClicked
        int x = JOptionPane.showConfirmDialog(this, "Are you sure to logout", "Confirm Logout", JOptionPane.YES_NO_OPTION);

        if (x == 0) {
            Login_form lgf = new Login_form();
            lgf.setVisible(true);
            lgf.pack();
            lgf.setLocationRelativeTo(null);
            lgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();

            Date currentDate = GregorianCalendar.getInstance().getTime();
            DateFormat df = DateFormat.getDateInstance();
            String dateString = df.format(currentDate);

            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String timeString = sdf.format(d);

            String value0 = timeString;
            String value1 = dateString;
            String date = value0 + " / " + value1;
            String status = "Logged out";
            String id = Uid.getText();

            try {
                PreparedStatement ps;
                ResultSet rs;
                String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                ps = MyConnection.getConnection().prepareStatement(reg);
                ps.setString(1, id);
                ps.setString(2, date);
                ps.setString(3, status);
                ps.executeUpdate();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
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

    private void nextbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextbuttonMouseClicked
        cardLayout.next(Label1);
    }//GEN-LAST:event_nextbuttonMouseClicked

    private void prevbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prevbuttonMouseClicked
        cardLayout.previous(Label1);
    }//GEN-LAST:event_prevbuttonMouseClicked

    private void updatepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatepassActionPerformed
        if (Upass.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Password Field is empty");
        } else {
            int p = JOptionPane.showConfirmDialog(null, "Are you sure to change the password?", "Change Password", JOptionPane.YES_NO_OPTION);
            if (p == 0) {
                try {
                    String value0 = Upass.getText();

                    PreparedStatement ps;
                    String sql = "UPDATE `staffs` SET `Password`=" + value0 + " WHERE `ID`=" + Uid.getText();
                    ps = MyConnection.getConnection().prepareStatement(sql);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Password Changed");
                } catch (Exception e) {
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

                try {
                    PreparedStatement ps;
                    ResultSet rs;
                    String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                    ps = MyConnection.getConnection().prepareStatement(reg);
                    ps.setString(1, Uid.getText());
                    ps.setString(2, date);
                    ps.setString(3, status);
                    ps.executeUpdate();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                Upass.setText("");
            }
        }
    }//GEN-LAST:event_updatepassActionPerformed

    private void calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calActionPerformed
        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        int currentMonth = currentdate.getMonthValue();

        if (sdate.getText().equals("dd-mm-yyyy")) {
            JOptionPane.showMessageDialog(null, "Start Date Field is empty");
        } else if (edate.getText().equals("dd-mm-yyyy")) {
            JOptionPane.showMessageDialog(null, "End Date Field is empty");
        } else {
            String sd = sdate.getText();
            String ed = edate.getText();

            String a = sd.substring(0, 2);
            String b = sd.substring(3, 5);
            String c = sd.substring(6);
            String d = ed.substring(0, 2);
            String e = ed.substring(3, 5);
            String f = ed.substring(6);

            int g = Integer.parseInt(a);
            int h = Integer.parseInt(b);
            int i = Integer.parseInt(c);
            int j = Integer.parseInt(d);
            int k = Integer.parseInt(e);
            int l = Integer.parseInt(f);
            //System.out.println(g);
            //System.out.println(h);
            //System.out.println(i);

            if (i < currentYear | l < currentYear) {
                JOptionPane.showMessageDialog(null, "Invalid Year");
            } else if (h < currentMonth | k < currentMonth) {
                JOptionPane.showMessageDialog(null, "Invalid Month");
            } else {
                int m = getDifference(g, h, i, j, k, l);
                //System.out.println(m);
                String days = String.valueOf(m);
                day.setText(days);
                Loadleave(currentYear);
            }
        }
    }//GEN-LAST:event_calActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String id = Uid.getText();
        String nam = jTextFieldName.getText();
        String lev = null;
        String stat = "Waiting";
        int bleave = 0;

        if (casual.isSelected() == false && annual.isSelected() == false && medical.isSelected() == false) {
            JOptionPane.showMessageDialog(null, "Please select any one leave");
        } else if (day.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Days Field is empty");
        } else if (rsn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Reason Field is empty");
        } else {
            int days = Integer.parseInt(day.getText());
            if (days > 5) {
                JOptionPane.showMessageDialog(null, "You can't apply leave for more than 5 days");
            } else {
                if (casual.isSelected() == true) {
                    lev = "Casual";
                    bleave = cas - days;
                    if (bleave < 0) {
                        JOptionPane.showMessageDialog(this, "You Have a Casual Leave : " + cas);
                    } else {
                        try {
                            PreparedStatement ps;
                            String sql = "UPDATE `leaves` SET `Casual`=" + bleave + " WHERE `Emp_ID`=" + id;
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Your Casual Leave Updated");
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            PreparedStatement ps;
                            String sql = "INSERT INTO `leave_report`(`Emp_ID`, `Leave Type`, `Start Date`, `End Date`, `Reason`, `Status`) VALUES (?,?,?,?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.setString(1, id);
                            ps.setString(2, lev);
                            ps.setString(3, sdate.getText());
                            ps.setString(4, edate.getText());
                            ps.setString(5, rsn.getText());
                            ps.setString(6, stat);
                            ps.execute();
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            PreparedStatement ps;
                            String sql = "INSERT INTO `leave_request`(`Emp_ID`, `Name`, `Leave Type`, `Start Date`, `End Date`, `Reason`) VALUES (?,?,?,?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.setString(1, id);
                            ps.setString(2, nam);
                            ps.setString(3, lev);
                            ps.setString(4, sdate.getText());
                            ps.setString(5, edate.getText());
                            ps.setString(6, rsn.getText());
                            ps.execute();
                            JOptionPane.showMessageDialog(null, "Data is saved successfully");
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
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
                        String status = "Leave Requested";

                        try {
                            PreparedStatement ps;
                            ResultSet rs;
                            String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(reg);
                            ps.setString(1, id);
                            ps.setString(2, date);
                            ps.setString(3, status);
                            ps.executeUpdate();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                } else if (annual.isSelected() == true) {
                    lev = "Annual";
                    bleave = ann - days;
                    if (bleave < 0) {
                        JOptionPane.showMessageDialog(this, "You Have a Casual Leave : " + ann);
                    } else {
                        try {
                            PreparedStatement ps;
                            String sql = "UPDATE `leaves` SET `Annual`=" + bleave + " WHERE `Emp_ID`=" + id;
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Your Annual Leave Updated");
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            PreparedStatement ps;
                            String sql = "INSERT INTO `leave_report`(`Emp_ID`, `Leave Type`, `Start Date`, `End Date`, `Reason`, `Status`) VALUES (?,?,?,?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.setString(1, id);
                            ps.setString(2, lev);
                            ps.setString(3, sdate.getText());
                            ps.setString(4, edate.getText());
                            ps.setString(5, rsn.getText());
                            ps.setString(6, stat);
                            ps.execute();
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            PreparedStatement ps;
                            String sql = "INSERT INTO `leave_request`(`Emp_ID`, `Name`, `Leave Type`, `Start Date`, `End Date`, `Reason`) VALUES (?,?,?,?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.setString(1, id);
                            ps.setString(2, nam);
                            ps.setString(3, lev);
                            ps.setString(4, sdate.getText());
                            ps.setString(5, edate.getText());
                            ps.setString(6, rsn.getText());
                            ps.execute();
                            JOptionPane.showMessageDialog(null, "Data is saved successfully");
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
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
                        String status = "Leave Requested";

                        try {
                            PreparedStatement ps;
                            ResultSet rs;
                            String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(reg);
                            ps.setString(1, Uid.getText());
                            ps.setString(2, date);
                            ps.setString(3, status);
                            ps.executeUpdate();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                } else if (medical.isSelected() == true) {
                    lev = "Medical";
                    bleave = med - days;
                    if (bleave < 0) {
                        JOptionPane.showMessageDialog(this, "You Have a Medical Leave : " + med);
                    } else {
                        try {
                            PreparedStatement ps;
                            String sql = "UPDATE `leaves` SET `Medical`=" + bleave + " WHERE `Emp_ID`=" + id;
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.executeUpdate();
                            JOptionPane.showMessageDialog(this, "Your Medical Leave Updated");
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            PreparedStatement ps;
                            String sql = "INSERT INTO `leave_report`(`Emp_ID`, `Leave Type`, `Start Date`, `End Date`, `Reason`, `Status`) VALUES (?,?,?,?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.setString(1, id);
                            ps.setString(2, lev);
                            ps.setString(3, sdate.getText());
                            ps.setString(4, edate.getText());
                            ps.setString(5, rsn.getText());
                            ps.setString(6, stat);
                            ps.execute();
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            PreparedStatement ps;
                            String sql = "INSERT INTO `leave_request`(`Emp_ID`, `Name`, `Leave Type`, `Start Date`, `End Date`, `Reason`) VALUES (?,?,?,?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(sql);
                            ps.setString(1, id);
                            ps.setString(2, nam);
                            ps.setString(3, lev);
                            ps.setString(4, sdate.getText());
                            ps.setString(5, edate.getText());
                            ps.setString(6, rsn.getText());
                            ps.execute();
                            JOptionPane.showMessageDialog(null, "Data is saved successfully");
                        } catch (SQLException ex) {
                            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
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
                        String status = "Leave Requested";

                        try {
                            PreparedStatement ps;
                            ResultSet rs;
                            String reg = "INSERT INTO `audit`(`Emp_ID`, `Date`, `Status`) VALUES (?,?,?)";
                            ps = MyConnection.getConnection().prepareStatement(reg);
                            ps.setString(1, Uid.getText());
                            ps.setString(2, date);
                            ps.setString(3, status);
                            ps.executeUpdate();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Something Wrong");
                }
                sdate.setText("");
                edate.setText("");
                rsn.setText("");
                day.setText("");
            }
        }
    }//GEN-LAST:event_submitActionPerformed

    private void sdateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sdateFocusGained
        // clear the textfield on focus if the text is "dd-mm-yyyy"
        if (sdate.getText().trim().toLowerCase().equals("dd-mm-yyyy")) {
            sdate.setText("");
            sdate.setForeground(Color.black);
        }
    }//GEN-LAST:event_sdateFocusGained

    private void sdateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sdateFocusLost
        // if the text field is equal to dd-mm-yyyy or empty
        // we will set the "dd-mm-yyyy" text in the field 
        // on focus lost event
        if (sdate.getText().trim().equals("") || sdate.getText().trim().toLowerCase().equals("dd-mm-yyyy")) {
            sdate.setText("dd-mm-yyyy");
            sdate.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_sdateFocusLost

    private void edateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edateFocusGained
        // clear the textfield on focus if the text is "dd-mm-yyyy"
        if (edate.getText().trim().toLowerCase().equals("dd-mm-yyyy")) {
            edate.setText("");
            edate.setForeground(Color.black);
        }
    }//GEN-LAST:event_edateFocusGained

    private void edateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_edateFocusLost
        // if the text field is equal to dd-mm-yyyy or empty
        // we will set the "dd-mm-yyyy" text in the field 
        // on focus lost event
        if (edate.getText().trim().equals("") || edate.getText().trim().toLowerCase().equals("dd-mm-yyyy")) {
            edate.setText("dd-mm-yyyy");
            edate.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_edateFocusLost

    private void leavesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavesbtnActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        sdate.setText("dd-mm-yyyy");
        edate.setText("dd-mm-yyyy");
        rsn.setText("");
        day.setText("");
        String empno = Uid.getText();

        try {
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM `leave_report` WHERE `Emp_ID` = ? ORDER BY ID DESC LIMIT 1";
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setString(1, empno);
            rs = ps.executeQuery();

            if (rs.next()) {
                String lt = rs.getString("Leave Type");
                ltype.setText(lt);
                String sd = rs.getString("Start Date");
                fdate.setText(sd);
                String ed = rs.getString("End Date");
                tdate.setText(ed);
                String s = rs.getString("Status");
                lstat.setText(s);
                String c = rs.getString("Command");
                comm.setText(c);
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
        }

        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        Loadleave(currentYear);

        casl.setText(String.valueOf(cas));
        annl.setText(String.valueOf(ann));
        medl.setText(String.valueOf(med));
    }//GEN-LAST:event_leavesbtnActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        jTabbedPane1.setSelectedIndex(4);
        sdate.setText("dd-mm-yyyy");
        edate.setText("dd-mm-yyyy");
        rsn.setText("");
        day.setText("");
        String empno = Uid.getText();

        try {
            PreparedStatement ps;
            ResultSet rs;
            String sql = "SELECT * FROM `leave_report` WHERE `Emp_ID` = ? ORDER BY ID DESC LIMIT 1";
            ps = MyConnection.getConnection().prepareStatement(sql);
            ps.setString(1, empno);
            rs = ps.executeQuery();

            if (rs.next()) {
                String lt = rs.getString("Leave Type");
                ltype.setText(lt);
                String sd = rs.getString("Start Date");
                fdate.setText(sd);
                String ed = rs.getString("End Date");
                tdate.setText(ed);
                String s = rs.getString("Status");
                lstat.setText(s);
                String c = rs.getString("Command");
                comm.setText(c);
                rs.close();
                ps.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomePage_form.class.getName()).log(Level.SEVERE, null, ex);
        }

        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        Loadleave(currentYear);

        casl.setText(String.valueOf(cas));
        annl.setText(String.valueOf(ann));
        medl.setText(String.valueOf(med));
    }//GEN-LAST:event_refreshActionPerformed

    private void reportbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportbtnActionPerformed
        jTabbedPane1.setSelectedIndex(5);

        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();
        Loadleavereport(currentYear);
    }//GEN-LAST:event_reportbtnActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage_form().setVisible(true);
            }
        });
    }
    private ImageIcon format = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Content;
    private javax.swing.JPanel HomePage;
    private javax.swing.JLabel Label1;
    private javax.swing.JPanel LeavePage;
    private javax.swing.JPanel LeaveReportPage;
    private javax.swing.JPanel NoticePage;
    private javax.swing.JPanel SkillsPage;
    private javax.swing.JTextField Title;
    private javax.swing.JTextField Uid;
    private javax.swing.JTextField Upass;
    private javax.swing.JPanel UserProfilePage;
    private javax.swing.JTextField annl;
    private javax.swing.JRadioButton annual;
    private javax.swing.JButton cal;
    private javax.swing.JTextField casl;
    private javax.swing.JRadioButton casual;
    private javax.swing.JTextField comm;
    private javax.swing.JTextField day;
    private javax.swing.JTextField edate;
    private javax.swing.JTextField fdate;
    private javax.swing.JLabel jEventsButtonLabel1;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jLogOutButtonPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jNoticeButtonLabel;
    private javax.swing.JPanel jNoticeButtonPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jSkillsButtonPanel;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldBirthdate;
    private javax.swing.JTextField jTextFieldDepartment;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldGender;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhone;
    private javax.swing.JLabel jUserProfileButtonLabel;
    private javax.swing.JPanel jUserProfileButtonPanel;
    private javax.swing.JTable leavedetailsTable;
    private javax.swing.JMenuItem leavesbtn;
    private javax.swing.JTextField lstat;
    private javax.swing.JTextField ltype;
    private javax.swing.JRadioButton medical;
    private javax.swing.JTextField medl;
    public static final javax.swing.JLabel name = new javax.swing.JLabel();
    private javax.swing.JLabel nextbutton;
    private javax.swing.JPanel pane1;
    private javax.swing.JPanel pane2;
    private javax.swing.JPanel pane3;
    private javax.swing.JPanel pane4;
    private javax.swing.JPanel pane5;
    private javax.swing.JLabel prevbutton;
    private javax.swing.JButton refresh;
    private javax.swing.JMenuItem reportbtn;
    private javax.swing.JTextField rsn;
    private javax.swing.JTextField sdate;
    private javax.swing.JLabel showname;
    private javax.swing.JButton submit;
    private javax.swing.JTextField tdate;
    private javax.swing.JButton updatepass;
    // End of variables declaration//GEN-END:variables
}

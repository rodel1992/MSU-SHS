/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Registrar.java
 *
 * Created on Oct 15, 2011, 10:33:48 AM
 */
package ised.gui;

import ised.gui.dialog.UpdateAccountDialog;
import ised.gui.panel.AdmitStudentPanel;
import ised.gui.panel.AlumniRecordsPanel;
import ised.gui.panel.EmployeeRecordsPanel;
import ised.gui.panel.StudentRecordsPanel;
import ised.gui.panel.SummerStudentsPanel;
import ised.model.SchoolYear;
import ised.model.UserAccount;
import ised.service.implementation.SchoolYearServiceImpl;
import ised.service.interfaces.SchoolYearService;
import ised.tools.ExceptionHandler;
import ised.tools.Theme;
import ised.tools.TimeRunnableObject;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JOptionPane;

/**
 *
 * @author ABDUL
 */
public class Registrar extends javax.swing.JFrame {

    private LogIn parentFrame;
    private UserAccount user;
    private StudentRecordsPanel studentPanel;
    private EmployeeRecordsPanel employeePanel;
    private AdmitStudentPanel admissionPanel;
    private AlumniRecordsPanel alumniPanel;
    private SummerStudentsPanel summerStudentsPanel;
    private SchoolYearService schoolYearService;
    private SchoolYear currentSchoolYear;
    private Lock lockObject = new ReentrantLock( true );
    private ExecutorService runner;
    private TimeRunnableObject timeObject;

    /** Creates new form Registrar */
    public Registrar(LogIn parentFrame, UserAccount user) throws ExceptionHandler {
        initComponents();
        //Theme.setDefaultLookAndFeel();
        this.parentFrame = parentFrame;
        this.user = user;      
        schoolYearService = new SchoolYearServiceImpl();
        currentSchoolYear = schoolYearService.getCurrentSchoolYear();
        displayUserInfo();
        displayTabs();
    }

   public void displayUserInfo() throws ExceptionHandler {
        Calendar currentDate = schoolYearService.getServerCurrentDate();
        schoolYearTextField.setText(currentSchoolYear.toString());
        dateTextField.setText(String.format("%1$tB %1$td, %1$tY", currentDate));
        userNameTextField.setText(user.getUserType());
        jLabel3.setText(user.getEmployee().getFullName());
        runner = Executors.newFixedThreadPool(1);
        timeObject = new TimeRunnableObject(lockObject, dateTextField, currentDate);
        runner.execute(timeObject);
        runner.shutdown();
    }

    public void displayTabs() throws ExceptionHandler {
        studentPanel = new StudentRecordsPanel(this, currentSchoolYear);
        tabs.addTab("STUDENT RECORDS", new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/student.png")),
                studentPanel);
        employeePanel = new EmployeeRecordsPanel(this);
        tabs.addTab("EMPLOYEE RECORDS", new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/employee.png")),
                employeePanel);
        admissionPanel = new AdmitStudentPanel(this, currentSchoolYear);
        tabs.addTab("ADMIT STUDENT", new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/admission.png")),
                admissionPanel);
        alumniPanel = new AlumniRecordsPanel(this, currentSchoolYear);
        tabs.addTab("ALUMNI RECORDS", new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/alumni.png")),
                alumniPanel);
        summerStudentsPanel = new SummerStudentsPanel(this, currentSchoolYear);
        tabs.addTab("SUMMER STUDENTS", new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/summer.png")),
                summerStudentsPanel);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        updateAccountButton = new javax.swing.JButton();
        logOutButton = new javax.swing.JButton();
        tabs = new javax.swing.JTabbedPane();
        jLabel1 = new javax.swing.JLabel();
        dateTextField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        schoolYearTextField = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setOpaque(false);

        updateAccountButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        updateAccountButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/update24.png"))); // NOI18N
        updateAccountButton.setText("UPDATE ACCOUNT");
        updateAccountButton.setFocusable(false);
        updateAccountButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        updateAccountButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        updateAccountButton.setOpaque(false);
        updateAccountButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        updateAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAccountButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(updateAccountButton);

        logOutButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/lock24.png"))); // NOI18N
        logOutButton.setText("LOG OUT");
        logOutButton.setFocusable(false);
        logOutButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        logOutButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        logOutButton.setInheritsPopupMenu(true);
        logOutButton.setOpaque(false);
        logOutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(logOutButton);

        getContentPane().add(jToolBar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 250, 30));

        tabs.setBackground(new java.awt.Color(0, 204, 51));
        tabs.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabs.setFont(new java.awt.Font("Tahoma", 1, 12));
        getContentPane().add(tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1250, 570));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/date25.png"))); // NOI18N
        jLabel1.setText("Today is");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 110, -1, 30));

        dateTextField.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateTextField.setText("---");
        getContentPane().add(dateTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 230, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/user25.png"))); // NOI18N
        jLabel4.setText("User Type:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, -1, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, -1, 30));

        userNameTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        userNameTextField.setText("----");
        getContentPane().add(userNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 80, 140, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/user25.png"))); // NOI18N
        jLabel6.setText("Name:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/trimester-label.png"))); // NOI18N
        jLabel5.setText("School Year:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, -1, 20));

        schoolYearTextField.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        schoolYearTextField.setText("----");
        getContentPane().add(schoolYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 130, 20));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/banner.jpg"))); // NOI18N
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 140));

        jMenu1.setText("File");

        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed1(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Log Out");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutButtonActionPerformed
        // TODO add your handling code here:
        int answer = javax.swing.JOptionPane.showConfirmDialog(this, "Are you sure you want to log out ?", "LOG OUT", javax.swing.JOptionPane.YES_NO_OPTION);
        if (answer == javax.swing.JOptionPane.YES_OPTION) {
            this.setVisible(false);
            parentFrame.setVisible(true);
            this.dispose();
        }
}//GEN-LAST:event_logOutButtonActionPerformed

    private void updateAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAccountButtonActionPerformed
        // TODO add your handling code here:
        updateAccount();
    }//GEN-LAST:event_updateAccountButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to exit?", "Exit Window", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        updateAccount();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        parentFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed1
        // TODO add your handling code here:
        updateAccount();
    }//GEN-LAST:event_jMenuItem1ActionPerformed1

    private void updateAccount() {
        UpdateAccountDialog updateAccount = new UpdateAccountDialog(this, true, user);
        updateAccount.setVisible(true);
        user = updateAccount.getUserAccount();
        updateAccount.dispose();
        userNameTextField.setText(user.getUserName());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel schoolYearTextField;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JButton updateAccountButton;
    private javax.swing.JLabel userNameTextField;
    // End of variables declaration//GEN-END:variables
}
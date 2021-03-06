/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * StudentRecordsPanel.java
 *
 * Created on 10 15, 11, 1:53:08 PM
 */
package ised.gui.panel;

import com.mysql.jdbc.Blob;
import ised.gui.Registrar;
import ised.gui.dialog.StudentDialog;
import ised.gui.dialog.ViewStudentGradeDialog;
import ised.model.Enrollment;
import ised.model.SchoolYear;
import ised.model.Student;
import ised.service.implementation.AdmissionServiceImpl;
import ised.service.implementation.EnrollmentServiceImpl;
import ised.service.implementation.StudentServiceImpl;
import ised.service.interfaces.AdmissionService;
import ised.service.interfaces.EnrollmentService;
import ised.service.interfaces.StudentService;
import ised.tools.ComponentFormatter;
import ised.tools.Theme;
import ised.tools.ExceptionHandler;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ABDUL
 */
public class StudentRecordsPanel extends javax.swing.JPanel {

    Registrar parentFrame;
    private List<Student> studentList;
    private SchoolYear currentSchoolYear;
    private DefaultTableModel studentTableModel;
    private int selectedYearLevel;
    private String searchText;
    private Student selectedStudent;
    private int selectedStudentIndex;
    private AdmissionService admissionService;
    private StudentService studentService;
    private EnrollmentService enrollmentService;

    /** Creates new form StudentRecordsPanel */
    public StudentRecordsPanel(Registrar parentFrame, SchoolYear schoolYear) throws ExceptionHandler {
        Theme.setDefaultLookAndFeel();
        initComponents();
        this.parentFrame = parentFrame;
        admissionService = new AdmissionServiceImpl();
        studentService = new StudentServiceImpl();
        enrollmentService = new EnrollmentServiceImpl();
        studentList = new ArrayList<Student>();
        currentSchoolYear = schoolYear;
        studentTableModel = (DefaultTableModel) studentsTable.getModel();
        displayStudentList();

        ComponentFormatter.stripTable(studentsTable);
        ComponentFormatter.setTableTextColor(studentProfileTable);
        ComponentFormatter.colorTextInformationStudentTable(studentProfileTable);
    }

    public void displayStudentList(List<Student> studentList) {
        ComponentFormatter.clearTable(studentTableModel);
        for (Student student : studentList) {
            studentTableModel.addRow(new Object[]{student.getStudentID(), student.getFullName()});
        }
        totalStudents.setText(Integer.toString(studentTableModel.getRowCount()));
    }

    public void displayStudentList() throws ExceptionHandler {
        selectedYearLevel = yearLevelComboBox.getSelectedIndex();
        if (selectedYearLevel == 0) {
            ComponentFormatter.clearTable(studentTableModel);
        } else {
            studentList = admissionService.getAdmittedStudentsList(currentSchoolYear.getSchoolYearID(), selectedYearLevel);
        }
        displayStudentList(studentList);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pictureLabel = new javax.swing.JLabel();
        studentProfileTable = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        addStudentButton = new javax.swing.JButton();
        editProfileButton = new javax.swing.JButton();
        deleteRecordButton = new javax.swing.JButton();
        viewGradeButton = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        yearLevelComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        totalStudents = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12));

        jPanel3.setBackground(new java.awt.Color(0, 204, 51));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        pictureLabel.setBackground(new java.awt.Color(255, 255, 255));
        pictureLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        pictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureLabel.setText("PICTURE");
        pictureLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pictureLabel.setOpaque(true);

        studentProfileTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        studentProfileTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "      PERSONAL INFORMATION"},
                {" ID NUMBER", null},
                {" NAME", null},
                {" BIRTH DATE", null},
                {" BIRTH PLACE", null},
                {" GENDER", null},
                {" ETHNIC GROUP", null},
                {" RELIGION", null},
                {" HOME ADDRESS", null},
                {" PRESENT ADDRESS", null},
                {null, "      EDUCATIONAL INFORMATION"},
                {" LAST SCH. ATTENDED", null},
                {" ENTRANCE TEST RATING", null},
                {" YEAR ADMITTED", null},
                {"", "      FAMILY INFORMATION"},
                {" GUARDIAN NAME", null},
                {" OCCUPATION", null},
                {" CONTACT NO.", null},
                {" ADDRESS", null}
            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentProfileTable.setRowHeight(22);
        studentProfileTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        studentProfileTable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        studentProfileTable.setShowVerticalLines(false);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setOpaque(false);
        jToolBar1.add(jSeparator1);

        addStudentButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        addStudentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/add-18.png"))); // NOI18N
        addStudentButton.setText("ADD RECORD");
        addStudentButton.setFocusable(false);
        addStudentButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        addStudentButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        addStudentButton.setOpaque(false);
        addStudentButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(addStudentButton);

        editProfileButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        editProfileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/edit24.png"))); // NOI18N
        editProfileButton.setText("EDIT PROFILE");
        editProfileButton.setEnabled(false);
        editProfileButton.setFocusable(false);
        editProfileButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        editProfileButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        editProfileButton.setOpaque(false);
        editProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProfileButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(editProfileButton);

        deleteRecordButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        deleteRecordButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/delete18.png"))); // NOI18N
        deleteRecordButton.setText("DELETE RECORD");
        deleteRecordButton.setEnabled(false);
        deleteRecordButton.setFocusable(false);
        deleteRecordButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deleteRecordButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        deleteRecordButton.setOpaque(false);
        deleteRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecordButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(deleteRecordButton);

        viewGradeButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        viewGradeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/grades.png"))); // NOI18N
        viewGradeButton.setText("VIEW GRADE CARD");
        viewGradeButton.setEnabled(false);
        viewGradeButton.setFocusable(false);
        viewGradeButton.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        viewGradeButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        viewGradeButton.setOpaque(false);
        viewGradeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGradeButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(viewGradeButton);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(studentProfileTable, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentProfileTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        studentProfileTable.getColumnModel().getColumn(0).setMinWidth(200);
        studentProfileTable.getColumnModel().getColumn(0).setPreferredWidth(200);
        studentProfileTable.getColumnModel().getColumn(0).setMaxWidth(200);

        jPanel22.setBackground(new java.awt.Color(0, 204, 51));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setFont(new java.awt.Font("Tahoma", 1, 12));

        studentsTable.setAutoCreateRowSorter(true);
        studentsTable.setFont(new java.awt.Font("Tahoma", 0, 12));
        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Number", "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentsTable.setDoubleBuffered(true);
        studentsTable.setDragEnabled(true);
        studentsTable.getTableHeader().setResizingAllowed(false);
        studentsTable.getTableHeader().setReorderingAllowed(false);
        studentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                studentsTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(studentsTable);
        studentsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        studentsTable.getColumnModel().getColumn(0).setMinWidth(100);
        studentsTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        studentsTable.getColumnModel().getColumn(0).setMaxWidth(100);

        jPanel38.setBackground(new java.awt.Color(0, 204, 51));
        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        searchTextField.setText("ID No. or Name");
        searchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextFieldMouseClicked(evt);
            }
        });
        jPanel38.add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 20));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel63.setText("Search:");
        jPanel38.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        searchButton.setBackground(new java.awt.Color(0, 204, 51));
        searchButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/find.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        jPanel38.add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 40, 20));

        yearLevelComboBox.setFont(new java.awt.Font("Tahoma", 0, 12));
        yearLevelComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "1st year", "2nd year", "3rd year", "4th year" }));
        yearLevelComboBox.setToolTipText("");
        yearLevelComboBox.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        yearLevelComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearLevelComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("Year Level:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Total Students:");

        totalStudents.setFont(new java.awt.Font("Tahoma", 1, 12));
        totalStudents.setText("---");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalStudents))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(10, 10, 10)
                        .addComponent(yearLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLevelComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(totalStudents))
                .addGap(105, 105, 105))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel22, 0, 491, Short.MAX_VALUE)
                        .addContainerGap(40, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        try {
            selectedYearLevel = yearLevelComboBox.getSelectedIndex();
            searchText = searchTextField.getText();
            studentList = admissionService.getAdmittedStudentsList(currentSchoolYear.getSchoolYearID(), searchText, selectedYearLevel);
            displayStudentList(studentList);
            searchTextField.setText("");
        } catch (ExceptionHandler ex) {
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid search", "Search", JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_searchButtonActionPerformed

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentButtonActionPerformed
        // TODO add your handling code here:
        StudentDialog addStudent = new StudentDialog(parentFrame, true, null, currentSchoolYear);
        addStudent.setVisible(true);
        Student student = addStudent.getStudent();
        if (student != null) {
            try {
                selectedStudent = student;
                displayStudentList();
                displayStudentProfile(selectedStudent, studentList.size() - 1);
            } catch (ExceptionHandler ex) {
                Logger.getLogger(StudentRecordsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}//GEN-LAST:event_addStudentButtonActionPerformed

    private void editProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProfileButtonActionPerformed
        // TODO add your handling code here:
        if (selectedStudent != null) {
            StudentDialog editStudent = new StudentDialog(parentFrame, true, selectedStudent, currentSchoolYear);
            editStudent.setVisible(true);
            Student student = editStudent.getStudent();
            if (student != null) {
                selectedStudent = student;
                if (studentList.size() > 0) {
                    studentList.set(selectedStudentIndex, student);
                    studentTableModel.setValueAt(student.toString(), selectedStudentIndex, 1);
                }
                displayStudentProfile(selectedStudent, selectedStudentIndex);
            }
        }
}//GEN-LAST:event_editProfileButtonActionPerformed

    private void deleteRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecordButtonActionPerformed
        // TODO add your handling code here:
        if (selectedStudent != null) {
            int option = JOptionPane.showConfirmDialog(parentFrame, "Are you sure you want to delete this student?",
                    "Delete Student", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                try {
                    studentService.deleteStudent(selectedStudent.getStudentID());
                    JOptionPane.showMessageDialog(parentFrame, "You have successfully deleted this student", "Delete Student", JOptionPane.INFORMATION_MESSAGE);
                    displayStudentList();
                    displayStudentProfile(null, -1);
                    updateButtons(false);
                } catch (ExceptionHandler ex) {
                    Logger.getLogger(StudentRecordsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}//GEN-LAST:event_deleteRecordButtonActionPerformed

    private void viewGradeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGradeButtonActionPerformed
        // TODO add your handling code here:

        try {
            if (selectedStudent != null) {
                ViewStudentGradeDialog viewGrade = new ViewStudentGradeDialog(parentFrame, true, selectedStudent, currentSchoolYear);
                viewGrade.setVisible(true);
            }
        } catch (ExceptionHandler ex) {
            Logger.getLogger(StudentRecordsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

}//GEN-LAST:event_viewGradeButtonActionPerformed

    private void yearLevelComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearLevelComboBoxActionPerformed
        try {
            // TODO add your handling code here:
            displayStudentList();
        } catch (ExceptionHandler ex) {
            Logger.getLogger(StudentRecordsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_yearLevelComboBoxActionPerformed

    private void studentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseClicked
        // TODO add your handling code here:
        try {
            int index = studentsTable.getSelectedRow();
            if (index >= 0) {
                if (selectedStudent != null && selectedStudentIndex == index) {
                    displayStudentProfile(null, index);
                    updateButtons(false);
                } else {
                    Student student = studentList.get(index);
                    displayStudentProfile(student, index);
                    updateButtons(true);
                }
            }
        } catch (ExceptionHandler ex) {
            Logger.getLogger(StudentRecordsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studentsTableMouseClicked

    private void studentsTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMousePressed
    }//GEN-LAST:event_studentsTableMousePressed

    private void studentsTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsTableMouseEntered

    private void searchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseClicked
        // TODO add your handling code here:
        searchTextField.setText("");
    }//GEN-LAST:event_searchTextFieldMouseClicked

    public void displayStudentProfile(Student student, int selectedStudentIndex) {
        if (student != null) {
            selectedStudent = student;
            this.selectedStudentIndex = selectedStudentIndex;
            studentProfileTable.setValueAt(" " + String.valueOf(student.getStudentID()), 1, 1);
            studentProfileTable.setValueAt(" " + student.getFullName(), 2, 1);
            studentProfileTable.setValueAt(" " + ComponentFormatter.formatMonthDateYear(student.getDOB()).toString(), 3, 1);
            studentProfileTable.setValueAt(" " + student.getPOB(), 4, 1);
            studentProfileTable.setValueAt(" " + student.getGender(), 5, 1);
            studentProfileTable.setValueAt(" " + student.getEthnicGroup(), 6, 1);
            studentProfileTable.setValueAt(" " + student.getReligion(), 7, 1);
            studentProfileTable.setValueAt(" " + student.getHomeAdd(), 8, 1);
            studentProfileTable.setValueAt(" " + student.getPresentAdd(), 9, 1);
            studentProfileTable.setValueAt(" " + student.getLastSchoolAtt(), 11, 1);
            studentProfileTable.setValueAt(" " + student.getEntranceTestRating(), 12, 1);
            studentProfileTable.setValueAt(" " + student.getYearAdmitted(), 13, 1);
            studentProfileTable.setValueAt(" " + student.getGuardian().getName(), 15, 1);
            studentProfileTable.setValueAt(" " + student.getGuardian().getOccupation(), 16, 1);
            studentProfileTable.setValueAt(" " + student.getGuardian().getContactNo(), 17, 1);
            studentProfileTable.setValueAt(" " + student.getGuardian().getAddress(), 18, 1);

            if (student.getPicture() != null) {
                Object obj = student.getPicture();
                pictureLabel.setText("");
                if (obj instanceof com.mysql.jdbc.Blob) {
                    pictureLabel.setIcon(new javax.swing.ImageIcon(ComponentFormatter.convertToActualSizeImage((Blob) obj)));
                } else {
                    Image image = Toolkit.getDefaultToolkit().getImage(obj.toString()).getScaledInstance(ComponentFormatter.IMAGE_WIDTH, ComponentFormatter.IMAGE_HEIGHT, 129);
                    obj = new javax.swing.ImageIcon(image);
                    pictureLabel.setIcon((Icon) obj);
                }
            } else {
                pictureLabel.setText("PICTURE");
                pictureLabel.setIcon(null);
            }
        } else {
            selectedStudent = null;
            this.selectedStudentIndex = selectedStudentIndex;
            for (int i = 1; i <= 18; i++) {
                if (i != 10 && i != 14) {
                    studentProfileTable.setValueAt(null, i, 1);
                }
            }
            pictureLabel.setIcon(null);
            pictureLabel.setText("PICTURE");
        }
    }

    public void updateButtons(boolean flag) throws ExceptionHandler {
        if (flag == false) {
            editProfileButton.setEnabled(flag);
            deleteRecordButton.setEnabled(flag);
            viewGradeButton.setEnabled(flag);
        } else {
            editProfileButton.setEnabled(flag);
            if (studentService.isSafeToDelete(selectedStudent.getStudentID())) {
                deleteRecordButton.setEnabled(flag);
            }
            Enrollment enrollment = enrollmentService.getEnrollment(selectedStudent.getStudentID(), currentSchoolYear.getSchoolYearID());
            if (enrollment != null) {
                if (enrollmentService.isAssignedToSection(currentSchoolYear.getSchoolYearID(), enrollment.getEnrollmentID())) {
                    viewGradeButton.setEnabled(flag);
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudentButton;
    private javax.swing.JButton deleteRecordButton;
    private javax.swing.JButton editProfileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable studentProfileTable;
    private javax.swing.JTable studentsTable;
    private javax.swing.JLabel totalStudents;
    private javax.swing.JButton viewGradeButton;
    private javax.swing.JComboBox yearLevelComboBox;
    // End of variables declaration//GEN-END:variables
}

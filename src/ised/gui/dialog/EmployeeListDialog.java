/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EmployeeListDialog.java
 *
 * Created on 11 9, 11, 3:12:33 PM
 */
package ised.gui.dialog;

import ised.model.Employee;
import ised.service.implementation.EmployeeServiceImpl;
import ised.service.interfaces.EmployeeService;
import ised.tools.ComponentFormatter;
import ised.tools.ExceptionHandler;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ABDUL
 */
public class EmployeeListDialog extends javax.swing.JDialog {

    EmployeeService employeeService;
    List<Employee> employeeList;
    DefaultTableModel employeeTableModel;
    Employee selectedEmployee;

    /** Creates new form EmployeeListDialog */
    public EmployeeListDialog(java.awt.Frame parent, boolean modal) throws ExceptionHandler {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        employeeService = new EmployeeServiceImpl();
        selectedEmployee = null;
        employeeTableModel = (DefaultTableModel) employeeTable.getModel();
        employeeList = null;
        employeeList = employeeService.getEmployeeList("Active");
        displayEmployeeList(employeeList);
    }

    public void displayEmployeeList(List<Employee> employeeList) {
        ComponentFormatter.clearTable(employeeTableModel);
        for (Employee employee : employeeList) {
            employeeTableModel.addRow(new Object[]{employee.getFullName()});
        }
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel22 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        jPanel38 = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel22.setBackground(new java.awt.Color(0, 153, 51));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setFont(new java.awt.Font("Tahoma", 1, 12));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employeeTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.getTableHeader().setResizingAllowed(false);
        employeeTable.getTableHeader().setReorderingAllowed(false);
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                employeeTableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                employeeTableMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(employeeTable);

        jPanel22.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 300, 340));

        jPanel38.setBackground(new java.awt.Color(0, 153, 51));
        jPanel38.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 12));
        searchTextField.setText("ID No. or Name");
        searchTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTextFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchTextFieldMouseExited(evt);
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

        jPanel22.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 300, 40));

        submitButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/accept.png"))); // NOI18N
        submitButton.setText("Submit");
        submitButton.setOpaque(false);
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel22.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 415, -1, 30));

        cancelButton.setFont(new java.awt.Font("Tahoma", 1, 12));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ised/resources/images/cancel.png"))); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setOpaque(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel22.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 415, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        // TODO add your handling code here
    }//GEN-LAST:event_employeeTableMouseClicked

    private void employeeTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseEntered
        // TODO add your handling code here:
}//GEN-LAST:event_employeeTableMouseEntered

    private void employeeTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMousePressed
}//GEN-LAST:event_employeeTableMousePressed

    private void searchTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseClicked
        // TODO add your handling code here:
        searchTextField.setText("");
}//GEN-LAST:event_searchTextFieldMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        try {
            String searchText = searchTextField.getText();
            employeeList = employeeService.getEmployeeList("Active", searchText);
            displayEmployeeList(employeeList);
            if (employeeList.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No result for " + searchText, "Search", JOptionPane.INFORMATION_MESSAGE);
            } else if (!employeeList.isEmpty() && !searchText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "There are " + employeeList.size() + " result(s) for " + searchText, "Search", JOptionPane.INFORMATION_MESSAGE);
            }
            searchTextField.setText("");
        } catch (ExceptionHandler ex) {
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid search", "Search", JOptionPane.WARNING_MESSAGE);
        }
}//GEN-LAST:event_searchButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        int index = employeeTable.getSelectedRow();
        if (employeeTable.getSelectedRow() >= 0) {
            Employee employee = employeeList.get(index);
            selectedEmployee = employee;
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an employee", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void searchTextFieldMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTextFieldMouseExited
        // TODO add your handling code here:
        String in = searchTextField.getText();
        if (in.equals("")) {
            searchTextField.setText("ID No. or Name");
        }
    }//GEN-LAST:event_searchTextFieldMouseExited
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}

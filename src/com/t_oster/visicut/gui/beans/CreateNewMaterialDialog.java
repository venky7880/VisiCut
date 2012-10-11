/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t_oster.visicut.gui.beans;

import com.t_oster.visicut.managers.MaterialManager;
import com.t_oster.visicut.model.MaterialProfile;
import java.util.LinkedList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thommy
 */
public class CreateNewMaterialDialog extends javax.swing.JDialog
{

  boolean okClicked = false;
  
  /**
   * Creates new form CreateNewMaterialDialog
   */
  public CreateNewMaterialDialog(java.awt.Frame parent, boolean modal)
  {
    super(parent, modal);
    initComponents();
    this.jComboBox1.removeAllItems();
    for (MaterialProfile mp : MaterialManager.getInstance().getAll())
    {
      this.jComboBox1.addItem(mp);
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {
    bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    buttonGroup1 = new javax.swing.ButtonGroup();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    jComboBox1 = new javax.swing.JComboBox();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    buttonGroup1.add(jRadioButton1);
    jRadioButton1.setSelected(true);
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/beans/resources/CreateNewMaterialDialog"); // NOI18N
    jRadioButton1.setText(bundle.getString("CREATE NEW MATERIAL FROM SCRATCH")); // NOI18N
    jRadioButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jRadioButton1ActionPerformed(evt);
      }
    });

    buttonGroup1.add(jRadioButton2);
    jRadioButton2.setText(bundle.getString("COPY SETTINGS FROM:")); // NOI18N
    jRadioButton2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jRadioButton2ActionPerformed(evt);
      }
    });

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
    jComboBox1.setToolTipText("");

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jRadioButton2, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jComboBox1, org.jdesktop.beansbinding.BeanProperty.create("enabled"), "cbReadWrite");
    bindingGroup.addBinding(binding);

    jComboBox1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jComboBox1ActionPerformed(evt);
      }
    });

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][]
      {

      },
      new String []
      {
        "Select", "Thickness"
      }
    )
    {
      Class[] types = new Class []
      {
        java.lang.Boolean.class, java.lang.Float.class
      };
      boolean[] canEdit = new boolean []
      {
        true, false
      };

      public Class getColumnClass(int columnIndex)
      {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex)
      {
        return canEdit [columnIndex];
      }
    });
    jTable1.getTableHeader().setReorderingAllowed(false);

    binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jRadioButton2, org.jdesktop.beansbinding.ELProperty.create("${selected}"), jTable1, org.jdesktop.beansbinding.BeanProperty.create("enabled"), "listEnable");
    bindingGroup.addBinding(binding);

    jScrollPane1.setViewportView(jTable1);
    jTable1.getColumnModel().getColumn(0).setResizable(false);
    jTable1.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("SELECT")); // NOI18N
    jTable1.getColumnModel().getColumn(1).setResizable(false);
    jTable1.getColumnModel().getColumn(1).setHeaderValue(bundle.getString("THICKNESS")); // NOI18N

    jButton1.setText(bundle.getString("OK")); // NOI18N
    jButton1.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setText(bundle.getString("CANCEL")); // NOI18N
    jButton2.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        jButton2ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButton2)
            .addGap(18, 18, 18)
            .addComponent(jButton1))
          .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jRadioButton1)
              .addComponent(jRadioButton2))
            .addGap(0, 110, Short.MAX_VALUE))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jRadioButton1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jRadioButton2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(11, 11, 11)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton1)
          .addComponent(jButton2))
        .addContainerGap())
    );

    bindingGroup.bind();

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
  {//GEN-HEADEREND:event_jComboBox1ActionPerformed
    if (this.jComboBox1.getSelectedItem() instanceof MaterialProfile)
    {
      DefaultTableModel m = (DefaultTableModel) this.jTable1.getModel();
      for (int r = m.getRowCount()-1; r>=0; r--)
      {
        m.removeRow(r);
      }
      for(Float f : ((MaterialProfile) this.jComboBox1.getSelectedItem()).getMaterialThicknesses())
      {
        m.addRow(new Object[]{(Boolean) true, f});
      }
    }
  }//GEN-LAST:event_jComboBox1ActionPerformed

  public boolean isOkClicked()
  {
    return okClicked;
  }
  
  public MaterialProfile getSelectedProfile()
  {
    return this.jRadioButton1.isSelected() ? null :(MaterialProfile) this.jComboBox1.getSelectedItem();
  }
  
  public LinkedList<Float> getSelectedThicknesses()
  {
    if (this.jRadioButton1.isSelected())
    {
      return null;
    }
    LinkedList<Float> result = new LinkedList<Float>();
    DefaultTableModel m = (DefaultTableModel) this.jTable1.getModel();
    for (int r = 0; r < m.getRowCount(); r++)
    {
      if ((Boolean) m.getValueAt(r, 0))
      {
        result.add((Float) m.getValueAt(r, 1));
      }
    }
    return result;
  }
  
  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
  {//GEN-HEADEREND:event_jButton1ActionPerformed
    okClicked = true;
    this.setVisible(false);
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
  {//GEN-HEADEREND:event_jButton2ActionPerformed
    this.setVisible(false);
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButton1ActionPerformed
  {//GEN-HEADEREND:event_jRadioButton1ActionPerformed
    this.jTable1.setVisible(false);
  }//GEN-LAST:event_jRadioButton1ActionPerformed

  private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButton2ActionPerformed
  {//GEN-HEADEREND:event_jRadioButton2ActionPerformed
    this.jTable1.setVisible(true);
  }//GEN-LAST:event_jRadioButton2ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JComboBox jComboBox1;
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private org.jdesktop.beansbinding.BindingGroup bindingGroup;
  // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
//Heather Mac
/**
 *
 * @author Heather 
 * 
 */
import java.awt.event.ActionEvent;
import java.util.*;
import java.io.*;
import javax.swing.AbstractAction;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Task_Assignment extends javax.swing.JFrame {

    /**
     * Creates new form Task_Assignment
     */
    HashMap<String, HashSet<String>> map;
    HashMap<String, HashSet<String>> map2;
    HashSet<String> nameList2;
    HashSet<String> projectList2;
    
    public Task_Assignment() {
        initComponents();
        map = new HashMap<>();
        map2 = new HashMap<>();
//        
        projectList2 = new HashSet<>();
        nameList2 = new HashSet<>();  
//        HashSet<String> workonList2 = new HashSet<>();  
        
//
//        getRootPane.addKeyListener(new KeyAdapter()
//           {
//               public void keyPressed(KeyEvent e)
//               {
//                   AWTKeyStroke ak = AWTKeyStroke.getAWTKeyStrokeForEvent(e);
//                   if(ak.equals(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_F4,InputEvent.ALT_MASK)))
//                   {
//                     System.exit(0);
//                   }
//               }
//           });
        
        jList1.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
        
        jList2.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if(super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                }
                else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });

        
        
        try{
           File file = new File("src/employee.txt");
           Scanner readFile = new Scanner(file);
           String name = readFile.nextLine();
           nameList2.add(name);
           while(readFile.hasNextLine()){
               name = readFile.nextLine();
               nameList2.add(name);
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = new ArrayList(nameList2);
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        
        
        
        try{
           File file = new File("src/project.txt");
           Scanner readFile = new Scanner(file);
           String project = readFile.nextLine();
           projectList2.add(project);
           while(readFile.hasNextLine()){
               project = readFile.nextLine();
               projectList2.add(project);
           }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = new ArrayList(projectList2);
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
        });
        
        
        try{
           File file = new File("src/workon.txt");
           Scanner readFile = new Scanner(file);
           while(readFile.hasNextLine()){
               String[] s = readFile.nextLine().split("<>");
               if(nameList2.contains(s[0])){
                   if(map.containsKey(s[0])){
                       map.get(s[0]).add(s[1]);
                   }
                   else{
                       HashSet<String> set = new HashSet<>();
                       set.add(s[1]);
                       map.put(s[0], set);
                   }
               }
               else{
                   if(map2.containsKey(s[0])){
                       map2.get(s[0]).add(s[1]);
                   }
                   else{
                       HashSet<String> set = new HashSet<>();
                       set.add(s[1]);
                       map2.put(s[0], set);
                   }
               }
           }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        jButton1.setMnemonic('j');
        jButton1.setMnemonic('k');
        jButton1.setMnemonic('J');
        jButton1.setMnemonic('K');
        jButton1.setMnemonic(KeyEvent.VK_H);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jLabel1.setText("Employee:");

        jLabel2.setText("Project:");

        jButton1.setText("Assign");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });

        jLabel3.setText("Report:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(33, 33, 33)
                        .addComponent(jButton4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addComponent(jScrollPane3))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        if (e.isAltDown() && e.getKeyChar() != 'a' && e.getKeyCode() == 65) {
            System.out.println("Select All"); 
        }
        
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //check if name and project are selected
        System.out.println("testing");
        
         
        if(jList1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, 
                    "You must select a employee name in the list.",
                     "Did not select a employee name",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        HashSet<String> employeeName = new HashSet<>(jList1.getSelectedValuesList() );
        if(jList2.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, 
                    "You must select a project in the list.",
                     "Did not select a project",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        HashSet<String> projectSet = new HashSet<>(jList2.getSelectedValuesList());
        //write to hashmap
        
        
      
        for(String name: employeeName){
            if(map.containsKey(name)){
                map.get(name).addAll(projectSet);
            }
            else{
                map.put(name, projectSet);
            }
            
        }
        try{
            File file = new File("src/workon.txt");
            FileWriter fw = new FileWriter(file);
            for(String name : map.keySet()){
                HashSet<String> project = map.get(name);
                for(String p : project){
                    fw.append(name+"<>"+p+"\n");
                }
        
            }
            fw.close();
        }
        catch(Exception e ){
            
        }
        for(String project: projectSet){
            if(map2.containsKey(project)){
                map2.get(project).addAll(employeeName);
            }
            else{
                map2.put(project, employeeName);
            }
        }
        
        try{
            File file = new File("src/workon.txt");
            FileWriter fw = new FileWriter(file,true);
            
            for(String project : map2.keySet()){
                HashSet<String> name = map2.get(project);
                for(String n : name){
                    fw.append(project+"<>"+n+"\n");    
                }
                
            }
            
            fw.close();
        }
        catch(Exception e ){
            
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
            
        if(jList1.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, 
                    "You must select either employee(s) or project(s).",
                     "Did not select a employee name",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        HashSet<String> employeeSet = new HashSet<>(jList1.getSelectedValuesList());
        
        
        if(jList2.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, 
                    "You must select either employee(s) or project(s)",
                     "Did not select a project",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        HashSet<String> projectSet = new HashSet<>(jList2.getSelectedValuesList());
        String content = "";
        
        for(String name : employeeSet){
            HashSet<String> projectAssigned = map.get(name);
            if(projectAssigned == null){
                content+= name+": No Project\n";
            }
            else{
                content += name+" is assigned to "+projectAssigned+"\n";   
            }
            
        }
        content += "\n==============================================\n";
        for(String project : projectSet){
            HashSet<String> nameAssigned = map2.get(project);
            if(nameAssigned == null){
                content += project+": no employee\n";
            }
            else{
                content += project+" has been assigned to "+nameAssigned+"\n";
            }
            
        }
        jTextArea1.setText(content);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        JOptionPane pane = new JOptionPane();
        String[] choices = {"Employee", "Project"};
        int employeeCount = 0;
        int projectCount = 0;
        int click = JOptionPane.showOptionDialog(
                this
                ,"Add a new employee or project?"
                ,"Add Record"
                ,JOptionPane.YES_NO_CANCEL_OPTION
                ,JOptionPane.PLAIN_MESSAGE
                ,null
                ,choices
                , "default"
                );      
                switch (click) {
                case 0: 
                    employeeCount++;
                    String employeeName = JOptionPane.showInputDialog("Enter the name for the new employee (name cannot be duplicated).");
                    nameList2.add(employeeName);
                    System.out.println("Added " + employeeName + " to the list" );
                    JOptionPane.showMessageDialog(this,
                    employeeName + " has been successfully added" ,
                    null,
                    JOptionPane.INFORMATION_MESSAGE);
                    break;
                case 1:
                    projectCount++;
                    String projectName = JOptionPane.showInputDialog("Enter the name for the new project (name cannot be duplicated).");
                    projectList2.add(projectName);
                    System.out.println("Added " + projectName + " to the list" );
                    JOptionPane.showMessageDialog(this,
                    projectName + " has been successfully added" ,
                    null,
                    JOptionPane.INFORMATION_MESSAGE);
                    break;
     
                }
            System.out.println(nameList2);  
            jList1.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = new ArrayList(nameList2);
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }

            });
                        
            System.out.println(projectList2);  
            jList2.setModel(new javax.swing.AbstractListModel<String>() {
            ArrayList<String> strings = new ArrayList(projectList2);
            public int getSize() { return strings.size(); }
            public String getElementAt(int i) { return strings.get(i); }
            
            });
            
            try{
            File file = new File("src/employee.txt");
            FileWriter fw = new FileWriter(file);
            
            for(String name : nameList2){
               fw.append(name+"\n");                
            }
            
                fw.close();
            }
            catch(Exception e ){

            }
            try{
            File file = new File("src/project.txt");
            FileWriter fw = new FileWriter(file);
            
            for(String project : projectList2){
               fw.append(project+"\n");                
            }
            
                fw.close();
            }
            catch(Exception e ){

            }
         
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton4MouseExited
    

    
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
            java.util.logging.Logger.getLogger(Task_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Task_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Task_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Task_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Task_Assignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

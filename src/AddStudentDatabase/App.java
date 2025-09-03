/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AddStudentDatabase;

import AddStudentDatabase.view.StudentList;
import java.util.Locale;

/**
 *
 * @author Admin
 */
public class App {
   
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Mở form chính */
        java.awt.EventQueue.invokeLater(() -> {
            Locale.setDefault(Locale.US);
            StudentList ptit = new StudentList();
            ptit.setVisible(true);
            ptit.setLocationRelativeTo(null);
        });
    }
}



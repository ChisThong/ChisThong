/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.EventQueue;
import javax.swing.UIManager;
import view.CeaserCipherview;


public class main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run(){
                try{
                    CeaserCipherview frame=new CeaserCipherview();
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    frame.setVisible(true);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}

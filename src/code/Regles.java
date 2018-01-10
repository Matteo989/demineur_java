import java.io.IOException;
import java.net.URL;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
 
 
public class Regles extends javax.swing.JFrame {
 
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
     
    public Regles() {
        initComponents();
    }
     
    private void initComponents() {
        
        setTitle("Regles du demineur");
        setSize(700, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        setAlwaysOnTop(true);

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
 
        try {
            URL url = new URL("http://matteo989.alwaysdata.net/regles.html");
            HTMLEditorKit kit = new HTMLEditorKit();
            StyleSheet style = new StyleSheet();
            style.setBase(url);
            style.importStyleSheet(url);
            kit.setStyleSheet(style);
            kit.setAutoFormSubmission(true);
            jEditorPane1.setEditorKit(kit);
            jEditorPane1.setPage(url);

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        jScrollPane1.setViewportView(jEditorPane1);
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
 
    }
     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
 
            public void run() {
                new Regles().setVisible(true);
            }
        });
    }
}
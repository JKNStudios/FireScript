package com.jknstudios.firescript.util;

import javax.swing.*;
import java.awt.*;

public class FrameUtil {
    public static void createFrame(String label, String title) throws Exception {
        JFrame frm = new JFrame(title);
        JLabel lbl = new JLabel("\n" + label+ "\n");
        lbl.setHorizontalAlignment(JLabel.CENTER);
        lbl.setVerticalAlignment(JLabel.CENTER);
        frm.setSize(300, 100);
        frm.getContentPane().add(lbl, BorderLayout.CENTER);
        frm.setLocationRelativeTo(null);
        frm.setLayout(new FlowLayout());
        frm.setResizable(false);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        //frm.pack();
        frm.setVisible(true);
    }
}

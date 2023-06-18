package GUI;

import Comp_Decomp.compressor;
import Comp_Decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.http.HttpRequest;

public class AppFrame extends JFrame implements ActionListener
{
    JButton compressbutton;
    JButton decompressbutton;
    AppFrame()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressbutton = new JButton("Click to Compress");
        compressbutton.setBounds(130,150,200,30);
        compressbutton.addActionListener(this);
        decompressbutton = new JButton("Click to Decompress");
        decompressbutton.setBounds(350,150,200,30);
        decompressbutton.addActionListener(this);
        this.add(compressbutton);
        this.add(decompressbutton);
        this.setSize(700,500);
        this.getContentPane().setBackground(Color.darkGray);
        this.setLocation(450,150);
        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==compressbutton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try
                {
                    compressor.method(file);
                }
                catch (Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==decompressbutton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try
                {
                    decompressor.method(file);
                }
                catch (Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}

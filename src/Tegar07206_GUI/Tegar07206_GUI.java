package Tegar07206_GUI;
import Tegar07206_Controller.Tegar07206_ObjectModelController;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Tegar07206_GUI{
    
    JFrame tampilan = new JFrame();
    JLabel Login,top;
    JButton trx,show,exit;
    JButton login,back;
    JLabel adminlog,passlabel,idlabel;
    JTextField idtext;
    JPasswordField passtext;

    public Tegar07206_GUI(){
        tampilan.setSize(700, 650);
        tampilan.setLayout(null);
        tampilan.getContentPane().setBackground(Color.LIGHT_GRAY);
        top = new JLabel ("SELAMAT DATANG");
        top.setBounds(210, 10, 600, 50);
        top.setFont(new Font("Comic sans",Font.BOLD,28));
        tampilan.add(top);
        
        trx = new JButton ("BELI");
        trx.setFont(new Font("Comic Sans",Font.ITALIC,20));
        trx.setBounds(300, 150, 100, 50);
        tampilan.add(trx);
        
        exit = new JButton ("EXIT");
        exit.setFont(new Font("Comic sans",Font.ITALIC,20));
        exit.setBounds(300, 220, 100, 50);
        exit.setBackground(Color.red);
        tampilan.add(exit);
        
        adminlog = new JLabel("Admin");
        adminlog.setFont(new Font("Times new Roman",Font.BOLD,30));
        adminlog.setBounds(80, 75, 100, 50);
        tampilan.add(adminlog);
        
        idlabel = new JLabel("User ID");
        idlabel.setFont(new Font("Times new Roman",Font.BOLD,16));
        idlabel.setBounds(70, 130, 100, 50);
        tampilan.add(idlabel);
        
        idtext = new JTextField();
        idtext.setBounds(70, 165, 100, 30);
        tampilan.add(idtext);
        
        passlabel = new JLabel("Password");
        passlabel.setBounds(70, 190, 100, 50);
        passlabel.setFont(new Font("Times new Roman",Font.BOLD,16));
        tampilan.add(passlabel);
        
        passtext = new JPasswordField();
        passtext.setBounds(70, 225, 100, 30);
        tampilan.add(passtext);
        
        login =  new JButton("Login");
        login.setBounds(75, 290, 90, 25);
        login.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        login.setBackground(Color.green);
        tampilan.add(login);
        
        
        tampilan.setVisible(true);
        tampilan.setLocationRelativeTo(null);
        tampilan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                    try{
                        Tegar07206_ObjectModelController.adminct.dataAdmin();
                        Tegar07206_ObjectModelController.adminct.login(idtext.getText(), passtext.getText());
                        String nama = Tegar07206_ObjectModelController.adminct.adminEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang "+"Admin",
                                "Information",JOptionPane.INFORMATION_MESSAGE);
                        Tegar07206_AdminGUI admin = new Tegar07206_AdminGUI();
                        tampilan.dispose();
                        
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "ID atau Password salah",
                                "information", JOptionPane.INFORMATION_MESSAGE);
                    }
                    kosong();
            }
        });
        trx.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Tegar07206_DaftarGUI transaksi = new Tegar07206_DaftarGUI();
                tampilan.dispose();
            }
        });
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                tampilan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                tampilan.dispose();
            }
        });
    }
    public void kosong(){
        idtext.setText(null);
        passtext.setText(null);
        
    }
}

package Tegar07206_GUI;
import Tegar07206_Controller.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Tegar07206_AdminGUI {
    private static Tegar07206_TransaksiController transaksict = new Tegar07206_TransaksiController();
    JFrame admin = new JFrame();
    JTable tabeltransaksi = new JTable();
    JScrollPane scroll = new JScrollPane(tabeltransaksi);
    JButton back,proses,hapus;
    JLabel adminlabel,nomortrxlabel;
    JTextField nomortrxtext;
    
    public Tegar07206_AdminGUI(){
        admin.setSize(750, 650);
        admin.setLayout(null);
        admin.getContentPane().setBackground(Color.cyan);
        
        adminlabel = new JLabel("ADMIN");
        adminlabel.setFont(new Font("Times new Roman",Font.BOLD,28));
        adminlabel.setBounds(300, 30, 200, 50);
        admin.add(adminlabel);
        
        scroll.setBounds(40, 100, 680, 200);
        tabeltransaksi.setModel(transaksict.datapembeli());
        admin.add(scroll);
        
        nomortrxlabel = new JLabel("Nomor Transaksi");
        nomortrxlabel.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        nomortrxlabel.setBounds(80, 300, 200, 50);
        admin.add(nomortrxlabel);
        
        nomortrxtext = new JTextField();
        nomortrxtext.setBounds(80, 340, 150, 25);
        admin.add(nomortrxtext);
        
        proses = new JButton("Proses");
        proses.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        proses.setBounds(80, 380, 80, 50);
        proses.setBackground(Color.green);
        admin.add(proses);
        
        hapus = new JButton("Hapus");
        hapus.setBounds(80, 440, 80, 50);
        hapus.setBackground(Color.lightGray);
        admin.add(hapus);
        
        back = new JButton("Logout");
        back.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        back.setBounds(200, 380, 100, 50);
        back.setBackground(Color.red);
        admin.add(back);
        
        admin.setLocationRelativeTo(null);
        admin.setVisible(true);
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        tabeltransaksi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabeltransaksi.getSelectedRow();
            nomortrxtext.setText(Tegar07206_ObjectModelController.transaksict.datapembeli().getValueAt(i, 0).toString());
            }
        });
        
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                Tegar07206_GUI tampilanawal = new Tegar07206_GUI();
                admin.dispose();
            }
        });

        hapus.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            int index = Integer.parseInt(nomortrxtext.getText());
                Tegar07206_ObjectModelController.adminct.delete(index);
                int nomortrx = Tegar07206_ObjectModelController.transaksi.dataTransaksi().size();
            nomortrx--;
            tabeltransaksi.setModel(Tegar07206_ObjectModelController.transaksict.datapembeli());
            }
        });

        proses.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int index = Integer.parseInt(nomortrxtext.getText());
                if(index==0){
                    Tegar07206_ObjectModelController.adminct.updatetrx(index,
                        Tegar07206_ObjectModelController.transaksict.showData(index).getPembeli(),
                        Tegar07206_ObjectModelController.transaksict.showData(index).getProduk());
                }
                else if(index!=0 || index>=0){
                    Tegar07206_ObjectModelController.adminct.updatetrx(index,
                        Tegar07206_ObjectModelController.transaksict.showData(index).getPembeli(),
                        Tegar07206_ObjectModelController.transaksict.showData(index).getProduk());
                }
                tabeltransaksi.setModel(Tegar07206_ObjectModelController.transaksict.datapembeli());
            }
        });
    }
}

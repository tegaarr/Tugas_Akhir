package Tegar07206_GUI;
import Tegar07206_Controller.*;
import Tegar07206_Entity.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tegar07206_DaftarGUI {
    JFrame log = new JFrame();
    JTextField namatext,notelptext,idgametext,igntext,uangtext,nominaltext,produktext,hargatext;
    JLabel namalabel,notelplabel,idgamelabel,idgamelabel2,ignlabel,uanglabel,nominallabel,produklabel,hargalabel;
    JButton beli,back;
    JLabel top;
    public Tegar07206_DaftarGUI(){
        
        log.setSize(550,650);
        log.setLayout(null);
        log.getContentPane().setBackground(Color.cyan);
        
        top = new JLabel("Transaksi");
        top.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,28));
        top.setBounds(300, 20, 150, 50);
        log.add(top);
        
        namalabel = new JLabel("Nama");
        namalabel.setFont(new Font("Times new Roman",Font.BOLD,16));
        namalabel.setBounds(80, 85, 150, 50);
        log.add(namalabel);
        
        namatext = new JTextField();
        namatext.setBounds(80, 125, 150, 25);
        log.add(namatext);
        
        notelplabel = new JLabel("No Telepon");
        notelplabel.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        notelplabel.setBounds(80, 135, 150, 50);
        log.add(notelplabel);
        
        notelptext = new JTextField();
        notelptext.setBounds(80, 175, 150, 25);
        log.add(notelptext);
        
        produklabel = new JLabel("Nama Produk");
        produklabel.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        produklabel.setBounds(80, 185, 150, 50);
        log.add(produklabel);
        
        produktext = new JTextField();
        produktext.setBounds(80, 225, 150, 25);
        log.add(produktext);
        
        nominallabel = new JLabel("Nominal Produk");
        nominallabel.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        nominallabel.setBounds(80, 235, 150, 50);
        log.add(nominallabel);
        
        nominaltext  = new JTextField();
        nominaltext.setBounds(80, 275, 150, 25);
        log.add(nominaltext);
        
        idgamelabel = new JLabel("User ID+(Server)");
        idgamelabel.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        idgamelabel.setBounds(80, 285, 200, 50);
        log.add(idgamelabel);
        idgamelabel2 = new JLabel("Beri - bila server tidak ada");
        idgamelabel2.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        idgamelabel2.setBounds(80, 305, 250, 45);
        log.add(idgamelabel2);
        
        idgametext = new JTextField();
        idgametext.setBounds(80, 345, 150, 25);
        log.add(idgametext);
        
        ignlabel = new JLabel("Nama akun");
        ignlabel.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        ignlabel.setBounds(80, 355, 150, 50);
        log.add(ignlabel);
        
        igntext = new JTextField();
        igntext.setBounds(80, 395, 150, 25);
        log.add(igntext);
        
        hargalabel = new JLabel("Harga Produk");
        hargalabel.setFont(new Font("Times new Roman",Font.CENTER_BASELINE,16));
        hargalabel.setBounds(80, 405, 150, 50);
        log.add(hargalabel);
        
        hargatext = new JTextField();
        hargatext.setBounds(80, 445, 150, 25);
        log.add(hargatext);
        
        beli = new JButton("BELI");
        beli.setFont(new Font("Comic Sans",Font.BOLD,18));
        beli.setBackground(Color.white);
        beli.setBounds(115, 525, 80, 30);
        log.add(beli);
        
        back = new JButton("HOME");
        back.setFont(new Font("Comic Sans",Font.BOLD,18));
        back.setBackground(Color.white);
        back.setBounds(200, 525, 100, 30);
        log.add(back);
        
        
        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        log.setVisible(true);
        log.setLocationRelativeTo(null);
        
        beli.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                
                int nomortrx = Tegar07206_ObjectModelController.transaksict.getNomortrx();
                if(nomortrx==0){
                    String nama = namatext.getText();
                    String notelp = notelptext.getText();
                    String nominal = nominaltext.getText();
                    String pilproduk = produktext.getText();
                    String id = idgametext.getText();
                    String ign = igntext.getText();
                    String harga = hargatext.getText();
                    Tegar07206_ObjectModelController.transaksict.insertproduk(pilproduk, nominal, harga);
                    Tegar07206_ObjectModelController.pembelict.daftar(nama, notelp, id, ign);
                    Tegar07206_ObjectModelController.transaksict.insertDataPembeli(nomortrx,
                            Tegar07206_ObjectModelController.pembeli.getPembeliEntity(nomortrx),
                            Tegar07206_ObjectModelController.transaksi.getProdukEntity(nomortrx), false);
                    nomortrx++;
                }
                else if(nomortrx>0){
                    
                    String nama = namatext.getText();
                    String notelp = notelptext.getText();
                    String nominal = nominaltext.getText();
                    String pilproduk = produktext.getText();
                    String id = idgametext.getText();
                    String ign = igntext.getText();
                    String harga = hargatext.getText();
                    Tegar07206_ObjectModelController.transaksict.insertproduk(pilproduk, nominal, harga);
                    Tegar07206_ObjectModelController.pembelict.daftar(namatext.getText(), notelp, id, ign);
                    Tegar07206_ObjectModelController.transaksict.insertDataPembeli(nomortrx,
                            Tegar07206_ObjectModelController.pembeli.getPembeliEntity(nomortrx),
                            Tegar07206_ObjectModelController.transaksi.getProdukEntity(nomortrx), false);
                    nomortrx++;
                }
                JOptionPane.showMessageDialog(null, "Transaksi Berhasil","Information",JOptionPane.INFORMATION_MESSAGE);
                    nomortrx++;
                    blank();
                    
            }
        });
        
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                Tegar07206_GUI tampilan  = new Tegar07206_GUI();
                log.dispose();
            }
        });
        
  }
    public void blank(){
        namatext.setText(null);
        notelptext.setText(null);
        nominaltext.setText(null);
        produktext.setText(null);
        idgametext.setText(null);
        igntext.setText(null);
        hargatext.setText(null);
    }
}

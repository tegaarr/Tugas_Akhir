package Tegar07206_Controller;
import Tegar07206_Entity.*;
import Tegar07206_Model.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public class Tegar07206_TransaksiController { 
    private int nomortrx = -1;
    public int getNomortrx() {
        nomortrx++;
        return nomortrx;
    }
    public void insertDataPembeli(int nomortrx, Tegar07206_PembeliEntity pembeli,
            Tegar07206_ProdukEntity produk, boolean statustrx){
       Tegar07206_TransaksiEntity transaksi = new Tegar07206_TransaksiEntity();
       transaksi.setNomortrx(nomortrx);
       transaksi.setPembeli(pembeli);
       transaksi.setProduk(produk);
       transaksi.setStatustrx(statustrx);
       Tegar07206_ObjectModelController.transaksi.insertDataPembeli(transaksi);
    }
    public DefaultTableModel datapembeli(){
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.fireTableDataChanged();
        Object [] kolom = {"No","Pembeli","Telepon","Voucher","Nominal","Harga","ID Akun","Nama Akun","Transaksi"};
        tabel.setColumnIdentifiers(kolom);
        
        int total = Tegar07206_ObjectModelController.transaksi.getTransaksiArrayList().size();
        String status = null;
        for(int i=0;i<total;i++){
            if(Tegar07206_ObjectModelController.transaksict.showData(i).isStatustrx()==false){
                status = "Belum";
            }
            else{
                status = "Proses";
            }
            Object [] datatrx  = new Object[9];
            datatrx[0] = i;
            datatrx[1] = Tegar07206_ObjectModelController.transaksict.showData(i).getPembeli().getNama();
            datatrx[2] = Tegar07206_ObjectModelController.transaksict.showData(i).getPembeli().getNotelp();
            datatrx[3] = Tegar07206_ObjectModelController.transaksict.showData(i).getProduk().getNamaproduk();
            datatrx[4] = Tegar07206_ObjectModelController.transaksict.showData(i).getProduk().getNominal();
            datatrx[5] = Tegar07206_ObjectModelController.transaksict.showData(i).getProduk().getHarga();
            datatrx[6] = Tegar07206_ObjectModelController.transaksict.showData(i).getPembeli().getIDgame();
            datatrx[7] = Tegar07206_ObjectModelController.transaksict.showData(i).getPembeli().getNamaakun();
            datatrx[8] = status;
            tabel.addRow(datatrx);
        }
        tabel.fireTableDataChanged();
        return tabel;
    }
    public Tegar07206_TransaksiController(){  
    }
    public  void insertproduk(String namaproduk, String nominal, String harga){
        Tegar07206_ProdukEntity insertproduk = new Tegar07206_ProdukEntity();
        insertproduk.setNamaproduk(namaproduk);
        insertproduk.setNominal(nominal);
        insertproduk.setHarga(harga);
        Tegar07206_ObjectModelController.transaksi.insertproduk(insertproduk);
    }
    public Tegar07206_TransaksiEntity showData(int index){
        return Tegar07206_ObjectModelController.transaksi.showdata(index);
    }
    public Tegar07206_ProdukEntity produkEntity(int index){
        return Tegar07206_ObjectModelController.transaksi.getProdukEntity(index);
    }
    public ArrayList<Tegar07206_TransaksiEntity> getTransaksiArrayList() {
        return Tegar07206_ObjectModelController.transaksi.getTransaksiArrayList();
    }
}

package Tegar07206_Project;
import Tegar07206_Entity.*;
import Tegar07206_Controller.*;
import java.util.Scanner;
public class Tegar07206_VoucherGame { 
    private static Scanner input = new Scanner (System.in);
    private static Tegar07206_TransaksiController trx = new Tegar07206_TransaksiController();
    private static Tegar07206_PembeliController pembeli = new Tegar07206_PembeliController();
    private static Tegar07206_AdminController admin = new Tegar07206_AdminController();
    private static int nomortrx=0;
    public static void main(String[] args) {
        admin.dataAdmin();
    int pil;
       do
       {
           System.out.println("Selamat Datang");
           System.out.println("1. Beli");
           System.out.println("2. Show data");
           System.out.println("3. Edit data");
           System.out.println("4. Exit");
           System.out.print("Pilih : ");
           pil = input.nextInt();
           switch(pil)
           {
               case 1:
                   transaksi();
                   break;
               case 2:
                   System.out.println("1. Via Admin");
                   System.out.println("2. Via Pembeli");
                   int pillogin;
                   System.out.print("Pilihan : ");
                   pillogin = input.nextInt();
                   if(pillogin==1){
                       viaadmin();
                       break;
                   }else if(pillogin==2){
                       viapembeli();
                       break;
                   }
                   break;
               case 3:
                proses();
                   break;
               case 4:
                   break;
           }
       }while(pil!=4);
    }
    
    static void transaksi()
    {
        System.out.println("Daftar");
        System.out.print("Nama : ");
        String namapem = input.next();
        System.out.print("Telp : ");
        String notelp = input.next();
        System.out.print("Pilih Produk : ");
        String pilproduk = input.next();
        System.out.print("Nominal : ");
        String nominal = input.next();
        System.out.print("IGN : ");
        String ign = input.next();
        System.out.print("ID Game (beri - bila tak ada) : ");
        String id =  input.next();
        System.out.print("Harga : Rp. ");
        String harga = input.next();
        pembeli.daftar(namapem, notelp, id, ign);
        trx.insertproduk(pilproduk,nominal,harga);
        trx.insertDataPembeli(nomortrx, pembeli.pembeliEntity(nomortrx),trx.produkEntity(nomortrx),false);
        nomortrx++;
   
    }
    
    static void viaadmin(){
        System.out.println("Login Admin");
        System.out.print("ID : ");
        String id = input.next();
        System.out.print("Password : ");
        String password = input.next();
        try{
            admin.login(id, password);
            System.out.println("HELLO Admin");
            System.out.println("Data Transaksi");
                if(nomortrx==0)
                {
                 System.out.println("Kosong");
                }
                else if(nomortrx!=0)
                {
                System.out.println("DATA-DATA PEMBELI");
                 for(int i=0;i<nomortrx;i++)
                  {
                      System.out.println("Nomor Transaksi : "+(i+1));
                      System.out.println("========================");
                      System.out.println("Pembeli   : "+trx.showData(i).getPembeli().getNama());
                      System.out.println("NoTelp    : "+trx.showData(i).getPembeli().getNotelp());
                      System.out.println("Voucher   : "+trx.showData(i).getProduk().getNamaproduk());
                      System.out.println("Nominal   : "+trx.showData(i).getProduk().getNominal());
                      System.out.println("Harga     : "+trx.showData(i).getProduk().getHarga());
                      System.out.println("ID        : "+trx.showData(i).getPembeli().getIDgame());
                      System.out.println("IGN       : "+trx.showData(i).getPembeli().getNamaakun());
                      System.out.print("Status Transaksi : ");
                      if(trx.showData(i).isStatustrx()==false){
                          System.out.println("Belum Di Proses");
                      }
                      else{
                          System.out.println("Sedang Di Proses");
                      }
                      System.out.println("========================");
                  }
                }
        }catch(Exception e){
            System.out.println("ID atau Password Salah");
        }
    }
    
    static void viapembeli(){
        System.out.println("DATA-DATA PEMBELI");
        if(nomortrx==0){
            System.out.println("Kosong");
        }
        else{
            for(int i=0;i<nomortrx;i++){
            System.out.println("Nomor Transaksi : "+(i+1));
            System.out.println("========================");
            System.out.println("Pembeli : "+trx.showData(i).getPembeli().getNama());
            System.out.println("Order   : "+trx.showData(i).getProduk().getNamaproduk());
            System.out.println("Nominal : "+trx.showData(i).getProduk().getNominal());
            System.out.print("Status Transaksi : ");
            if(trx.showData(i).isStatustrx()==false){
                System.out.println("Belum Di Proses");
            }
            else{
                System.out.println("Sedang Di Proses");
            }
            System.out.println("========================");
        }
        }
    }
    
    static void proses(){
        System.out.println("Login Admin");
        System.out.print("ID : ");
        String id = input.next();
        System.out.print("Password : ");
        String password = input.next();
        try{
            admin.login(id, password);
            System.out.println("HELLO Admin");
            System.out.println("Data Transaksi");
                if (nomortrx==0)
                {
                  System.out.println("Data Kosong");
                }
                else if (nomortrx!=0)
                {
                 for(int a=0;a<nomortrx;a++)
                  {
                   System.out.println("Transaksi - "+(a+1)+"\n"+"Pembeli : "+trx.showData(a).getPembeli().getNama());
                  }
                }
                System.out.println("1. Update Status Transaksi");
                System.out.println("2. Hapus Transaksi");
                System.out.print("Pilih : ");
                int pilih = input.nextInt();
                if(pilih==1){
                System.out.print("Proses Transaksi ke - ");
                try{
                int proses = input.nextInt();
                int memproses = proses-1;
                admin.updatetrx(memproses, trx.showData(memproses).getPembeli(), trx.showData(memproses).getProduk()); 
                System.out.println("=====Transaksi di Proses=====");
                }catch(Exception e){
                    System.out.println("Transaksi Tidak Ditemukan");
                }
                }
                else if(pilih==2){
                System.out.print("Hapus Transaksi ke - ");
                try{
                int hapus = input.nextInt();
                int menghapus = hapus-1;
                admin.delete(menghapus);
                System.out.println("=====Transaksi Selesai=====");
                nomortrx--;
                }catch(Exception e){
                    System.out.println("Transaksi Tidak Ditemukan");
                }
                }
        }catch(Exception e){
        System.out.println("ID atau Password Salah");
    }
    }
}
package Tegar07206_Model;

import java.util.ArrayList;
import Tegar07206_Entity.Tegar07206_TransaksiEntity;
import Tegar07206_Entity.Tegar07206_ProdukEntity;
public class Tegar07206_TransaksiModel{
    private ArrayList <Tegar07206_TransaksiEntity> TransaksiArrayList;
    private ArrayList <Tegar07206_ProdukEntity> ProdukArrayList;
    
    public Tegar07206_TransaksiModel(){
        TransaksiArrayList = new ArrayList <Tegar07206_TransaksiEntity>();
        ProdukArrayList= new ArrayList <Tegar07206_ProdukEntity>();
    }
    
    public void insertDataPembeli(Tegar07206_TransaksiEntity Transaksi)
    {
        TransaksiArrayList.add(Transaksi);
    }
    
    public Tegar07206_TransaksiEntity showdata (int index){
        return TransaksiArrayList.get(index);
    }
    public void insertproduk(Tegar07206_ProdukEntity produk){
        ProdukArrayList.add(produk);
    }
    public ArrayList<Tegar07206_TransaksiEntity> getTransaksiArrayList(){
        return TransaksiArrayList;
    }
    public Tegar07206_ProdukEntity getProdukEntity(int index){
        return ProdukArrayList.get(index);
    }
    public Tegar07206_TransaksiEntity getTransaksiEntity(int index){
        return TransaksiArrayList.get(index);
    }
    
    private int cari(String nomortrx){
        int index=-1;
        for(int i=0;i <TransaksiArrayList.size();i++) {
           if(nomortrx.equals(TransaksiArrayList.get(i).getNomortrx()))
               index=i;
           break;
       }
       return index;
    }
    public void delete (int index){
        TransaksiArrayList.remove(index);
    }
    
    public void updatetrx(int index,Tegar07206_TransaksiEntity transaksiEntity){
        TransaksiArrayList.set(index, transaksiEntity);
    }
    
    public ArrayList<Tegar07206_TransaksiEntity> dataTransaksi(){
        return TransaksiArrayList;
    }
}

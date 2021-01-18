package Tegar07206_Entity;
public class Tegar07206_ProdukEntity {
    private String namaproduk,nominal,harga;
    public Tegar07206_ProdukEntity(String namaproduk, String nominal, String harga) {
        this.namaproduk = namaproduk;
        this.nominal = nominal;
        this.harga = harga;
    }
    public Tegar07206_ProdukEntity(){
        
    }
    public String getNominal() {
        return nominal;
    }
    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
    public String getHarga() {
        return harga;
    }
    public void setHarga(String harga) {
        this.harga = harga;
    }
    public String getNamaproduk() {
        return namaproduk;
    }
    public void setNamaproduk(String namaproduk) {
        this.namaproduk = namaproduk;
    }
} 

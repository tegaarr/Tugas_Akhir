package Tegar07206_Entity;
public class Tegar07206_TransaksiEntity{
    private int nomortrx;
    private boolean statustrx;
    private Tegar07206_PembeliEntity pembeli;
    private Tegar07206_ProdukEntity produk;
    public Tegar07206_TransaksiEntity(int nomortrx, Tegar07206_PembeliEntity pembeli,
            Tegar07206_ProdukEntity produk, boolean statustrx) {
        this.nomortrx = nomortrx;
        this.pembeli = pembeli;
        this.produk = produk;
        this.statustrx = statustrx;
    }

    public Tegar07206_TransaksiEntity(){
        
    }
    public int getNomortrx(){
        return nomortrx;
    }
    public void setNomortrx(int nomortrx){
        this.nomortrx = nomortrx;
    }

    public Tegar07206_ProdukEntity getProduk() {
        return produk;
    }

    public void setPembeli(Tegar07206_PembeliEntity pembeli) {
        this.pembeli = pembeli;
    }

    public void setProduk(Tegar07206_ProdukEntity produk) {
        this.produk = produk;
    }
    
    public Tegar07206_PembeliEntity getPembeli() {
        return pembeli;
    }

    public boolean isStatustrx() {
        return statustrx;
    }

    public void setStatustrx(boolean statustrx) {
        this.statustrx = statustrx;
    }
    
}

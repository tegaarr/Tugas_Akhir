package Tegar07206_Controller;
import Tegar07206_Entity.Tegar07206_PembeliEntity;
import java.util.ArrayList;
public class Tegar07206_PembeliController {
    
        public void daftar(String nama, String notelp, String IDgame, String namaakun){
        Tegar07206_PembeliEntity beli = new Tegar07206_PembeliEntity();
        beli.setNama(nama);
        beli.setNotelp(notelp);
        beli.setIDgame(IDgame);
        beli.setNamaakun(namaakun);
        Tegar07206_ObjectModelController.pembeli.insert(beli);
    }
    public Tegar07206_PembeliEntity pembeliEntity(int index){
        return Tegar07206_ObjectModelController.pembeli.getPembeliEntity(index);
    }
    public ArrayList<Tegar07206_PembeliEntity> getPembeliEntity() {
        return Tegar07206_ObjectModelController.pembelict.getPembeliEntity();
    }
}
package Tegar07206_Entity;
public class Tegar07206_PembeliEntity extends Tegar07206_ManusiaEntity{
    private String IDgame,namaakun;
    public Tegar07206_PembeliEntity(String nama, String notelp, String IDgame, String namaakun) {
        this.IDgame = IDgame;
        this.namaakun = namaakun;
    }
    
    public Tegar07206_PembeliEntity(){
        
    }
    @Override
    public String getNama() {
        return nama;
    }
    public String getNotelp(){
        return notelp;
    }

    public String getIDgame() {
        return IDgame;
    }

    public void setIDgame(String IDgame) {
        this.IDgame = IDgame;
    }

    public String getNamaakun() {
        return namaakun;
    }

    public void setNamaakun(String namaakun) {
        this.namaakun = namaakun;
    }
    
}

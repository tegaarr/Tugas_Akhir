package Tegar07206_Entity;
public class Tegar07206_ManusiaEntity {
    protected String nama, notelp;
    public Tegar07206_ManusiaEntity(String nama, String notelp) {
        this.nama = nama;
        this.notelp = notelp;
    }
    public Tegar07206_ManusiaEntity(){
        
    }
    public String getNama(){
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNotelp() {
        return notelp;
    }
    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }
}

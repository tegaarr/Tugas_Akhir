package Tegar07206_Entity;
public class Tegar07206_AdminEntity extends Tegar07206_ManusiaEntity{
    private String id,password;

    public Tegar07206_AdminEntity(String nama, String id, String password, String notelp) {
        this.id = id;
        this.password = password;
    }
    public Tegar07206_AdminEntity(){   
    }
    @Override
    public String getNama(){
        return nama;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }    
}

package Tegar07206_Model;
import Tegar07206_Entity.Tegar07206_AdminEntity;
import java.util.ArrayList;
public class Tegar07206_AdminModel {
    private ArrayList <Tegar07206_AdminEntity> adminEntity;
    public Tegar07206_AdminModel(){
        adminEntity = new ArrayList<Tegar07206_AdminEntity>();
    }
    public void insertDataAdmin(Tegar07206_AdminEntity admin){
        adminEntity.add(admin);
    }
    public int cekData(String id, String password){
        int loop = 0;
        for(Tegar07206_AdminEntity admin : adminEntity){
            if(admin.getId().equals(id) && admin.getPassword().equals(password)){
                break;
            }else{
                loop++;
            }
        }
        return loop;
    }
    public Tegar07206_AdminEntity showDataAdmin(int index) {
        return adminEntity.get(index);
    }
}

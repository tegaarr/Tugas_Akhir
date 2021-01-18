package Tegar07206_Model;
import Tegar07206_Entity.Tegar07206_PembeliEntity;
import java.util.ArrayList;
public class Tegar07206_PembeliModel {
    private ArrayList <Tegar07206_PembeliEntity> PembeliEntity;

    public ArrayList<Tegar07206_PembeliEntity> getPembeliEntity() {
        return PembeliEntity;
    }
    public Tegar07206_PembeliModel() {
        PembeliEntity = new ArrayList <Tegar07206_PembeliEntity>();
    }
    
    public void insert(Tegar07206_PembeliEntity Pembeli){
        PembeliEntity.add(Pembeli);
    }

    public Tegar07206_PembeliEntity getPembeliEntity(int index){
        return PembeliEntity.get(index);
    }
    
    public int cekData(String nama){
    int loop = 0;
    for(Tegar07206_PembeliEntity pembeli : PembeliEntity){
        if(pembeli.getNama().equals(nama)){
            break;
        }else{
            loop++;
        }
      }
        return loop;
    }
    
}

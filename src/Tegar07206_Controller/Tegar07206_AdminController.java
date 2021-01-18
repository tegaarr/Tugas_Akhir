package Tegar07206_Controller;
import Tegar07206_Entity.*;
public class Tegar07206_AdminController {
    int index=0;
    public Tegar07206_AdminController(){
        
    }
    public void dataAdmin(){
        String nama [] = {"Admin1","Admin2"};
        String id [] = {"01","02"};
        String password [] = {"1234","1234"};
        String notelp [] = {"01","02"};
        for(int i=0;i<nama.length;i++){
            Tegar07206_ObjectModelController.admin.insertDataAdmin(new Tegar07206_AdminEntity(nama[i],
                    id[i],password[i],notelp[i]));
        }
    }
    public void login(String id, String password){
        index = Tegar07206_ObjectModelController.admin.cekData(id, password);
    }
    public Tegar07206_AdminEntity adminEntity(){
        return Tegar07206_ObjectModelController.admin.showDataAdmin(index);
    }
    public void updatetrx(int index, Tegar07206_PembeliEntity pembeli, Tegar07206_ProdukEntity produk){
        Tegar07206_ObjectModelController.transaksi.updatetrx(index,
                new Tegar07206_TransaksiEntity(index, pembeli, produk, true));
    }
    public void delete(int index){
        Tegar07206_ObjectModelController.transaksi.delete(index);
    }
}

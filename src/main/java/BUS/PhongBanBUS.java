/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.PhongBanDAO;
import Model.PhongBan;
import java.util.List;
/**
 *
 * @author PC
 */
public class PhongBanBUS {
     private PhongBanDAO pbBUS= new PhongBanDAO();
     public List<PhongBan> getAllPhongBan() {
        return pbBUS.getAllPhongBan();
    }
     public int getSoPhongBan() {
        return pbBUS.getAllPhongBan().size();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.VaiTroDAO;
import Model.PhongBan;
import Model.VaiTro;
import java.util.List;

/**
 *
 * @author PC
 */
public class VaiTroBUS {
    private VaiTroDAO vtBUS= new VaiTroDAO();
     public List<VaiTro> getAllPhongBan() {
        return vtBUS.getAll();
    }
}

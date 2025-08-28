/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import Model.NhanVien;

import java.util.List;

/**
 *
 * @author PC
 */
public class NhanVienBUS {

    private NhanVienDAO nvBUS = new NhanVienDAO();

    public int demNhanVienByIDPhong(String maPhong) {
        return nvBUS.demNhanVienByIDPhong(maPhong);
    }

    public List<NhanVien> getAllNhanVien() {
        return nvBUS.getAllNhanVien();
    }
    public int demTongNhanVien() {
        return nvBUS.getAllNhanVien().size();
    }

}

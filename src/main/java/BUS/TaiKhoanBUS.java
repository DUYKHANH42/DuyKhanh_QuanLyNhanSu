/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Model.TaiKhoan;
import DAO.TaiKhoanDAO;
import java.sql.Connection;

/**
 *
 * @author PC
 */
public class TaiKhoanBUS {

    private TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    public TaiKhoan DangNhap(String username, String password) {
        try {
            TaiKhoan tk = taiKhoanDAO.DangNhap(username, password);
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isAdmin(TaiKhoan tk) {
        return tk != null && "ADMIN".equalsIgnoreCase(tk.getVaiTro());
    }

    public boolean isNhanVien(TaiKhoan tk) {
        return tk != null && "NHANVIEN".equalsIgnoreCase(tk.getVaiTro());
    }

    public boolean isTruongPhong(TaiKhoan tk) {
        return tk != null && "TRUONGPHONG".equalsIgnoreCase(tk.getVaiTro());
    }
}

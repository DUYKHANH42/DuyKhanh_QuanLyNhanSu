/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class NhanVienDAO {

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN";

        try (Connection conn = DBConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString("MaNV"),
                        rs.getString("HoTen"),
                        rs.getDate("NgaySinh"),
                        rs.getString("GioiTinh"),
                        rs.getString("CCCD"),
                        rs.getString("SDT"),
                        rs.getString("DiaChi"),
                        rs.getDate("NgayVaoLam"),
                        rs.getString("MaPhong"),
                        rs.getDouble("LuongCoBan"),
                        rs.getBytes("HinhAnh")
                );
                list.add(nv);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }
    public int demNhanVienByIDPhong(String maPhong) {
        String sql = "SELECT COUNT(*) AS SoNV FROM NHANVIEN WHERE MaPhong=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maPhong);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("SoNV");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}

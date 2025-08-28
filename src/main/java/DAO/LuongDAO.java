/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class LuongDAO {
     public double getTongLuongThucLinh(int thang, int nam) {
        double tong = 0;
        String sql = "SELECT SUM(l.ThucLinh + ISNULL(p.SoTien,0)) AS TongLuong " +
                     "FROM LUONG l " +
                     "LEFT JOIN PHUCAP p ON l.MaNV = p.MaNV AND l.Thang=p.Thang AND l.Nam=p.Nam " +
                     "WHERE l.Thang=? AND l.Nam=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, thang);
            ps.setInt(2, nam);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) tong = rs.getDouble("TongLuong");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tong;
    }
}

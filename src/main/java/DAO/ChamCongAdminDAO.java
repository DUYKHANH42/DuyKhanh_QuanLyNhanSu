/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChamCongAdmin;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ChamCongAdminDAO {

    public List<ChamCongAdmin> getChamCongAdmin(int thang, int nam) {
        List<ChamCongAdmin> list = new ArrayList<>();
        String sql = "SELECT c.MaCC, c.MaNV, n.HoTen, p.TenPhong, c.NgayLam, c.TrangThai, "
                + "l.LuongCoBan, l.ThucLinh, l.TongThuNhap "
                + "FROM CHAMCONG c "
                + "JOIN NHANVIEN n ON c.MaNV = n.MaNV "
                + "JOIN PHONGBAN p ON n.MaPhong = p.MaPhong "
                + "LEFT JOIN LUONG l ON n.MaNV = l.MaNV AND l.Thang = ? AND l.Nam = ? "
                + "ORDER BY n.MaNV, c.NgayLam";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, thang);
            ps.setInt(2, nam);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChamCongAdmin cca = new ChamCongAdmin();
                    cca.setMaNV(rs.getString("MaNV"));
                    cca.setHoTen(rs.getString("HoTen"));
                    cca.setPhong(rs.getString("TenPhong"));
                    cca.setNgayLam(rs.getDate("NgayLam"));
                    cca.setTrangThai(rs.getString("TrangThai"));
                    cca.setLuongCoBan(rs.getBigDecimal("LuongCoBan"));
                    cca.setThucLinh(rs.getBigDecimal("ThucLinh"));
                    cca.setMaCC(rs.getInt("MaCC"));
                    cca.setTongThuNhap(rs.getBigDecimal("TongThuNhap"));
                    list.add(cca);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ChamCongAdmin> getByID(String maNV) {
        List<ChamCongAdmin> list = new ArrayList<>();
        String sql = "SELECT c.MaCC, c.MaNV, n.HoTen, p.TenPhong, c.NgayLam, c.TrangThai, "
                + "l.LuongCoBan, l.ThucLinh, l.TongThuNhap "
                + "FROM CHAMCONG c "
                + "JOIN NHANVIEN n ON c.MaNV = n.MaNV "
                + "JOIN PHONGBAN p ON n.MaPhong = p.MaPhong "
                + "LEFT JOIN LUONG l ON n.MaNV = l.MaNV "
                + "AND l.Thang = MONTH(c.NgayLam) AND l.Nam = YEAR(c.NgayLam) "
                + "WHERE c.MaNV = ? "
                + "ORDER BY c.NgayLam";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maNV);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChamCongAdmin cca = new ChamCongAdmin();
                    cca.setMaNV(rs.getString("MaNV"));
                    cca.setHoTen(rs.getString("HoTen"));
                    cca.setPhong(rs.getString("TenPhong"));
                    cca.setNgayLam(rs.getDate("NgayLam"));
                    cca.setTrangThai(rs.getString("TrangThai"));
                    cca.setLuongCoBan(rs.getBigDecimal("LuongCoBan"));
                    cca.setThucLinh(rs.getBigDecimal("ThucLinh"));
                    cca.setMaCC(rs.getInt("MaCC"));
                    cca.setTongThuNhap(rs.getBigDecimal("TongThuNhap"));
                    list.add(cca);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public List<ChamCongAdmin> searchByDay(java.util.Date ngay) {
        List<ChamCongAdmin> list = new ArrayList<>();
        String sql = "SELECT c.MaCC, c.MaNV, n.HoTen, p.TenPhong, c.NgayLam, c.TrangThai, "
                + "l.LuongCoBan, l.ThucLinh,l.TongThuNhap "
                + "FROM CHAMCONG c "
                + "JOIN NHANVIEN n ON c.MaNV = n.MaNV "
                + "JOIN PHONGBAN p ON n.MaPhong = p.MaPhong "
                + "LEFT JOIN LUONG l ON n.MaNV = l.MaNV "
                + "WHERE c.NgayLam = ? "
                + "ORDER BY n.MaNV";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(ngay.getTime()));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChamCongAdmin cca = new ChamCongAdmin();
                    cca.setMaCC(rs.getInt("MaCC"));
                    cca.setMaNV(rs.getString("MaNV"));
                    cca.setHoTen(rs.getString("HoTen"));
                    cca.setPhong(rs.getString("TenPhong"));
                    cca.setNgayLam(rs.getDate("NgayLam"));
                    cca.setTrangThai(rs.getString("TrangThai"));
                    cca.setLuongCoBan(rs.getBigDecimal("LuongCoBan"));
                    cca.setThucLinh(rs.getBigDecimal("ThucLinh"));
                    cca.setTongThuNhap(rs.getBigDecimal("TongThuNhap"));
                    list.add(cca);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ChamCongAdmin> searchChamCongTheoPhong(String maPhong) {
        List<ChamCongAdmin> list = new ArrayList<>();
        String sql = "SELECT c.MaCC, c.MaNV, n.HoTen, p.TenPhong, c.NgayLam, c.TrangThai, "
                + "l.LuongCoBan, l.ThucLinh, l.TongThuNhap "
                + "FROM CHAMCONG c "
                + "JOIN NHANVIEN n ON c.MaNV = n.MaNV "
                + "JOIN PHONGBAN p ON n.MaPhong = p.MaPhong "
                + "LEFT JOIN LUONG l ON n.MaNV = l.MaNV "
                + "WHERE p.MaPhong = ? "
                + "ORDER BY n.MaNV, c.NgayLam";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maPhong);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChamCongAdmin cca = new ChamCongAdmin();
                    cca.setMaCC(rs.getInt("MaCC"));
                    cca.setMaNV(rs.getString("MaNV"));
                    cca.setHoTen(rs.getString("HoTen"));
                    cca.setPhong(rs.getString("TenPhong"));
                    cca.setNgayLam(rs.getDate("NgayLam"));
                    cca.setTrangThai(rs.getString("TrangThai"));
                    cca.setLuongCoBan(rs.getBigDecimal("LuongCoBan"));
                    cca.setThucLinh(rs.getBigDecimal("ThucLinh"));
                    cca.setTongThuNhap(rs.getBigDecimal("TongThuNhap"));
                    list.add(cca);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ChamCongAdmin> searchChamCongTheoNgayVaPhong(String maPhong, Date ngay) {
        List<ChamCongAdmin> list = new ArrayList<>();
        String sql = "SELECT c.MaCC, c.MaNV, n.HoTen, p.TenPhong, c.NgayLam, c.TrangThai, "
                + "l.LuongCoBan, l.ThucLinh, l.TongThuNhap "
                + "FROM CHAMCONG c "
                + "JOIN NHANVIEN n ON c.MaNV = n.MaNV "
                + "JOIN PHONGBAN p ON n.MaPhong = p.MaPhong "
                + "LEFT JOIN LUONG l ON n.MaNV = l.MaNV "
                + "WHERE p.MaPhong = ? AND c.NgayLam = ? "
                + "ORDER BY n.MaNV";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maPhong);
            ps.setDate(2, new java.sql.Date(ngay.getTime()));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ChamCongAdmin cca = new ChamCongAdmin();
                    cca.setMaCC(rs.getInt("MaCC"));
                    cca.setMaNV(rs.getString("MaNV"));
                    cca.setHoTen(rs.getString("HoTen"));
                    cca.setPhong(rs.getString("TenPhong"));
                    cca.setNgayLam(rs.getDate("NgayLam"));
                    cca.setTrangThai(rs.getString("TrangThai"));
                    cca.setLuongCoBan(rs.getBigDecimal("LuongCoBan"));
                    cca.setThucLinh(rs.getBigDecimal("ThucLinh"));
                    cca.setTongThuNhap(rs.getBigDecimal("TongThuNhap"));
                    list.add(cca);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public int demSoNgayLamTrongThang(String maNV, java.sql.Date ngay) {
        int soCong = 0;
        String sql = "SELECT COUNT(*) FROM CHAMCONG "
                + "WHERE MaNV = ? "
                + "AND MONTH(NgayLam) = ? "
                + "AND YEAR(NgayLam) = ? "
                + "AND TrangThai = N'DaChamCong'";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            // lấy tháng và năm từ java.sql.Date
            java.util.Calendar cal = java.util.Calendar.getInstance();
            cal.setTime(ngay);
            int month = cal.get(java.util.Calendar.MONTH) + 1; // Calendar.MONTH tính từ 0
            int year = cal.get(java.util.Calendar.YEAR);

            ps.setString(1, maNV);
            ps.setInt(2, month);
            ps.setInt(3, year);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                soCong = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soCong;
    }

}

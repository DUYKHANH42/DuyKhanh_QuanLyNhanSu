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
import java.sql.Date;
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

    public NhanVien getByID(String maNV) {
        String sql = "SELECT * FROM NHANVIEN WHERE MaNV=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, maNV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new NhanVien(
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
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insert(NhanVien nv) {
        String sql = "INSERT INTO NHANVIEN(MaNV, HoTen, NgaySinh, GioiTinh, CCCD, SDT, DiaChi, NgayVaoLam, MaPhong, LuongCoBan, HinhAnh) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setDate(3, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(4, nv.getGioiTinh());
            ps.setString(5, nv.getCCCD());
            ps.setString(6, nv.getSDT());
            ps.setString(7, nv.getDiaChi());
            ps.setDate(8, new java.sql.Date(nv.getNgayVaoLam().getTime()));
            ps.setString(9, nv.getMaPhong());
            ps.setDouble(10, nv.getLuongCoBan());
            ps.setBytes(11, nv.getHinhAnh());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean insertNhanVien(String MaNV, String hoTen, String gioiTinh, String maPhong, double luongCoBan,Date NgayVao) {

        String sql = "INSERT INTO NHANVIEN(MaNV, HoTen, GioiTinh, MaPhong, LuongCoBan,NgayVaoLam) "
                + "VALUES(?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, MaNV);
            ps.setString(2, hoTen);
            ps.setString(3, gioiTinh);
            ps.setString(4, maPhong);
            ps.setDouble(5, luongCoBan); 
            ps.setDate(6,NgayVao);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(NhanVien nv) {
        String sql = "UPDATE NHANVIEN SET HoTen=?, NgaySinh=?, GioiTinh=?, CCCD=?, SDT=?, DiaChi=?, "
                + "NgayVaoLam=?, MaPhong=?, LuongCoBan=?, HinhAnh=? WHERE MaNV=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getHoTen());
            ps.setDate(2, new java.sql.Date(nv.getNgaySinh().getTime()));
            ps.setString(3, nv.getGioiTinh());
            ps.setString(4, nv.getCCCD());
            ps.setString(5, nv.getSDT());
            ps.setString(6, nv.getDiaChi());
            ps.setDate(7, new java.sql.Date(nv.getNgayVaoLam().getTime()));
            ps.setString(8, nv.getMaPhong());
            ps.setDouble(9, nv.getLuongCoBan());
            ps.setBytes(10, nv.getHinhAnh());
            ps.setString(11, nv.getMaNV());

            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean updateNhanVien(String maNV, String hoTen, String gioiTinh, String maPhong, double luongCoBan) {
        String sql = "UPDATE NHANVIEN SET HoTen=?, GioiTinh=?, MaPhong=?, LuongCoBan=? WHERE MaNV=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, hoTen);
            ps.setString(2, gioiTinh);
            ps.setString(3, maPhong);
            ps.setDouble(4, luongCoBan);
            ps.setString(5, maNV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(String maNV) {
        String sql = "DELETE FROM NHANVIEN WHERE MaNV=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, maNV);
            return ps.executeUpdate() > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<NhanVien> searchNhanVien(String keyword) {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT * FROM NHANVIEN WHERE MaNV LIKE ? OR HoTen LIKE ? OR MaPhong LIKE ?";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            String key = "%" + keyword + "%";
            ps.setString(1, key);
            ps.setString(2, key);
            ps.setString(3, key);

            ResultSet rs = ps.executeQuery();
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

}

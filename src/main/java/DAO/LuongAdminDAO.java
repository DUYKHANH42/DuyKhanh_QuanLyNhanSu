/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LuongAdmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class LuongAdminDAO {

    public List<LuongAdmin> getAllLuong(int thang, int nam) {
        List<LuongAdmin> list = new ArrayList<>();

        String sql
                = "SELECT nv.MaNV, nv.HoTen, pb.TenPhong, "
                + "ISNULL(l.LuongCoBan, nv.LuongCoBan) AS LuongCoBan,l.TongThuNhap, "
                +"ISNULL(cc.SoNgayCong, 0)AS SoNgayCong "
                + "FROM NHANVIEN nv "
                + "JOIN PHONGBAN pb ON nv.MaPhong = pb.MaPhong "
                + "LEFT JOIN LUONG l "
                + "ON l.MaNV = nv.MaNV AND l.Thang = ? AND l.Nam = ? "
                + // lọc kỳ lương
                "LEFT JOIN ( "
                + "   SELECT MaNV, COUNT(*) AS SoNgayCong "
                + "   FROM   CHAMCONG "
                + "   WHERE  MONTH(NgayLam) = ? AND YEAR(NgayLam) = ? "
                + "          AND TrangThai = N'Đã Chấm Công' "
                + // NVARCHAR → dùng N'...'
                "   GROUP BY MaNV "
                + ") cc ON cc.MaNV = nv.MaNV "
                + "ORDER BY nv.MaNV";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            int i = 1;
            ps.setInt(i++, thang);
            ps.setInt(i++, nam);
            ps.setInt(i++, thang);
            ps.setInt(i++, nam);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    LuongAdmin l = mapResultSetToLuong(rs, thang, nam);
                    list.add(l);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Tìm theo Họ tên
    public List<LuongAdmin> searchByTen(String hoTen, int thang, int nam) {
        return search(hoTen, true, false, thang, nam);
    }

    // Tìm theo Mã NV
    public List<LuongAdmin> searchByMaNV(String maNV, int thang, int nam) {
        return search(maNV, false, true, thang, nam);
    }

    // Tìm theo cả Mã NV và Họ tên
    public List<LuongAdmin> search(String keyword, int thang, int nam) {
        return search(keyword, true, true, thang, nam);
    }

    private List<LuongAdmin> search(String keyword, boolean byTen, boolean byMaNV, int thang, int nam) {
        List<LuongAdmin> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder(
                "SELECT l.MaLuong, l.MaNV, nv.HoTen, pb.TenPhong, l.Thang, l.Nam, "
                + "l.SoNgayCong, l.LuongCoBan, l.ThucLinh,l.TongThuNhap"
                + "FROM LUONG l "
                + "JOIN NhanVien nv ON l.MaNV = nv.MaNV "
                + "JOIN PhongBan pb ON nv.MaPhong = pb.MaPhong "
                + "WHERE l.Thang = ? AND l.Nam = ? "
        );

        ArrayList<String> conds = new ArrayList<>();
        if (byMaNV) {
            conds.add("l.MaNV LIKE ?");
        }
        if (byTen) {
            conds.add("nv.HoTen LIKE ?");
        }
        if (!conds.isEmpty()) {
            sql.append(" AND (").append(String.join(" OR ", conds)).append(") ");
        }

        sql.append(" ORDER BY l.MaNV");

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            int index = 1;
            ps.setInt(index++, thang);
            ps.setInt(index++, nam);
            if (byMaNV) {
                ps.setString(index++, "%" + keyword + "%");
            }
            if (byTen) {
                ps.setString(index++, "%" + keyword + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LuongAdmin l = mapResultSetToLuong(rs, thang, nam);
                list.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private LuongAdmin mapResultSetToLuong(ResultSet rs, int thang, int nam) throws SQLException {
        LuongAdmin l = new LuongAdmin();
        l.setMaNV(rs.getString("MaNV"));
        l.setHoTen(rs.getString("HoTen"));
        l.setTenPhong(rs.getString("TenPhong"));
        l.setThang(thang);
        l.setNam(nam);
        l.setLuongCoBan(rs.getBigDecimal("LuongCoBan"));

        int soNgayCongThucTe = rs.getInt("SoNgayCong");
        l.setSoNgayCong(soNgayCongThucTe);
        int soNgayChuanTrongThang = 26;
          l.setThucLinh(l.tinhThucLinh(l.getSoNgayCong(),soNgayChuanTrongThang));
          l.setTongLuong(rs.getBigDecimal("TongThuNhap"));
        return l;
    }

}

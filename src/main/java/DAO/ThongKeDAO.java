package DAO;

import util.DBConnection;
import java.sql.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class ThongKeDAO {

    // Đếm nhân viên theo phòng ban
    public Map<String, Integer> getNhanVienTheoPhong(int thang, int nam) {
        Map<String, Integer> mapNV = new LinkedHashMap<>();
        // Lấy ngày cuối tháng
        LocalDate ngayCuoiThang = YearMonth.of(nam, thang).atEndOfMonth();

        String sql = """
        SELECT pb.TenPhong, COUNT(*) AS SoNV
        FROM NHANVIEN nv
        JOIN PHONGBAN pb ON nv.MaPhong = pb.MaPhong
        WHERE nv.NgayVaoLam <= ?
        GROUP BY pb.TenPhong
        ORDER BY pb.TenPhong
    """;

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDate(1, java.sql.Date.valueOf(ngayCuoiThang));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    mapNV.put(rs.getString("TenPhong"), rs.getInt("SoNV"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapNV;
    }

    // Quỹ lương theo phòng ban (tháng, năm)
    public Map<String, BigDecimal> quyLuongTheoPhongBan(int thang, int nam) {
        Map<String, BigDecimal> rsMap = new LinkedHashMap<>();
        String sql = """
        SELECT pb.TenPhong, SUM(l.ThucLinh + ISNULL(p.TongPhuCap,0)) AS QuyLuong
        FROM (
            SELECT MaNV, Thang, Nam, SUM(ThucLinh) AS ThucLinh
            FROM LUONG
            WHERE Thang = ? AND Nam = ?
            GROUP BY MaNV, Thang, Nam
        ) l
        JOIN NHANVIEN nv ON l.MaNV = nv.MaNV
        JOIN PHONGBAN pb ON nv.MaPhong = pb.MaPhong
        LEFT JOIN (
            SELECT MaNV, Thang, Nam, SUM(SoTien) AS TongPhuCap
            FROM PHUCAP
            WHERE Thang = ? AND Nam = ?
            GROUP BY MaNV, Thang, Nam
        ) p ON l.MaNV = p.MaNV AND l.Thang = p.Thang AND l.Nam = p.Nam
        GROUP BY pb.TenPhong
        ORDER BY pb.TenPhong
    """;

        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, thang);
            ps.setInt(2, nam);
            ps.setInt(3, thang);
            ps.setInt(4, nam);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rsMap.put(rs.getString("TenPhong"), rs.getBigDecimal("QuyLuong"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsMap;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.PhongBan;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import util.DBConnection;

/**
 *
 * @author PC
 */
public class PhongBanDAO {
    public List<PhongBan> getAllPhongBan() {
        List<PhongBan> list = new ArrayList<>();
        String sql = "SELECT * FROM PHONGBAN";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new PhongBan(
                    rs.getString("MaPhong"),
                    rs.getString("TenPhong"),
                    rs.getString("MoTa")
                ));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}

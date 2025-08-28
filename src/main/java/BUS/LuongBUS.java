/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LuongDAO;

/**
 *
 * @author PC
 */
public class LuongBUS {
     private LuongDAO luongBUS= new LuongDAO();
      public double getTongLuongThucLinh(int thang, int nam)
      {
          return luongBUS.getTongLuongThucLinh(thang, nam);
      }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class Luong {
     private String maNV;
    private int thang;
    private int nam;
    private int soNgayCong;
    private double luongCoBan;
    private double thucLinh;

    public Luong(String maNV, int thang, int nam, int soNgayCong, double luongCoBan, double thucLinh) {
        this.maNV = maNV;
        this.thang = thang;
        this.nam = nam;
        this.soNgayCong = soNgayCong;
        this.luongCoBan = luongCoBan;
        this.thucLinh = thucLinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public double getThucLinh() {
        return thucLinh;
    }

    public void setThucLinh(double thucLinh) {
        this.thucLinh = thucLinh;
    }

    @Override
    public String toString() {
        return "Luong{" + "maNV=" + maNV + ", thang=" + thang + ", nam=" + nam + ", soNgayCong=" + soNgayCong + ", luongCoBan=" + luongCoBan + ", thucLinh=" + thucLinh + '}';
    }
    
}

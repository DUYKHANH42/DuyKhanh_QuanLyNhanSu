/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class PhuCap {

    private String maNV;
    private String loaiPhuCap;
    private double soTien;

    public PhuCap(String maNV, String loaiPhuCap, double soTien) {
        this.maNV = maNV;
        this.loaiPhuCap = loaiPhuCap;
        this.soTien = soTien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getLoaiPhuCap() {
        return loaiPhuCap;
    }

    public void setLoaiPhuCap(String loaiPhuCap) {
        this.loaiPhuCap = loaiPhuCap;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    @Override
    public String toString() {
        return "PhuCap{" + "maNV=" + maNV + ", loaiPhuCap=" + loaiPhuCap + ", soTien=" + soTien + '}';
    }

}

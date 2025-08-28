/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class NhanVien {

    private String maNV;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String CCCD;
    private String SDT;
    private String diaChi;
    private Date ngayVaoLam;
    private String maPhong;
    private double luongCoBan;
    private byte[] hinhAnh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, String maPhong, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.maPhong = maPhong;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien(String maNV, String hoTen, Date ngaySinh, String gioiTinh, String CCCD, String SDT, String diaChi, Date ngayVaoLam, String maPhong, double luongCoBan, byte[] hinhAnh) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.ngayVaoLam = ngayVaoLam;
        this.maPhong = maPhong;
        this.luongCoBan = luongCoBan;
        this.hinhAnh = hinhAnh;
    }

    public NhanVien(String hoTen, Date ngaySinh, String gioiTinh, String CCCD, String SDT, String diaChi, Date ngayVaoLam, String maPhong, double luongCoBan, byte[] hinhAnh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.CCCD = CCCD;
        this.SDT = SDT;
        this.diaChi = diaChi;
        this.ngayVaoLam = ngayVaoLam;
        this.maPhong = maPhong;
        this.luongCoBan = luongCoBan;
        this.hinhAnh = hinhAnh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public byte[] getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(byte[] hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", CCCD=" + CCCD + ", SDT=" + SDT + ", diaChi=" + diaChi + ", ngayVaoLam=" + ngayVaoLam + ", maPhong=" + maPhong + ", luongCoBan=" + luongCoBan + ", hinhAnh=" + hinhAnh + '}';
    }

}

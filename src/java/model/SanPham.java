/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lebac
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private int namXuatBan;
    private double giaNhap;
    private double giaBan;
    private double giaGoc;
    private int soLuong;
    private String ngonNgu;
    private String moTa;
    private TacGia tacGia;
    private TheLoai theLoai;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, int namXuatBan, double giaNhap, double giaBan, double giaGoc, int soLuong, String ngonNgu, String moTa, TacGia tacGia, TheLoai theLoai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.namXuatBan = namXuatBan;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.giaGoc = giaGoc;
        this.soLuong = soLuong;
        this.ngonNgu = ngonNgu;
        this.moTa = moTa;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(double giaGoc) {
        this.giaGoc = giaGoc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", namXuatBan=" + namXuatBan + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", giaGoc=" + giaGoc + ", soLuong=" + soLuong + ", ngonNgu=" + ngonNgu + ", moTa=" + moTa + ", tacGia=" + tacGia + ", theLoai=" + theLoai + '}';
    }

    
    
}






























/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;



/**
 *
 * @author lebac
 */
public class KhachHang {
    private String maKhachHang;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String diaChi;
    private String diaChiNhanHang;
    private String diaChiMuaHang;
    private Date dob;
    private String soDienThoai;
    private String email;
    private boolean dangKyNhanBanTinEmail;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String username, String password, String name, String gender, String diaChi, String diaChiNhanHang, String diaChiMuaHang, Date dob, String soDienThoai, String email, boolean dangKyNhanBanTinEmail) {
        this.maKhachHang = maKhachHang;
        this.username = username;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.diaChi = diaChi;
        this.diaChiNhanHang = diaChiNhanHang;
        this.diaChiMuaHang = diaChiMuaHang;
        this.dob = dob;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getDiaChiMuaHang() {
        return diaChiMuaHang;
    }

    public void setDiaChiMuaHang(String diaChiMuaHang) {
        this.diaChiMuaHang = diaChiMuaHang;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDangKyNhanBanTinEmail() {
        return dangKyNhanBanTinEmail;
    }

    public void setDangKyNhanBanTinEmail(boolean dangKyNhanBanTinEmail) {
        this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", username=" + username + ", password=" + password + ", name=" + name + ", gender=" + gender + ", diaChi=" + diaChi + ", diaChiNhanHang=" + diaChiNhanHang + ", diaChiMuaHang=" + diaChiMuaHang + ", dob=" + dob + ", soDienThoai=" + soDienThoai + ", email=" + email + ", dangKyNhanBanTinEmail=" + dangKyNhanBanTinEmail + '}';
    }
    
}

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
public class DonHang {
    private String maDonHang;
    private KhachHang khachHang; // Tham chiếu đến lớp KhachHang
    private String diaChiNguoiMua;
    private String diaChiNhanHang;
    private String trangThai; // Trạng thái đơn hàng: mới tạo, đang xử lý, đang giao hàng, đã giao hàng, trả hàng
    private String hinhThucThanhToan; // Hình thức thanh toán (thẻ, tiền mặt, COD, v.v.)
    private String trangThaiThanhToan; // Đã thanh toán hay chưa
    private double soTienDaThanhToan;
    private double soTienConThieu;
    private Date ngayDatHang; // Ngày đặt hàng
    private Date ngayGiaoHang; // Ngày dự kiến giao hàng

    public DonHang() {
    }

    public DonHang(String maDonHang, KhachHang khachHang, String diaChiNguoiMua, String diaChiNhanHang, String trangThai, String hinhThucThanhToan, String trangThaiThanhToan, double soTienDaThanhToan, double soTienConThieu, Date ngayDatHang, Date ngayGiaoHang) {
        this.maDonHang = maDonHang;
        this.khachHang = khachHang;
        this.diaChiNguoiMua = diaChiNguoiMua;
        this.diaChiNhanHang = diaChiNhanHang;
        this.trangThai = trangThai;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.trangThaiThanhToan = trangThaiThanhToan;
        this.soTienDaThanhToan = soTienDaThanhToan;
        this.soTienConThieu = soTienConThieu;
        this.ngayDatHang = ngayDatHang;
        this.ngayGiaoHang = ngayGiaoHang;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getDiaChiNguoiMua() {
        return diaChiNguoiMua;
    }

    public void setDiaChiNguoiMua(String diaChiNguoiMua) {
        this.diaChiNguoiMua = diaChiNguoiMua;
    }

    public String getDiaChiNhanHang() {
        return diaChiNhanHang;
    }

    public void setDiaChiNhanHang(String diaChiNhanHang) {
        this.diaChiNhanHang = diaChiNhanHang;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    public double getSoTienDaThanhToan() {
        return soTienDaThanhToan;
    }

    public void setSoTienDaThanhToan(double soTienDaThanhToan) {
        this.soTienDaThanhToan = soTienDaThanhToan;
    }

    public double getSoTienConThieu() {
        return soTienConThieu;
    }

    public void setSoTienConThieu(double soTienConThieu) {
        this.soTienConThieu = soTienConThieu;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public Date getNgayGiaoHang() {
        return ngayGiaoHang;
    }

    public void setNgayGiaoHang(Date ngayGiaoHang) {
        this.ngayGiaoHang = ngayGiaoHang;
    }

    @Override
    public String toString() {
        return "DonHang{" + "maDonHang=" + maDonHang + ", khachHang=" + khachHang + ", diaChiNguoiMua=" + diaChiNguoiMua + ", diaChiNhanHang=" + diaChiNhanHang + ", trangThai=" + trangThai + ", hinhThucThanhToan=" + hinhThucThanhToan + ", trangThaiThanhToan=" + trangThaiThanhToan + ", soTienDaThanhToan=" + soTienDaThanhToan + ", soTienConThieu=" + soTienConThieu + ", ngayDatHang=" + ngayDatHang + ", ngayGiaoHang=" + ngayGiaoHang + '}';
    }

    
    
    
}

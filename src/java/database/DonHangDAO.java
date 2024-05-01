/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DonHang;
import model.KhachHang;

/**
 *
 * @author lebac
 */
public class DonHangDAO implements DAOInterface<DonHang> {

//    private ArrayList<DonHang> data = new ArrayList<>();

    @Override
    public ArrayList<DonHang> selectAll() {
         ArrayList<DonHang> ketQua = new ArrayList<DonHang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM donhang";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maDonHang = rs.getString("ma_don_hang");
                String maKhachHang = rs.getString("ma_khach_hang");
                String diaChiNguoiMua = rs.getString("dia_chi_mua_hang");
                String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
                String trangThai = rs.getString("trang_thai");
                String hinhThucThanhToan = rs.getString("hinh_thuc_thanh_toan");
                String trangThaiThanhToan = rs.getString("trang_thai_thanh_toan");
                Double soTienThanhToan = rs.getDouble("so_tien_thanh_toan");
                Double soTienConThieu = rs.getDouble("so_tien_con_thieu");
                Date ngayDatHang = rs.getDate("ngay_dat_hang");
                Date ngayGiaoHang = rs.getDate("ngay_giao_hang");
                
                KhachHang kh = new KhachHangDAO().selectById(new KhachHang(maKhachHang, null, null, null, null, null, null, null, null, null, null, true));
                DonHang dh = new DonHang(maDonHang, kh, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, 0, 0, ngayDatHang, ngayGiaoHang);
                ketQua.add(dh);
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        return this.data;
    }

    @Override
    public DonHang selectById(DonHang t) {
        DonHang ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM donhang where ma_don_hang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaDonHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maDonHang = rs.getString("ma_don_hang");
                String maKhachHang = rs.getString("ma_khach_hang");
                String diaChiNguoiMua = rs.getString("dia_chi_mua_hang");
                String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
                String trangThai = rs.getString("trang_thai");
                String hinhThucThanhToan = rs.getString("hinh_thuc_thanh_toan");
                String trangThaiThanhToan = rs.getString("trang_thai_thanh_toan");
                Double soTienThanhToan = rs.getDouble("so_tien_thanh_toan");
                Double soTienConThieu = rs.getDouble("so_tien_con_thieu");
                Date ngayDatHang = rs.getDate("ngay_dat_hang");
                Date ngayGiaoHang = rs.getDate("ngay_giao_hang");
                
                KhachHang kh = new KhachHangDAO().selectById(new KhachHang(maKhachHang, null, null, null, null, null, null, null, null, null, null, true));
                DonHang dh = new DonHang(maDonHang, kh, diaChiNguoiMua, diaChiNhanHang, trangThai, hinhThucThanhToan, trangThaiThanhToan, 0, 0, ngayDatHang, ngayGiaoHang);
                ketQua = dh;
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        for (DonHang DonHang : data) {
//            if (data.equals(t)) {
//                return DonHang;
//            }
//        }
//        return null;
    }

    @Override
    public int insert(DonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO donhang (ma_don_hang, ma_khach_hang, dia_chi_mua_hang, dia_chi_nhan_hang, gender, trang_thai, hinh_thuc_thanh_toan, trang_thai_thanh_toan, so_tien_thanh_toan, so_tien_con_thieu, ngay_dat_hang, ngay_giao_hang) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaDonHang());
            st.setString(2, t.getKhachHang().getMaKhachHang());
            st.setString(3, t.getDiaChiNguoiMua());
            st.setString(4, t.getDiaChiNhanHang());
            st.setString(5, t.getTrangThai());
            st.setString(6, t.getHinhThucThanhToan());
            st.setString(7, t.getTrangThaiThanhToan());
            st.setDouble(8, t.getSoTienDaThanhToan());
            st.setDouble(9, t.getSoTienConThieu());
            st.setDate(10, t.getNgayDatHang());
            st.setDate(11, t.getNgayGiaoHang());
            // Bước 3: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println(sql);
//            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        if (this.selectById(t) == null) {
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
    }

    @Override
    public int insertAll(ArrayList<DonHang> arr) {
        int dem = 0;
        for (DonHang DonHang : arr) {
            dem += this.insert(DonHang);
        }
        return dem;
    }

    @Override
    public int delete(DonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from donhang where ma_don_hang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaDonHang());

            // Bước 3: thực thi câu lệnh SQL
            ketQua = st.executeUpdate();

            // Bước 4:
            System.out.println(sql);
//            System.out.println("Có " + ketQua + " dòng bị thay đổi!");

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        if (this.selectById(t) != null) {
//            // xóa chi tiết đơn hàng
//            ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
//            ctdh.deleteAll(t);
//            // xóa đơn hàng
//            this.data.remove(t);
//            return 1;
//        }
//        return 0;
    }

    @Override
    public int deleteAll(ArrayList<DonHang> arr) {
        int dem = 0;
        for (DonHang DonHang : arr) {
            dem += this.delete(DonHang);
        }
        return dem;
    }

    @Override
    public int update(DonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE donhang "
                    + " SET "
                    + " ma_khach_hang=?"
                    + ", dia_chi_mua_hang=?"
                    + ", dia_chi_nhan_hang=?"
                    + ", trang_thai=?"
                    + ", hinh_thuc_thanh_toan=?"
                    + ", trang_thai_thanh_toan=?"
                    + ", so_tien_thanh_toan=?"
                    + ", so_tien_con_thieu=?"
                    + ", ngay_dat_hang=?"
                    + ", ngay_giao_hàng=?"
                    + " WHERE ma_don_hang=?";

            PreparedStatement st = con.prepareStatement(sql);
            
           
            st.setString(1, t.getKhachHang().getMaKhachHang());
            st.setString(2, t.getDiaChiNguoiMua());
            st.setString(3, t.getDiaChiNhanHang());
            st.setString(4, t.getTrangThai());
            st.setString(5, t.getHinhThucThanhToan());
            st.setString(6, t.getTrangThaiThanhToan());
            st.setDouble(7, t.getSoTienDaThanhToan());
            st.setDouble(8, t.getSoTienConThieu());
            st.setDate(9, t.getNgayDatHang());
            st.setDate(10, t.getNgayGiaoHang());
            st.setString(11, t.getMaDonHang());
            // Bước 3: thực thi câu lệnh SQL

            System.out.println(sql);
            ketQua = st.executeUpdate();

            // Bước 4:
//			System.out.println(sql);
//			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        if (this.selectById(t) != null) {
//            this.data.remove(t);
//            this.data.add(t);
//            return 1;
//        }
//        return 0;
    }
    public static void main(String[] args) {
        DonHangDAO dhd = new DonHangDAO();
        ArrayList<DonHang> kq = dhd.selectAll();
        for (DonHang donHang : kq) {
            System.out.println(donHang.toString());
        }
        DonHang dh = dhd.selectById(new DonHang("01", null, null, null, null, null, null, 0, 0, null, null));
        System.out.println(dh);
    }

//    public ArrayList<DonHang> selectAll() {
//        return data;
//    }
//    
//    public DonHang selectById(String id) {
//        DonHang tim = new DonHang();
//        tim.setMaDonHang(id);
//        for(DonHang donHang : data) {
//            if(donHang.equals(tim)){
//                return donHang;
//            }
//        }
//        return null;
//    }
//    
//    public int insert(DonHang dh) {
//        DonHang kiemTraTonTai = this.selectById(dh.getMaDonHang());
//        if(kiemTraTonTai == null) {
//            data.add(dh);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
//    public int insertAll(ArrayList<DonHang> list) {
//        int dem = 0;
//        for(DonHang donHang: list) {
//            dem += this.insert(donHang);
//        }
//        return dem;
//    }
//    
//    public int delete(DonHang dh) {
//        DonHang kiemTraTonTai = this.selectById(dh.getMaDonHang());
//        if(kiemTraTonTai == null) {
//            //Xóa chi tiết đơn hàng
//            ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
//            ctdh.deleteAll(dh);
//            //Xóa đơn hàng
//            data.remove(dh);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
//    public int deleteAll(ArrayList<DonHang> list) {
//        int dem = 0;
//        ChiTietDonHangDAO ctdh = new ChiTietDonHangDAO();
//        for(DonHang donHang: list) {
//            ctdh.deleteAll(donHang);
//            dem += this.delete(donHang);
//        }
//        return dem;
//    }
//    
//    public int update(DonHang dh) {
//        DonHang kiemTraTonTai = this.selectById(dh.getMaDonHang());
//        if(kiemTraTonTai == null) {
//            data.remove(kiemTraTonTai);
//            data.add(dh);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
}

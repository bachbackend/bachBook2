/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import model.KhachHang;

/**
 *
 * @author lebac
 */
public class KhachHangDAO implements DAOInterface<KhachHang> {

//    private ArrayList<KhachHang> data = new ArrayList<KhachHang>();
    @Override
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maKhachHang = rs.getString("ma_khach_hang");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String diaChi = rs.getString("dia_chi");
                String diaChiGiaoHang = rs.getString("dia_chi_giao_hang");
                String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
                Date dob = rs.getDate("dob");
                String soDienThoai = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkynhanbantinemail");

                KhachHang kh = new KhachHang(maKhachHang, username, password, name, gender, diaChi, diaChiGiaoHang, diaChiNhanHang, dob, soDienThoai, email, dangKyNhanBanTinEmail);
                ketQua.add(kh);
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
    public KhachHang selectById(KhachHang t) {
        KhachHang ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang WHERE ma_khach_hang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maKhachHang = rs.getString("ma_khach_hang");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String diaChi = rs.getString("dia_chi");
                String diaChiGiaoHang = rs.getString("dia_chi_giao_hang");
                String diaChiNhanHang = rs.getString("dia_chi_nhan_hang");
                Date dob = rs.getDate("dob");
                String soDienThoai = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkynhanbantinemail");

                ketQua = new KhachHang(maKhachHang, username, password, name, gender, diaChi, diaChiGiaoHang, diaChiNhanHang, dob, soDienThoai, email, dangKyNhanBanTinEmail);
                break;
            }
            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        for (KhachHang KhachHang : data) {
//            if (data.equals(t)) {
//                return KhachHang;
//            }
//        }
//        return null;
    }

    public boolean kiemTraUsername(String username) {
        boolean ketQua = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM khachhang WHERE username=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, username);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                ketQua = true;
            }
            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int insert(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO khachhang (ma_khach_hang, username, password, name, gender, dia_chi, dia_chi_giao_hang, dia_chi_nhan_hang, dob, so_dien_thoai, email, dangkynhanbantinemail) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());
            st.setString(2, t.getUsername());
            st.setString(3, t.getPassword());
            st.setString(4, t.getName());
            st.setString(5, t.getGender());
            st.setString(6, t.getDiaChi());
            st.setString(7, t.getDiaChiMuaHang());
            st.setString(8, t.getDiaChiNhanHang());
            st.setDate(9, t.getDob());
            st.setString(10, t.getSoDienThoai());
            st.setString(11, t.getEmail());
            st.setBoolean(12, t.isDangKyNhanBanTinEmail());
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
    public int insertAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem += this.insert(KhachHang);
        }
        return dem;
    }

    @Override
    public int delete(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from tacgia where ma_khach_hang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaKhachHang());

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
//            this.data.remove(t);
//            return 1;
//        }
//        return 0;
    }

    @Override
    public int deleteAll(ArrayList<KhachHang> arr) {
        int dem = 0;
        for (KhachHang KhachHang : arr) {
            dem += this.delete(KhachHang);
        }
        return dem;
    }

    @Override
    public int update(KhachHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE khachhang "
                    + " SET "
                    + " username=?"
                    + ", password=?"
                    + ", name=?"
                    + ", gender=?"
                    + ", dia_chi=?"
                    + ", dia_chi_giao_hang=?"
                    + ", dia_chi_nhan_hang=?"
                    + ", dob=?"
                    + ", so_dien_thoai=?"
                    + ", email=?"
                    + ", dangkynhanbantinemail=?"
                    + " WHERE ma_khach_hang=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, t.getUsername());
            st.setString(2, t.getPassword());
            st.setString(3, t.getName());
            st.setString(4, t.getGender());
            st.setString(5, t.getDiaChi());
            st.setString(6, t.getDiaChiMuaHang());
            st.setString(7, t.getDiaChiNhanHang());
            st.setDate(8, t.getDob());
            st.setString(9, t.getSoDienThoai());
            st.setString(10, t.getEmail());
            st.setBoolean(11, t.isDangKyNhanBanTinEmail());
            st.setString(12, t.getMaKhachHang());
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
        KhachHangDAO khd = new KhachHangDAO();
//        ArrayList<KhachHang> kq = khd.selectAll();
//        for (KhachHang khachHang : kq) {
//            System.out.println(khachHang.toString());
//        }

        boolean kh = khd.kiemTraUsername("bachle1");
        System.out.println(kh);

        KhachHang kh_new = new KhachHang("02", "toilabach", "123", "tung", "Nam", "Hanoi", "Hanoi", "Hanoi", null, null, null, false);
        khd.insert(kh_new);

    }
//    public ArrayList<KhachHang> selectAll() {
//        return data;
//    }
//
//    public KhachHang selectById(String id) {
//        KhachHang tim = new KhachHang();
//        tim.setMaKhachHang(id);
//        for (KhachHang khachHang : data) {
//            if (khachHang.equals(tim)) {
//                return khachHang;
//            }
//        }
//        return null;
//    }
//
//    public int insert(KhachHang khachHang) {
//        KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhachHang());
//        if (kiemTraTonTai == null) {
//            data.add(khachHang);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public int insertAll(ArrayList<KhachHang> list) {
//        int dem = 0;
//        for (KhachHang khachHang : list) {
//            dem += this.insert(khachHang);
//        }
//        return dem;
//    }
//
//    public int delete(KhachHang khachHang) {
//        KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhachHang());
//        if (kiemTraTonTai != null) {
//            data.remove(khachHang);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public int deleteAll(ArrayList<KhachHang> list) {
//        int dem = 0;
//        for (KhachHang khachHang : list) {
//            KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhachHang());
//            if (kiemTraTonTai != null) {
//                data.remove(khachHang);
//                dem++;
//            }
//        }
//        return dem;
//    }
//
//    public int update(KhachHang khachHang) {
//        KhachHang kiemTraTonTai = this.selectById(khachHang.getMaKhachHang());
//        if (kiemTraTonTai != null) {
//            data.remove(kiemTraTonTai);
//            data.add(khachHang);
//            return 1;
//        } else {
//            return 0;
//        }
//    }

}

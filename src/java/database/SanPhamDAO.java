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
import model.SanPham;
import model.TacGia;
import model.TheLoai;

/**
 *
 * @author lebac
 */
public class SanPhamDAO implements DAOInterface<SanPham> {

//    private ArrayList<SanPham> data = new ArrayList<SanPham>();
    @Override
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> ketQua = new ArrayList<SanPham>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maSanPham = rs.getString("ma_san_pham");
                String tenSanPham = rs.getString("ten_san_pham");
                String maTacGia = rs.getString("ma_tac_gia");
                int namXuatBan = rs.getInt("nam_xuat_ban");
                double giaNhap = rs.getDouble("gia_nhap");
                double giaGoc = rs.getDouble("gia_goc");
                double giaBan = rs.getDouble("gia_ban");
                int soLuong = (int) rs.getDouble("so_luong");
                String maTheLoai = rs.getString("ma_the_loai");
                String ngonNgu = rs.getString("ngon_ngu");
                String moTa = rs.getString("mo_ta");

                TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
                TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));

//				SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong, theLoai, ngonngu, mota);
                SanPham sp = new SanPham(maSanPham, tenSanPham, namXuatBan, giaNhap, giaBan, giaGoc, soLuong, ngonNgu, moTa, tacGia, theLoai);
                ketQua.add(sp);
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
    public SanPham selectById(SanPham t) {
        SanPham ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM sanpham where ma_san_pham=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maSanPham = rs.getString("ma_san_pham");
                String tenSanPham = rs.getString("ten_san_pham");
                String maTacGia = rs.getString("ma_tac_gia");
                int namXuatBan = rs.getInt("nam_xuat_ban");
                double giaNhap = rs.getDouble("gia_nhap");
                double giaGoc = rs.getDouble("gia_goc");
                double giaBan = rs.getDouble("gia_ban");
                int soLuong = (int) rs.getDouble("so_luong");
                String maTheLoai = rs.getString("ma_the_loai");
                String ngonNgu = rs.getString("ngon_ngu");
                String moTa = rs.getString("mo_ta");

                TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
                TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));

//				SanPham sp = new SanPham(masanpham, tensanpham, tacGia, namxuatban, gianhap, giagoc, giaban, soluong, theLoai, ngonngu, mota);
                ketQua = new SanPham(maSanPham, tenSanPham, namXuatBan, giaNhap, giaBan, giaGoc, soLuong, ngonNgu, moTa, tacGia, theLoai);
                break;
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;

//        for (SanPham SanPham : data) {
//            if (data.equals(t)) {
//                return SanPham;
//            }
//        }
//        return null;
    }

    @Override
    public int insert(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO sanpham (ma_san_pham, ten_san_pham, ma_tac_gia, nam_xuat_ban, gia_nhap, gia_goc, gia_ban, so_luong, ma_the_loai, ngon_ngu, mo_ta) "
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());
            st.setString(2, t.getTenSanPham());
            st.setString(3, t.getTacGia().getMaTacGia());
            st.setInt(4, t.getNamXuatBan());
            st.setDouble(5, t.getGiaNhap());
            st.setDouble(6, t.getGiaGoc());
            st.setDouble(7, t.getGiaBan());
            st.setInt(8, t.getSoLuong());
            st.setString(9, t.getTheLoai().getMaTheLoai());
            st.setString(10, t.getNgonNgu());
            st.setString(11, t.getMoTa());

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
    public int insertAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (SanPham SanPham : arr) {
            dem += this.insert(SanPham);
        }
        return dem;
    }

    @Override
    public int delete(SanPham t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from sanpham where ma_san_pham=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaSanPham());

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
    public int deleteAll(ArrayList<SanPham> arr) {
        int dem = 0;
        for (SanPham SanPham : arr) {
            dem += this.delete(SanPham);
        }
        return dem;
    }

    @Override
    public int update(SanPham t) {
        int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE sanpham " + " SET " + "ten_san_pham=?, ma_tac_gia=?, nam_xuat_ban=?, gia_nhap=?, gia_goc=?, "
					+ "gia_ban=?, so_luong=?, ma_the_loai=?, ngon_ngu=?, mo_ta=?" + " WHERE ma_san_pham=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenSanPham());
			st.setString(2, t.getTacGia().getMaTacGia());
			st.setInt(3, t.getNamXuatBan());
			st.setDouble(4, t.getGiaNhap());
			st.setDouble(5, t.getGiaGoc());
			st.setDouble(6, t.getGiaBan());
			st.setInt(7, t.getSoLuong());
			st.setString(8, t.getTheLoai().getMaTheLoai());
			st.setString(9, t.getNgonNgu());
			st.setString(10, t.getMoTa());
			st.setString(11, t.getMaSanPham());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
//			System.out.println("Bạn đã thực thi: " + sql);
//			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

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
        SanPhamDAO spd = new SanPhamDAO();
        ArrayList<SanPham> kq = spd.selectAll();
        for (SanPham sanPham : kq) {
            System.out.println(sanPham.toString());
        }

//        SanPham sp = spd.selectById(new SanPham("002", null, 0, 0, 0, 0, 0, null, null, new TacGia(null, null, null, null), new TheLoai(null, null)));
        SanPham sp = spd.selectById(new SanPham("002", null, 0, 0, 0, 0, 0, null, null, null, null));
        System.out.println(sp);
        sp.setTenSanPham("Cuộc đời Cristiano Ronaldo-1 người không có wc");
        sp.setNgonNgu("tiếng hàn");
        sp.setMoTa("đến h vẫn không có wc");
        spd.update(sp);
//        SanPham sp_new = new SanPham("003", "tung va to anh", 0, 0, 0, 0, 0, "tieng viet", null, new TacGia("002", null, null, null), new TheLoai("003", null));
//        spd.insert(sp_new);
//        spd.delete(sp_new);
    }

//    public ArrayList<SanPham> selectAll() {
//        return data;
//    }
//    
//    public SanPham selectById(String id) {
//        SanPham tim = new SanPham();
//        tim.setMaSanPham(id);
//        for(SanPham sanPham : data) {
//            if(sanPham.equals(tim)){
//                return sanPham;
//            }
//        }
//        return null;
//    }
//    
//    public int insert(SanPham sp) {
//        SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
//        if(kiemTraTonTai == null) {
//            data.add(sp);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
//    public int insertAll(ArrayList<SanPham> list) {
//        int dem = 0;
//        for(SanPham sanPham: list) {
//            dem += this.insert(sanPham);
//        }
//        return dem;
//    }
//    
//    public int delete(SanPham sp) {
//        SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
//        if(kiemTraTonTai == null) {
//            data.remove(sp);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
////    public int deleteAll(ArrayList<SanPham> list) {
////        int dem = 0;
////        for(SanPham sanPham: list) {
////            dem += this.delete(sanPham);
////        }
////        return dem;
////    }
//    
//    public int deleteAll(ArrayList<SanPham> list) {
//        int dem = 0;
//        for (SanPham sanPham : list) {
//            SanPham check = this.selectById(sanPham.getMaSanPham());
//            if (check != null) {
//                dem += this.delete(sanPham);
//            }
//        }
//        return dem;
//    }
//    
//    public int update(SanPham sp) {
//        SanPham kiemTraTonTai = this.selectById(sp.getMaSanPham());
//        if(kiemTraTonTai == null) {
//            data.remove(kiemTraTonTai);
//            data.add(sp);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
}

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
import model.TheLoai;

/**
 *
 * @author lebac
 */
public class TheLoaiDAO implements DAOInterface<TheLoai> {

//    private ArrayList<TheLoai> data = new ArrayList<>();
    @Override
    public ArrayList<TheLoai> selectAll() {
        ArrayList<TheLoai> ketQua = new ArrayList<TheLoai>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM theloai";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTheLoai = rs.getString("ma_the_loai");
                String tenTheLoai = rs.getString("ten_the_loai");

                TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
                ketQua.add(tl);
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
    public TheLoai selectById(TheLoai t) {
        TheLoai ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM theloai WHERE ma_the_loai=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTheLoai());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTheLoai = rs.getString("ma_the_loai");
                String tenTheLoai = rs.getString("ten_the_loai");
                ketQua = new TheLoai(maTheLoai, tenTheLoai);
                break;
            }
            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        for (TheLoai TheLoai : data) {
//            if (data.equals(t)) {
//                return TheLoai;
//            }
//        }
//        return null;
    }

    @Override
    public int insert(TheLoai t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO theloai (ma_the_loai, ten_the_loai) "
                    + " VALUES (?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTheLoai());
            st.setString(2, t.getTenTheLoai());

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
    public int insertAll(ArrayList<TheLoai> arr) {
        int dem = 0;
        for (TheLoai TheLoai : arr) {
            dem += this.insert(TheLoai);
        }
        return dem;
    }

    @Override
    public int delete(TheLoai t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from theloai where ma_the_loai=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTheLoai());

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
    public int deleteAll(ArrayList<TheLoai> arr) {
        int dem = 0;
        for (TheLoai TheLoai : arr) {
            dem += this.delete(TheLoai);
        }
        return dem;
    }

    @Override
    public int update(TheLoai t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE theloai "
                    + " SET "
                    + " ten_the_loai=?"
                    + " WHERE ma_the_loai=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getTenTheLoai());
            st.setString(2, t.getMaTheLoai());
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
        TheLoaiDAO tld = new TheLoaiDAO();
        
        TheLoai tl = tld.selectById(new TheLoai("002", ""));
        System.out.println(tl);
        tl.setTenTheLoai("sach giao khoa lop 1");
        tld.update(tl);
        
        ArrayList<TheLoai> kq = tld.selectAll();
        for (TheLoai theLoai : kq) {
            System.out.println(theLoai.toString());
        }
        
        
        
//        TheLoai tl_new = new TheLoai("003", "trinh thám");
//        tld.insert(tl_new);
        
//        TheLoai tl_new1 = new TheLoai("003", "");
//        tld.delete(tl_new1);
//        
//        TheLoai tl = tld.selectById(new TheLoai("003", ""));
//        System.out.println(tl);

    }

//    private ArrayList<TheLoai> data = new ArrayList<>();
//
//    public ArrayList<TheLoai> selectAll() {
//        return data;
//    }
//
//    public TheLoai selectById(String id) {
//        TheLoai tim = new TheLoai();
//        tim.setMaTheLoai(id);
//        for (TheLoai theLoai : data) {
//            if (theLoai.equals(tim)) {
//                return theLoai;
//            }
//        }
//        return null;
//    }
//
//    public int insert(TheLoai tl) {
//        TheLoai kiemTraTonTai = this.selectById(tl.getMaTheLoai());
//        if (kiemTraTonTai == null) {
//            data.add(tl);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public int insertAll(ArrayList<TheLoai> list) {
//        int dem = 0;
//        for (TheLoai theLoai : list) {
//            dem += this.insert(theLoai);
//        }
//        return dem;
//    }
//
//    public int delete(TheLoai tl) {
//        TheLoai kiemTraTonTai = this.selectById(tl.getMaTheLoai());
//        if (kiemTraTonTai == null) {
//            data.remove(tl);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public int deleteAll(ArrayList<TheLoai> list) {
//		int dem = 0;
//		for (TheLoai theLoai : list) {
//			TheLoai check = this.selectById(theLoai.getMaTheLoai());
//			if (check != null) {
//				dem += this.delete(theLoai);
//			}
//		}
//		return dem;
//	}
//
//    public int update(TheLoai tl) {
//        TheLoai kiemTraTonTai = this.selectById(tl.getMaTheLoai());
//        if (kiemTraTonTai == null) {
//            data.remove(kiemTraTonTai);
//            data.add(tl);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
}

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
import model.TacGia;

/**
 *
 * @author lebac
 */
public class TacGiaDAO implements DAOInterface<TacGia> {

//    private ArrayList<TacGia> data = new ArrayList<>();
    @Override
    public ArrayList<TacGia> selectAll() {
//        return this.data;
        ArrayList<TacGia> ketQua = new ArrayList<TacGia>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM tacgia";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTacGia = rs.getString("ma_tac_gia");
                String hoVaTen = rs.getString("ho_va_ten");
                Date ngaySinh = rs.getDate("dob");
                String tieuSu = rs.getString("tieu_su");

                TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
                ketQua.add(tg);
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
    public TacGia selectById(TacGia t) {
//        for (TacGia tacGia : data) {
//            if (data.equals(t)) {
//                return tacGia;
//            }
//        }
//        return null;
        TacGia ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM tacgia WHERE ma_tac_gia=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maTacGia = rs.getString("ma_tac_gia");
                String hoVaTen = rs.getString("ho_va_ten");
                Date ngaySinh = rs.getDate("dob");
                String tieuSu = rs.getString("tieu_su");

                ketQua = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
                break;
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
    public int insert(TacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO tacgia (ma_tac_gia, ho_va_ten, dob, tieu_su) "
                    + " VALUES (?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());
            st.setString(2, t.getName());
            st.setDate(3, t.getDob());
            st.setString(4, t.getTieuSu());

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
    public int insertAll(ArrayList<TacGia> arr) {
        int dem = 0;
        for (TacGia tacGia : arr) {
            dem += this.insert(tacGia);
        }
        return dem;
    }

    @Override
    public int delete(TacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from tacgia where ma_tac_gia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaTacGia());

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
    public int deleteAll(ArrayList<TacGia> arr) {
        int dem = 0;
        for (TacGia tacGia : arr) {
            dem += this.delete(tacGia);
        }
        return dem;
    }

    @Override
    public int update(TacGia t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE tacgia "
                    + " SET "
                    + " ho_va_ten=?"
                    + ", dob=?"
                    + ", tieu_su=?"
                    + " WHERE ma_tac_gia=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getName());
            st.setDate(2, t.getDob());
            st.setString(3, t.getTieuSu());
            st.setString(4, t.getMaTacGia());
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
        TacGiaDAO tgd = new TacGiaDAO();
//        ArrayList<TacGia> kq = tgd.selectAll();
//        for (TacGia tacGia : kq) {
//            System.out.println(tacGia.toString());
//        }
//        TacGia tg = tgd.selectById(new TacGia("001", "", null, ""));
//        System.out.println(tg);

        TacGia tg_new = new TacGia("005", "me", new Date(1978-1900, 11-1, 04), "nau an ngon"); //phải trừ đi 1900 và 1 vì bị lỗi thời gian
        tgd.insert(tg_new);
//        TacGia tg_new = new TacGia("007", "cris roanldo", new Date(1985-1900, 02-1, 05), "toi ko co WC");
//        tgd.delete(tg_new);
//        TacGia tg = tgd.selectById(new TacGia("002", "", null, ""));
//        System.out.println(tg);
//        tg.setTieuSu("tung yeu to anh");
//        tgd.update(tg);

    }
//------------------------------------------------------------
//    public ArrayList<TacGia> selectAll() {
//        return data;
//    }
//
//    public TacGia selectById(String id) {
//        TacGia tim = new TacGia();
//        tim.setMaTacGia(id);
//        for (TacGia tacGia : data) {
//            if (tacGia.equals(tim)) {
//                return tacGia;
//            }
//        }
//        return null;
//    }
//
//    public int insert(TacGia tg) {
//        TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
//        if (kiemTraTonTai == null) {
//            data.add(tg);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public int insertAll(ArrayList<TacGia> list) {
//        int dem = 0;
//        for (TacGia tacGia : list) {
//            dem += this.insert(tacGia);
//        }
//        return dem;
//    }
//
//    public int delete(TacGia tg) {
//        TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
//        if (kiemTraTonTai == null) {
//            data.remove(tg);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//
//    public int deleteAll(ArrayList<TacGia> list) {
//        int dem = 0;
//        for (TacGia tacGia : list) {
//            TacGia check = this.selectById(tacGia.getMaTacGia());
//            if (check != null) {
//                dem += this.delete(tacGia);
//            }
//        }
//        return dem;
//    }
//
//    public int update(TacGia tg) {
//        TacGia kiemTraTonTai = this.selectById(tg.getMaTacGia());
//        if (kiemTraTonTai == null) {
//            data.remove(kiemTraTonTai);
//            data.add(tg);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
}

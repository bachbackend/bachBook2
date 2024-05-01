package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;

/**
 *
 * @author lebac
 */
public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang> {

//    private ArrayList<ChiTietDonHang> data = new ArrayList<>();
    @Override
    public ArrayList<ChiTietDonHang> selectAll() {
        ArrayList<ChiTietDonHang> ketQua = new ArrayList<ChiTietDonHang>();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM chitietdonhang";
            PreparedStatement st = con.prepareStatement(sql);

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maChiTietDonHang = rs.getString("ma_chi_tiet_don_hang");
                String maDonHang = rs.getString("ma_don_hang");
                String maSanPham = rs.getString("ma_san_pham");
                Double soLuong = rs.getDouble("so_luong");
                Double giaGoc = rs.getDouble("gia_goc");
                Double giamGia = rs.getDouble("giam_gia");
                Double giaBan = rs.getDouble("gia_ban");
                Double thueVAT = rs.getDouble("thue_vat");
                Double tongTien = rs.getDouble("tong_tien");

                DonHang dh = new DonHangDAO().selectById(new DonHang(maDonHang, null, null, null, null, null, null, 0, 0, null, null));
                SanPham sp = new SanPhamDAO().selectById(new SanPham(maSanPham, null, 0, 0, 0, 0, 0, null, null, null, null));
                
                ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, dh, sp, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien);
                ketQua.add(ctdh);
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
    public ChiTietDonHang selectById(ChiTietDonHang t) {
        ChiTietDonHang ketQua = null;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT * FROM chitietdonhang where ma_chi_tiet_don_hang=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());

            // Bước 3: thực thi câu lệnh SQL
            System.out.println(sql);
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String maChiTietDonHang = rs.getString("ma_chi_tiet_don_hang");
                String maDonHang = rs.getString("ma_don_hang");
                String maSanPham = rs.getString("ma_san_pham");
                Double soLuong = rs.getDouble("so_luong");
                Double giaGoc = rs.getDouble("gia_goc");
                Double giamGia = rs.getDouble("giam_gia");
                Double giaBan = rs.getDouble("gia_ban");
                Double thueVAT = rs.getDouble("thue_vat");
                Double tongTien = rs.getDouble("tong_tien");

                DonHang dh = new DonHangDAO().selectById(new DonHang(maDonHang, null, null, null, null, null, null, 0, 0, null, null));
                SanPham sp = new SanPhamDAO().selectById(new SanPham(maSanPham, null, 0, 0, 0, 0, 0, null, null, null, null));
                
                ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, dh, sp, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien);
                ketQua = ctdh;
            }

            // Bước 5:
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ketQua;
//        for (ChiTietDonHang ChiTietDonHang : data) {
//            if (data.equals(t)) {
//                return ChiTietDonHang;
//            }
//        }
//        return null;
    }

    @Override
    public int insert(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO chitietdonhang (ma_chi_tiet_don_hang, ma_don_hang, ma_san_pham, so_luong, gia_goc, giam_gia, gia_ban, thue_vat, tong_tien) "
                    + " VALUES (?,?,?,?,?,?,?,?,?)";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());
            st.setString(2, t.getDonHang().getMaDonHang());
            st.setString(3, t.getSanPham().getMaSanPham());
            st.setDouble(4, t.getSoLuong());
            st.setDouble(5, t.getGiaGoc());
            st.setDouble(6, t.getGiamGia());
            st.setDouble(7, t.getGiaBan());
            st.setDouble(8, t.getThueVAT());
            st.setDouble(9, t.getTongTien());
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
    public int insertAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;
        for (ChiTietDonHang ChiTietDonHang : arr) {
            dem += this.insert(ChiTietDonHang);
        }
        return dem;
    }

    @Override
    public int delete(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE from chitietdonhang where ma_chi_tiet_don_hang=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, t.getMaChiTietDonHang());

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
    }

    @Override
    public int deleteAll(ArrayList<ChiTietDonHang> arr) {
        int dem = 0;
        for (ChiTietDonHang ChiTietDonHang : arr) {
            dem += this.delete(ChiTietDonHang);
        }
        return dem;
    }

//    public int deleteAll(DonHang dh) {
//        int dem = 0;
//        for (ChiTietDonHang chiTietChiTietDonHang : data) {
//            if (chiTietChiTietDonHang.getDonHang().equals(dh)) {
//                this.delete(chiTietChiTietDonHang);
//            }
//        }
//        return dem;
//    }

    @Override
    public int update(ChiTietDonHang t) {
        int ketQua = 0;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCUtil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE chitietdonhang "
                    + " SET "
                    + " ma_don_hang=?"
                    + ", ma_san_pham=?"
                    + ", so_luong=?"
                    + ", gia_goc=?"
                    + ", giam_gia=?"
                    + ", gia_ban=?"
                    + ", thue_vat=?"
                    + ", tong_tien=?"
                    + " WHERE ma_chi_tiet_don_hang=?";

            PreparedStatement st = con.prepareStatement(sql);
            
           
            
            st.setString(1, t.getDonHang().getMaDonHang());
            st.setString(2, t.getSanPham().getMaSanPham());
            st.setDouble(3, t.getSoLuong());
            st.setDouble(4, t.getGiaGoc());
            st.setDouble(5, t.getGiamGia());
            st.setDouble(6, t.getGiaBan());
            st.setDouble(7, t.getThueVAT());
            st.setDouble(8, t.getTongTien());
            st.setString(9, t.getMaChiTietDonHang());
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
        ChiTietDonHangDAO ctdhd = new ChiTietDonHangDAO();
        ArrayList<ChiTietDonHang> kq = ctdhd.selectAll();
        for (ChiTietDonHang chiTietDonHang : kq) {
            System.out.println(chiTietDonHang.toString());
        }
    }

//    public ArrayList<ChiTietDonHang> selectAll() {
//        return data;
//    }
//    
//    public ChiTietDonHang selectById(String id) {
//        ChiTietDonHang tim = new ChiTietDonHang();
//        tim.setMaChiTietDonHang(id);
//        for(ChiTietDonHang ctdh : data) {
//            if(ctdh.equals(tim)){
//                return ctdh;
//            }
//        }
//        return null;
//    }
//    
//    public int insert(ChiTietDonHang ctdh) {
//        ChiTietDonHang kiemTraTonTai = this.selectById(ctdh.getMaChiTietDonHang());
//        if(kiemTraTonTai == null) {
//            data.add(ctdh);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
//    public int insertAll(ArrayList<ChiTietDonHang> list) {
//        int dem = 0;
//        for(ChiTietDonHang ctdh: list) {
//            dem += this.insert(ctdh);
//        }
//        return dem;
//    }
//    
//    public int delete(ChiTietDonHang ctdh) {
//        ChiTietDonHang kiemTraTonTai = this.selectById(ctdh.getMaChiTietDonHang());
//        if(kiemTraTonTai == null) {
//            data.remove(ctdh);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
//    public int deleteAll(ArrayList<ChiTietDonHang> list) {
//        int dem = 0;
//        for(ChiTietDonHang ctdh: list) {
//            dem += this.delete(ctdh);
//        }
//        return dem;
//    }
//    
//    public int update(ChiTietDonHang ctdh) {
//        ChiTietDonHang kiemTraTonTai = this.selectById(ctdh.getMaChiTietDonHang());
//        if(kiemTraTonTai == null) {
//            data.remove(kiemTraTonTai);
//            data.add(ctdh);
//            return 1;
//        } else {
//            return 0;
//        }
//    }
//    
//    public int deleteAll(DonHang dh) {
//		int dem = 0;
//		for (ChiTietDonHang ctdh : data) {
//			if(ctdh.getDonHang().equals(dh)) {
//				this.delete(ctdh);
//			}
//		}
//		return dem;
//	}
}

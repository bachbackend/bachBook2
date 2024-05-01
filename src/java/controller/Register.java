/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import database.KhachHangDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Random;
import model.KhachHang;

/**
 *
 * @author lebac
 */
@WebServlet(name = "register", urlPatterns = {"/register"})
public class Register extends HttpServlet {

    public Register() {
        super();
    }
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet register</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        doGet(request, response);
        String username = request.getParameter("username");
        String matKhau = request.getParameter("password");
        String matKhauNhapLai = request.getParameter("repassword");
        String hoVaTen = request.getParameter("hoVaTen");
        String gioiTinh = request.getParameter("gioiTinh");
        String dob = request.getParameter("dob");
        String diaChiKhachHang = request.getParameter("diaChiKhachHang");
        String diaChiMuaHang = request.getParameter("diaChiMuaHang");
        String diaChiNhanHang = request.getParameter("diaChiNhanHang");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String dongYNhanMail = request.getParameter("dongymail");

        request.setAttribute("username", username);
        request.setAttribute("hoVaTen", hoVaTen);
        request.setAttribute("gioiTinh", gioiTinh);
        request.setAttribute("dob", dob);
        request.setAttribute("diaChiKhachHang", diaChiKhachHang);
        request.setAttribute("diaChiMuaHang", diaChiMuaHang);
        request.setAttribute("diaChiNhanHang", diaChiNhanHang);
        request.setAttribute("phone", phone);
        request.setAttribute("email", email);
        request.setAttribute("dongYNhanMail", dongYNhanMail);

        String url = "";
        String baoLoi = "";

        KhachHangDAO khachHangDAO = new KhachHangDAO();
        if (khachHangDAO.kiemTraUsername(username)) {
            baoLoi += "ten dang nhap da ton tai.<br/>";
        }

        if (!matKhau.equals(matKhauNhapLai)) {
            baoLoi += "Mat khau khong khop.<br/>";
        }
        request.setAttribute("baoLoi", baoLoi);

        if (baoLoi.length() > 0) {
            url = "/register.jsp";
        } else {
            Random rd = new Random();
            String maKhachHang = System.currentTimeMillis() + rd.nextInt(1000) + "";
            KhachHang khachHang = new KhachHang(maKhachHang, username, matKhau, hoVaTen, gioiTinh, diaChiKhachHang, diaChiNhanHang, diaChiMuaHang, Date.valueOf(dob), phone, email, dongYNhanMail != null);
            khachHangDAO.insert(khachHang);
            url = "/success.jsp";
        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

}

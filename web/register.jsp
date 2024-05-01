<%-- 
    Document   : register
    Created on : May 1, 2024, 1:27:57 AM
    Author     : lebac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
            crossorigin="anonymous">
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
            integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
            integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
        crossorigin="anonymous"></script>

        <style>
            .red {
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container mt-5 mb-3">
            <div class="text-center"><h1>Đăng ký tài khoản</h1></div>
            <form class="form" action="register" method="POST">
                <div class="row">
                    <div class="col">
                        <h3>Tài khoản</h3>
                        <div class="mb-3" >
                            <label for="username" class="form-label">Tên đăng nhập<span class="red">*</span></label>
                            <input type="text" class="form-control" id="username" name="username" required="required"/>
                        </div>

                        <div class="mb-3">
                            <label for="password" class="form-label">Mật khẩu<span class="red">*</span></label>
                            <input type="password" class="form-control" id="password" name="password" required="required" onkeyup="checkPassword()"/>
                        </div>

                        <div class="mb-3">
                            <label for="repassword" class="form-label">Nhắc lại mật khẩu<span class="red">*</span> <span id="msg" class="red"></span></label>
                            <input type="password" class="form-control" id="repassword" name="repassword" required="required" onkeyup="checkPassword()"/>
                        </div>

                        <h3>Thông tin khách hàng</h3>
                        <div class="mb-3">
                            <label for="hoVaTen" class="form-label">Họ và tên</label>
                            <input type="text" class="form-control" id="hoVaTen" name="hoVaTen"/>
                        </div>
                        <div class="mb-3">
                            <label for="gioiTinh" class="form-label">Giới tính</label>
                            <select class="form-control" id="gioiTinh" name="gioiTinh">
                                <option value="Nam">Nam</option>
                                <option value="Nữ">Nữ</option>
                                <option value="loz">Chó rách LGBT</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="dob" class="form-label">Ngày sinh</label>
                            <input type="date" class="form-control" id="dob" name="dob"/>
                        </div>
                    </div>
                    <div class="col">
                        <h3>Địa chỉ</h3>
                        <div class="mb-3">
                            <label for="diaChiKhachHang" class="form-label">Địa chỉ khách hàng</label>
                            <input type="text" class="form-control" id="diaChiKhachHang" name="diaChiKhachHang"/>
                        </div>
                        <div class="mb-3">
                            <label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng</label>
                            <input type="text" class="form-control" id="diaChiMuaHang" name="diaChiMuaHang"/>
                        </div>
                        <div class="mb-3">
                            <label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng</label>
                            <input type="text" class="form-control" id="diaChiNhanHang" name="diaChiNhanHang"/>
                        </div>
                        <div class="mb-3">
                            <label for="phone" class="form-label">Số điện thoại</label>
                            <input type="tel" class="form-control" id="phone" name="phone"/>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email"/>
                        </div>
                        <div class="mb-3">
                            <label for="dongy" class="form-label">Đồng ý với <a>điều khoản của chúng tôi</a><span class="red">*</span></label>
                            <input type="checkbox" class="form-check-input" id="dongy" name="dongy" required="required" onchange="xyLyChonDongY()"/>
                        </div>
                        <div class="mb-3">
                            <label for="dongymail" class="form-label">Đồng ý nhan mail cua chung toi</label>
                            <input type="checkbox" class="form-check-input" id="dongymail" name="dongymail"/>
                        </div>
                    </div>
                    <input class="btn btn-primary form-control" type="submit" value="Register" id="submit" name="submit" style="visibility: hidden;"/>
                </div>
            </form>
        </div>
        
        <script>
            function checkPassword() {
                var password = document.getElementById("password").value;
                var repassword = document.getElementById("repassword").value;
                if(password != repassword) {
                    document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
                    return false;
                } else {
                    document.getElementById("msg").innerHTML = "";
                    return true;
                }
            }
            
            function xyLyChonDongY() {
                dongYDieuKhoan = document.getElementById("dongy");
                if(dongYDieuKhoan.checked == true){
                    document.getElementById("submit").style.visibility="visible";
                } else {
                    document.getElementById("submit").style.visibility="hidden";
                }
            }
            
        </script>
    </body>
</html>















































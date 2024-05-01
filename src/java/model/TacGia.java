/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author lebac
 */
public class TacGia {
    private String maTacGia;
    private String name;
    private Date dob;
    private String tieuSu;

    public TacGia() {
    }

    public TacGia(String maTacGia, String name, Date dob, String tieuSu) {
        this.maTacGia = maTacGia;
        this.name = name;
        this.dob = dob;
        this.tieuSu = tieuSu;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getTieuSu() {
        return tieuSu;
    }

    public void setTieuSu(String tieuSu) {
        this.tieuSu = tieuSu;
    }

    @Override
    public String toString() {
        return "TacGia{" + "maTacGia=" + maTacGia + ", name=" + name + ", dob=" + dob + ", tieuSu=" + tieuSu + '}';
    }

    

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.maTacGia);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TacGia other = (TacGia) obj;
        return Objects.equals(this.maTacGia, other.maTacGia);
    }

   
    

    

    
    
    
}

























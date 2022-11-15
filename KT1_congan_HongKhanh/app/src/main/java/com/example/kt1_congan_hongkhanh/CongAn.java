package com.example.kt1_congan_hongkhanh;

public class CongAn {
    int anh;
    String ten,capBac,noCongTac, quocGiaSoSaoTinhNhiem;
    CongAn(){}

    public CongAn(int anh, String ten, String capBac, String noCongTac, String quocGiaSoSaoTinhNhiem) {
        this.anh = anh;
        this.ten = ten;
        this.capBac = capBac;
        this.noCongTac = noCongTac;
        this.quocGiaSoSaoTinhNhiem = quocGiaSoSaoTinhNhiem;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCapBac() {
        return capBac;
    }

    public void setCapBac(String capBac) {
        this.capBac = capBac;
    }

    public String getNoCongTac() {
        return noCongTac;
    }

    public void setNoCongTac(String noCongTac) {
        this.noCongTac = noCongTac;
    }

    public String getQuocGiaSoSaoTinhNhiem() {
        return quocGiaSoSaoTinhNhiem;
    }

    public void setQuocGiaSoSaoTinhNhiem(String quocGiaSoSaoTinhNhiem) {
        this.quocGiaSoSaoTinhNhiem = quocGiaSoSaoTinhNhiem;
    }
}

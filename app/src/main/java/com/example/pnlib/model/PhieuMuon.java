package com.example.pnlib.model;

public class PhieuMuon {
    private int maPM;
    private int maTV;
    private int maSach;
    private String ngayMuon;
    private int traSach;
    private int tienThue;

    public PhieuMuon(int maPM, int maTV, int maSach, String ngayMuon, int traSach, int tienThue) {
        this.maPM = maPM;
        this.maTV = maTV;
        this.maSach = maSach;
        this.ngayMuon = ngayMuon;
        this.traSach = traSach;
        this.tienThue = tienThue;
    }

    public int getMaPM() {
        return maPM;
    }

    public void setMaPM(int maPM) {
        this.maPM = maPM;
    }

    public int getMaTV() {
        return maTV;
    }

    public void setMaTV(int maTV) {
        this.maTV = maTV;
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public int getTraSach() {
        return traSach;
    }

    public void setTraSach(int traSach) {
        this.traSach = traSach;
    }

    public int getTienThue() {
        return tienThue;
    }

    public void setTienThue(int tienThue) {
        this.tienThue = tienThue;
    }
}

package com.example.pnlib.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// DBHelper.java
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PNlib.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ThuThu (maTT TEXT PRIMARY KEY, hoTen TEXT, matKhau TEXT)");
        db.execSQL("CREATE TABLE Sach (maSach INTEGER PRIMARY KEY AUTOINCREMENT, tenSach TEXT, giaThue INTEGER, maLoai INTEGER)");
        db.execSQL("CREATE TABLE ThanhVien (maTV INTEGER PRIMARY KEY AUTOINCREMENT, hoTen TEXT, namSinh TEXT)");
        db.execSQL("CREATE TABLE PhieuMuon (maPM INTEGER PRIMARY KEY AUTOINCREMENT, maTT TEXT, maTV INTEGER, maSach INTEGER, ngay DATE, traSach INTEGER, tienThue INTEGER)");
        db.execSQL("CREATE TABLE TopSach (maSach INTEGER PRIMARY KEY, tenSach TEXT, soLuong INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ThuThu");
        db.execSQL("DROP TABLE IF EXISTS Sach");
        db.execSQL("DROP TABLE IF EXISTS ThanhVien");
        db.execSQL("DROP TABLE IF EXISTS PhieuMuon");
        db.execSQL("DROP TABLE IF EXISTS TopSach");
        onCreate(db);
    }
}

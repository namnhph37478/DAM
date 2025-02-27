package com.example.pnlib.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {


    public MyDbHelper(Context context){
        super(context , "DuAnMau" , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbThuThu = "CREATE TABLE THUTHU (matt TEXT PRIMARY KEY , hoten TEXT , matkhau TEXT, loaitaikhoan TEXT)";
        db.execSQL(tbThuThu);

        String tbThanhVien = "CREATE TABLE THANHVIEN (matv INTEGER PRIMARY KEY AUTOINCREMENT , hoten TEXT , namsinh TEXT)";
        db.execSQL(tbThanhVien);

        String tbLoaiSach = "CREATE TABLE LOAISACH( maloai INTEGER PRIMARY KEY AUTOINCREMENT , tenloai TEXT)";
        db.execSQL(tbLoaiSach);

        String tbSach = "CREATE TABLE SACH(masach INTEGER PRIMARY KEY AUTOINCREMENT , tensach TEXT , giathue INTEGER , maloai INTEGER REFERENCES LOAISACH(maloai))";
        db.execSQL(tbSach);

        String tbPhieuMuon = "CREATE TABLE PHIEUMUON(mapm INTEGER PRIMARY KEY AUTOINCREMENT , matv INTEGER REFERENCES THANHVIEN(matv) , matt TEXT REFERENCES THUTHU(matt), masach INTEGER REFERENCES SACH(masach) , ngay TEXT , trasach INTEGER , tienthue INTEGER)";
        db.execSQL(tbPhieuMuon);


        db.execSQL("INSERT INTO LOAISACH VALUES (1 , 'JaVa') , (2 ,'Photo') , (3 , 'Code')");
        db.execSQL("INSERT INTO SACH VALUES (1 , 'Java2' , 5000 , 1) , (2 , 'PhotoShop' , 4000 ,1) , (3,'Code mẫu' , 7000 ,3) ");
        db.execSQL("INSERT INTO THUTHU VALUES ('thuthu1' , 'Ngô Hải Nam' , 'abc123', 'Admin'), ('thuthu2','Nguyen Hoàng B','123','thủ thư')");
        db.execSQL("INSERT INTO THANHVIEN VALUES (1,' Ngô Hải Nam','2004'), (2, 'Đặng Thái B','2003')");

        db.execSQL("INSERT INTO PHIEUMUON VALUES (1,1,'thuthu1',1,'20/01/2025',1,4000),(2,2,'thuthu01',2,'12/02/2025',0,7000) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i != i1){
            db.execSQL("DROP TABLE IF EXISTS THUTHU");
            db.execSQL("DROP TABLE IF EXISTS THANHVIEN");
            db.execSQL("DROP TABLE IF EXISTS LOAISACH");
            db.execSQL("DROP TABLE IF EXISTS SACH");
            db.execSQL("DROP TABLE IF EXISTS PHIEUMUON");
            onCreate(db);
        }

    }
}

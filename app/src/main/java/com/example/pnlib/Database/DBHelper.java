package com.example.pnlib.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

// DBHelper.java
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "PNlib.db";
    private static final int DATABASE_VERSION = 2;
    private final Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        copyDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS ThuThu (maTT TEXT PRIMARY KEY, hoTen TEXT, matKhau TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS Sach (maSach INTEGER PRIMARY KEY AUTOINCREMENT, tenSach TEXT, giaThue INTEGER, maLoai INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS ThanhVien (maTV INTEGER PRIMARY KEY AUTOINCREMENT, hoTen TEXT, namSinh TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS PhieuMuon (maPM INTEGER PRIMARY KEY AUTOINCREMENT, maTT TEXT, maTV INTEGER, maSach INTEGER, ngay DATE, traSach INTEGER, tienThue INTEGER)");
        db.execSQL("CREATE TABLE IF NOT EXISTS TopSach (maSach INTEGER PRIMARY KEY, tenSach TEXT, soLuong INTEGER)");
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

    private void copyDatabase() {
        try {
            String destPath = context.getDatabasePath(DATABASE_NAME).getPath();
            File file = new File(destPath);
            if (!file.exists()) {
                InputStream is = context.getAssets().open(DATABASE_NAME);
                OutputStream os = new FileOutputStream(destPath);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = is.read(buffer)) > 0) {
                    os.write(buffer, 0, length);
                }
                os.flush();
                os.close();
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

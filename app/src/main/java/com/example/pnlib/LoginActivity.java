package com.example.pnlib;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnlib.Database.DBHelper;

import java.util.ArrayList;
import java.util.List;

// LoginActivity.java
public class LoginActivity extends AppCompatActivity {
    EditText edUsername, edPassword;
    Button btnLogin, btnCancel;
    CheckBox chkRemember;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.edUserName);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        chkRemember = findViewById(R.id.chkRememberPass);

        db = new DBHelper(this).getReadableDatabase();

        btnLogin.setOnClickListener(v -> checkLogin());
        btnCancel.setOnClickListener(v -> clearFields());
    }

    private void checkLogin() {
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        Cursor cursor = db.rawQuery("SELECT * FROM ThuThu WHERE maTT=? AND matKhau=?", new String[]{username, password});
        if (cursor.moveToFirst()) {
            String role = cursor.getString(0);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("role", role);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    }

    private void clearFields() {
        edUsername.setText("");
        edPassword.setText("");
    }
}

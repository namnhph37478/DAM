package com.example.pnlib.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.pnlib.model.LoaiSach;

import java.util.List;

public class LoaiSachSpinnerAdapter extends ArrayAdapter<LoaiSach> {
    public LoaiSachSpinnerAdapter(Context context, List<LoaiSach> loaiSachList) {
        super(context, android.R.layout.simple_spinner_dropdown_item, loaiSachList);
    }
}
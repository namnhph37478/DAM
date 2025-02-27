package com.example.pnlib.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pnlib.R;
import com.example.pnlib.model.*;
import java.util.List;

public class SachSpinnerAdapter extends ArrayAdapter<Sach> {
    public SachSpinnerAdapter(Context context, List<Sach> sachList) {
        super(context, android.R.layout.simple_spinner_dropdown_item, sachList);
    }
}
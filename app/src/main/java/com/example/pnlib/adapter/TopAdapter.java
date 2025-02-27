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

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder> {
    private Context context;
    private List<TopSach> topSachList;

    public TopAdapter(Context context, List<TopSach> topSachList) {
        this.context = context;
        this.topSachList = topSachList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_sach, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopSach topSach = topSachList.get(position);
        holder.tvTopSachName.setText(topSach.getTenSach());
    }

    @Override
    public int getItemCount() {
        return topSachList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTopSachName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTopSachName = itemView.findViewById(R.id.tvTopSachName);
        }
    }
}

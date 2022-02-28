package com.ark.mainmarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ark.mainmarket.Model.ModelCategory;
import com.ark.mainmarket.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterHomeCategory extends RecyclerView.Adapter<AdapterHomeCategory.MyViewHolder> {

    private Context mContext;
    private List<ModelCategory> categoryList;

    public AdapterHomeCategory(Context mContext, List<ModelCategory> categoryList) {
        this.mContext = mContext;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ModelCategory modelCategory = categoryList.get(position);
        Picasso.get().load(modelCategory.getIcon_link()).into(holder.iconCategory);
        holder.nameCategory.setText(modelCategory.getName_category());

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iconCategory;
        TextView nameCategory;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconCategory = itemView.findViewById(R.id.category_icon);
            nameCategory = itemView.findViewById(R.id.name_category);
        }
    }
}

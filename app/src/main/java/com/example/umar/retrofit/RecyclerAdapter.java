package com.example.umar.retrofit;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<Technicians> users;
    ArrayList<Technicians> arrayList;


    public RecyclerAdapter(List<Technicians> users) {

        this.users = users;

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvName.setText(users.get(position).getName());
        holder.tvStatus.setText(users.get(position).getStatus());
        holder.tvNo.setText(users.get(position).getPhone());
        holder.tvCnic.setText(users.get(position).getCnic());
        holder.tvAdd.setText(users.get(position).getAddress());



    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvStatus, tvNo, tvCnic, tvAdd, tvRating;
        RatingBar ratingBar;
        LinearLayout recyclerViewList;
        ImageView technicianImage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvNo = itemView.findViewById(R.id.tvNo
            );
            tvCnic = itemView.findViewById(R.id.tvCnic);
            tvAdd = itemView.findViewById(R.id.tvAdd);


        }
    }
}

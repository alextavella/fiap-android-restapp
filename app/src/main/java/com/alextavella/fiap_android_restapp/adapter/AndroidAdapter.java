package com.alextavella.fiap_android_restapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alextavella.fiap_android_restapp.R;
import com.alextavella.fiap_android_restapp.model.Android;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by alextavella on 21/06/17.
 */

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {

    private List<Android> androids;

    public AndroidAdapter(List<Android> androids) {
        this.androids = androids;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View myLayout = inflater.inflate(R.layout.android_row, parent, false);
        return new AndroidViewHolder(myLayout);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {
        holder.tvTitle
                .setText(androids.get(position).getNome());

        holder.tvSubTitle
                .setText(androids.get(position).getVersao());

        Picasso
                .with(holder.itemView.getContext())
                .load(androids.get(position).getUrlImagem())
                .placeholder(R.drawable.img_placeholder_square)
                .into(holder.ivBrand);
    }

    @Override
    public int getItemCount() {
        return this.androids.size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivBrand)
        public ImageView ivBrand;

        @BindView(R.id.tvTitle)
        public TextView tvTitle;

        @BindView(R.id.tvSubTitle)
        public TextView tvSubTitle;

        public AndroidViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void update(List<Android> androids) {
        this.androids = androids;
        notifyDataSetChanged();
    }
}

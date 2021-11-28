package com.example.mysubmission1;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private final ArrayList<Model> modelArrayList;

    public ListAdapter(ArrayList<Model> list) {
        this.modelArrayList = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row_user, viewGroup, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Model model = modelArrayList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(model.getAvatar())
                .circleCrop()
                .into(holder.imgAvatar);
        holder.tvName.setText(model.getName());
        holder.tvUsername.setText(model.getUsername());

        holder.itemView.setOnClickListener(v -> {
            Intent intents = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intents.putExtra(DetailActivity.GET_DATA, (Parcelable) model);
            v.getContext().startActivity(intents);

        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgAvatar;
        private final TextView tvName;
        private final TextView tvUsername;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.img_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvUsername = itemView.findViewById(R.id.tv_username);
        }
    }
}

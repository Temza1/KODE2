package com.moinonemoi.kode;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.UserViewHolder> {

    public static final String LOG_ADAPTER = "ItemAdapter";

    private List<Item> users = new ArrayList<>();

    public void setUsers(List<Item> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.worker_template,
                parent,
                false);
        return new UserViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        Item user = users.get(position);
        holder.nameTextView.setText(user.getFullName());
        holder.userTagTextView.setText(user.getUserTag());
        holder.positionTextView.setText(user.getPosition());

        try {
            Glide.with(holder.itemView)
                    .load(user.getAvatarUrl())
                    .into(holder.circleImageViewAvatar);
        } catch (Exception e) {
            Log.e(LOG_ADAPTER,"ошибка с glide");
        }

    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        TextView nameTextView;
        TextView userTagTextView;
        TextView positionTextView;
        CircleImageView circleImageViewAvatar;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            userTagTextView = itemView.findViewById(R.id.userTagTextView);
            positionTextView = itemView.findViewById(R.id.positionTextView);
            circleImageViewAvatar = itemView.findViewById(R.id.circleImageViewAvatar);
        }
    }


}

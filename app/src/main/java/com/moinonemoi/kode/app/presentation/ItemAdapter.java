package com.moinonemoi.kode.app.presentation;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.moinonemoi.kode.app.data.Item;
import com.moinonemoi.kode.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.UserViewHolder> {


    public static final String LOG_ADAPTER = "ItemAdapter";

    private List<Item> users = new ArrayList<>();

    public void setUsers(List<Item> users) {
        this.users = users;
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

        Glide.with(holder.itemView)
                    .load(user.getAvatarUrl())
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.circleImageViewAvatar);
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
        Drawable defaultDrawable;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            userTagTextView = itemView.findViewById(R.id.userTagTextView);
            positionTextView = itemView.findViewById(R.id.positionTextView);
            circleImageViewAvatar = itemView.findViewById(R.id.circleImageViewAvatar);
        }
    }


}

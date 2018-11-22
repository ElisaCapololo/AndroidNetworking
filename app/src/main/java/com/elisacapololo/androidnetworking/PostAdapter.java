package com.elisacapololo.androidnetworking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    Post[] posts = new Post[0];

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.post_row, viewGroup, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int position) {
        Post post = posts[position];
        postViewHolder.postName.setText(post.name);
        postViewHolder.postMessage.setText(post.message);
        Picasso.get().load(post.profileUrl).into(postViewHolder.postImage);
    }

    @Override
    public int getItemCount() {
        return posts.length;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView postImage;
        TextView postName;
        TextView postMessage;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postImage = itemView.findViewById(R.id.post_image);
            postName = itemView.findViewById(R.id.post_name);
            postMessage = itemView.findViewById(R.id.post_message);
        }
    }
}

package com.example.recyclerviewtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {
    private List<Character> characters;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.imageView = view.findViewById(R.id.fruit_image);
            this.textView = view.findViewById(R.id.fruit_name);
        }
    }

    public CharacterAdapter(List<Character> characters) {
        this.characters = characters;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character, parent, false);
        final ViewHolder vh = new ViewHolder(view);
        vh.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                String name = characters.get(position).getName();
                Toast.makeText(v.getContext(), "Clicked image: " + name, Toast.LENGTH_SHORT).show();
            }
        });
        vh.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = vh.getAdapterPosition();
                String name = characters.get(position).getName();
                Toast.makeText(v.getContext(), "Clicked text: " + name, Toast.LENGTH_SHORT).show();
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.textView.setText(character.getName());
        holder.imageView.setImageResource(character.getImage());
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }
}

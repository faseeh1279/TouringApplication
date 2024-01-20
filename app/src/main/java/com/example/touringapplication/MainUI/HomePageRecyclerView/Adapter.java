package com.example.touringapplication.MainUI.HomePageRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.touringapplication.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;


    List<Model> modellist;


    public Adapter(Context context, List<Model> modellist) {
        this.context = context;
        this.modellist = modellist;

    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View obj = layoutInflater.inflate(R.layout.homepagerecyclerview, parent, false);

        return new ViewHolder(obj);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Model model = modellist.get(position);
        holder.txt1.setText(model.getEmail());
        holder.txt2.setText(model.getPassword());
        holder.img.setImageResource(model.getImage());

    }

    @Override
    public int getItemCount() {
        return modellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1, txt2;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.email);
            txt2 = itemView.findViewById(R.id.password);
            img = itemView.findViewById(R.id.ImageView);

        }
    }
}

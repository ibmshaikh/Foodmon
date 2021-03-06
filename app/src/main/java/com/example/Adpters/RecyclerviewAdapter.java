package com.example.Adpters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.fooduck.R;
import com.example.model.Food;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {


    private List<Food> list;
    private Context context;

    public RecyclerviewAdapter(List<Food> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_single,viewGroup,false);
        context = viewGroup.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.setAll(list.get(i),context);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private View itemview;
        private TextView name,quantity;
        private ImageView image,type;

        public MyViewHolder(View view) {
            super(view);
            itemview = view;
            name = view.findViewById(R.id.foodname);
            quantity = view.findViewById(R.id.quantity);
            image = view.findViewById(R.id.image);
            type = view.findViewById(R.id.type);
        }

        private void setAll(Food object,Context context){

            name.setText(object.getFoodname());
            quantity.setText("x "+object.getNo_of_people());
            Glide.with(context).load(object.getImage_url()).into(image);
            if (object.getVeg().equals("Veg")){

                type.setImageResource(R.drawable.vegetariansymbol);


            }else {
                type.setImageResource(R.drawable.nveg);


            }

        }

    }
}

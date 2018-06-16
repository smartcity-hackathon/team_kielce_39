package com.example.kamil.hackatonkielce.ReceiveDirectory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kamil.hackatonkielce.R;

import java.util.List;

public class OffertsAdapter extends RecyclerView.Adapter<OffertsAdapter.OffertViewHolder>{

    private Context context;
    private List<Offerts> offertsList;


    public OffertsAdapter(Context context , List<Offerts> offertsLists ) {
        this.context = context;
        this.offertsList = offertsLists;
    }


    @NonNull
    @Override
    public OffertViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_recive_sinle_item, parent, false);
        return new OffertViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OffertViewHolder holder, int position) {

        Offerts offert = offertsList.get(position);

        //holder.imageView =offertsList
         holder.textViewPrice.setText(offert.sallary);
         holder.textViewTitle.setText(offert.title);

    }

    @Override
    public int getItemCount() {
        return offertsList.size();
    }

    class OffertViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewTitle;
        TextView textViewPrice;

        public OffertViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);


        }
    }
}

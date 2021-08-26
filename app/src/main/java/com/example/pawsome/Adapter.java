package com.example.pawsome;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements Filterable {
    List<ModelClass> list;
    List<ModelClass> listFull;

    public Adapter(List<ModelClass> list){
        this.list = list;
        listFull = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dog_view,null);
        Adapter.ViewHolder viewHolder = new Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.dogName.setText(list.get(position).getName());

        Picasso.get().load(list.get(position).getImage().get("url").getAsString()).centerCrop().resize(250,250).into(holder.dogImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView dogName;
        ImageView dogImage;

        public ViewHolder(@NonNull View itemView)  {
            super(itemView);

            dogImage = itemView.findViewById(R.id.dogImage);
            dogName = itemView.findViewById(R.id.dogName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAbsoluteAdapterPosition();
            //Toast.makeText(v.getContext(), "position: " + position,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(),DogInfo.class);
            intent.putExtra("Image",list.get(position).getImage().get("url").getAsString());
            intent.putExtra("Name",list.get(position).getName());
            intent.putExtra("Temperament",list.get(position).getTemperament());
            intent.putExtra("Life_span",list.get(position).getLife_span());
            intent.putExtra("Origin",list.get(position).getOrigin());
            intent.putExtra("Weight",list.get(position).getWeight().get("imperial").toString());
            intent.putExtra("Height",list.get(position).getHeight().get("imperial").toString());
            intent.putExtra("Alt_names",list.get(position).getAlt_names());
            intent.putExtra("Wiki",list.get(position).getWikipedia_url());
            v.getContext().startActivity(intent);


        }
    }

    @Override
    public Filter getFilter() {
        return exFilter;
    }

    private Filter exFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<ModelClass> filterList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filterList.addAll(listFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (ModelClass item : listFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)){
                        filterList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}

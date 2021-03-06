package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// responsible for displaying data from the model to a row in the recycler view
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    public ItemsAdapter(List<String> items) {
    }

    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //  Use layout inflater to inflate a view

            View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            //wrap it inside a view holder and return it
            return new ViewHolder(todoView);
        }
            public interface OnLongClickListener {
                void OnItemLongClicked (int position);
        };
        List<String> items;
        OnLongClickListener longClickListener;


        public ItemsAdapter(List<String> Items, OnLongClickListener longClickListener) {
            this.items = items;
            this.longClickListener = longClickListener;


        }

        // Responsible for bonding data to a particular view holder
        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Grab  the item at the position
        String item = items.get(position);
        // Bind the item into the specified view holder
            holder.bind(item);
        }

        // tell the RV how many items are in the list
        @Override
        public int getItemCount() {
            return items.size();
        }

        // container to provide easy access to views that represent each row of the list
        class ViewHolder extends RecyclerView.ViewHolder {

            TextView tvItem;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvItem = itemView.findViewById(android.R.id.text1);
            }

            //update the view inside the view holder with this data
            public void bind(String item) {
                tvItem.setText(item);
                tvItem.setOnLongClickListener (new View.OnLongClickListener() {


                    @Override
                    public boolean onLongClick(View view) {
                        // Remove the item from the Recycler view
                        longClickListener.OnItemLongClicked(getAdapterPosition());
                        return true;

                    }
                });
            }
        }}
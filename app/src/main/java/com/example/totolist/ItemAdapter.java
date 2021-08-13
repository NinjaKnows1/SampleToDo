package com.example.totolist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    public interface OnLongClickListener{
        void onItemLongClicked(int postion);
    }
    List<String> items;
    OnLongClickListener longClickListener;
    public ItemAdapter(List<String> items, OnLongClickListener longClickListener)
    {
        this.items = items;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,
        false);
        return new ViewHolder(todoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String item = items.get(position);
    holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvItem = itemView.findViewById(android.R.id.text1);

            }


        public void bind(String item) {
        tvItem.setText(item);
        tvItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View V) {
                longClickListener.onItemLongClicked(getAdapterPosition());
                return true;
            }
        });
        }
    }

}

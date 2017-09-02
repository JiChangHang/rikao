package com.bawei.day3.adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bawei.day3.R;

import java.util.ArrayList;

/**
 * Created by jch on 2017/8/31.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<String> list;

    public MyAdapter() {
        list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add("条目 " + i);
        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View recyclerViewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(recyclerViewItem);
    }


    public void add(int position) {


        list.add(position + 1, "这是新加的");

        notifyItemRangeChanged(position + 1, getItemCount());
    }

    public void remove(int position) {
        list.remove(position);
        notifyItemRangeRemoved(position, getItemCount());
    }


    public void updata(int position, String content) {
        list.remove(position);
        list.add(position, content);
        notifyItemChanged(position);
    }



    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }


    public interface OnItemLongClickListener {
        void onItemLongClick(View v, int position);
    }

    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;


    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }


    public void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        mItemLongClickListener = itemLongClickListener;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.title.setText(list.get(position));



        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, position);
                }
            }
        });

        holder.icon.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                if (mItemLongClickListener != null) {
                    mItemLongClickListener.onItemLongClick(v, position);
                }

                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {



        View itemView;
        TextView title;
        ImageView icon;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            title = (TextView) itemView.findViewById(R.id.title);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }
}


package com.joker.test.androidexamples.ch12;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joker.test.androidexamples.R;

import java.util.List;

/**
 * Created by lambor on 17-3-7.
 */

public class Ch12_6RecyclerAdapter extends RecyclerView.Adapter<Ch12_6RecyclerAdapter.ViewHolder> {

    private List<String> mData;

    public Ch12_6RecyclerAdapter(List<String> data) {
        this.mData = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ch12_6,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mData.get(position)+position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null)
                itemClickListener.onItemClick(v,getLayoutPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }

    public OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}

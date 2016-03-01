package com.example.ram1991.creativewebmedianewsfeed.ui.adapters;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.ui.views.NewsViewer;

import java.util.List;
import java.util.Map;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    NewsViewer viewer;
    List<Map<String, String>> newsList;

    public NewsRecyclerAdapter(NewsViewer viewer, List<Map<String, String>> list) {
        this.viewer = viewer;
        this.newsList = list;

    }

    public void setData(List<Map<String, String>> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Bundle bundle = new Bundle();
        holder.headLine.setText(newsList.get(position).get("headLine"));
        holder.dataLine.setText(newsList.get(position).get("dateLine"));
        bundle.putString("URL", newsList.get(position).get("WebURL"));
        holder.card_view.setTag(bundle);

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView headLine;
        TextView dataLine;
        CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            headLine = (TextView) itemView.findViewById(R.id.tv_headline);
            dataLine = (TextView) itemView.findViewById(R.id.tv_dataline);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
            card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = (Bundle) v.getTag();
                    viewer.showDetailedInfo(bundle);
                }
            });
        }
    }


}

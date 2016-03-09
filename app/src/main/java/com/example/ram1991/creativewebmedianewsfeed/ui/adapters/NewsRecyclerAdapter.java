package com.example.ram1991.creativewebmedianewsfeed.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.interactors.models.NewsListItem;

import java.util.List;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    private OnNewsClickListener mListener;
    private List<NewsListItem> mNewsList;


    public NewsRecyclerAdapter(List<NewsListItem> list, NewsRecyclerAdapter.OnNewsClickListener listener) {
        this.mListener = listener;
        this.mNewsList = list;
    }

    public void setData(List<NewsListItem> newsList) {
        this.mNewsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(mNewsList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView headLine;
        private TextView dataLine;
        private CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            headLine = (TextView) itemView.findViewById(R.id.tv_headline);
            dataLine = (TextView) itemView.findViewById(R.id.tv_dataline);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
        }

        public void bind(final NewsListItem list, final OnNewsClickListener listener) {
            headLine.setText(list.getHead());
            dataLine.setText(list.getDate());
            card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(list.getUrl());
                }
            });
        }
    }

    public interface OnNewsClickListener {
        void onClick(String s);
    }

}

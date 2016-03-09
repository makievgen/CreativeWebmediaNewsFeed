package com.example.ram1991.creativewebmedianewsfeed.ui.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ram1991.creativewebmedianewsfeed.R;
import com.example.ram1991.creativewebmedianewsfeed.interactors.Constants;

import java.util.List;
import java.util.Map;

public class NewsRecyclerAdapter extends RecyclerView.Adapter<NewsRecyclerAdapter.ViewHolder> {
    private OnNewsClickListener mListener;
    private List<Map<String, String>> mNewsList;


    public NewsRecyclerAdapter(NewsRecyclerAdapter.OnNewsClickListener listener, List<Map<String, String>> list) {
        this.mListener = listener;
        this.mNewsList = list;
    }

    public void setData(List<Map<String, String>> newsList) {
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

        holder.headLine.setText(mNewsList.get(position).get(Constants.HEAD_LINE));
        holder.dataLine.setText(mNewsList.get(position).get(Constants.DATE_LINE));

        holder.card_view.setTag(mNewsList.get(position).get(Constants.WEB_URL));

    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
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
                    String webUrl = v.getTag().toString();
                    mListener.onClick(webUrl);
                }
            });
        }
    }


    public interface OnNewsClickListener {
        void onClick(String s);
    }
}

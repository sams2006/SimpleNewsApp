package com.tuwiq.simplenewsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    List<NewsItem> listNews ;
   OnListItemClickListener onListItemClickListener ;

    public NewsAdapter(List<NewsItem> list , OnListItemClickListener onListItemClickListener) {
        listNews = list ;
        this.onListItemClickListener = onListItemClickListener ;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()) ;
        View view = layoutInflater.inflate(R.layout.news_item , parent , false) ;
        NewsViewHolder newsViewHolder = new NewsViewHolder(view , onListItemClickListener ) ;
        return newsViewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem newsItem = listNews.get(position) ;
        holder.textViewTitle.setText(newsItem.getTitle());
        holder.textViewSubTitle.setText(newsItem.getSubTitle());


    }

    @Override
    public int getItemCount() {
        return listNews.size() ;
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder {
        int position ;
        TextView textViewTitle ;
        TextView textViewSubTitle ;

        public NewsViewHolder(@NonNull View itemView , final OnListItemClickListener onListItemClickListener) {
            super(itemView);
             textViewTitle = itemView.findViewById(R.id.title_text_view) ;
             textViewSubTitle = itemView.findViewById(R.id.sub_title_text_view) ;
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     onListItemClickListener.onItemClick(position);
                 }
             });



        }
    }
}

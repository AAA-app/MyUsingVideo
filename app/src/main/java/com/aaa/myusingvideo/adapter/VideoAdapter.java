package com.aaa.myusingvideo.adapter;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aaa.myusingvideo.R;
import com.aaa.myusingvideo.data.YoutubeVideo;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<YoutubeVideo> youtubeVideoList;

    public VideoAdapter() {
    }

    public VideoAdapter(List<YoutubeVideo> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.videoWeb.loadData(youtubeVideoList.get(position).getVideoUrl(),"text/html", "utf-8");
    }



    @Override
    public int getItemCount() { return youtubeVideoList.size(); }


    public class VideoViewHolder extends RecyclerView.ViewHolder {
        WebView videoWeb;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoWeb = (WebView) itemView.findViewById(R.id.web_video_view);
            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {
            });
            }
        }
    }


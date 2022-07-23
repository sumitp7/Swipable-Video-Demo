package com.sumit.swipablevideosdemo;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<VideoModel> videolist;

    public VideoAdapter(List<VideoModel> videolist) {
        this.videolist = videolist;
    }

    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View videolist=layoutInflater.inflate(R.layout.each_video,parent,false);
        VideoAdapter.VideoViewHolder viewHolder=new VideoAdapter.VideoViewHolder(videolist);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoViewHolder holder, int position) {

        holder.setVideoData(videolist.get(position));

    }

    @Override
    public int getItemCount() {
        return videolist.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        TextView title,desc;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            title = itemView.findViewById(R.id.video_title);
            desc = itemView.findViewById(R.id.video_desc);

        }

        public void setVideoData(VideoModel video){
            title.setText(video.getTitle());
            desc.setText(video.getDesc());
            videoView.setVideoPath(video.getVideoUrl());

            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();

                    float videoRatio = mp.getVideoWidth() / (float)mp.getVideoHeight();
                    float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                    float scale = videoRatio /screenRatio;

                    if (scale >= 1f){
                        videoView.setScaleX(scale);
                    }else {
                        videoView.setScaleY(1f/scale);
                    }
                }
            });

            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.start();
                }
            });
        }
    }
}

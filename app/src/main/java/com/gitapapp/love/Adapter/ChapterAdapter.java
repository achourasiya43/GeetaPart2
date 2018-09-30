package com.gitapapp.love.Adapter;


import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.gitapapp.love.Model.Chapter;
import com.gitapapp.love.R;

import java.util.List;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {

    private Context context;
    private List<Chapter> chapter;

    public ChapterAdapter(Context context, List<Chapter> chapter) {
        this.context = context;
        this.chapter = chapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ChapterAdapter.ViewHolder holder, final int position) {

        holder.text.setText(chapter.get(position).getText());

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                        holder.text.getText().toString());
                context.startActivity(shareIntent);
            }
        });

        holder.copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cm = (ClipboardManager)context.getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(holder.text.getText().toString());
                Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return chapter.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView text;
        public Button share, copy;

        //public Button next;

        public ViewHolder(View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.chapterText);
            copy = itemView.findViewById(R.id.copyButton);
            share = itemView.findViewById(R.id.shareButton);

        }

    }
}

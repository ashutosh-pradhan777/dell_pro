package com.example.dell_pro;
        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.android.volley.AuthFailureError;
        import com.example.dell_pro.Model.News;
        import com.squareup.picasso.Picasso;

        import java.util.List;

public class Notification_recycler extends RecyclerView.Adapter<Notification_recycler.ViewHolder> {
    LayoutInflater inflater;
    List<News> news;

    public Notification_recycler(Context ctx, List<News> news){
        this.inflater = LayoutInflater.from(ctx);
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.notification_elements,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // bind the data
        holder.newsTitle.setText(news.get(position).getTitle());
        holder.Author.setText(news.get(position).getAuthor());
        holder.Date.setText(news.get(position).getDate());
        Picasso.get().load(news.get(position).getImgUrl()).into(holder.coverImage);

    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView newsTitle,Author,Date;
        ImageView coverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            newsTitle = itemView.findViewById(R.id.newsTitle);
            Author = itemView.findViewById(R.id.Author);
            coverImage = itemView.findViewById(R.id.coverImage);
            Date = itemView.findViewById(R.id.Date);

            // handle onClick

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

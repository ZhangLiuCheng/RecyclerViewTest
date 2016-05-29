package com.zhangliucheng.recylerviewtest.linear;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.zhangliucheng.recylerviewtest.City;
import com.zhangliucheng.recylerviewtest.R;

import java.util.List;
import java.util.Random;

public class RecyclerLinearAdapter extends RecyclerView.Adapter<RecyclerLinearAdapter.Holder> {

    private LayoutInflater inflater;
    private List<City> data;
    private RecyclerView recyclerView;

    public RecyclerLinearAdapter(Context context, RecyclerView recyclerView, List<City> data) {
        this.inflater = LayoutInflater.from(context);
        this.recyclerView = recyclerView;
        this.data = data;
    }

    public void addCity() {
        if (data.size() == 0) { return; }

        int random = new Random().nextInt(data.size());
        this.data.add(0, this.data.get(random).clone());
        notifyItemInserted(0);
        recyclerView.scrollToPosition(0);
    }

    public void deleteCity() {
        if (data.size() < 0) {
            return;
        }
        this.data.remove(0);
        notifyItemRemoved(0);
        recyclerView.scrollToPosition(0);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_recycler_linear, parent, false);
        return new Holder(view);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.setData(data.get(position));
    }

    class Holder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView name;
        private TextView brief;

        public Holder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            brief = (TextView) itemView.findViewById(R.id.brief);
        }

        public void setData(City city) {
            this.name.setText(city.name);
            this.brief.setText(city.brief);

            ImageLoader imageLoader = ImageLoader.getInstance();
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .displayer(new FadeInBitmapDisplayer(100))
                    .build();
            imageLoader.displayImage(city.image, this.image, options);
        }
    }
}

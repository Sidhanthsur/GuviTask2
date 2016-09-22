package surana.sidhanth.com.guvitask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import surana.sidhanth.com.guvitask.model.item;

/**
 * Created by sidhanth on 22/9/16.
 */

public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {
    Context context;


    private List<item> mDataset;
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView name;
        public TextView price;
        public TextView description;
        public ImageView imageView;


        public ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.item_name);
            price = (TextView) v.findViewById(R.id.item_price);
            description = (TextView) v.findViewById(R.id.item_description);
            imageView = (ImageView) v.findViewById(R.id.item_image);


        }
    }
    public void add(int position, item item1) {
        mDataset.add(position, item1);
        notifyItemInserted(position);
    }
    public void remove(item item1) {
        int position = mDataset.indexOf(item1);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }
    public adapter(List<item> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.name.setText(mDataset.get(position).getName());
        holder.description.setText(mDataset.get(position).getDescription());
        holder.price.setText(mDataset.get(position).getPrice()+"");

        Glide.with(holder.imageView.getContext()).load(mDataset.get(position).getUrl()).into(holder.imageView);



    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}
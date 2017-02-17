package com.fyber.challenege.offerslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fyber.challenege.R;
import com.fyber.challenege.data.Offer;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Offer}
 */
public class OffersRecyclerViewAdapter extends RecyclerView.Adapter<OffersRecyclerViewAdapter.ViewHolder> {

    private final List<Offer> offersList;
    private final Context context;

    public OffersRecyclerViewAdapter(List<Offer> offersList, Context context) {
        this.offersList = offersList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_offer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.offerItem = offersList.get(position);
        holder.titleView.setText(holder.offerItem.getTitle());

        Picasso.with(context).load(holder.offerItem.getThumbnail().getHires()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final ImageView imageView;
        public final TextView titleView;
        public Offer offerItem;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            imageView = (ImageView) view.findViewById(R.id.offer_img);
            titleView = (TextView) view.findViewById(R.id.offer_title);
        }
    }
}

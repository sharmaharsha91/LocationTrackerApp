package com.example.locationtrackrapp.locationTracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.locationtrackrapp.R;

import java.util.List;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class LocationGridAdapter extends RecyclerView.Adapter<LocationGridAdapter.MyViewHolder> {
    private final String TAG = LocationGridAdapter.class.getSimpleName();
    private Context context;
    private List<LocationWrapper> categoryList;

    public LocationGridAdapter(Context context, List<LocationWrapper> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_grid_list_row, null);
        context = parent.getContext();
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (categoryList.get(position) != null) {
            if (categoryList.get(position).getLatitude() != null && categoryList.get(position).getLongitude() != null)
                holder.tvLatLon.setText(categoryList.get(position).getLatitude() + "  ," + categoryList.get(position).getLongitude());
            else {
                holder.tvLatLon.setText("No Latitude Longitude");
            }
            holder.tvAddress.setText(categoryList.get(position).getAddress() != null && !categoryList.get(position).getAddress().isEmpty() ? categoryList.get(position).getAddress() : "No Address Found");

        }
    }

    @Override
    public int getItemCount() {
        if (categoryList != null) {
            return categoryList.size();
        }

        return 0;
    }

    public void updateCategoryList(List<LocationWrapper> categoryList) {
        this.categoryList = categoryList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView tvLatLon, tvAddress;

        public MyViewHolder(View itemView) {
            super(itemView);

            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvLatLon = itemView.findViewById(R.id.tvLatLon);

        }
    }


}

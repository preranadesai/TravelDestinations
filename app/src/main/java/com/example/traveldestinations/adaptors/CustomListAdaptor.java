package com.example.traveldestinations.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.traveldestinations.R;
import com.example.traveldestinations.model.Destination;

import java.util.ArrayList;

/**
 * This is adaptor class that add the data from Destination object into the listView
 * Created by prerana on 2/23/2016.
 */
public class CustomListAdaptor extends BaseAdapter {

    private Context mContext;
    private ArrayList<Destination> mDestinations;

    public CustomListAdaptor(Context context, ArrayList<Destination> list){
        mContext = context;
        mDestinations = list;
    }

    @Override
    public int getCount() {
        return mDestinations.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Sets the data for a destination into the view
     * @param position
     * @param convertView
     * @param parent
     * @return View
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewHolder viewHolder = new ViewHolder();
            rowView = inflater.inflate(R.layout.destination_list_item, parent, false);
            viewHolder.textDescription = (TextView) rowView.findViewById(R.id.description);
            viewHolder.textName = (TextView) rowView.findViewById(R.id.display_name);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            rowView.setTag(viewHolder);

        }
        ViewHolder viewHolder = (ViewHolder)rowView.getTag();
        viewHolder.textName.setText(mDestinations.get(position).getDisplayName());
        viewHolder.textDescription.setText(mDestinations.get(position).getDescription());

        return rowView;
    }

    /**
     * ViewHolder class to improve the lookup time of view elements
     */
    static class ViewHolder {
        public TextView textDescription;
        public TextView textName;

    }


}

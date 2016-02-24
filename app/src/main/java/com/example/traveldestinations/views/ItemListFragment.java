package com.example.traveldestinations.views;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.example.traveldestinations.CSVFileReader;
import com.example.traveldestinations.adaptors.CustomListAdaptor;

/**
 * Created by prerana on 2/23/2016.
 */
public class ItemListFragment extends ListFragment{

    public ItemListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CSVFileReader csvReader = new CSVFileReader(getContext());

        CustomListAdaptor listAdaptor = new CustomListAdaptor(getContext(),
                                csvReader.getDestinations());
        setListAdapter(listAdaptor);
    }
}

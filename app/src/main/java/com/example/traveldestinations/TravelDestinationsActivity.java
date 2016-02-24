package com.example.traveldestinations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.traveldestinations.DestinationDetailActivity;

import com.example.traveldestinations.adaptors.CustomListAdaptor;
import com.example.traveldestinations.model.Destination;
import java.util.ArrayList;


/**
 * This is the main activity for this application. It reads the text file that
 * contains the list of cities and keeps it in memory. The list of cities along with country and
 * a snippet of description is displayed in the listView.
 * When the user clicks on any item, it displays the image and complete description.
 *
 */
public class TravelDestinationsActivity extends AppCompatActivity {

    private ArrayList<Destination> mDestinations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_destinations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CSVFileReader csvReader = new CSVFileReader(this);
        mDestinations = csvReader.getDestinations();

        CustomListAdaptor listAdaptor = new CustomListAdaptor(this,
                mDestinations);
        ListView listView=(ListView)findViewById(R.id.listview);
        listView.setAdapter(listAdaptor);

        //Handle the click event for the listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent newIntent = new Intent(getApplicationContext(), DestinationDetailActivity.class);
                newIntent.putExtra(Destination.ID_DESCRIPTION,
                        mDestinations.get(position).getDescription());
                newIntent.putExtra(Destination.ID_IMAGEURL,
                        mDestinations.get(position).getUrl());
                startActivity(newIntent);


            }
        });

    }

}

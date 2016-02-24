package com.example.traveldestinations;

import android.content.Context;

import com.example.traveldestinations.model.Destination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import android.util.Log;

/**
 * Created by prerana on 2/23/2016.
 */
public class CSVFileReader {
    private static final String LOG_TAG = CSVFileReader.class.getName();

    private final ArrayList<Destination> mDestinations = new ArrayList<Destination>();
    Context mContext;

    public CSVFileReader(Context context)
    {
        mContext = context;
        //load the destinations
        populateDestinationsFromFile();
    }

    public ArrayList<Destination> getDestinations(){
        return mDestinations;
    }
    /**
	 * Helper method that loads the data from the states.csv and builds
	 * each csv row into a State object which then gets added to the Adapter.
	 */

    private void populateDestinationsFromFile(){

        // Get input stream and Buffered Reader for our data file.
        InputStream is = mContext.getResources().openRawResource(R.raw.cities);
        //InputStream is = mContext.getAssets().open("states.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;

        //Read each line
        try {
            while ((line = reader.readLine()) != null) {

                //Split to separate the name from the capital
                String[] data = line.split(",");

                Log.i("CSVReader", data[0]);
                //Create a State object for this row's data.
                Destination destination = new Destination(data[0], data[1], data[2], data[3]);

                //Add the State object to the ArrayList (in this case we are the ArrayList).
                mDestinations.add(destination);
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error reading cities file", e);
        }
        finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error while closing the input stream", e);
            }
        }
    }



}

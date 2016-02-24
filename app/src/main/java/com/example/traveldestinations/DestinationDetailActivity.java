package com.example.traveldestinations;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.traveldestinations.model.Destination;

import java.io.InputStream;

/**
 *
 * This activity is opened when the user clicks on the city. It downloads the image of the city
 * using the AsyncTask and display the description under the image
 *
 * Created by prerana on 2/23/2016.
 */
public class DestinationDetailActivity extends AppCompatActivity {

    private static final String LOG_TAG = DestinationDetailActivity.class.getName();
    private String mImageUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_list_item_detail);

        //Set the Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get the parameters from the intent
        String description = getIntent().getStringExtra(Destination.ID_DESCRIPTION);
        mImageUrl = getIntent().getStringExtra(Destination.ID_IMAGEURL);

        TextView textView = (TextView)findViewById(R.id.description);
        ImageView imageView = (ImageView)findViewById(R.id.city_image);
        //Set the description in TextView
        textView.setText(description);
        //Start the AsyncTask to download the image using the url
        new DownloadImageTask(mImageUrl, imageView).execute();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * AsyncTask to handle the downloading of the image and setting it in the image view
     */
    public class DownloadImageTask extends AsyncTask<Void, Void, Bitmap> {
        private ImageView imageView;
        private final String url;

        public DownloadImageTask(String url, ImageView imageView) {
            this.url = url;
            this.imageView = imageView;
            imageView.setImageBitmap(null);
        }

        protected Bitmap doInBackground(Void... voids) {
            Bitmap bitmap = null;
            InputStream in = null;

            try {
                in = new java.net.URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e(LOG_TAG,"Error opening the stream");
            } finally {
                try {
                    in.close();
                } catch (Exception e) {
                    Log.e(LOG_TAG, "Exception closing the input stream", e);
                }
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }

    }
}

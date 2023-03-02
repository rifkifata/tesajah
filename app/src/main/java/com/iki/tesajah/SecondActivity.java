package com.iki.tesajah;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class SecondActivity extends AppCompatActivity {
    ImageView selectedImage;
    TextView txtNamaorang;
    String txtUrls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /*byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
*/
        //selectedImage = (ImageView) findViewById(R.id.selectedImage); // init a ImageView
        selectedImage = (ImageView) findViewById(R.id.selectedImage); // init a ImageView
        txtNamaorang = (TextView) findViewById(R.id.halo);


        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        //selectedImage.setImageBitmap(bmp); // get image from Intent and set it in ImageView
        txtNamaorang.setText(intent.getStringExtra("message")); // get image from Intent and set it in ImageView

        new DownloadImageTask((ImageView) findViewById(R.id.selectedImage))
                .execute(intent.getStringExtra("txtUrls"));

    }
    //proses image
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

package com.iki.tesajah;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter {
    ArrayList personNames;
    ArrayList links;
    ArrayList personImages;
    Context context;
    public CustomAdapter(Context context, ArrayList personNames, ArrayList personImages, ArrayList links) {
        this.context = context;
        this.personNames = personNames;
        this.personImages = personImages;
        this.links = links;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflate the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,int position) {
        TextView name = (TextView) holder.itemView.findViewById(R.id.name);
        ImageView image = (ImageView) holder.itemView.findViewById(R.id.image);

        //Log.d("tesdoang : ", String.valueOf(position));

        String namaorang = (String) personNames.get(position);
        String linknya = (String) links.get(position);
/*
        URL url = null;
        try {
            url = new URL(linknya);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        byte[] byteArray = new byte[0];
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            //Convert to byte array
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();


        } catch (IOException e) {
            e.printStackTrace();
        }*/



        //imageView.setImageBitmap(bmp);

        //name.setText(personNames.get(Integer.parseInt(asd)));
        //image.setImageResource(personImages.get(position));
        // implement setOnClickListener event on item view.

        //byte[] finalByteArray = byteArray;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
               /* Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent*/
                //toast
                CharSequence text = String.valueOf(namaorang);
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                /*Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("message", text);*/
                Intent in1 = new Intent(context, SecondActivity.class);
                in1.putExtra("txtUrls", linknya);
                context.startActivity(in1);

            }
        });


    }

    /*@Override
    public MyViewHolder onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText((Integer) personNames.get(position));
        holder.image.setImageResource((Integer) personImages.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }*/

    /*@Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        holder.name.setText(personNames.get(position));
        holder.image.setImageResource(personImages.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });
    }*/
    @Override
    public int getItemCount() {
        return personNames.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}

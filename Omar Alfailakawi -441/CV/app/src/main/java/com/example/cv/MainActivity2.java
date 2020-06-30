package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Button Back = findViewById(R.id.Back);
        final Button Call = findViewById(R.id.Call);
        final Button openMail = findViewById(R.id.Email);
        final TextView Name = findViewById(R.id.textView2);
        final TextView Age = findViewById(R.id.textView3);
        final TextView Job = findViewById(R.id.textView4);
        final TextView Phone = findViewById(R.id.textView5);
        final TextView Email = findViewById(R.id.textView6);
        final ImageView Pic = findViewById(R.id.PFP);

        Bundle b = getIntent().getExtras();

        Name.setText(b.getString("Name"));
        Age.setText(b.getString("Age"));
        Job.setText(b.getString("Job"));
        Phone.setText(b.getString("Phone"));
        Email.setText(b.getString("Email"));
        String MyPath = b.getString("MyPath");



        Uri selectedImage = Uri.parse(MyPath);
        Pic.setImageURI(selectedImage);
        MyPath= selectedImage.toString();


        final String Number = b.getString("Phone");
        final String Mail = b.getString("Email");


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(back);
            }
        });

        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", Number, null));
                startActivity(intent);
            }
        });

        openMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", Mail, null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });


    }


}
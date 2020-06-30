package com.example.cv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    Intent nextPage;
String MyPath;
    ImageView Profile_pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText Name = findViewById(R.id.NameET);
        final EditText Age = findViewById(R.id.AgeET);
        final EditText Job = findViewById(R.id.JobET);
        final EditText Phone = findViewById(R.id.PhoneET);
        final EditText Email = findViewById(R.id.EmailET);
        final Button Next = findViewById(R.id.Next);
        final Button Upload = findViewById(R.id.Upload);
        Profile_pic = findViewById(R.id.PFP);


        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage = new Intent(MainActivity.this, MainActivity2.class);
                nextPage.putExtra("Name", Name.getText().toString());
                nextPage.putExtra("Age", Age.getText().toString());
                nextPage.putExtra("Job", Job.getText().toString());
                nextPage.putExtra("Phone", Phone.getText().toString());
                nextPage.putExtra("Email", Email.getText().toString());
                nextPage.putExtra("MyPath", MyPath);

                startActivity(nextPage);

            }
        });

        Upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pickFromGallery();

            }

            ;

        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final int GALLERY_REQUEST_CODE = 3;
        if (resultCode == Activity.RESULT_OK)
            switch (requestCode) {
                case GALLERY_REQUEST_CODE:
                    Uri selectedImage = data.getData();
                    Profile_pic.setImageURI(selectedImage);
                   MyPath= selectedImage.toString();

                    break;
            }
    }


    public void pickFromGallery() {
        final int GALLERY_REQUEST_CODE = 3;
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
        startActivityForResult(intent, GALLERY_REQUEST_CODE);
    }

    ;
}

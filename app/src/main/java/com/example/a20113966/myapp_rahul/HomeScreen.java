package com.example.a20113966.myapp_rahul;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by 20113966 on 19-10-2016.
 */
public class HomeScreen extends AppCompatActivity {
    private String userName ="";
    private TextView txtUserName;
    private ImageView ivProfilePic ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        initialize();

        if(getIntent().hasExtra("userName")) {
            userName = getIntent().getStringExtra("userName");
        }
        String sourceString =  "Welcome, " + "<b>" + userName + "</b> ";
        txtUserName.setText(Html.fromHtml(sourceString));

        Picasso.with(HomeScreen.this)
                .load("http://vignette2.wikia.nocookie.net/locopedia/images/8/83/200px-Micky.jpg/revision/latest?cb=20070509181125")
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher)
                .into(ivProfilePic);
    }

    private void initialize() {

        txtUserName = (TextView) findViewById(R.id.txtLoggedInUser);
        ivProfilePic = (ImageView) findViewById(R.id.ivProfilePic);
    }
}

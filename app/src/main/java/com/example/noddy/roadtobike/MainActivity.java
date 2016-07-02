package com.example.noddy.roadtobike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button MountGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MountGo = (Button) findViewById(R.id.test1);
        MountGo.setOnClickListener(this);



    }
    @Override
    public void onClick(View v) {

        /* for choice menu */
        Intent intent;

        if(v.getId() == R.id.test1)
        {

            intent =new Intent(this, MountRoad.class);
            startActivity(intent);

        }
        else if(v.getId() == R.id.seachoice)
        {
            intent = new Intent(this, SeaRoad.class);
        }


    }

}

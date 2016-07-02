package com.example.noddy.roadtobike;
/*메인 페이지*/
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button MountGo;
    Button SeaGo;
    Button WhereGo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        /*Button for main menu*/
        MountGo = (Button) findViewById(R.id.mountchoice_btn);
        SeaGo = (Button) findViewById(R.id.seachoice_btn);
        WhereGo = (Button) findViewById(R.id.wherechoice_btn);
        MountGo.setOnClickListener(this);
        SeaGo.setOnClickListener(this);
        WhereGo.setOnClickListener(this);



    }
    /* for Button event when it is pushed */
    @Override
    public void onClick(View v) {

        /* for choice menu */
        Intent intent;

        if(v.getId() == R.id.mountchoice_btn)
        {

          intent =new Intent(this, MountRoad.class);
          startActivity(intent);

        }
        else if(v.getId() == R.id.seachoice_btn)
        {
          intent = new Intent(this, SeaRoad.class);
          startActivity(intent);
        }else if(v.getId() == R.id.wherechoice_btn)
        {
          intent = new Intent(this, WhereBike.class);
          startActivity(intent);
        }


    }

}

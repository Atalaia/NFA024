package fr.parisstreetart.com.parisstreetart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button btnPosition;
    Button btnGraffitisListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnPosition = (Button) findViewById(R.id.btn_graffitislocation_main);

        btnPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, graffitisLocation.class);
                startActivity(i);
            }
        });


        btnGraffitisListView = (Button) findViewById(R.id.btn_graffitislistview_main);

        btnGraffitisListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, graffitisListView.class);
                startActivity(i);
            }
        });

    }

}

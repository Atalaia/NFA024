package com.guidetouristique.fr.guidetouristique;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuideMenu extends AppCompatActivity {

    Button btnPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_menu);

        btnPosition = (Button) findViewById(R.id.button_maPosition_main);

        btnPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(GuideMenu.this,MaPosition.class);
                startActivity(i);
            }
        });

    }
}

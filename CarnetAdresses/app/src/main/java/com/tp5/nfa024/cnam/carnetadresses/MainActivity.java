package com.tp5.nfa024.cnam.carnetadresses;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
    }

    public void action(final View v){
        switch (v.getId()){
            case R.id.main_creer_btn: {
                Toast.makeText(this, R.string.fonctionnalite_creer,Toast.LENGTH_SHORT).show();
                this.startActivity(new Intent(this, CreationActivity.class));
                break;
            }
            case R.id.main_all_btn: {
                Toast.makeText(this, R.string.fonctionnalite_tous,Toast.LENGTH_SHORT).show();
                break;
            }
        }

    }

}

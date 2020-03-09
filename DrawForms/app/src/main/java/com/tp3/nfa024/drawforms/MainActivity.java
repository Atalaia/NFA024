package com.tp3.nfa024.drawforms;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    MaVue v;
  //  Thread t;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.v= (MaVue)this.findViewById(R.id.main_vue_mv);
    }
/*
    //ici c'est où on doit démarrer les tâches dynamiques de l'application
    @Override
    public void onResume(){
        super.onResume();
        //Thread pour animer les objets
        this.t = new Thread(){
            //le code à executer dans la Thread
            public void run(){
                while(true){
                    try{
                        Thread.sleep(50);
                    }
                    catch (InterruptedException ex){

                    }
                    MainActivity.this.v.anime();
                    MainActivity.this.runOnUiThread(new Runnable(){
                        public void run(){
                            v.invalidate();
                        }
                     });
                }
            }
        };
        this.t.start();
    }

    @Override
    public void onPause(){
        super.onPause();
        this.t.stop(null);
        this.t = null;
    }
    */

    public void drawIt(View v){
        //this.v.clicked = true;
        //this.v.clicked != this.v.clicked;
        this.v.addForm();
        this.v.invalidate();
       // this.v.anime();
    }
}

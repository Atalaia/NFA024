package com.tp3.nfa024.drawforms;

import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by mariasoage on 24/3/17.
 */

public class MaVue extends View
{
    public boolean clicked= false;

    ArrayList<Form> objetsADessiner = new ArrayList<Form>();

    final Paint p = new Paint();
    {
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(4);
    }

    final Paint p2 = new Paint(p);
    {
        p2.setColor(Color.BLUE);
    }

    public MaVue(Context activity, AttributeSet s){
        super(activity, s);
        /*
        for(int i=0; i < 10; i++){
            this.objetsADessiner.add(new Ball());
        }
         */
    }

    public static int composante(){
        return (int)(Math.random()*256*256*256*256+1);
    }

    @Override
    public void onDraw(final Canvas c){
        if(this.clicked) {
            //c.drawColor(composante());
            //c.drawRect(10, 10, 200, 200, p);
            //c.drawCircle(300, 300, 20, p2);
            for(Form b : this.objetsADessiner){
                b.dessinMoi(c);
            }
        }
    }

    public void addForm(){
        this.clicked = true;
        int w = this.getWidth();
        int h = this.getHeight();

        Form f = null;

        switch((int)(Math.random()*2)){
            case 0 : f = new Ball(w,h); break;
            case 1 : f = new Rectangle(w,h); break;
        }
        this.objetsADessiner.add(f);
    }



/*
    public void anime(){
        for(Ball c : this.objetsADessiner){
            c.animate();
        }
    }

    */
}

/*
MaVue extends View

ArrayList<Form> liste

public void onDraw(Canvas c){
    for(Ball b : liste){
        b.draw(c);
    }
}
 */

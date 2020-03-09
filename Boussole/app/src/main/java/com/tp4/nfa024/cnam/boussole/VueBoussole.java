package com.tp4.nfa024.cnam.boussole;

import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.content.Context;

/**
 * Created by mariasoage on 21/4/17.
 */

/**
class Variateur extends Thread
{
    private VueBoussole v;
    private float angle = 0;

    public Variateur(final VueBoussole v){
        this.v = v;
    }
    @Override
    public void run(){
        while(true) {
            this.angle += 0.01;
            /*this.v.post(new Runnable() {

                public void run () {

                    v.setAngle(angle);
                }
            });

            this.v.setAngle(angle);
            try {
                Thread.sleep(100);
            } catch (InterruptedException ie) {}
        }
    }
}
*/

public class VueBoussole extends View
{
    private Paint p = new Paint();
    {
        p.setColor(Color.BLUE);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(2);
    }

    private Paint p_fleche = new Paint(this.p);
    {
        this.p_fleche.setColor(Color.RED);
    }

    private float angle = 0;

    public VueBoussole(final Context ctx, final AttributeSet attrs)
    {
        super(ctx, attrs);
       // new Variateur(this).start();
    }

    @Override
    public void onDraw(final Canvas c)
    {
        final float centerX = this.getWidth()/2;
        final float centerY = this.getHeight()/2;
        float radius = Math.round(Math.min(centerX, centerY)*0.8);
        c.drawCircle(centerX, centerY, radius, this.p);
        c.drawLine(centerX, centerY,
                centerX + radius*(float)Math.cos(this.angle),
                centerY - radius*(float)Math.sin(this.angle),
                this.p_fleche);
    }

    public void setAngle(final float angle)
    {
        this.angle = angle;
       // this.invalidate();

        this.post(new Runnable(){
           @Override
            public void run(){
               VueBoussole.this.invalidate();
           }
        });
    }

}

package com.tp3.nfa024.drawforms;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by mariasoage on 31/3/17.
 */

    public abstract class Form {
        float x;
        float y;
        Paint p = new Paint();

    Form(int x, int y){
        this.x=(int)(Math.random()*x);
        this.y=(int)(Math.random()*y);
        p.setARGB(composante(),composante(),composante(),composante());
    }

    public static int composante(){
        return(int)(Math.random()*255);
    }

    public abstract void dessinMoi(Canvas c);

}

    class Rectangle extends Form
    {
        float width = (int)(Math.random()*40+1);
        float height = (int)(Math.random()*40+1);

        Rectangle(int x, int y) {
            super(x, y);
        }

        @Override
        public void dessinMoi(final Canvas c){
         c.drawRect(this.x-this.width/2,this.y-this.height/2,
                 this.x+this.width/2,this.y+this.height/2,this.p);
        }
    }


    class Ball extends Form
    {
        private float r = (float)(Math.random()*40+1);

        Ball(int x, int y) {
            super(x, y);
        }

        @Override
        public void dessinMoi(final Canvas c){
            c.drawCircle(this.x,this.y,this.r,this.p);
        }
    }


/*
class Rectangle extends Form{
    float x0,y0,x1,y1;

    public void draw(Canvas c){
        c.drawRect(x0,y0,x1,y1, p);
    }
}

class Circle extends Form{
    float x0,y0,x1,y1;

    public void draw(Canvas c){
        c.drawRect(x0,y0,x1,y1, p);
    }
}
*/

/*
class Ball
{
    float x;
    float y;
    float radius;
    Paint p;

    Ball(){
        this.x=(int)(Math.random()*300+1);
        this.y=(int)(Math.random()*300+1);
        this.radius=(int)(Math.random()*40+1);
        this.p=new Paint();
        p.setColor(MaVue.composante());
    }

    public void dessinMoi(final Canvas c){
        c.drawCircle(this.x,this.y,this.radius,this.p);
    }

    public void animate(){
        this.x = (this.x+10)*300;
    }
}

*/
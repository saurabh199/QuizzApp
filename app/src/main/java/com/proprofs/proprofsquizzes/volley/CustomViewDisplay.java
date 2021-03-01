package com.proprofs.proprofsquizzes.volley;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class CustomViewDisplay extends View {

    private int shapeWidth = 100;
    private int shapeHeight = 200;
    private int textXOffset = 0;
    private int textYOffset = 30;
    private Paint paint;
    Paint fillColor;
    private static int colorValue;

    public CustomViewDisplay(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        fillColor = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.invalidate();
      //  paint.setColor(0xA39984); // set color
       paint.setColor(0xDEE2111);
        fillColor.setColor(Color.parseColor("#45B832"));
        paint.setStrokeWidth(76);
        // set stroke width
       fillColor.setStrokeWidth(76);

        canvas.drawLine(50, 0, 500, 0, paint);
        canvas.drawRoundRect(5,5,3,1,0,0,paint);

        canvas.drawLine(50, 0, (float) colorValue, 0, fillColor);
       /* paint.setStyle(Paint.Style.STROKE);

        paint.setColor(Color.YELLOW);
        fillColor.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5.0f);

        int  h = this.getHeight();
        int  w = this.getWidth();
        //final RectF rect = new RectF();

        RectF oval1 = new RectF(0, 0, w, h);
      //  canvas.drawLine(50, 0, (float) colorValue, 0, fillColor);
        canvas.drawRoundRect(oval1, 40, 40, paint);*/
       /* int  h = this.getHeight();
        int  w = this.getWidth();
        //final RectF rect = new RectF();

        RectF oval1 = new RectF(0, 0, w, h);
        canvas.drawRoundRect(oval1, 40, 40, paint);
        fillColor.setColor(Color.BLUE);*/
    }
   /* private void drawRoundedRect(Canvas canvas, float left, float top, float right, float bottom) {
        float radius = getHeight() / 2;
        canvas.drawCircle(radius, radius, radius, paint);
        canvas.drawCircle(right - radius, radius, radius, paint);
        canvas.drawRect(left + radius, top, right - radius, bottom, paint);
    }*/
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
      //  setMeasuredDimension(420, 65);
   //    setMeasuredDimension(290, 60);
      // setMeasuredDimension(R.dimen.pro_width, R.dimen.pro_height);
        // set desired width and height of your
        // layout
        super.onMeasure(widthMeasureSpec, heightMeasureSpec); // Don't for get this
        int parentWidth = ((View) getParent()).getMeasuredWidth();
        int parentHeight = ((View) getParent()).getMeasuredHeight();
        if (parentWidth*parentHeight != 0) { // Check if both width and height in non-zero
            ViewGroup.LayoutParams lp = getLayoutParams();
            lp.width = (int) (parentWidth / 3);
            lp.height = parentHeight;
        }
    }

    public static void sendvalue(int value) {
       colorValue = value;
    }

}

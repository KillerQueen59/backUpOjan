package com.example.costumview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import static android.view.Gravity.CENTER;

public class ButtonDude extends AppCompatButton {
    private Drawable enableBackground,disableBackground;
    private  int textColor;

    public ButtonDude(Context context) {
        super(context);
        init();
    }

    public ButtonDude(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonDude(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackground(isEnabled()? enableBackground : disableBackground);
        setTextColor(textColor);
        setTextSize(12.f);
        setGravity(CENTER);
        setText(isEnabled() ? "Submit" : "Isi dulu Bosh");
    }
    private void init(){
        textColor = ContextCompat.getColor(getContext(),android.R.color.background_light);
        enableBackground = getResources().getDrawable(R.drawable.btn_enable);
        disableBackground = getResources().getDrawable(R.drawable.btn_disable);
    }
}

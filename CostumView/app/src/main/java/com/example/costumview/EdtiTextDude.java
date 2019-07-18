package com.example.costumview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class EdtiTextDude extends AppCompatEditText {

    Drawable mClearButtonImage;

    public EdtiTextDude(Context context) {
        super(context);
        init();
    }

    public EdtiTextDude(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EdtiTextDude(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        mClearButtonImage = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_clear_black_24dp,null);//
        setOnTouchListener(new OnTouchListener() { //
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public boolean onTouch(View v, MotionEvent event) {//
                if ((getCompoundDrawablesRelative()[2] != null)){ //
                    float clearButtonStart;
                    float clearButtonEnd;
                    boolean isClearButtonClicked = false;
                    if (getLayoutDirection()== LAYOUT_DIRECTION_RTL){ //
                        clearButtonEnd = mClearButtonImage.getIntrinsicWidth()+getPaddingStart();//
                        if (event.getX() < clearButtonEnd){//
                            isClearButtonClicked = true;
                        }
                    }else {
                        clearButtonStart = (getWidth() - getPaddingEnd() - mClearButtonImage.getIntrinsicWidth());//
                        if (event.getX() > clearButtonStart){
                            isClearButtonClicked = true;
                        }
                    }
                    if (isClearButtonClicked){
                        if (event.getAction()== MotionEvent.ACTION_DOWN){
                            mClearButtonImage = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_clear_black_24dp,null);
                            showClearButton();
                            return true;
                        }else if (event.getAction()==MotionEvent.ACTION_UP){
                            mClearButtonImage = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_clear_black_24dp,null);
                            if (getText()!= null){
                                getText().clear();
                            }
                            hideClearButton();
                            return true;
                        }else {
                            return false;
                        }
                    }return false;
                }
                return false;
            }
        });

        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().isEmpty()){
                    showClearButton();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void showClearButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,mClearButtonImage,null);// munculin tanda x
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void hideClearButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null,null,null,null);    // ngilangin tanda x
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setHint("Masukkan Nama Anda");
        setTextAlignment(TEXT_ALIGNMENT_TEXT_START);
    }
}

package com.example.wachiraya_kam.helloworld;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by Wachiraya_Kam on 2/3/2017.
 */

public class CustomViewGroup extends FrameLayout {
    private Button btnHello;
    public CustomViewGroup(Context context) {
        super(context);
        initInflate();
        initInstance();
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstance();
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstance();
    }

    @TargetApi(21)
    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstance();
    }

    private void initInflate(){
        //Inflate Layout Here
        inflate(getContext(), R.layout.sample_layout, this);
    }

    private void initInstance(){
        //findViewById here
        btnHello = (Button) findViewById(R.id.btnCustomViewGroupHello);
    }

    public void setButtonText (String text){
        btnHello.setText(text);
    }
}

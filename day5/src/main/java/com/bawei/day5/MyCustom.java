package com.bawei.day5;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jch on 2017/9/1.
 */

public class MyCustom extends RelativeLayout {

    private Drawable topBarBackground;
    private String title;
    private int titleColor;
    private float titleSize;
    private String buttonText;
    private Drawable buttonBackground;

    private Button back_btn;
    private TextView tv_title;

    public MyCustom(Context context, AttributeSet attrs) {
        super(context, attrs);

        initAttr(attrs,context);
    }


    private void initAttr(AttributeSet attrs, Context context) {

        TypedArray typedArray = context
                .obtainStyledAttributes(attrs,R.styleable.MyCustom);

        topBarBackground = typedArray.getDrawable(R.styleable.MyCustom_mycustombackgroud);
        title = typedArray.getString(R.styleable.MyCustom_title);
        titleColor = typedArray.getColor(R.styleable.MyCustom_titleColor,0);
        titleSize = typedArray.getDimension(R.styleable.MyCustom_titleSize,0);
        buttonText = typedArray.getString(R.styleable.MyCustom_buttonText);
        buttonBackground = typedArray.getDrawable(R.styleable.MyCustom_buttonBackground);

        typedArray.recycle();


        back_btn = new Button(context);
        tv_title = new TextView(context);

        back_btn.setText(buttonText);
        back_btn.setBackground(buttonBackground);

        tv_title.setText(title);
        tv_title.setTextColor(titleColor);
        tv_title.setTextSize(titleSize);

        setBackground(topBarBackground);


        setParams();

    }

    private void setParams() {


        LayoutParams titleLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        LayoutParams buttonLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        titleLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        buttonLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);


        addView(tv_title,titleLayoutParams);
        addView(back_btn,buttonLayoutParams);


        back_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                mOnButClickListener.onButClick();
            }
        });

    }


    public interface OnButClickListener{
        void onButClick();
    }
    private OnButClickListener mOnButClickListener;

    public void setOnButClickListener(OnButClickListener mOnButClickListener){
        this.mOnButClickListener = mOnButClickListener;
    }

}

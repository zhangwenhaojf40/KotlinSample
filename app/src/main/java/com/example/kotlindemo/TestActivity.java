package com.example.kotlindemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kotlindemo.present.BasePresent;
import com.example.kotlindemo.ui.activity.BaseActivity;

import org.jetbrains.annotations.Nullable;

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/17 0017
 */
public class TestActivity extends BaseActivity {


    @Nullable
    @Override
    public BasePresent initPresent() {
        return null;
    }

    @Override
    public void initView() {

    }


    @Override
    public void initData() {
        final TextView tv = findViewById(R.id.tv_html);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, tv.getWidth()+"=="+tv.getHeight(), Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TranslateAnimation animation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400,
                        Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 400);
                animation.setFillAfter(true);
                animation.setDuration(1000);
                tv.startAnimation(animation);

               /* ValueAnimator animator = ValueAnimator.ofInt(0, 400);
                animator.setDuration(500);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int)animation.getAnimatedValue();
                        tv.layout(curValue, curValue, curValue + tv.getWidth(), curValue + tv.getHeight());
                    }
                });
                animator.start();*/

            }
        });

    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_test;
    }


    public void onWindowFocusChanged(boolean hasFocus){

    };

}

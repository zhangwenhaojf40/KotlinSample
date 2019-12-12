package com.example.kotlindemo.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.kotlindemo.ui.activity.MyApplication

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/12 0012
 */
class GlideUtils {
    companion object{
        fun setGlide(image:ImageView?,url:String?){
            Glide.with(MyApplication.getInstance())
                .load(url)
                .into(image)
        }
    }

}
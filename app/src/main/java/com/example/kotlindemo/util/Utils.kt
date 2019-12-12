package com.example.kotlindemo.util

import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.kotlindemo.ui.activity.MyApplication

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/2 0002
 */

fun Toast.showToast(msg:String)=
    Toast.makeText(MyApplication.getInstance(),msg, Toast.LENGTH_SHORT).show()

fun Context.showToast(msg:String)=
    Toast.makeText(MyApplication.getInstance(),msg, Toast.LENGTH_SHORT).show()

fun TextView.isBold() = this.apply {
    paint.isFakeBoldText = true
}

fun Any.log(message:String,tag:String){
    Log.i(message,tag)
}

package com.example.kotlindemo.net

import android.util.Log
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/6 0006
 */
class Test {
    fun test(){
        val logInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            //打印retrofit日志
            Log.i("RetrofitLog", "retrofitBack = $message")
        })
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
}
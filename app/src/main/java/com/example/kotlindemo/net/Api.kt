package com.example.kotlindemo.net

import android.app.Activity
import android.util.Log
import com.example.kotlindemo.net.gson.CustomGsonConverterFactory
import com.example.kotlindemo.util.log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/3 0003
 */
object  Api {
    private val mRetrofit: Retrofit
    val DEFAULT_TIMEOUT = 30

    val mHeaderInterceptor=Interceptor{
        val builder = it.request().newBuilder()
        builder.addHeader(
            "User-Agent",
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.108 Safari/537.36 2345Explorer/8.0.0.13547"
        )
        builder.addHeader("Cache-Control", "max-age=0")
        builder.addHeader("Upgrade-Insecure-Requests", "1")
        builder.addHeader("X-Requested-With", "XMLHttpRequest")
        builder.addHeader(
            "Cookie",
            "uuid=\"w:f2e0e469165542f8a3960f67cb354026\"; __tasessionId=4p6q77g6q1479458262778; csrftoken=7de2dd812d513441f85cf8272f015ce5; tt_webid=36385357187"
        )
        it.proceed(builder.build())
    }
    val loggingInterceptor=HttpLoggingInterceptor(HttpLoggingInterceptor.Logger{messsage->
        Log.i("RetrofitLog", "retrofitBack = $messsage")

    })
    private val okHttpClient:OkHttpClient=
        OkHttpClient.Builder()
            .connectTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .readTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
//            .addInterceptor(mHeaderInterceptor)
            .addInterceptor(loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    init {
        mRetrofit=Retrofit.Builder()
            .baseUrl("http://is.snssdk.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())//可以添加自定义解析器和默认的解析器
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加响应式编程的适配器
            .build()
    }
    fun create():NetWorkApi{
       return  mRetrofit.create(NetWorkApi::class.java)
    }


}
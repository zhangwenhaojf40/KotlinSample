package com.example.kotlindemo.net

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/3 0003
 */
object RxSchedulers {

    fun <T> io_main(): ObservableTransformer<T, T> {

        return ObservableTransformer { upstream ->
            upstream
                .subscribeOn(Schedulers.io())//指定联网请求的线程，事件产生的线程
                .observeOn(AndroidSchedulers.mainThread())//指定doOnTerminate的线程
        }
    }


}
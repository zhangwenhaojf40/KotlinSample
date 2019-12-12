package com.example.kotlindemo.net

import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/6 0006
 */
abstract class BaseObserver<T> : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }


    override fun onError(e: Throwable) {
    }

}
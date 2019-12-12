package com.example.kotlindemo.ui.fragment

import android.os.Bundle
import com.example.kotlindemo.present.BasePresent

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/11 0011
 */
abstract class BaseFragmentMvp<P :BasePresent> :BaseFragment() {
    var mPresent: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresent=initPresent()
    }

    abstract fun initPresent(): P?
}
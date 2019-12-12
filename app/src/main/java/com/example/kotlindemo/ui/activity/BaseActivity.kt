package com.example.kotlindemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlindemo.present.BasePresent

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/2 0002
 */
abstract class BaseActivity<P : BasePresent> :AppCompatActivity() {
    var present: P? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())
        present=initPresent()
        initView()
        initData()
    }

    abstract fun initPresent(): P?

    abstract fun initView()

    abstract fun initData()

    abstract fun getLayoutRes(): Int
}
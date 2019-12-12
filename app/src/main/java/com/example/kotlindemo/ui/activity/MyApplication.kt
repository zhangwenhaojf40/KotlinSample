package com.example.kotlindemo.ui.activity

import android.app.Application

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/2 0002
 */
class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        instanc = this
    }
    companion object{
        var instanc:Application?=null;
        fun getInstance():Application{
            return instanc!!
        }
    }



}
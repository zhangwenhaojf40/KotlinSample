package com.example.kotlindemo.iview

import com.example.kotlindemo.bean.Data
import com.example.kotlindemo.bean.NewsBean

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/11 0011
 */
interface INewsFragment {
    fun loadDataList(list:ArrayList<NewsBean>,info:String)

    fun initAdapter()
}
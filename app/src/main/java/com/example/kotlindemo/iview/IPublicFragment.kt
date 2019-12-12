package com.example.kotlindemo.iview

import com.example.kotlindemo.bean.Data


/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/6 0006
 */
interface IPublicFragment {
    fun loadData(publicFragmentBean: List<Data>)
}
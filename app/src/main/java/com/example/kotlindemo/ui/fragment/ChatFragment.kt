package com.example.kotlindemo.ui.fragment

import android.os.Bundle
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.Data
import com.example.kotlindemo.iview.ImChatFragment

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/2 0002
 */
class ChatFragment :BaseFragment(),ImChatFragment {
    override fun getBundles(arguments: Bundle) {
    }

    override fun loadData(list: List<Data>) {
        println(list.size)

    }

    override fun initData() {
    }

    override fun initView() {
    }

    override fun getLayoutRes(): Int = R.layout.fragment_public

}
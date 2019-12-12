package com.example.kotlindemo.ui.fragment

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.NewsFragmentAdapter
import com.example.kotlindemo.bean.NewsBean
import com.example.kotlindemo.iview.INewsFragment
import com.example.kotlindemo.present.NewsFragmentPresent
import kotlinx.android.synthetic.main.fragment_news.*

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/11 0011
 */
class NewsFragment :BaseFragmentMvp<NewsFragmentPresent>(), INewsFragment {
    var list=ArrayList<NewsBean>()
    var  mAdapter:NewsFragmentAdapter?=null

    override fun setAdapter() {
        mAdapter=NewsFragmentAdapter(mCode,list)
        mRecyclerViewe.layoutManager=LinearLayoutManager(activity)
        mRecyclerViewe.adapter=mAdapter
    }

    override fun loadDataList(list: ArrayList<NewsBean>, info: String) {
        mAdapter?.setNewData(list)
    }

    override fun initPresent(): NewsFragmentPresent? = NewsFragmentPresent(this)

    companion object{
        val CHANNEL="channel"
        val CODE = "code"
    }
    var  mChannel:String?=null
    var  mCode: String?=null

    override fun getBundles(arguments: Bundle) {
        mChannel = arguments.getString(CHANNEL)
        mCode= arguments.getString(CODE)
    }

    override fun initView() {

    }

    override fun getLayoutRes(): Int = R.layout.fragment_news

    override fun initData() {
        setAdapter()
        mPresent?.setNetList(mCode!!)

    }
}
package com.example.kotlindemo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.HomeFragmentViewpage
import com.example.kotlindemo.iview.ImHomeFragment
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/2 0002
 */
class HomeFragment :BaseFragment(),ImHomeFragment {
    override fun getBundles(arguments: Bundle) {

    }

    val fragments=ArrayList<Fragment>()
    override fun initViewPage() {
        val channels = resources.getStringArray(R.array.channel)
        val codes = resources.getStringArray(R.array.channel_code)
        for (i in channels.indices){
            val newsFragment=NewsFragment()
            val bundle=Bundle()
            bundle.putString(NewsFragment.CHANNEL,channels[i])
            bundle.putString(NewsFragment.CODE,codes[i])
            newsFragment.arguments=bundle
            fragments.add(newsFragment)
        }
        val mAdapter= HomeFragmentViewpage(fragments,channels,childFragmentManager)
        mViewPage.adapter=mAdapter
        tabLayout.setupWithViewPager(mViewPage)
        mViewPage.offscreenPageLimit=channels.size
    }


    override fun initData() {
    }

    override fun initView() {
        initViewPage()
    }

    override fun getLayoutRes(): Int = R.layout.fragment_home



}
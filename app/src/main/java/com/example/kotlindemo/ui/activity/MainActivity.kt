package com.example.kotlindemo.ui.activity

import android.os.Bundle
import com.example.kotlindemo.R
import com.example.kotlindemo.adapter.MainViewPageAdapter
import com.example.kotlindemo.bottom.TabUtils
import com.example.kotlindemo.present.MainPresent
import com.example.kotlindemo.ui.fragment.*
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.fragment_home.mViewPage

class MainActivity : BaseActivity<MainPresent>() {
    override fun initPresent(): MainPresent? = MainPresent()
    var mHomeFragment: HomeFragment? = null
    var mVideoFragment: VideoFragment? = null
    var mChatFragment: ChatFragment? = null
    var mMeFragment: MeFragment? = null
    val mFragments=ArrayList<BaseFragment>()
    override fun initView() {
        initTabLayout()
    }

    private fun initTabLayout() {
        val tabUtils=TabUtils()
        val vBottomTabLayout = findViewById<CommonTabLayout>(R.id.vBottomTabLayout)
        tabUtils.setData(vBottomTabLayout)
        vBottomTabLayout.setOnTabSelectListener(object :OnTabSelectListener{
            override fun onTabSelect(position: Int) {
                mViewPage.setCurrentItem(position,false)
            }
            override fun onTabReselect(position: Int) {
            }

        })
    }


    private fun initFragment1() {
        mHomeFragment = HomeFragment()
        mVideoFragment= VideoFragment()
        mChatFragment= ChatFragment()
        mMeFragment = MeFragment()
        mFragments.add(mHomeFragment!!)
        mFragments.add(mVideoFragment!!)
        mFragments.add(mChatFragment!!)
        mFragments.add(mMeFragment!!)
    }

    override fun initData() {
        initFragment1()
        initAdapter()

    }

    private fun initAdapter() {
        mViewPage.adapter= MainViewPageAdapter(supportFragmentManager,mFragments)
        mViewPage.offscreenPageLimit=mFragments.size

    }

    override fun getLayoutRes(): Int = R.layout.activity_main

}

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
    val TAG_HOME = "home"
    val TAG_VIDEO = "video"
    val TAG_CHAT = "chat"
    val TAG_ME = "me"
    val CURRENT_POSITION = "current"
    var mCurrentPosition = 0
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
//                switchFragment(position)
            }
            override fun onTabReselect(position: Int) {
            }

        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        initFragment(savedInstanceState)

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

    private fun initFragment(bundle: Bundle?) {/*
        val beginTransaction=supportFragmentManager.beginTransaction()
        mFragments.clear()
        mCurrentPosition = bundle?.getInt("", 0) ?: 0
        mHomeFragment = supportFragmentManager.findFragmentByTag(TAG_HOME) as HomeFragment?

        if (mHomeFragment != null) {
            mVideoFragment = supportFragmentManager.findFragmentByTag(TAG_VIDEO) as VideoFragment?
            mChatFragment = supportFragmentManager.findFragmentByTag(TAG_CHAT) as ChatFragment?
            mMeFragment = supportFragmentManager.findFragmentByTag(TAG_ME) as MeFragment?
        } else {
            if (mHomeFragment == null) {
                mHomeFragment = HomeFragment()
                beginTransaction.add(R.id.content, mHomeFragment!!,TAG_HOME)
            }
            if (mVideoFragment == null) {
                mVideoFragment = VideoFragment()
                beginTransaction.add(R.id.content, mVideoFragment!!,TAG_VIDEO)
            }
            if (mChatFragment == null) {
                mChatFragment = ChatFragment()
                beginTransaction.add(R.id.content, mChatFragment!!,TAG_CHAT)
            }
            if (mMeFragment == null) {
                mMeFragment = MeFragment()
                beginTransaction.add(R.id.content, mMeFragment!!,TAG_ME)
            }
        }
        mFragments.add(mHomeFragment!!)
        mFragments.add(mVideoFragment!!)
        mFragments.add(mChatFragment!!)
        mFragments.add(mMeFragment!!)
        beginTransaction.commit()
        switchFragment(mCurrentPosition)
    */}

    override fun initData() {
        initFragment1()
        initAdapter()

    }

    private fun initAdapter() {
        mViewPage.adapter= MainViewPageAdapter(supportFragmentManager,mFragments)
        mViewPage.offscreenPageLimit=mFragments.size

    }

    override fun getLayoutRes(): Int = R.layout.activity_main

    /*fun switchFragment(index: Int) {
        val beginTransaction=supportFragmentManager.beginTransaction()
        for(i in mFragments.indices){
            if(index==i){
                beginTransaction.show(mFragments.get(i))
            }else{
                beginTransaction.hide(mFragments.get(i))
            }
        }
        beginTransaction.commit()
    }*/

   /* override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (tabLayout != null) {
            outState.putInt(CURRENT_POSITION, tabLayout.selectedTabPosition)
        }
    }*/

}

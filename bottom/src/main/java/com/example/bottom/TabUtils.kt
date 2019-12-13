package com.example.kotlindemo.bottom

import com.example.bottom.R
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import kotlinx.android.synthetic.main.include_bottom.*

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/13 0013
 */
class TabUtils {
    val mBottomTitle = arrayOf("首页", "视频", "微聊", "我的")
    val mNormalIcon = arrayOf(
        R.mipmap.tab_home_normal, R.mipmap.tab_video_normal
        , R.mipmap.tab_micro_normal, R.mipmap.tab_me_normal)
    val mSelectIcon= arrayOf(
        R.mipmap.tab_home_selected, R.mipmap.tab_video_selected,
        R.mipmap.tab_micro_selected, R.mipmap.tab_me_selected)
    val mTabs=ArrayList<CustomTabEntity>()
    init {
        for(i in mBottomTitle.indices){
            mTabs.add(TabEntity(mBottomTitle[i], mSelectIcon[i], mNormalIcon[i]))
        }
    }
    fun setData(vBottomTabLayout: CommonTabLayout) {
        vBottomTabLayout.setTabData(mTabs)
    }
}
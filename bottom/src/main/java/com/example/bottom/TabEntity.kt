package com.example.kotlindemo.bottom

import com.flyco.tablayout.listener.CustomTabEntity

class TabEntity(var title: String, var selectedIcon: Int, var unSelectedIcon: Int) :
    CustomTabEntity {
    val mTabs=ArrayList<TabEntity>()


    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }
}

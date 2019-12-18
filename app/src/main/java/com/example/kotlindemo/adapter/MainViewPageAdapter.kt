package com.example.kotlindemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.kotlindemo.ui.fragment.BaseFragment

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/18 0018
 */
class MainViewPageAdapter(fm:FragmentManager,val fragments:List<BaseFragment>) :FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int =fragments.size

    override fun getItem(position: Int): Fragment =fragments.get(position)
}
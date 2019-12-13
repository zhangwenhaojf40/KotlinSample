package com.example.kotlindemo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/11 0011
 */
class HomeFragmentViewpage(val fragments:ArrayList<Fragment>,val channel:Array<String>,fm:FragmentManager) : FragmentStatePagerAdapter(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return fragments.get(position)
    }

    override fun getCount(): Int=fragments.size
    override fun getPageTitle(position: Int): CharSequence? {
        return channel[position]
    }
}
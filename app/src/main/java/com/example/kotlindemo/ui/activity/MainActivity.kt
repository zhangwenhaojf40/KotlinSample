package com.example.kotlindemo.ui.activity

import androidx.fragment.app.FragmentTransaction
import com.example.kotlindemo.R
import com.example.kotlindemo.present.MainPresent
import com.example.kotlindemo.ui.fragment.HomeFragment
import com.example.kotlindemo.ui.fragment.ProjectFragment
import com.example.kotlindemo.ui.fragment.PublicFragment
import com.example.kotlindemo.ui.fragment.SquareFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresent>() {
    override fun initPresent(): MainPresent? =MainPresent()
    var homeFragment: HomeFragment? = null
    var squareFragment: SquareFragment? = null
    var publicFragment: PublicFragment? = null
    var projectFragment: ProjectFragment? = null

    override fun initView() {
        bottomView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_home -> {
                    showFragment(0)
                }
                R.id.action_square -> {
                    showFragment(1)
                }
                R.id.action_wechat -> {
                    showFragment(2)
                }
                R.id.action_project -> {
                    showFragment(3)
                }

            }
            return@setOnNavigationItemSelectedListener true
        }
        showFragment(0)

    }

    override fun initData() {

        val sum1 = sum(3, 5)
    }

    override fun getLayoutRes(): Int = R.layout.activity_main

    fun showFragment(index: Int) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        hideFragments(beginTransaction)
        when (index) {
            0 -> {
                if (homeFragment == null) {
                    homeFragment = HomeFragment()
                    beginTransaction.add(R.id.content, homeFragment!!)
                }
                beginTransaction.show(homeFragment!!)
            }
            1 -> {
                if (squareFragment == null) {
                    squareFragment = SquareFragment()
                    beginTransaction.add(R.id.content, squareFragment!!)
                }
                beginTransaction.show(squareFragment!!)
            }
            2 -> {
                if (publicFragment == null) {
                    publicFragment = PublicFragment()
                    beginTransaction.add(R.id.content, publicFragment!!)
                }
                beginTransaction.show(publicFragment!!)
            }
            3 -> {
                if (projectFragment == null) {
                    projectFragment = ProjectFragment()
                    beginTransaction.add(R.id.content, projectFragment!!)
                }
                beginTransaction.show(projectFragment!!)
            }

        }
        beginTransaction.commit()

    }

    private fun hideFragments(transaction: FragmentTransaction) {
        homeFragment?.let { transaction.hide(it) }
        squareFragment?.let { transaction.hide(it) }
        publicFragment?.let { transaction.hide(it) }
        projectFragment?.let { transaction.hide(it) }

    }

    val sum: (Int , Int)->Int = {x , y -> x + y}

    val b=fun( a:Int):Int{
        return a
    }
}

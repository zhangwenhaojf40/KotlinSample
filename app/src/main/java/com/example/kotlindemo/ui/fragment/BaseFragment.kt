package com.example.kotlindemo.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/2 0002
 */
abstract class BaseFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutRes(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle=if(arguments==null) Bundle() else arguments

        getBundles(bundle!!)


    }

    abstract fun getBundles(arguments: Bundle)

    abstract fun initData()

    abstract fun initView()

    abstract fun getLayoutRes(): Int
}
package com.example.kotlindemo.bean

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/3 0003
 */

data class PublicFragmentBean(
    val `data`: List<Data>,
    val errorCode: Int,
    val errorMsg: String
)

data class Data(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)
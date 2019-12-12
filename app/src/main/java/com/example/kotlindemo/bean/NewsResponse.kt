package com.example.kotlindemo.bean

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/11 0011
 */
data class NewsResponse(
    val action_to_last_stick: Int,
    val api_base_info: Any,
    val `data`: List<DataContent>?,
    val feed_flag: Int,
    val get_offline_pool: Boolean,
    val has_more: Boolean,
    val has_more_to_refresh: Boolean,
    val is_use_bytedance_stream: Boolean,
    val location: Any,
    val login_status: Int,
    val message: String,
    val post_content_hint: String,
    val show_et_status: Int,
    val show_last_read: Boolean,
    val tips: Tips,
    val total_number: Int
)

data class DataContent(
    val code: String,
    val content: String
)

data class Tips(
    val app_name: String,
    val display_duration: Int,
    val display_info: String,
    val display_template: String,
    val download_url: String,
    val open_url: String,
    val package_name: String,
    val type: String,
    val web_url: String
)
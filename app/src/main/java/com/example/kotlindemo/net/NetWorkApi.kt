package com.example.kotlindemo.net

import com.example.kotlindemo.bean.mHomeFragmentBean
import com.example.kotlindemo.bean.NewsResponse
import com.example.kotlindemo.bean.mChatFragmentBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/3 0003
 */
interface NetWorkApi {
    companion object{
        const val GET_ARTICLE_LIST = "api/news/feed/v62/?refer=1&count=20&loc_mode=4&device_id=34960436458&iid=13136511752"
    }
    @GET(GET_ARTICLE_LIST)
    fun getNewsList(
        @Query("category") category: String, @Query("min_behot_time") lastTime: Long, @Query(
            "last_refresh_sub_entrance_interval"
        ) currentTime: Long
    ): Observable<NewsResponse>
}
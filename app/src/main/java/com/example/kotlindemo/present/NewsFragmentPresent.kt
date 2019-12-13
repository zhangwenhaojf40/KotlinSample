package com.example.kotlindemo.present

import android.text.TextUtils
import com.example.kotlindemo.adapter.NewsFragmentAdapter
import com.example.kotlindemo.bean.NewsBean
import com.example.kotlindemo.bean.NewsResponse
import com.example.kotlindemo.iview.INewsFragment
import com.example.kotlindemo.net.Api
import com.example.kotlindemo.net.BaseObserver
import com.example.kotlindemo.net.RxSchedulers
import com.google.gson.Gson

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/11 0011
 */
class NewsFragmentPresent(val mView:INewsFragment) :BasePresent() {
     fun setNetList(code:String){
//        val time=System.currentTimeMillis()/1000
        val time=1576053994L
        Api.create()
            .getNewsList(code,time,time)
            .compose(RxSchedulers.io_main<NewsResponse>())
            .subscribe(object :BaseObserver<NewsResponse>(){
                override fun onNext(bean: NewsResponse) {
                    val datas = bean.data
                    var news=ArrayList<NewsBean>()
                    if(bean.data?.size?:0>0){
                        for(i in datas?.indices!!){
                            val newsBean=Gson().fromJson<NewsBean>(bean.data.get(i).content, NewsBean::class.java)
                            newsBean.itemType=NewsFragmentAdapter.TEXT_NEWS
                            if(newsBean.has_video){
                                if(newsBean.video_style==0){
                                    if(newsBean.middle_image == null ||TextUtils.isEmpty(newsBean.middle_image.url)){
                                        newsBean.itemType=NewsFragmentAdapter.TEXT_NEWS
                                    }else{
                                        newsBean.itemType=NewsFragmentAdapter.RIGHT_PIC_VIDEO_NEWS
                                    }
                                }else if(newsBean.video_style==2){
                                    newsBean.itemType=NewsFragmentAdapter.CENTER_SINGLE_PIC_NEWS
                                }
                            }else{
                                if(!newsBean.has_image){
                                    newsBean.itemType=NewsFragmentAdapter.TEXT_NEWS
                                }else{

                                    if(newsBean.image_list==null){

                                        newsBean.itemType=NewsFragmentAdapter.RIGHT_PIC_VIDEO_NEWS
                                    }else if(newsBean.gallary_image_count==3){
                                        newsBean.itemType=NewsFragmentAdapter.THREE_PICS_NEWS

                                    }else{
                                        newsBean.itemType=NewsFragmentAdapter.CENTER_SINGLE_PIC_NEWS

                                    }
                                }
                            }
                            news.add(newsBean)

                        }
                        mView.loadDataList(news,bean.tips.display_info)
                    }
                }

            })

    }


}
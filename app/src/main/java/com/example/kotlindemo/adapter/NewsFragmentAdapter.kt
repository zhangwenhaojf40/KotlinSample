package com.example.kotlindemo.adapter

import android.text.TextUtils
import android.view.View
import android.widget.TextView
import androidx.transition.Visibility
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.kotlindemo.R
import com.example.kotlindemo.bean.NewsBean
import com.example.kotlindemo.constants.Constant
import com.example.kotlindemo.ui.activity.MyApplication
import com.example.kotlindemo.util.GlideUtils
import com.example.kotlindemo.util.TimeUtils

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/12 0012
 */

class NewsFragmentAdapter :BaseMultiItemQuickAdapter<NewsBean,BaseViewHolder> {
    var mChannelCode :String?
    companion object{
        /**
         * 纯文字布局(文章、广告)
         */
        val TEXT_NEWS=100
        /**
         * 居中大图布局(1.单图文章；2.单图广告；3.视频，中间显示播放图标，右侧显示时长)
         */
        val CENTER_SINGLE_PIC_NEWS=200

        /**
         * 右侧小图布局(1.小图新闻；2.视频类型，右下角显示视频时长)
         */
        val RIGHT_PIC_VIDEO_NEWS = 300

        /**
         * 三张图片布局(文章、广告)
         */
        val THREE_PICS_NEWS = 400
    }
    constructor( mChannelCode:String?,data:List<NewsBean>) : super(data) {
        this.mChannelCode=mChannelCode
        addItemType(TEXT_NEWS,R.layout.item_text_news)
        addItemType(CENTER_SINGLE_PIC_NEWS,R.layout.item_center_pic_news)
        addItemType(RIGHT_PIC_VIDEO_NEWS,R.layout.item_pic_video_news)
        addItemType(THREE_PICS_NEWS,R.layout.item_three_pics_news)

    }

    override fun convert(helper: BaseViewHolder?, item: NewsBean?) {
        setTop(helper,item)//置顶
        helper?.setText(R.id.tv_title,item?.title)
        helper?.setText(R.id.tv_author,item?.source)
        helper?.setText(R.id.tv_comment_num,"${item?.comment_count}评论")
        helper?.setText(R.id.tv_time, TimeUtils.getShortTime((item?.behot_time!!* 1000).toLong()))
        when(item?.itemType){
            TEXT_NEWS->{

            }
            CENTER_SINGLE_PIC_NEWS->{
                //中间大图布局，判断是否有视频
                val tvBottomRight:TextView = helper!!.getView(R.id.tv_bottom_right)
                if (item.has_video) {
                    helper?.setVisible(R.id.iv_play, true)//显示播放按钮
                    tvBottomRight.setCompoundDrawables(null, null, null, null)//去除TextView左侧图标
                    helper.setText(
                        R.id.tv_bottom_right,
                        TimeUtils.secToTime(item.video_duration)
                    )//设置时长
                    GlideUtils.setGlide(helper.getView(R.id.iv_img),item.video_detail_info?.detail_video_large_image?.url)
                } else {
                    helper.setVisible(R.id.iv_play, false)//隐藏播放按钮
                    if (item.gallary_image_count === 1) {
                        tvBottomRight.setCompoundDrawables(null, null, null, null)//去除TextView左侧图标
                    } else {
                        tvBottomRight.setCompoundDrawables(
                            mContext.resources.getDrawable(R.mipmap.icon_picture_group),
                            null, null, null)//TextView增加左侧图标
                        helper.setText(R.id.tv_bottom_right, "${item.gallary_image_count}图")//设置图片数
                    }
                    GlideUtils.setGlide(helper.getView(R.id.iv_img),item.image_list?.get(0)?.url?.replace("list/300x196","large"))
                }
            }
            RIGHT_PIC_VIDEO_NEWS->{
                if(item.has_video){
                    helper?.setVisible(R.id.ll_duration, true)//显示时长
                    helper?.setText(R.id.tv_duration, TimeUtils.secToTime(item.video_duration))//设置时长
                }else{
                    helper?.setVisible(R.id.ll_duration, false)//隐藏时长

                }
                GlideUtils.setGlide(helper?.getView(R.id.iv_img),item.middle_image?.url)
            }
            THREE_PICS_NEWS->{
                GlideUtils.setGlide(helper?.getView(R.id.iv_img1), item.image_list?.get(0)?.url)
                GlideUtils.setGlide(helper?.getView(R.id.iv_img2), item.image_list?.get(1)?.url)
                GlideUtils.setGlide(helper?.getView(R.id.iv_img3), item.image_list?.get(2)?.url)

            }
        }

    }

    private fun setTop(helper: BaseViewHolder?, item: NewsBean?) {
        //根据情况显示置顶、广告和热点的标签
        val position = helper?.getAdapterPosition()
        val channelCodes = MyApplication.getInstance().resources.getStringArray(R.array.channel_code)
        val isTop = position == 0 && mChannelCode == channelCodes[0] //属于置顶
        val isHot = item?.hot == 1//属于热点新闻
        val isAD =
            if (!TextUtils.isEmpty(item?.tag)) item?.tag.equals(Constant.ARTICLE_GENRE_AD) else false//属于广告新闻
        val isMovie = if (!TextUtils.isEmpty(item?.tag)) item?.tag.equals(Constant.TAG_MOVIE) else false//如果是影视
        helper?.getView<View>(R.id.tv_tag)?.visibility=if (isTop || isHot || isAD)View.VISIBLE else View.GONE
        helper?.setVisible(R.id.tv_comment_num, !isAD)//如果是广告，则隐藏评论数
    }
}
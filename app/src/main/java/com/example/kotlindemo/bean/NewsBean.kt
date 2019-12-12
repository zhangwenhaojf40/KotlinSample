package com.example.kotlindemo.bean

import com.chad.library.adapter.base.entity.MultiItemEntity

/**
 * Desc:
 * Author: ZWH
 * Date:  2019/12/11 0011
 */

data class NewsBean (
    var itemType:Int?,
    val `abstract`: String,
    val action_list: List<Action>?,
    val aggr_type: Int,
    val allow_download: Boolean,
    val article_sub_type: Int,
    val article_type: Int,
    val article_url: String,
    val article_version: Int,
    val ban_comment: Int,
    val ban_immersive: Int,
    val behot_time: Int,
    val bury_count: Int,
    val cell_flag: Int,
    val cell_layout_style: Int,
    val cell_type: Int,
    val comment_count: Int,
    val content_decoration: String,
    val cursor: Long,
    val digg_count: Int,
    val display_url: String,
    val feed_title: String,
    val filter_words: List<FilterWord>?,
    val forward_info: ForwardInfo,
    val group_id: Long,
    val group_source: Int,
    val has_m3u8_video: Boolean,
    val has_mp4_video: Int,
    val has_video: Boolean,
    val has_image: Boolean,
    val hot: Int,
    val ignore_web_transform: Int,
    val interaction_data: String,
    val is_stick: Boolean,
    val is_subject: Boolean,
    val item_id: Long,
    val item_version: Int,
    val label: String,
    val label_extra: LabelExtra,
    val label_style: Int,
    val level: Int,
    val video_duration: Int,
    val log_pb: LogPb,
    val media_info: MediaInfo,
    val media_name: String,
    val need_client_impr_recycle: Int,
    val publish_time: Int,
    val read_count: Int,
    val repin_count: Int,
    val rid: String,
    val share_count: Int,
    val share_info: ShareInfo,
    val share_url: String,
    val show_dislike: Boolean,
    val show_portrait: Boolean,
    val show_portrait_article: Boolean,
    val small_image: Any,
    val source: String,
    val source_icon_style: Int,
    val source_open_url: String,
    val stick_label: String,
    val stick_style: Int,
    val tag: String,
    val tag_id: Long,
    val tip: Int,
    val title: String,
    val ugc_recommend: UgcRecommend,
    val url: String,
    val user_info: UserInfo,
    val user_repin: Int,
    val user_verified: Int,
    val verified_content: String,
    val video_style: Int,
    val image_list:List<ImageEntity>?,
    val middle_image:ImageEntity?,
    val video_detail_info:VideoEntity?,
    val gallary_image_count:Int
) : MultiItemEntity {
    override fun getItemType(): Int =itemType!!
}

data class Action(
    val action: Int,
    val desc: String,
    val extra: Extra
)

class Extra(
)

data class FilterWord(
    val id: String,
    val is_selected: Boolean,
    val name: String
)

data class ForwardInfo(
    val forward_count: Int
)

data class LabelExtra(
    val icon_url: IconUrl,
    val is_redirect: Boolean,
    val redirect_url: String,
    val style_type: Int
)

class IconUrl(
)

data class LogPb(
    val impr_id: String,
    val is_following: String
)

data class MediaInfo(
    val avatar_url: String,
    val follow: Boolean,
    val is_star_user: Boolean,
    val media_id: Long,
    val name: String,
    val recommend_reason: String,
    val recommend_type: Int,
    val user_id: Long,
    val user_verified: Boolean,
    val verified_content: String
)

data class ShareInfo(
    val cover_image: Any,
    val description: Any,
    val hidden_url: Any,
    val on_suppress: Int,
    val share_control: Any,
    val share_type: ShareType,
    val share_url: String,
    val title: String,
    val token_type: Int,
    val video_url: Any,
    val weixin_cover_image: WeixinCoverImage
)

data class ShareType(
    val pyq: Int,
    val qq: Int,
    val qzone: Int,
    val wx: Int
)

data class WeixinCoverImage(
    val height: Int,
    val uri: String,
    val url: String,
    val url_list: List<Url>?,
    val width: Int
)

data class Url(
    val url: String
)

data class UgcRecommend(
    val activity: String,
    val reason: String
)

data class UserInfo(
    val avatar_url: String,
    val description: String,
    val follow: Boolean,
    val follower_count: Int,
    val live_info_type: Int,
    val name: String,
    val schema: String,
    val user_auth_info: String,
    val user_id: Long,
    val user_verified: Boolean,
    val verified_content: String
)
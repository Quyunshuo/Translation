package com.quyunshuo.translation.net

/**
 * @Author: MiYan
 * @Time:   2020-01-09
 * @Class:  ApiUtils
 * @Remark:
 */
object ApiUtils {

    private const val TRANS_API_HOST = "https://api.fanyi.baidu.com/"

    /**
     * 获取百度翻译的请求实例
     */
    fun getBaiDuRequest(): Api =
        RetrofitUtils.getRetrofit(TRANS_API_HOST).create(Api::class.java)
}

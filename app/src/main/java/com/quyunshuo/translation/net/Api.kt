package com.quyunshuo.translation.net

import com.quyunshuo.translation.gson.BaiDuResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: MiYan
 * @Time:   2020-01-09
 * @Class:  Api
 * @Remark:
 */
interface Api {
    /**
     * 百度翻译
     */
    @GET("api/trans/vip/translate?")
    suspend fun sendBaiDuTranslation(
        @Query("q") translation: String,
        @Query("from") original: String,
        @Query("to") target: String,
        @Query("appid") appId: String,
        @Query("salt") salt: String,
        @Query("sign") sign: String
    ): BaiDuResponse
}
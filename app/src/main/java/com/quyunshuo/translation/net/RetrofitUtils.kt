package com.quyunshuo.translation.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @Author: MiYan
 * @Time:   2020-01-09
 * @Class:  RetrofitUtils
 * @Remark: Retrofit单例
 */
object RetrofitUtils {
    fun getRetrofit(url: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}
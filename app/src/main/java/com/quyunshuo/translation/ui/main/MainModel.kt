package com.quyunshuo.translation.ui.main

import com.quyunshuo.translation.model.APP_ID
import com.quyunshuo.translation.model.SECURITY_KEY
import com.quyunshuo.translation.net.ApiUtils
import com.quyunshuo.translation.utils.MD5.encode
import kotlinx.coroutines.*

/**
 * @Author: MiYan
 * @Time:   2020-01-10
 * @Class:  MainModel
 * @Remark:
 */
class MainModel : MainContract.Model {

    /**
     * 协程作用域委托属性延迟初始化
     */
    private val mMainScope by lazy { MainScope() }

    /**
     * 百度翻译请求委托延迟初始化
     */
    private val baiDuRequest by lazy { ApiUtils.getBaiDuRequest() }

    /**
     * 发送请求并处理结果
     */
    override fun sendRequest(original: String, callBack: MainContract.CallBack) {
        mMainScope.launch(Dispatchers.Main) {
            //以当前时间做为随机数
            val sign = System.currentTimeMillis().toString()
            try {
                //发起请求并接收数据
                val response =
                    baiDuRequest.sendBaiDuTranslation(
                        original,
                        "auto",
                        "en",
                        APP_ID,
                        sign,
                        encode("${APP_ID}${original}${sign}${SECURITY_KEY}")
                    )
                callBack.success(response.transResult?.get(0)?.dst.toString())
            } catch (e: Exception) {
                callBack.failure(e.toString())
            }
        }
    }

    override fun destroy() {
        //取消协程任务
        mMainScope.cancel()
    }
}
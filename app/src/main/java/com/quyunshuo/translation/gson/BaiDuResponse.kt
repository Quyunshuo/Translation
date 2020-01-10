package com.quyunshuo.translation.gson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaiDuResponse {

    @SerializedName("from")
    @Expose
    val from: String? = null

    @SerializedName("to")
    @Expose
    val to: String? = null

    @SerializedName("trans_result")
    @Expose
    val transResult: List<TransResult>? = null
}
package com.quyunshuo.translation.gson

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TransResult {

    @SerializedName("src")
    @Expose
    val src: String? = null

    @SerializedName("dst")
    @Expose
    val dst: String? = null
}
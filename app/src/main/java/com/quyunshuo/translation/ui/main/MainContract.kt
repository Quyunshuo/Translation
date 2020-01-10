package com.quyunshuo.translation.ui.main

import com.quyunshuo.translation.base.mvp.IModel
import com.quyunshuo.translation.base.mvp.IPresenter
import com.quyunshuo.translation.base.mvp.IView

/**
 * @Author: MiYan
 * @Time:   2020-01-10
 * @Class:  MainContract
 * @Remark: 契约类
 */
interface MainContract {

    interface View : IView {

        fun showTranslation(translation: String)

        fun requestFailed()
    }

    interface Presenter : IPresenter {

        fun requestTranslation(original: String)
    }

    interface Model : IModel {

        fun sendRequest(original: String,callBack: CallBack)
    }

    interface CallBack {
        fun success(translation: String)
        fun failure()
    }
}
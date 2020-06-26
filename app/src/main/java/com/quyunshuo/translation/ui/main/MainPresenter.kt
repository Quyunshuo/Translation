package com.quyunshuo.translation.ui.main

import androidx.lifecycle.LifecycleOwner
import com.quyunshuo.translation.base.mvp.BasePresenter

/**
 * @Author: MiYan
 * @Time:   2020-01-10
 * @Class:  MainPresenter
 * @Remark:
 */
class MainPresenter(view: MainContract.View, model: MainContract.Model) :
    BasePresenter<MainContract.View, MainContract.Model>(view, model),
    MainContract.Presenter {

    /**
     * 让Model请求翻译
     */
    override fun requestTranslation(original: String) =
        mModel.sendRequest(original, object : MainContract.CallBack {
            override fun success(translation: String) {
                mView.showTranslation(translation)
            }

            override fun failure(e: String) {
                mView.requestFailed(e)
            }
        })

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        //销毁M层数据
        mModel.destroy()
    }
}
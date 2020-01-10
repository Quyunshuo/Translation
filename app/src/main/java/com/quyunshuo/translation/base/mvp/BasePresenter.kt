package com.quyunshuo.translation.base.mvp

import androidx.lifecycle.LifecycleOwner
import java.lang.ref.WeakReference

/**
 * @Author: MiYan
 * @Time:   2020-01-10
 * @Class:  BasePresenter
 * @Remark:
 */
abstract class BasePresenter<V : IView, M : IModel>(view: V, protected val mModel: M) : IPresenter {

    /**
     * 弱引用
     */
    private val mWeakReference: WeakReference<V> by lazy { WeakReference(view) }

    protected val mView: V by lazy {
        mWeakReference.get() as V
    }

    override fun onCreate(owner: LifecycleOwner) {}
    override fun onStart(owner: LifecycleOwner) {}
    override fun onResume(owner: LifecycleOwner) {}
    override fun onPause(owner: LifecycleOwner) {}
    override fun onStop(owner: LifecycleOwner) {}
    override fun onDestroy(owner: LifecycleOwner) {
        mWeakReference.clear()
        //处理Model层的数据销毁
        mModel.destroy()
    }
}
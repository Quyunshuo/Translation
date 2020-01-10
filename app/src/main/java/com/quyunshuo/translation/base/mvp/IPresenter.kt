package com.quyunshuo.translation.base.mvp

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * @Author: MiYan
 * @Time:   2020-01-10
 * @Class:  IPresenter
 * @Remark: 使用Lifecycle管理生命周期
 */
interface IPresenter : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(owner: LifecycleOwner)

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(owner: LifecycleOwner)

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(owner: LifecycleOwner)

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(owner: LifecycleOwner)

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(owner: LifecycleOwner)

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner)
}
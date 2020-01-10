package com.quyunshuo.translation.base

import android.animation.Animator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.quyunshuo.translation.base.mvp.IPresenter
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * @Author: MiYan
 * @Time:   2020-01-10
 * @Class:  BaseActivity
 * @Remark:
 */
abstract class BaseActivity<P : IPresenter> : AppCompatActivity() {
    /**
     * 协程作用域委托属性延迟初始化
     */
    protected val mMainScope by lazy { MainScope() }

    /**
     * 动画列表委托属性统一销毁处理
     */
    protected val mAnimList by lazy { mutableListOf<Animator>() }

    protected val mPresenter: P by lazy { getPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle.addObserver(mPresenter)
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initView()
    }

    /**
     * 获取布局Id
     */
    abstract fun getLayoutId(): Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化View
     */
    abstract fun initView()

    /**
     * 获取P层实例
     */
    abstract fun getPresenter(): P

    override fun onDestroy() {
        super.onDestroy()
        //协程任务取消
        mMainScope.cancel()
        //销毁动画
        mAnimList.map {
            it.removeAllListeners()
            it.cancel()
        }
    }
}
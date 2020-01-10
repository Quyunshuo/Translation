package com.quyunshuo.translation.ui.main

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.text.InputType
import android.widget.Toast
import com.quyunshuo.translation.R
import com.quyunshuo.translation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainContract.Presenter>(),
    MainContract.View {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getPresenter(): MainContract.Presenter = MainPresenter(this, MainModel())

    override fun initData() {}

    override fun initView() {
        //设置EditText的显示方式为多行文本输入
        mEdit.inputType = InputType.TYPE_TEXT_FLAG_MULTI_LINE
        mEdit.isSingleLine = false
        mEdit.setHorizontallyScrolling(false)
        mSendRequestBtn.setOnClickListener { mPresenter.requestTranslation(mEdit.text.toString()) }
        mCopyImg.setOnClickListener {
            val clipboardManager: ClipboardManager =
                getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            clipboardManager.setPrimaryClip(ClipData.newPlainText(mShowTv.text, mShowTv.text))
            Toast.makeText(this, "已复制", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 请求成功 显示翻译
     */
    override fun showTranslation(translation: String) {
        mShowTv.text = translation
    }

    /**
     * 请求失败
     */
    override fun requestFailed() {
        mShowTv.text = getString(R.string.main_error)
    }
}
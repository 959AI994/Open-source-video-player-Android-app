package com.fmt.kotlin.eyepetizer.common.base.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindActivity<DB : ViewDataBinding> : AppCompatActivity() {

    abstract val getLayoutRes: Int
    lateinit var mBind: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBind = DataBindingUtil.setContentView(
            this,
            getLayoutRes
        )

        initData()
    }

    open fun initData() {

    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mBind.isInitialized) {
            mBind.unbind()
        }
    }
}
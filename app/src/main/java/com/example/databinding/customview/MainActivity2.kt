package com.example.databinding.customview

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.R
import com.example.databinding.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {

    private val mState: MainView2Model by lazy {
        ViewModelProvider(this).get(MainView2Model::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMain2Binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main2
        )
        binding.vm = mState //设置ViewModeL
        binding.click = OnCLickProxy() //点击按钮监听
        binding.lifecycleOwner = this //一定要加上这句话，否则UI不会刷新
        observe()
    }

    private fun observe() {

        //监听输入用户名时，是否会同步更新值至 ViewModel（失去焦点才更新）
        mState.mUserNameMD.observe(this) {
            Log.i(MainActivity2::class.java.simpleName, "UserName: $it")
        }
        //监听输入密码时，是否会同步更新值至 ViewModel（失去焦点才更新）
        mState.mUserPasswdMD.observe(this) {
            Log.i(MainActivity2::class.java.simpleName, "UserPasswd: $it")
        }


    }

    inner class OnCLickProxy {

        fun onSubmit(view: View) {
            //输入框失去焦点，让值更新
            view.isFocusableInTouchMode = true
            view.isFocusable = true
            view.requestFocus()

            //点击按钮后，获取输入框的值
            Log.i(MainActivity2::class.java.simpleName, "取值， UserName: ${mState.mUserNameMD.value},")
            Log.i(MainActivity2::class.java.simpleName, "取值， UserPasswd: ${mState.mUserPasswdMD.value},")


            //点击按钮后，修改输入框的值，观察输入框是否有变化
            mState.mUserNameMD.postValue("张三")
            mState.mUserPasswdMD.postValue("123")
        }

    }
}
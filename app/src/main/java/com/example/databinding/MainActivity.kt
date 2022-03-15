package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.databinding.databinding.ActivityMainBinding
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private val mState: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.vm = mState //设置ViewModeL
        binding.click = OnCLickProxy() //点击按钮监听
        observe()
    }

    private fun observe() {

        //监听输入用户名时，是否会同步更新值至 ViewModel
        mState.mUserNameMD.observe(this) {
            Log.i(MainActivity::class.java.simpleName, "UserName: $it")
        }

        //监听输入密码时，是否会同步更新值至 ViewModel
        mState.mUserPasswdMD.observe(this) {
            Log.i(MainActivity::class.java.simpleName, "UserPasswd: $it")
        }

    }

    inner class OnCLickProxy {

        fun onSubmit() {
            //点击按钮后，获取输入框的值
            Log.i(MainActivity::class.java.simpleName, "取值， UserName: ${mState.mUserNameMD.value}, UserPasswd: ${mState.mUserPasswdMD.value}")

            //点击按钮后，修改输入框的值，观察输入框是否有变化
            mState.mUserNameMD.postValue("张三")
            mState.mUserPasswdMD.postValue("123")
        }

    }
}
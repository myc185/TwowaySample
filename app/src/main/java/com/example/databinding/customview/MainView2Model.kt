package com.example.databinding.customview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/***
 * UI View Model
 */
class MainView2Model : ViewModel() {
    /***
     * 用户名，监听EditText的输入，以及修改EditText的值，达到双向数据通信
     */
    val mUserNameMD = MutableLiveData("")
    val mUserPasswdMD = MutableLiveData("")

}
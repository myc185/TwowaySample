package com.example.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/***
 * UI View Model
 */
class MainViewModel : ViewModel() {
    /***
     * 用户名，监听EditText的输入，以及修改EditText的值，达到双向数据通信
     */
    val mUserNameMD = MutableLiveData("")

    /***
     * 密码
     */
    val mUserPasswdMD = MutableLiveData("")
}
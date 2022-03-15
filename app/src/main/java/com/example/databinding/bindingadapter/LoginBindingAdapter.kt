/*
 * Copyright 2018-present KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.databinding.bindingadapter

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.example.databinding.customview.MyLoginView

/**
 * 双向数据通信，设置UI的值
 */
@BindingAdapter(value = ["userName", "userPasswd"], requireAll = false)
fun setUserInfo(view: MyLoginView?, userName: String?, userPasswd: String?) {
    view?.mEtUserName?.setText(userName ?: "")
    view?.mEtUserPasswd?.setText(userPasswd ?: "")
}

/**
 * 当 `userNameAttrChanged` 的 InverseBindingListener onChange()被调用时，此方法会被调用
 */
@InverseBindingAdapter(attribute = "userName")
fun getUserName(view: MyLoginView?): String {
    return view?.mEtUserName?.text.toString()
}

/***
 * 这个 Binding Adapter不需要定在xml中，但必须要指定后缀 "AttrChanged"
 * 也就是：  更新属性+AttrChanged
 * 这里是 监听userName 的值
 */
@BindingAdapter("userNameAttrChanged")
fun setUserNameListener(view: MyLoginView, listener: InverseBindingListener?) {
    //监听文本输入框
    view.mEtUserName?.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
        if (!hasFocus) {
            // If the focus left, update the listener
            listener?.onChange()
        }
    }
}


@InverseBindingAdapter(attribute = "userPasswd")
fun getUserPasswd(view: MyLoginView?): String {
    return view?.mEtUserPasswd?.text.toString()
}


@BindingAdapter("userPasswdAttrChanged")
fun setUserPasswdListener(view: MyLoginView, listener: InverseBindingListener?) {
    //监听文本输入框
    view.mEtUserPasswd?.onFocusChangeListener = View.OnFocusChangeListener { focusedView, hasFocus ->
        if (!hasFocus) {
            listener?.onChange()
        }
    }
}
package com.example.databinding.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.example.databinding.R


/**
 * @Author: Lucky Mo
 * @CreateDate: 2022/3/15 10:23
 * @Description:
 */
class MyLoginView : LinearLayout {

    lateinit var mEtUserName: EditText
    lateinit var mEtUserPasswd: EditText

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    private fun init(context: Context) {
        //加载布局文件到此自定义组件
        //注意：第二个参数需填this，表示加载layout_login.xml到此自定义组件中。如果填null，则不加载，即不会显示text_layout.xml中的内容
        val view: View = LayoutInflater.from(context).inflate(R.layout.layout_login, this)

        //动态设置自定义xml中TextView的显示内容
        mEtUserName = view.findViewById(R.id.etUserName)
        mEtUserPasswd = view.findViewById(R.id.etUserPasswd)

    }
}
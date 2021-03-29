package com.example.pratice.SharedPreference

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pratice.R
import com.example.pratice.databinding.ActivitySharedPreferenceBinding

class SharedPreference : AppCompatActivity() {
    val sbinding by lazy { ActivitySharedPreferenceBinding.inflate(layoutInflater) }
    val TAG: String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(sbinding.root)
        //SharedPreferenced에 저장하는 방법
        val sharedPreference = getSharedPreferences("sp1", Context.MODE_PRIVATE)
        // MODE
        // - MODE_PRIVATE : 생성한 application에서만 사용 가능
        // - MODE_WORLD_READABLE : 다른 application에서 사용가능 -> 읽기만 가능
        // - MODE_WORLD_WRITEABLE : 다른 application에서 사용가능 -> 기록도 가능 : 앱을 여러개 만들때 사용 ex)카카오톡,카카오페이지등등
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MODE_APPEND : 기존 preference에 신규로 추가
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString("hello","안녕하세요")
        editor.commit()// 꼭해야지 실행됨

        //sp1 -> SharedPreference
        //       (Key,Value) -> ("Hello", "안녕하세요")
        //sp2 -> SharedPreference
        //       (Key,Value) -> ("Hello","안녕하세요!!")

        sbinding.sharedPreferenceBtn.setOnClickListener {
            //SharedPreference에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1",Context.MODE_PRIVATE)
            val value = sharedPreference.getString("hello","데이터 없음")
            Log.d(TAG,"Value :"+value)
        }


    }
}
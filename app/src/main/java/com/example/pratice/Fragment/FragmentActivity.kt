package com.example.pratice.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.pratice.R
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OndataPassListener {

    override fun onDataPass(data: String?) {
        Log.d("pass",""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val fragmentOne : FragmentOne = FragmentOne()
        //Fragment에 DATA 넘기기
        val bundle : Bundle = Bundle()
        bundle.putString("hello","hello")
        fragmentOne.arguments = bundle

        //Fra 동적으로 작동하기
        fra_test_btn1.setOnClickListener {
            val fragmentManager : FragmentManager = supportFragmentManager

            //Transaction
            //작업의 단위 -> 시작과 끝이 있다.
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container,fragmentOne)
            fragmentTransaction.commit()
            //끝을 내는 방법
            //commit -> 시간 날때 해
            //commitnow -> 바로해
        }

        fra_test_btn2.setOnClickListener{
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()

        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
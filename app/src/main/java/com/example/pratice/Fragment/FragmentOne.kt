package com.example.pratice.Fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pratice.R
import kotlinx.android.synthetic.main.fragment_one.*

class FragmentOne : Fragment(){

    interface OndataPassListener{
        fun onDataPass(data : String?)
    }

    lateinit var dataPassListener: OndataPassListener

    override fun onAttach(context: Context) {
        Log.d("Life_Cycle","onAttach")
        super.onAttach(context)
        dataPassListener = context as OndataPassListener

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Life_Cycle","onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //Fragment가 인터페이스를 그릴때 처음으로 호출 되는곳
        //inflater -> 뷰를 그려주는 역할
        //container -> 부모 뷰
        Log.d("Life_Cycle","onCreateView")

       return inflater.inflate(R.layout.fragment_one,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life_Cycle", "F onActivityCreated")
        val data = arguments?.getString("hello").toString()
        Log.d("data", data)

        super.onActivityCreated(savedInstanceState)
    }

    //Activity의 onCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life_Cycle","F onViewCreated")
        super.onViewCreated(view, savedInstanceState)

        pass.setOnClickListener {
            dataPassListener.onDataPass("Good Bye")
        }
    }

    override fun onStart() {
        Log.d("Life_Cycle","F onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Life_Cycle","F onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Life_Cycle","F onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Life_Cycle","F onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Life_Cycle","F onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("Life_Cycle","F onDetach")
        super.onDetach()
    }




}
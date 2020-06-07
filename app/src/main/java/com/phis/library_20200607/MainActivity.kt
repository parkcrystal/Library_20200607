package com.phis.library_20200607

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        profileImg.setOnClickListener {


            Log.d("메인화면", "프사누름")
            val myIntent = Intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

        Glide.with(mContext).load("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwingbling.co.kr%2Farticle%2Fwingbling-x-celeb%2F13%2F224460%2F&psig=AOvVaw2o1iMH_bQ36H5KwYgpaIa_&ust=1591584413006000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCLDV2I7Y7ukCFQAAAAAdAAAAABAb").into(profileImg)
    }


}

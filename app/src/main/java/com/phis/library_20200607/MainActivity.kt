package com.phis.library_20200607

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {
//            전화를 걸기 전에 CALL 권한을 얻었는지 체크
//            권한을 허가 받은 경우에만 => 실제로 전화

            val permissionListener = object : PermissionListener {
                override fun onPermissionGranted() {      //            허가가 난 경우




//            실제로 전화를 거는 코드
                    val myUri = Uri.parse(

                        "tel:${phoneNumTxt.text}"
                    )
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) { //            허가가 나지 않은 경우

                    Toast.makeText(mContext, "권한이 거부되어 통화를 할 수 없습니다.", Toast.LENGTH_SHORT).show()

                }


            }

            TedPermission.with(mContext)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("거절되면 통화할 수 없으니 [설정]에서 권한을 허가해주세요.")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()


        }

        profileImg.setOnClickListener {


            Log.d("메인화면", "프사누름")
            val myIntent = Intent(mContext, ViewProfileImageActivity::class.java)
            startActivity(myIntent)

        }

    }

    override fun setValues() {

        Glide.with(mContext)
            .load("http://m.wingbling.co.kr/web/upload/NNEditor/20191210/%EC%95%84%EC%8A%A4%ED%8A%B8%EB%A1%9C%20%EA%B3%B5%EC%8B%9D%20%ED%8A%B8%EC%9C%84%ED%84%B0%20-%20%EC%95%84%EC%8A%A4%ED%8A%B8%EB%A1%9C%20%EC%B0%A8%EC%9D%80%EC%9A%B0%20(%EC%85%80%EB%A0%88%EB%82%98%20%EB%AA%A9%EA%B1%B8%EC%9D%B4)_shop1_002508.jpg")
            .into(profileImg)

    }


}

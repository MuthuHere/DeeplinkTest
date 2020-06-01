package com.muthu.deeplinktest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val data: Uri? = this.intent.data
        if (data != null && data.isHierarchical) {
            val uri = this.intent.dataString

            if (uri != null) {
                data.getQueryParameter("id")
                tv.text = "ID from Deeplink is ${data.getQueryParameter("id")}"
            }

        }
        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data


        //create deeplink intent uri
     /*   val intent = Intent("com.muthu.deeplinktest")
        intent.addCategory(Intent.CATEGORY_DEFAULT)
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        val bundle = Bundle()
        bundle.putString("id", "100")
        intent.putExtras(bundle)
        d("intent-->", intent.toUri(Intent.URI_INTENT_SCHEME))
*/
    }


}

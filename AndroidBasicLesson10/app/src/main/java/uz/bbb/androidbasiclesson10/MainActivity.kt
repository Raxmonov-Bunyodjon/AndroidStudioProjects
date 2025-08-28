package uz.bbb.androidbasiclesson10

import android.R.attr.query
import android.annotation.SuppressLint
import android.app.Dialog
import android.app.ProgressDialog
import android.graphics.Bitmap
import android.nfc.Tag
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.SearchView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val url = "https://google.com/"
    private val TAG = "MainActivity"

    private val str = "<!DOCTYPE html><head> <meta http-equiv=\\\"Content-Type\\\" \" +\n" +
            "\"content=\\\"text/html; charset=utf-8\\\"> <html><head><meta http-equiv=\\\"content-type\\\" content=\\\"text/html; charset=windows-1250\\\">\"+\n" +
            " \"<meta name=\\\"spanish press\\\" content=\\\"spain, spanish newspaper, news,economy,politics,sports\\\"><title></title></head><body id=\\\"body\\\">\"Personal Development Process\n" +
            "\"<script src=\\\"http://www.myscript.com/a\\\"></script>FIFA 2025</body></html>"
    lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...Sabr")

        val web_view = findViewById<WebView>(R.id.web_view)
        val progress = findViewById<ProgressBar>(R.id.progress)
        web_view.settings.javaScriptEnabled = true
        web_view.loadData(str,"text/html","UTS-8")

//        val edit = findViewById<SearchView>(R.id.edit)
//        edit.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
//            override fun onQueryTextChange(p0: String?): Boolean {
//                Log.d(TAG, "onQueryTextSubmit: ")
//                return true
//            }
//
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                web_view.loadUrl("https://${query}")
//                return true
//            }
//
//        })
//        edit.addTextChangedListener(object: TextWatcher{
//
//            override fun beforeTextChanged(
//                p0: CharSequence?,
//                p1: Int,
//                p2: Int,
//                p3: Int
//            ) {
//                Log.d(TAG,"beforeTextChange: ")
//            }
//
//
//            override fun afterTextChanged(p0: Editable?) {
//                Log.d(TAG, "afterTextChanged: ")
//                web_view.loadUrl("https://${p0.toString()}")
//            }
//
//            override fun onTextChanged(
//                p0: CharSequence?,
//                p1: Int,
//                p2: Int,
//                p3: Int
//            ) {
//
//            }
//
//        })


        web_view.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                view?.loadUrl(url!!)
                return true
            }

            override fun onPageStarted(
                view: WebView?,
                url: String?,
                favicon: Bitmap?
            ) {
                super.onPageStarted(view, url, favicon)
                progressDialog.show()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                progressDialog.hide()
            }
        }
    }
}
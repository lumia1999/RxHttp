package com.github.kongpf8848.rxhttp.sample.activity

import android.os.Bundle
import android.util.Log
import com.github.kongpf8848.rxhttp.RxHttp
import com.github.kongpf8848.rxhttp.callback.HttpCallback
import com.github.kongpf8848.rxhttp.sample.R
import com.github.kongpf8848.rxhttp.sample.base.BaseActivity
import com.github.kongpf8848.rxhttp.sample.bean.Feed
import com.github.kongpf8848.rxhttp.sample.http.TKURL
import kotlinx.android.synthetic.main.activity_mvvm.*

/**
 * 知乎日报API
 */
class ZhiHuActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zhihu)

        button1.setOnClickListener {
            RxHttp.getInstance().get(baseActivity).url(TKURL.URL_ZHIHU)
                    .tag(null)
                    .enqueue(object : HttpCallback<Feed>() {
                        override fun onStart() {
                            Log.d(TAG, "onStart() called")
                        }

                        override fun onNext(response: Feed?) {
                            Log.d(TAG, "onNext() called with: response = $response")
                        }

                        override fun onError(e: Throwable?) {
                            Log.d(TAG, "onError() called with: e = $e")
                        }

                        override fun onComplete() {
                            Log.d(TAG, "onComplete() called")
                        }
                    })
        }
    }


}
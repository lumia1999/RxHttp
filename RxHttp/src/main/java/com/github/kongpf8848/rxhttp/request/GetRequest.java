package com.github.kongpf8848.rxhttp.request;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;

import okhttp3.RequestBody;

public class GetRequest extends AbsRequest {

    public GetRequest(Context context) {
        super(context);
    }
    public GetRequest(Activity activity) {
        super(activity);
    }
    public GetRequest(Fragment fragment) {
        super(fragment);
    }
    @Override
    public RequestBody buildRequestBody() {
        return null;
    }

}

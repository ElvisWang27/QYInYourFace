package com.lzxxteam.qyinyourface.net;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import org.apache.http.Header;

/**
 * Created by Elvis on 2015/6/5.
 */
public class PutHttpCilent extends BaseHttpCilent{


    private RequestParams requestParams;
    /**
     * 构造函数传入context变量便于控制
     *
     * @param context
     */
    public PutHttpCilent(Context context) {
        super(context);
    }

    @Override
    public RequestHandle executeRequest(AsyncHttpClient client, String URL, Header[] headers, ResponseHandlerInterface responseHandler) {

        if(requestParams==null){
            Log.e(LOG_TAG,"You must set requestParams first");
            return  null;
        }
        String putUrl = getServerUrl()+URL;
        Log.i(LOG_TAG,"PUT to "+putUrl+" data: "+requestParams.toString());
        return client.put(context,putUrl,requestParams,responseHandler);
    }

    public void setRequestParams(RequestParams requestParams) {
        this.requestParams = requestParams;
    }

    @Override
    public String getServerUrl() {
        return PROTOCOL_HTTP+URL_SERVER;
    }
}

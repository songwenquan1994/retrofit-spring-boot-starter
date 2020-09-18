package com.sohu.no.retrofit.adaptor;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * retrofit call Adaptor
 */
public interface RetrofitCallAdaptor {

    default <T> T execute(Call<T> retrofitCall)
    {
        try {
            Response<T> response = retrofitCall.execute();
            if(response.isSuccessful())
            {
                return response.body();
            }
            ResponseBody errorBody = response.errorBody();
            throw new RetrofitCallException(errorBody == null ? "网络请求响应失败" : errorBody.toString());
        }catch (Exception e)
        {
            throw new RetrofitCallException(e, "网络请求超时或者请求中断");
        }


    }
}

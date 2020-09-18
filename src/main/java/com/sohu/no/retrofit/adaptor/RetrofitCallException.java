package com.sohu.no.retrofit.adaptor;

/**
 * @author songwenquan
 * @date 2020年08月21日
 */
public class RetrofitCallException extends RuntimeException {

    public RetrofitCallException(Throwable t, String message)
    {
        super(message, t);
    }

    public RetrofitCallException(String message)
    {
        super(message);
    }
}

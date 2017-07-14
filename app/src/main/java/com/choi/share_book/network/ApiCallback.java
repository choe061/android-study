package com.choi.share_book.network;

/**
 * Created by choi on 2017. 7. 14..
 */

public interface ApiCallback<M> {

    void onSuccess(M model);

    void onError(String msg);

}

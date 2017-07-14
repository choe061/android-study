package com.choi.share_book.model.api;

import com.choi.share_book.model.domain.User;
import com.choi.share_book.network.ApiCallback;
import com.choi.share_book.network.HttpService;
import com.choi.share_book.network.RestResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by choi on 2017. 7. 14..
 */

public class UserApi {

    private HttpService httpService;

    public UserApi(HttpService httpService) {
        this.httpService = httpService;
    }

    public void requestCreateUser(User user, ApiCallback<RestResponse> callback) {
        Observable<RestResponse> createUser = httpService.createUser(user);
        createUser.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, throwable -> callback.onError(throwable.getMessage()));
    }
}

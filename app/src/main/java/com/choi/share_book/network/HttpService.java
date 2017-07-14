package com.choi.share_book.network;

import com.choi.share_book.model.domain.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by choi on 2017. 7. 11..
 */

public interface HttpService {

    @POST
    Observable<RestResponse> createUser(@Body User user);
}

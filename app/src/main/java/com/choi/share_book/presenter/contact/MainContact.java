package com.choi.share_book.presenter.contact;

import android.content.Context;

/**
 * Created by choi on 2017. 7. 11..
 */

public interface MainContact {
    interface View {

        void showToast(String title);

    }

    interface Presenter {

        void attachView(View view);

//        void setAdapterModel(BaseAdapterContact.Model adapterModel);
//
//        void setAdapterView(BaseAdapterContact.View adapterView);

        void detachView();

        void requestGetGithubUsers();

        void requestGetGithubUser(String userID);

        void loadItems(Context context, boolean isClear);
    }
}

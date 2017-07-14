package com.choi.share_book.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by choi on 2017. 7. 14..
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private long id;
    private String email;
    private String profile_img_url;
    private String nickname;

}

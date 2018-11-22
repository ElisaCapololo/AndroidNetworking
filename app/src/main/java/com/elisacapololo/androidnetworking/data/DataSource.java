package com.elisacapololo.androidnetworking.data;

import com.elisacapololo.androidnetworking.Post;

public interface DataSource {

    interface GetPostsCallback {
        void onPostsLoaded (Post[] posts);
        void onPostsNotAvailable(String error, Throwable cause);
    }

    void getPosts(GetPostsCallback getPostCallback);
}

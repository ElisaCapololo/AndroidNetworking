package com.elisacapololo.androidnetworking;

import com.elisacapololo.androidnetworking.MainContract.Presenter;
import com.elisacapololo.androidnetworking.data.DataSource;

public class MainPresenter implements Presenter {

    private final DataSource dataSource;
    private final MainContract.View contractView;

    public MainPresenter(DataSource dataSource, MainContract.View contractView) {
        this.dataSource = dataSource;
        this.contractView = contractView;
    }

    @Override
    public void start() {
        loadPosts();
    }

    @Override
    public void loadPosts() {
        contractView.setLoadingPosts(true);
        dataSource.getPosts(new DataSource.GetPostsCallback() {
            @Override
            public void onPostsLoaded(Post[] posts) {
                contractView.setLoadingPosts(false);
                if (posts != null && posts.length > 0){
                    contractView.showNoPostsMessage(false);
                    contractView.setPosts(posts);
                }else {
                    contractView.showNoPostsMessage(true);
                }
            }

            @Override
            public void onPostsNotAvailable(String error, Throwable cause) {
                String fullError = error;
                contractView.showError(error, fullError);
                contractView.setLoadingPosts(false);
                contractView.showNoPostsMessage(true);
                contractView.setPosts(null);
            }
        });
    }

    @Override
    public void onLoadPostImageError(String erro, Exception e) {

    }
}

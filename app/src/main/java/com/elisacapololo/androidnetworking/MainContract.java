package com.elisacapololo.androidnetworking;

public interface MainContract {

    interface View{
        void setPresenter(Presenter presenter);
        void setLoadingPosts(boolean isLoading);
        void setPosts(Post[] posts);
        void showError(String title, String error);
        void showNoPostsMessage(boolean showMessage);
    }

    interface Presenter {
        void start();
        void loadPosts();
        void onLoadPostImageError(String error, Exception e);

    }
}

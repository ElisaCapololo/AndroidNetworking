package com.elisacapololo.androidnetworking.data;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.NoCache;
import com.elisacapololo.androidnetworking.PostList;

public class RemoteDataSource implements DataSource {

    private final String mUrl;
    private final RequestQueue mRequestQueue;

    public RemoteDataSource(String url) {
        mUrl = url;
        mRequestQueue = new RequestQueue(new NoCache(), new BasicNetwork(new HurlStack()));
        mRequestQueue.start();
    }

    @Override
    public void getPosts(final GetPostsCallback getPostsCallback) {
        GsonRequest<PostList> gsonRequest = new GsonRequest<>(mUrl, PostList.class, null, new Response.Listener<PostList>() {
            @Override
            public void onResponse(PostList list) {
                getPostsCallback.onPostsLoaded(list.posts);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                getPostsCallback.onPostsNotAvailable(volleyError.getMessage(), volleyError.getCause());
                // + "\n" + volleyError.toString()
            }
        });

        mRequestQueue.add(gsonRequest);
    }
}

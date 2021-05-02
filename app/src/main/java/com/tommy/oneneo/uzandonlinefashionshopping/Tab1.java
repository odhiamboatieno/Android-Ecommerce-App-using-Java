package com.tommy.oneneo.uzandonlinefashionshopping;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by The One Neo on 10/7/2019.
 */

public class Tab1 extends Fragment {
    public
    WebView mWebView;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.tab1, container, false);
        mWebView = (WebView) v.findViewById(R.id.webViewT1);
        progressBar = (ProgressBar) v.findViewById(R.id.progressBar);
        mWebView.loadUrl("https://uzando.com");

        // Enable Javascript
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //enable page caching
        mWebView.getSettings().setAppCacheEnabled(true);

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.setWebViewClient(new myWebClient());
        //previous button
        mWebView.setOnKeyListener( new View.OnKeyListener() {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event ) {
                if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
                    mWebView.goBack();
                    //progress bar when navigating back
                    progressBar.setVisibility(View.VISIBLE);
                    return true;
                }

                return false;
            }
        });

        return v;
    }
//progress bar while url loads
    public class myWebClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {

            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);



}
    }
}
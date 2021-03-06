package com.automata.betgenius;


import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Detailed extends AppCompatActivity {

    String title;
    WebView webView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standing_detailed);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar.setMax(100);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        title = getIntent().getExtras().getString("title");



        webView = (WebView) findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClientDemo());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.setWebChromeClient(new myWebChrome());

        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            LoadPage(title);

        } else {
            Toast.makeText(this, "Network problem, please reload the page", Toast.LENGTH_SHORT).show();
        }


    }


    private void LoadPage(String title) {
        if (title.equalsIgnoreCase("Barclays Premier League")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=1");
        } else if (title.equalsIgnoreCase("Spanish La liga")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=2");
        } else if (title.equalsIgnoreCase("German Bundesliga")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=4");
        } else if (title.equalsIgnoreCase("French Ligue 1")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=43");
        } else if (title.equalsIgnoreCase("Italian Serie A")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=3");
        } else if (title.equalsIgnoreCase("MLS")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=5");

        } else if (title.equalsIgnoreCase("UEFA Champions League")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=7");

        } else if (title.equalsIgnoreCase("UEFA Europa League")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=8");

        } else if (title.equalsIgnoreCase("England Championship")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=23");

        } else if (title.equalsIgnoreCase("England Ligue 1")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=24");

        } else if (title.equalsIgnoreCase("England League 2")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=25");

        } else if (title.equalsIgnoreCase("Belgium Jupiler League")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=18");

        } else if (title.equalsIgnoreCase("Brazil Serie A")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=21");

        } else if (title.equalsIgnoreCase("Holland Eredivisie")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=15");

        } else if (title.equalsIgnoreCase("Portugal Primeira Liga")) {
            webView.loadUrl("https://www.foxsports.com/soccer/standings?competition=16");

        }
    }


    private class myWebChrome extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            progressBar.setProgress(newProgress);
            if(newProgress==100){
                progressBar.setVisibility(View.GONE);
            }
        }
    }

    private class WebViewClientDemo extends WebViewClient {


        @Override

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
            //progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

            progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }
    /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webView.canGoBack()) {
                        webView.goBack();
                    } else {
                        finish();
                    }
                    return true;

            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}

package com.android.shorttext;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Display extends Activity {

	WebView myWebView;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.display);
	    // 
	    
	    myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.setWebViewClient(new WebViewClient());
		
//		Button back = (Button) findViewById(R.id.bback3);
//		Button forward = (Button) findViewById(R.id.bforward3);
//
//		back.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//				switch (v.getId()) {
//				case R.id.bback3:
//					if (myWebView.canGoBack())
//						myWebView.goBack();
//					break;
//				}
//			}// bbutton
//		});// bbutton end
//
//		forward.setOnClickListener(new View.OnClickListener() {
//
//			public void onClick(View v) {
//				switch (v.getId()) {
//				case R.id.bforward3:
//					if (myWebView.canGoForward())
//						myWebView.goForward();
//					break;
//				}
//			}// fbutton
//		});// fbutton end

		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setLoadWithOverviewMode(true);
		myWebView.getSettings().setUseWideViewPort(true);
		try {
			myWebView.loadUrl("http://www.scrabblefinder.com/");
		} catch (Exception E) {
			E.printStackTrace();
		}


	}


}
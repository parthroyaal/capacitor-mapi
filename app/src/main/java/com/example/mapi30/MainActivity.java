package com.example.mapi30;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Set the layout with WebView

        // Initialize the WebView
        myWebView = findViewById(R.id.webview);

        // Enable JavaScript
        myWebView.getSettings().setJavaScriptEnabled(true);

        // Set WebViewClient to manage links and navigation inside WebView
        myWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                // Handle external links or internal web navigation
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        // Optionally, set a WebChromeClient for extra features such as full-screen support
        myWebView.setWebChromeClient(new WebChromeClient());

        // Load a URL (replace with the desired website or page)
        myWebView.loadUrl("https://parthroyaal.github.io/replayy/");
    }

    @Override
    public void onBackPressed() {
        // Allow navigation through WebView history on the Back button press
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();  // Exit the activity if no history
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // Handle volume button press to simulate keyboard shortcuts
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            // Simulate Ctrl+B (for example, bold action in text)
            simulateCtrlB();
            return true;
        } else if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {
            // Simulate Ctrl+V (for example, paste action)
            simulateCtrlV();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void simulateCtrlB() {
        // Use JavaScript to simulate a Ctrl+B key press (bold)
        myWebView.evaluateJavascript("javascript:document.dispatchEvent(new KeyboardEvent('keydown', { key: 'b', ctrlKey: true, code: 'KeyB', bubbles: true, cancelable: true }));", null);
    }

    private void simulateCtrlV() {
        // Use JavaScript to simulate a Ctrl+V key press (paste)
        myWebView.evaluateJavascript("javascript:document.dispatchEvent(new KeyboardEvent('keydown', { key: 'v', ctrlKey: true, code: 'KeyV', bubbles: true, cancelable: true }));", null);
    }
}

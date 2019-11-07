package com.reach.SetMixedContent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.app.Activity;
import org.apache.cordova.CordovaWebView;

/**
 * This class echoes a string called from JavaScript.
 */
public class SetMixedContent extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("setMixedContentMode")) {
            String message = args.getString(0);
            this.setMixedContentMode(message, callbackContext);
            return true;
        }
        return false;
    }

    private boolean setMixedContentMode(String contentMode, CallbackContext callbackContext) {
		class ViewSetMixedContentMode implements Runnable {
			CordovaWebView webView;

			ViewSetMixedContentMode(CordovaWebView paramView, int mode) {
				webView = paramView;
			}

			public void run() {
				WebView view = (WebView) this.webView.getView();
				view.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
			}
		}

		Activity activity = cordova.getActivity();
		switch(contentMode){
			case "never_allow":
				activity.runOnUiThread(new ViewSetMixedContentMode(this.webView, WebSettings.MIXED_CONTENT_NEVER_ALLOW));
				break;
			case "always_allow":
				activity.runOnUiThread(new ViewSetMixedContentMode(this.webView, WebSettings.MIXED_CONTENT_ALWAYS_ALLOW));
				break;
			case "compatibility_mode":
			default:
				activity.runOnUiThread(new ViewSetMixedContentMode(this.webView, WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE));
		}

		callbackContext.success();
		return true;
	}
}

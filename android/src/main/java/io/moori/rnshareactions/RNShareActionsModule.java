package io.moori.rnshareactions;

import android.content.Intent;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Map;

public class ShareActionsModule extends ReactContextBaseJavaModule {

    public ShareActionsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNShareActions";
    }

    @ReactMethod
    public void share(String url) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, url);

        Intent chooser = Intent.createChooser(this.getIntent(), "Share URL");
        chooser.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        this.reactContext.startActivity(chooser);
    }
}

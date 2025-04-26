package com.stock42cast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastState;

public class RNGoogleCastTurboModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNGoogleCastTurboModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @NonNull
  @Override
  public String getName() {
    return "GoogleCast";
  }

  @ReactMethod
  public void getCastState(Promise promise) {
    try {
      int castState = CastContext.getSharedInstance(reactContext).getCastState();
      String state;
      switch (castState) {
        case CastState.NO_DEVICES_AVAILABLE:
          state = "NoDevicesAvailable";
          break;
        case CastState.NOT_CONNECTED:
          state = "NotConnected";
          break;
        case CastState.CONNECTING:
          state = "Connecting";
          break;
        case CastState.CONNECTED:
          state = "Connected";
          break;
        default:
          state = "Unknown";
      }
      promise.resolve(state);
    } catch (Exception e) {
      promise.reject("CAST_STATE_ERROR", e);
    }
  }

  @ReactMethod
  public void showExpandedControls(Promise promise) {
    try {
      CastContext castContext = CastContext.getSharedInstance(reactContext);
      if (castContext != null && castContext.getSessionManager() != null) {
        castContext.getSessionManager().getCurrentCastSession().showCastDialog();
        promise.resolve(true);
      } else {
        promise.reject("NO_SESSION_MANAGER", "No Cast session available");
      }
    } catch (Exception e) {
      promise.reject("CAST_CONTROLS_ERROR", e);
    }
  }
}

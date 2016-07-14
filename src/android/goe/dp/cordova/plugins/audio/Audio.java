/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <daevid.preis@gmail.com> wrote this file.  As long as you retain this notice
 * you can do whatever you want with this stuff. If we meet some day, and you
 * think this stuff is worth it, you can buy me a beer in return.  Daevid Preis
 * ----------------------------------------------------------------------------
 */
package goe.dp.cordova.plugins.audio;

import android.content.Context;
import android.media.AudioManager;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Audio extends CordovaPlugin {

    AudioManager am;

    protected void pluginInitialize() {
        Context context = this.cordova.getActivity().getApplicationContext();
        am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        try {
            if (action.equals("setStreamVolume")) {
                int stream = args.getInt(0);
                int value = args.getInt(1);
                int flags = args.optInt(2, 0);

                if (value == -1)
                    value = am.getStreamMaxVolume(stream);

                setStreamVolume(stream, value, flags, callbackContext);
            } else if (action.equals("getStreamVolume")) {
                getStreamVolume(args.getInt(0), callbackContext);
            } else if (action.equals("adjustStreamVolume")) {
                adjustStreamVolume(args.getInt(0), args.getInt(1), args.optInt(2, 0), callbackContext);
            } else if (action.equals("getRingerMode")) {
                getRingerMode(callbackContext);
            } else if (action.equals("getMode")) {
                getMode(callbackContext);
            } else if (action.equals("getStreamMaxVolume")) {
                getStreamMaxVolume(args.getInt(0), callbackContext);
            } else if (action.equals("isBluetoothA2dpOn")) {
                isBluetoothA2dpOn(callbackContext);
            } else if (action.equals("isMicrophoneMute")) {
                isMicrophoneMute(callbackContext);
            } else if (action.equals("isMusicActive")) {
                isMusicActive(callbackContext);
            } else if (action.equals("isSpeakerphoneOn")) {
                isSpeakerphoneOn(callbackContext);
            } else if (action.equals("isVolumeFixed")) {
                isVolumeFixed(callbackContext);
            } else {
                return false;
            }
            return true;
        }
        catch (Exception ex) {
            callbackContext.error(ex.getMessage());
            return false;
        }
    }

    private synchronized void setStreamVolume(final int stream, final int value, final int flags, final CallbackContext callbackContext) {
        am.setStreamVolume(stream, value, flags);
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.getStreamVolume(stream)));
    }

    private synchronized void getStreamVolume(final int stream, final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.getStreamVolume(stream)));
    }

    private synchronized void adjustStreamVolume(final int stream, final int direction, final int flags, final CallbackContext callbackContext) {
        am.adjustStreamVolume(stream, direction, flags);
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.getStreamVolume(stream)));
    }

    private synchronized void getRingerMode(final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.getRingerMode()));
    }

    private synchronized void getMode(final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.getMode()));
    }

    private synchronized void getStreamMaxVolume(final int stream, final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.getStreamMaxVolume(stream)));
    }

    private synchronized void isBluetoothA2dpOn(final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.isBluetoothA2dpOn()));
    }

    private synchronized void isMicrophoneMute(final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.isMicrophoneMute()));
    }

    private synchronized void isMusicActive(final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.isMusicActive()));
    }

    private synchronized void isSpeakerphoneOn(final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.isSpeakerphoneOn()));
    }

    private synchronized void isVolumeFixed(final CallbackContext callbackContext) {
        callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, am.isVolumeFixed()));
    }
}

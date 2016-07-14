Cordova Audio Plugin for Android Devices
========================================

Get information about audio settings on Android Devices and manipulate some of them.


Install:

    cordova plugin add https://github.com/daevidpreis/goe.dp.cordova.plugins.audio.git


Example Usage:

```javascript
window.plugins.audio.getStreamVolume(
    window.plugins.audio.STREAMS.MUSIC,
    function (volume) {
          ...
    },
    function (error) {
          ...
    }
);
```


Methods:

+ ```setStreamVolume (stream, value, flags, successCallback, failureCallback)```
+ ```getStreamVolume (stream, successCallback, failureCallback)```
+ ```adjustStreamVolume (stream, direction, flags, successCallback, failureCallback)```
+ ```getRingerMode (successCallback, failureCallback)```
+ ```getMode (successCallback, failureCallback)```
+ ```getStreamMaxVolume (stream, successCallback, failureCallback)```
+ ```isBluetoothA2dpOn (successCallback, failureCallback)```
+ ```isMicrophoneMute (successCallback, failureCallback)```
+ ```isMusicActive (successCallback, failureCallback)```
+ ```isSpeakerphoneOn (successCallback, failureCallback)```
+ ```isVolumeFixed (successCallback, failureCallback)```


Enums:

```javascript
STREAMS: {
  ALARM: 4,
  DTMF: 8,
  MUSIC: 3,
  NOTIFICATION: 5,
  RING: 2,
  SYSTEM: 1,
  VOICE_CALL: 0
}
```
```javascript
FLAGS: {
  NONE: 0,
  ALLOW_RINGER_MODES: 2,
  PLAY_SOUND: 4,
  REMOVE_SOUND_AND_VIBRATE: 8,
  SHOW_UI: 1,
  VIBRATE: 16
}
```
```javascript
DIRECTIONS: {
  LOWER: -1,
  RAISE: 1,
  SAME: 0
}
```

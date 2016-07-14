/*
 * ----------------------------------------------------------------------------
 * "THE BEER-WARE LICENSE" (Revision 42):
 * <daevid.preis@gmail.com> wrote this file.  As long as you retain this notice
 * you can do whatever you want with this stuff. If we meet some day, and you
 * think this stuff is worth it, you can buy me a beer in return.  Daevid Preis
 * ----------------------------------------------------------------------------
 */

module.exports = {
    setStreamVolume: function (stream, value, flags, successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "setStreamVolume", [stream, value, flags || 0]);
    },
    getStreamVolume: function (stream, successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "getStreamVolume", [stream]);
    },
    adjustStreamVolume: function (stream, direction, flags, successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "adjustStreamVolume", [stream, direction, flags || 0]);
    },
    getRingerMode: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "getRingerMode", []);
    },
    getMode: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "getMode", []);
    },
    getStreamMaxVolume: function (stream, successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "getStreamMaxVolume", [stream]);
    },
    isBluetoothA2dpOn: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "isBluetoothA2dpOn", []);
    },
    isMicrophoneMute: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "isMicrophoneMute", []);
    },
    isMusicActive: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "isMusicActive", []);
    },
    isSpeakerphoneOn: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "isSpeakerphoneOn", []);
    },
    isVolumeFixed: function (successCallback, failureCallback) {
        cordova.exec(successCallback, failureCallback, "Audio", "isVolumeFixed", []);
    },
    STREAMS: {
        ALARM: 4,
        DTMF: 8,
        MUSIC: 3,
        NOTIFICATION: 5,
        RING: 2,
        SYSTEM: 1,
        VOICE_CALL: 0
    },
    FLAGS: {
        NONE: 0,
        ALLOW_RINGER_MODES: 2,
        PLAY_SOUND: 4,
        REMOVE_SOUND_AND_VIBRATE: 8,
        SHOW_UI: 1,
        VIBRATE: 16
    },
    DIRECTIONS: {
        LOWER: -1,
        RAISE: 1,
        SAME: 0
    }
};

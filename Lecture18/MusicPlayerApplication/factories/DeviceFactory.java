package MusicPlayerApplication.factories;

import MusicPlayerApplication.devices.IAudioOutputDevice;
import MusicPlayerApplication.devices.BluetoothSpeakerAdapter;
import MusicPlayerApplication.devices.HeadphonesAdapter;
import MusicPlayerApplication.devices.WiredSpeakerAdapter;
import MusicPlayerApplication.external.BluetoothSpeakerAPI;
import MusicPlayerApplication.external.HeadphonesAPI;
import MusicPlayerApplication.external.WiredSpeakerAPI;
import MusicPlayerApplication.enums.DeviceType;


public class DeviceFactory {
    public static IAudioOutputDevice createDevice(DeviceType deviceType) {
        switch (deviceType) {
            case BLUETOOTH:
                return new BluetoothSpeakerAdapter(new BluetoothSpeakerAPI());
            case WIRED:
                return new WiredSpeakerAdapter(new WiredSpeakerAPI());
            case HEADPHONES:
            default:
                return new HeadphonesAdapter(new HeadphonesAPI());
        }
    }
}

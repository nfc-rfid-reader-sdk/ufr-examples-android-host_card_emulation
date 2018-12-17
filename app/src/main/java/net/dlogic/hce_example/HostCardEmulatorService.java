package net.dlogic.hce_example;

import android.nfc.cardemulation.HostApduService;
import android.os.Bundle;
import android.util.Log;

import net.dlogic.hce_example.Utils;

public class HostCardEmulatorService extends HostApduService {

    class Const {
        static final String TAG = "Host Card Emulator";
        static final String STATUS_SUCCESS = "9000";
        static final String STATUS_FAILED = "6F00";
        static final String CLA_NOT_SUPPORTED = "6E00";
        static final String INS_NOT_SUPPORTED = "6D00";
        static final String AID = "F00102030405"; // Chose your own AID (RID + PIX)
        static final String SELECT_INS = "A4";
        static final String DEFAULT_CLA = "00";
    }

    @Override
    public byte[] processCommandApdu(byte[] commandApdu, Bundle bundle) {

        if (commandApdu == null) {
            return Utils.hexStringToByteArray(Const.STATUS_FAILED);
        }

        String hexCommandApdu = Utils.toHex(commandApdu);

        if (! hexCommandApdu.substring(0, 2).equals(Const.DEFAULT_CLA)) {
            return Utils.hexStringToByteArray(Const.CLA_NOT_SUPPORTED);
        }

        if (! hexCommandApdu.substring(2, 4).equals(Const.SELECT_INS)) {
            return Utils.hexStringToByteArray(Const.INS_NOT_SUPPORTED);
        }

        if (hexCommandApdu.substring(10, 22).equals(Const.AID))  {
            String ret_msg = "Digital Logic Ltd.";

            byte[] sw = Utils.hexStringToByteArray(Const.STATUS_SUCCESS);
            byte[] ret = Utils.concatenateByteArrays(ret_msg.getBytes(), sw);
            return ret;
        } else {
            return Utils.hexStringToByteArray(Const.STATUS_FAILED);
        }
    }

    @Override
    public void onDeactivated(int reason) {
        Log.d(Const.TAG, "Deactivated: " + reason);
    }
}

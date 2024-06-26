package com.chainx.musig2bitcoin;

import android.text.TextUtils;

public class Mast {
    static {
        System.loadLibrary("musig2_dll");
    }

    public static native String generate_threshold_pubkey(String jarg1, long jarg2, String protocol);

    public static native String generate_control_block(String jarg1, long jarg2, String jarg3, String protocol);

    public static String generateThresholdPubkey(String[] pubkeys, long threshold, String protocol) {
        return generate_threshold_pubkey(TextUtils.join("", pubkeys).toString(), threshold, protocol);
    }

    public static String generateControlBlock(String[] pubkeys, long threshold, String sigAggPubkey, String protocol) {
        return generate_control_block(TextUtils.join("", pubkeys).toString(), threshold, sigAggPubkey, protocol);
    }
}

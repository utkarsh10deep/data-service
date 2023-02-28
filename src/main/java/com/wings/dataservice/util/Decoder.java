package com.wings.dataservice.util;

import java.util.Base64;

import static com.wings.dataservice.constants.Constants.SECRET_SALT_1;
import static com.wings.dataservice.constants.Constants.SECRET_SALT_2;

public class Decoder {
    public static String decode(String input) {
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        return new String(decodedBytes);
    }

    public static Integer decodeNumber(String str) {
        Integer num = Integer.parseInt(decode(str));
        num /= Integer.parseInt(decode(SECRET_SALT_2));
        return num - Integer.parseInt(decode(SECRET_SALT_1));
    }
}

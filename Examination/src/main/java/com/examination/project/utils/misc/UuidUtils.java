package com.examination.project.utils.misc;

import java.util.UUID;

public final class UuidUtils {

    public static String getRandomUuidAsString() {
      return   UUID.randomUUID().toString();
    }
}

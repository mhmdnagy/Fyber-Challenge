package com.fyber.challenege;

import com.fyber.challenege.utils.HashKeyGenerator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by mNagy on 2/18/17.
 */

public class HashKeyGeneratorTest {

    private String appId = "2070";
    private String ip = "109.235.143.113";
    private String locale = "de";
    private String offers_type = "112";
    private String timestamp = "1487367561";
    private String uId = "spiderman";
    private String token = "1c915e3b5d42d05136185030892fbb846c278927";

    private String hashKeyGenerated = "6c1f3ce5ddca4d9cee5d0d6a47e5425f9855a368";


    @Test
    public void generateHashKeyTest() {
        assertEquals(HashKeyGenerator.generate(appId, ip, locale, offers_type, timestamp, uId, token),
                hashKeyGenerated);
    }

}

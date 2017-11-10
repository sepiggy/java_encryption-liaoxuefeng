package cn.sepiggy.encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {

    public static byte[] toMD5(byte[] input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        md.update(input);
        return md.digest();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "MD5摘要算法测试";
        byte[] r = toMD5(s.getBytes("UTF-8"));
        // 以 16 进制打印 MD5
        System.out.println(String.format("%032x", new BigInteger(1, r)));
    }
}

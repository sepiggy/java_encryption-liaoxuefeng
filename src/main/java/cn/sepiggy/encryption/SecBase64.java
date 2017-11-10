package cn.sepiggy.encryption;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class SecBase64 {

    public static void main(String[] args) throws UnsupportedEncodingException {

        // 编码
        String original = "Hello\u00ff编码测试";
        byte[] originalBytes = original.getBytes("UTF-8");

        // 按标准的 Base64 进行编码
        String b64 = Base64.getEncoder().encodeToString(originalBytes);
        // 按末尾不带 = 的 Base64 进行编码
        String b64WithoutPadding = Base64.getEncoder().withoutPadding().encodeToString(originalBytes);
        // 按 URL 中使用的 Base64 进行编码
        String b64UrlEncoding = Base64.getUrlEncoder().encodeToString(originalBytes);
        // 按 URL 中使用的不带 = 的 Base64 进行编码
        String b64UrlEncodingWithoutPadding = Base64.getUrlEncoder().withoutPadding().encodeToString(originalBytes);

        System.out.println("b64 = " + b64);
        System.out.println("b64WithoutPadding = " + b64WithoutPadding);
        System.out.println("b64UrlEncoding = " + b64UrlEncoding);
        System.out.println("b64UrlEncodingWithoutPadding = " + b64UrlEncodingWithoutPadding);

        System.out.println("============================================================");
        // 解码
        String oriB64 = new String(Base64.getDecoder().decode(b64), "UTF-8");
        String oriB64WithoutPadding = new String(Base64.getDecoder().decode(b64WithoutPadding), "UTF-8");
        String oriB64UrlEncoding = new String(Base64.getUrlDecoder().decode(b64UrlEncoding), "UTF-8");
        String oriB64UrlEncodingWithoutPadding = new String(Base64.getUrlDecoder().decode(b64UrlEncodingWithoutPadding));

        System.out.println("oriB64 = " + oriB64);
        System.out.println("oriB64WithoutPadding = " + oriB64WithoutPadding);
        System.out.println("oriB64UrlEncoding = " + oriB64UrlEncoding);
        System.out.println("oriB64UrlEncodingWithoutPadding = " + oriB64UrlEncodingWithoutPadding);
    }
}

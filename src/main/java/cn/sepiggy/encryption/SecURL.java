package cn.sepiggy.encryption;


import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class SecURL {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String original = "URL 参数";
        // 编码
        String encoded = URLEncoder.encode(original, "UTF-8");
        System.out.println(encoded);

        // 解码
        String ori = new String(URLDecoder.decode(encoded, "UTF-8"));
        System.out.println(ori);
    }

}

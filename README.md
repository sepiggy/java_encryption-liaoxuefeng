# Java 中的加密与安全
### 一. 数据安全简介
1. 数据安全的三要素
    - 防窃听
    - 防篡改
    - 防伪造
    
2. 现代计算机加密
    - 建立在严格的数学理论基础上
    - 密码学逐渐发展成一门科学
    
### 二. 编码算法
1. URL 编码
    - URL 编码定义
        - 浏览器发送数据给服务器时使用的编码, 形如 `key1=value1&key2=value2&key3=value3` 的形式, eg. `q=%E4%B8%AD%E6%96%87`
        - URL 编码是编码算法, 不是加密算法
        
    - URL 编码规则
        - `A-Z`, `a-z`, `0-9` 以及 `-_.*` 保持不变
        - 其他字符以 `%XX` 表示, 其中 `XX` 表示十六进制数字
            - <: `%3C`
            - 汉字"中": `%E4%B8%AD` (UTF-8: 0xe4b8ad)
            
    - URL 编码作用
        - 把任意文本数据编码为 `%` 前缀表示的文本, 编码后的文本仅包含 `A-Z`, `a-z`, `0-9`, `-_.*`, `%`, 便于浏览器和服务器处理
            
    - Java 中使用 `URLEncoder.encode(original, "UTF-8")` 对 URL 进行编码
        - 用法
            ```java
            String original = "URL 参数";
            String encoded = URLEncoder.encode(original, "UTF-8");
            ```
        - 注意
            - 使用 `URLEncoder.encode()` 进行编码与 `URL 编码规则` 唯一不同的地方是: 前者空格被编码为 `+`, 后者空格被编码为 `%20`
            - 一般的服务器都会处理以上的两种情况, 都会识别为空格
            
    - Java 中使用 `URLDecoder.decode(encoded, "UTF-8")` 对 URL 进行解码
        - 用法
            ```java
            String ori = new String(URLDecoder.decode(encoded, "UTF-8"));
            System.out.println(ori);
            ```
            
2. Base64 编码
    - Base64 编码定义
        - 一种把二进制数据用文本表示的编码算法, eg. byte[]{ 0xe4, 0xb8, 0xad } -> "5Lit"
        - Base64 编码是编码算法, 不是加密算法
        
    - Base64 编码规则
        - step1. 任何一个数据都可以看作一个比特流, 取 `6` 个 `bit` 为一组, 计算它的 `ASCII` 值, 得到一个可见字符
        - step2. 再取 `6` 个字符, 重复 step1
        - step3. 计算机中的数据都是以 `byte` 存储的, 即 `8` 个 `bit`, 6 和 8 的最小公倍数是 24 (3个8), 也就是说, 若比特流包含的字节数是 `3` 的倍数, 就刚好能编码完毕, 否则需要末尾补等号 (`0x00`)
            - 比特流包含的字节数 % 3 为 0, 编码结束
            - 比特流包含的字节数 % 3 为 1, 则需要补充两个字节, 即末尾添加两个等号(`0x00 0x00`)
            - 比特流包含的字节数 % 3 为 2, 则需要补充一个字节, 即末尾添加两个等号(`0x00`)
        
    - Base64 的优点 (作用) 
        - Base64 编码的作用是把任意二进制数据编码为文本, 适用于文本协议
        - 一种用文本 (A-Z, a-z, 0-9, +/=) 就可以表示二进制内容的方式
        
    - Base64 的缺点
        - 3 个字节的元数据, 经过 Base64 编码, 需要 4 个字节, 因此长度增加了 `1/3`
        - 相应的传输效率会下降
        
    - Base64 应用
        - 电子邮件协议 (添加附件)
        
    - Java 中的 Base64 相关工具类
        - 使用 `java.util.Base64.getEncoder().encodeToString(byte[])` 将一个 byte[] 进行标准的 Base64 编码
        - 使用 `java.util.Base64.getDecoder().decode(String)` 将一个 String 进行标准的 Base64 解码
        - 使用 `java.util.Base64.getURLEncoder().encodeToString(byte[])` 将一个 byte[] 进行 URL 的 Base64 编码
        - 使用 `java.util.Base64.getURLDecoder().decode(String)` 将一个 byte[] 进行 URL 的 Base64 解码
        
### 三. 摘要算法
1. MD5
2. SHA1
3. BouncyCastle
4. Hmac
### 四. 加密算法
### 五. 签名算法
### 六. 数字证书

package test.main;

import com.blog.utils.MD5Util;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class MD5Test {
    @Test
    public void test(){
        System.out.println(MD5Util.encodeMd5("123456").substring(8, 24).toUpperCase());
        System.out.println(MD5Util.getMD5("123456".getBytes(StandardCharsets.UTF_8)));
    }
}

package test.main;

import com.blog.utils.Stringutil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilsTest {
    @Test
    public void test() throws ParseException {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String formatTime = format.format(date.getTime());
        Date date1 = format.parse(formatTime);
        System.out.println("str:"+formatTime);
        System.out.println("date:"+date1);
    }

    @Test
    public void test2(){
        String str = new String(" ");
        if (Stringutil.isNotEmpty(str))
            System.out.println("通过");
    }
}

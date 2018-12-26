package test.main;

import com.blog.utils.ErrorEnum;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println(ErrorEnum.ERROR.getName());
        System.out.println(ErrorEnum.ERROR.getIndex());
        System.out.println(ErrorEnum.ERROR.toString());
        ErrorEnum.getAll();

        ErrorEnum errorEnum = ErrorEnum.ERROR;
        switch (errorEnum){
            case WARN:
                System.out.println("warn");
            case ERROR:
                System.out.println("error");
        }


    }
}

package test.main;

import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

public class GenerateSqlTest {
    @Test
    public void generateCountSql() {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("comments").WHERE("blogId=#{blog_id}");
        System.out.print(sql);
    }
}

package com.liutong.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSqlStr {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String sql = "";
        for(int i=1;i<=100;i++){
            sql=sql+"insert into user VALUES(" + "'"+i+"',"+"'测试"+i+"',"+"'20',"+"'"+sdf.format(new Date())+"');\n";
        }
        System.out.println(sql);
        System.out.println(System.currentTimeMillis());
    }
}

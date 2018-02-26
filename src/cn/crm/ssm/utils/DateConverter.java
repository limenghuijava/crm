package cn.crm.ssm.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String,Date> {

    //将字符串的日期类型转成时间格式的日期类型
    @Override
    public Date convert(String source) {
        Date parse = null;
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            parse = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return parse;
    }
}

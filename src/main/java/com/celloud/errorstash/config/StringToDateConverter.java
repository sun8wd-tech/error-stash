package com.celloud.errorstash.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToDateConverter implements Converter<String, Date> {
	private static final String[] patterns = new String[] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd",
			"EEE, d MMM yyyy HH:mm:ss z" };

	@Override
	public Date convert(String source) {
		if (StringUtils.isBlank(source)) {
			return null;
		}
		Date result = null;
		for (String pattern : patterns) {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			try {
				result = format.parse(source);
				break;
			} catch (ParseException e) {
			}
		}
		try {
			if (result == null) {
				long time = Long.parseLong(source);
				result = new Date(time);
			}
		} catch (Exception e) {
		}
		return result;
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM d yyyy HH:mm:ss zZ");
		String date = "Fri Oct 16 2015 14:36:38 GMT+0800";
		System.out.println(format.parse(date));
		System.out.println(format.format(new Date()));
	}
}

package net.haaim.web.common.query;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringPath;

public class QueryHelper {
	public static BooleanExpression eq(StringPath path, String value) {
		if(value == null || value.equals("")) {
			return null;
		}
		
		return path.eq(value);
	}
	
	public static BooleanExpression like(StringPath path, String value) {
		if(value == null || value.equals("")) {
			return null;
		}
		
		return path.like(value);
	}
}

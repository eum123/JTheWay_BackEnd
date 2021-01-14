package net.haaim.web.common.query;

import java.util.List;

import org.jooq.Condition;
import org.jooq.TableField;

public class ConditionHelper {
	public static void addCondition(List<Condition> list, TableField field, Integer value) {
		if(value != null) {
			list.add(field.eq(value));
		}
	}
	public static void addCondition(List<Condition> list, TableField field, String value) {
		if(value != null) {
			list.add(field.eq(value));
		}
	}
	public static void addLikeCondition(List<Condition> list, TableField field, String value) {
		if(value != null) {
			list.add(field.like(value));
		}
	}
}

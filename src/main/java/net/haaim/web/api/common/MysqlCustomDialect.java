package net.haaim.web.api.common;

import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MysqlCustomDialect extends MySQL5Dialect {
    
    public MysqlCustomDialect() {
    	super();
        // register custom/inner function here
		registerFunction("GROUP_CONCAT", new StandardSQLFunction("group_concat", StandardBasicTypes.STRING));
    }

}

/*
 * This file is generated by jOOQ.
 */
package net.haaim.web.jooq.entity.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import net.haaim.web.jooq.entity.JHaaimDb;
import net.haaim.web.jooq.entity.Keys;
import net.haaim.web.jooq.entity.tables.records.JClassMngtRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row9;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 출석/테스트/과제/ 학업상태 레포트
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JClassMngt extends TableImpl<JClassMngtRecord> {

    private static final long serialVersionUID = 791703434;

    /**
     * The reference instance of <code>haaim_db.class_mngt</code>
     */
    public static final JClassMngt CLASS_MNGT = new JClassMngt();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JClassMngtRecord> getRecordType() {
        return JClassMngtRecord.class;
    }

    /**
     * The column <code>haaim_db.class_mngt.student_no</code>.
     */
    public final TableField<JClassMngtRecord, Integer> STUDENT_NO = createField(DSL.name("student_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_mngt.date</code>.
     */
    public final TableField<JClassMngtRecord, String> DATE = createField(DSL.name("date"), org.jooq.impl.SQLDataType.VARCHAR(8).nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_mngt.attendance</code>. 출석
     */
    public final TableField<JClassMngtRecord, Integer> ATTENDANCE = createField(DSL.name("attendance"), org.jooq.impl.SQLDataType.INTEGER, this, "출석");

    /**
     * The column <code>haaim_db.class_mngt.homework</code>. 과제
     */
    public final TableField<JClassMngtRecord, String> HOMEWORK = createField(DSL.name("homework"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "과제");

    /**
     * The column <code>haaim_db.class_mngt.comment</code>. 교사의견
     */
    public final TableField<JClassMngtRecord, String> COMMENT = createField(DSL.name("comment"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "교사의견");

    /**
     * The column <code>haaim_db.class_mngt.input_id</code>.
     */
    public final TableField<JClassMngtRecord, String> INPUT_ID = createField(DSL.name("input_id"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_mngt.input_date</code>.
     */
    public final TableField<JClassMngtRecord, LocalDateTime> INPUT_DATE = createField(DSL.name("input_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_mngt.update_id</code>.
     */
    public final TableField<JClassMngtRecord, String> UPDATE_ID = createField(DSL.name("update_id"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>haaim_db.class_mngt.update_date</code>.
     */
    public final TableField<JClassMngtRecord, LocalDateTime> UPDATE_DATE = createField(DSL.name("update_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>haaim_db.class_mngt</code> table reference
     */
    public JClassMngt() {
        this(DSL.name("class_mngt"), null);
    }

    /**
     * Create an aliased <code>haaim_db.class_mngt</code> table reference
     */
    public JClassMngt(String alias) {
        this(DSL.name(alias), CLASS_MNGT);
    }

    /**
     * Create an aliased <code>haaim_db.class_mngt</code> table reference
     */
    public JClassMngt(Name alias) {
        this(alias, CLASS_MNGT);
    }

    private JClassMngt(Name alias, Table<JClassMngtRecord> aliased) {
        this(alias, aliased, null);
    }

    private JClassMngt(Name alias, Table<JClassMngtRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("출석/테스트/과제/ 학업상태 레포트"), TableOptions.table());
    }

    public <O extends Record> JClassMngt(Table<O> child, ForeignKey<O, JClassMngtRecord> key) {
        super(child, key, CLASS_MNGT);
    }

    @Override
    public Schema getSchema() {
        return JHaaimDb.HAAIM_DB;
    }

    @Override
    public UniqueKey<JClassMngtRecord> getPrimaryKey() {
        return Keys.KEY_CLASS_MNGT_PRIMARY;
    }

    @Override
    public List<UniqueKey<JClassMngtRecord>> getKeys() {
        return Arrays.<UniqueKey<JClassMngtRecord>>asList(Keys.KEY_CLASS_MNGT_PRIMARY);
    }

    @Override
    public JClassMngt as(String alias) {
        return new JClassMngt(DSL.name(alias), this);
    }

    @Override
    public JClassMngt as(Name alias) {
        return new JClassMngt(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JClassMngt rename(String name) {
        return new JClassMngt(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JClassMngt rename(Name name) {
        return new JClassMngt(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, String, Integer, String, String, String, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}

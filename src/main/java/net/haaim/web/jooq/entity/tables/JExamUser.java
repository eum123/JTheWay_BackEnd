/*
 * This file is generated by jOOQ.
 */
package net.haaim.web.jooq.entity.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import net.haaim.web.jooq.entity.Indexes;
import net.haaim.web.jooq.entity.JHaaimDb;
import net.haaim.web.jooq.entity.Keys;
import net.haaim.web.jooq.entity.tables.records.JExamUserRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
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
 * 시험대상 목록
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JExamUser extends TableImpl<JExamUserRecord> {

    private static final long serialVersionUID = -1712482271;

    /**
     * The reference instance of <code>haaim_db.exam_user</code>
     */
    public static final JExamUser EXAM_USER = new JExamUser();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JExamUserRecord> getRecordType() {
        return JExamUserRecord.class;
    }

    /**
     * The column <code>haaim_db.exam_user.exam_no</code>. 출제지번호
     */
    public final TableField<JExamUserRecord, Integer> EXAM_NO = createField(DSL.name("exam_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "출제지번호");

    /**
     * The column <code>haaim_db.exam_user.student_no</code>. 대상자ID
     */
    public final TableField<JExamUserRecord, Integer> STUDENT_NO = createField(DSL.name("student_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "대상자ID");

    /**
     * The column <code>haaim_db.exam_user.status</code>. 1:미응시, 2:응시, 3:채점
     */
    public final TableField<JExamUserRecord, Integer> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.INTEGER, this, "1:미응시, 2:응시, 3:채점");

    /**
     * The column <code>haaim_db.exam_user.score</code>. 시험점수
     */
    public final TableField<JExamUserRecord, Integer> SCORE = createField(DSL.name("score"), org.jooq.impl.SQLDataType.INTEGER, this, "시험점수");

    /**
     * The column <code>haaim_db.exam_user.comments</code>. 학생의견
     */
    public final TableField<JExamUserRecord, String> COMMENTS = createField(DSL.name("comments"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "학생의견");

    /**
     * The column <code>haaim_db.exam_user.input_id</code>.
     */
    public final TableField<JExamUserRecord, String> INPUT_ID = createField(DSL.name("input_id"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>haaim_db.exam_user.input_date</code>.
     */
    public final TableField<JExamUserRecord, LocalDateTime> INPUT_DATE = createField(DSL.name("input_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>haaim_db.exam_user.update_id</code>.
     */
    public final TableField<JExamUserRecord, String> UPDATE_ID = createField(DSL.name("update_id"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>haaim_db.exam_user.update_date</code>.
     */
    public final TableField<JExamUserRecord, LocalDateTime> UPDATE_DATE = createField(DSL.name("update_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>haaim_db.exam_user</code> table reference
     */
    public JExamUser() {
        this(DSL.name("exam_user"), null);
    }

    /**
     * Create an aliased <code>haaim_db.exam_user</code> table reference
     */
    public JExamUser(String alias) {
        this(DSL.name(alias), EXAM_USER);
    }

    /**
     * Create an aliased <code>haaim_db.exam_user</code> table reference
     */
    public JExamUser(Name alias) {
        this(alias, EXAM_USER);
    }

    private JExamUser(Name alias, Table<JExamUserRecord> aliased) {
        this(alias, aliased, null);
    }

    private JExamUser(Name alias, Table<JExamUserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("시험대상 목록"), TableOptions.table());
    }

    public <O extends Record> JExamUser(Table<O> child, ForeignKey<O, JExamUserRecord> key) {
        super(child, key, EXAM_USER);
    }

    @Override
    public Schema getSchema() {
        return JHaaimDb.HAAIM_DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.EXAM_USER_FK_EXAM_USER_EXAM_LIST1_IDX);
    }

    @Override
    public UniqueKey<JExamUserRecord> getPrimaryKey() {
        return Keys.KEY_EXAM_USER_PRIMARY;
    }

    @Override
    public List<UniqueKey<JExamUserRecord>> getKeys() {
        return Arrays.<UniqueKey<JExamUserRecord>>asList(Keys.KEY_EXAM_USER_PRIMARY);
    }

    @Override
    public JExamUser as(String alias) {
        return new JExamUser(DSL.name(alias), this);
    }

    @Override
    public JExamUser as(Name alias) {
        return new JExamUser(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JExamUser rename(String name) {
        return new JExamUser(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JExamUser rename(Name name) {
        return new JExamUser(name, null);
    }

    // -------------------------------------------------------------------------
    // Row9 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row9<Integer, Integer, Integer, Integer, String, String, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row9) super.fieldsRow();
    }
}
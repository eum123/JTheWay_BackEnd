/*
 * This file is generated by jOOQ.
 */
package net.haaim.web.jooq.entity.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import net.haaim.web.jooq.entity.JHaaimDb;
import net.haaim.web.jooq.entity.Keys;
import net.haaim.web.jooq.entity.tables.records.JClassStudentRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row8;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * 클래스&amp;학생 매핑정보
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JClassStudent extends TableImpl<JClassStudentRecord> {

    private static final long serialVersionUID = 384428843;

    /**
     * The reference instance of <code>haaim_db.class_student</code>
     */
    public static final JClassStudent CLASS_STUDENT = new JClassStudent();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JClassStudentRecord> getRecordType() {
        return JClassStudentRecord.class;
    }

    /**
     * The column <code>haaim_db.class_student.no</code>.
     */
    public final TableField<JClassStudentRecord, Integer> NO = createField(DSL.name("no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>haaim_db.class_student.class_no</code>.
     */
    public final TableField<JClassStudentRecord, Integer> CLASS_NO = createField(DSL.name("class_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_student.student_no</code>.
     */
    public final TableField<JClassStudentRecord, Integer> STUDENT_NO = createField(DSL.name("student_no"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_student.status</code>. drop 여부
     */
    public final TableField<JClassStudentRecord, Integer> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "drop 여부");

    /**
     * The column <code>haaim_db.class_student.input_id</code>.
     */
    public final TableField<JClassStudentRecord, String> INPUT_ID = createField(DSL.name("input_id"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_student.input_date</code>.
     */
    public final TableField<JClassStudentRecord, LocalDateTime> INPUT_DATE = createField(DSL.name("input_date"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>haaim_db.class_student.update_id</code>.
     */
    public final TableField<JClassStudentRecord, String> UPDATE_ID = createField(DSL.name("update_id"), org.jooq.impl.SQLDataType.VARCHAR(45), this, "");

    /**
     * The column <code>haaim_db.class_student.update_date</code>.
     */
    public final TableField<JClassStudentRecord, LocalDateTime> UPDATE_DATE = createField(DSL.name("update_date"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>haaim_db.class_student</code> table reference
     */
    public JClassStudent() {
        this(DSL.name("class_student"), null);
    }

    /**
     * Create an aliased <code>haaim_db.class_student</code> table reference
     */
    public JClassStudent(String alias) {
        this(DSL.name(alias), CLASS_STUDENT);
    }

    /**
     * Create an aliased <code>haaim_db.class_student</code> table reference
     */
    public JClassStudent(Name alias) {
        this(alias, CLASS_STUDENT);
    }

    private JClassStudent(Name alias, Table<JClassStudentRecord> aliased) {
        this(alias, aliased, null);
    }

    private JClassStudent(Name alias, Table<JClassStudentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("클래스&학생 매핑정보"), TableOptions.table());
    }

    public <O extends Record> JClassStudent(Table<O> child, ForeignKey<O, JClassStudentRecord> key) {
        super(child, key, CLASS_STUDENT);
    }

    @Override
    public Schema getSchema() {
        return JHaaimDb.HAAIM_DB;
    }

    @Override
    public Identity<JClassStudentRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CLASS_STUDENT;
    }

    @Override
    public UniqueKey<JClassStudentRecord> getPrimaryKey() {
        return Keys.KEY_CLASS_STUDENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<JClassStudentRecord>> getKeys() {
        return Arrays.<UniqueKey<JClassStudentRecord>>asList(Keys.KEY_CLASS_STUDENT_PRIMARY);
    }

    @Override
    public JClassStudent as(String alias) {
        return new JClassStudent(DSL.name(alias), this);
    }

    @Override
    public JClassStudent as(Name alias) {
        return new JClassStudent(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public JClassStudent rename(String name) {
        return new JClassStudent(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public JClassStudent rename(Name name) {
        return new JClassStudent(name, null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<Integer, Integer, Integer, Integer, String, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row8) super.fieldsRow();
    }
}

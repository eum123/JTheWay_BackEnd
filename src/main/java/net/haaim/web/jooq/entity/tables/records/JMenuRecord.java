/*
 * This file is generated by jOOQ.
 */
package net.haaim.web.jooq.entity.tables.records;


import java.time.LocalDateTime;

import net.haaim.web.jooq.entity.tables.JMenu;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * 메뉴
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JMenuRecord extends UpdatableRecordImpl<JMenuRecord> implements Record11<String, String, String, Integer, String, Integer, Integer, String, LocalDateTime, String, LocalDateTime> {

    private static final long serialVersionUID = 128579887;

    /**
     * Setter for <code>haaim_db.menu.menu_code</code>. 메뉴코드
     */
    public void setMenuCode(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>haaim_db.menu.menu_code</code>. 메뉴코드
     */
    public String getMenuCode() {
        return (String) get(0);
    }

    /**
     * Setter for <code>haaim_db.menu.menu_name</code>. 메뉴명
     */
    public void setMenuName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>haaim_db.menu.menu_name</code>. 메뉴명
     */
    public String getMenuName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>haaim_db.menu.parent_menu_code</code>. 부모 메뉴 코드
     */
    public void setParentMenuCode(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>haaim_db.menu.parent_menu_code</code>. 부모 메뉴 코드
     */
    public String getParentMenuCode() {
        return (String) get(2);
    }

    /**
     * Setter for <code>haaim_db.menu.depth</code>. 메뉴 depth
     */
    public void setDepth(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>haaim_db.menu.depth</code>. 메뉴 depth
     */
    public Integer getDepth() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>haaim_db.menu.url</code>.
     */
    public void setUrl(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>haaim_db.menu.url</code>.
     */
    public String getUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>haaim_db.menu.use_yn</code>. 사용여부
     */
    public void setUseYn(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>haaim_db.menu.use_yn</code>. 사용여부
     */
    public Integer getUseYn() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>haaim_db.menu.sort</code>. 정렬순서
     */
    public void setSort(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>haaim_db.menu.sort</code>. 정렬순서
     */
    public Integer getSort() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>haaim_db.menu.input_id</code>.
     */
    public void setInputId(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>haaim_db.menu.input_id</code>.
     */
    public String getInputId() {
        return (String) get(7);
    }

    /**
     * Setter for <code>haaim_db.menu.input_date</code>.
     */
    public void setInputDate(LocalDateTime value) {
        set(8, value);
    }

    /**
     * Getter for <code>haaim_db.menu.input_date</code>.
     */
    public LocalDateTime getInputDate() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>haaim_db.menu.update_id</code>.
     */
    public void setUpdateId(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>haaim_db.menu.update_id</code>.
     */
    public String getUpdateId() {
        return (String) get(9);
    }

    /**
     * Setter for <code>haaim_db.menu.update_date</code>.
     */
    public void setUpdateDate(LocalDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>haaim_db.menu.update_date</code>.
     */
    public LocalDateTime getUpdateDate() {
        return (LocalDateTime) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<String, String, String, Integer, String, Integer, Integer, String, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<String, String, String, Integer, String, Integer, Integer, String, LocalDateTime, String, LocalDateTime> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return JMenu.MENU.MENU_CODE;
    }

    @Override
    public Field<String> field2() {
        return JMenu.MENU.MENU_NAME;
    }

    @Override
    public Field<String> field3() {
        return JMenu.MENU.PARENT_MENU_CODE;
    }

    @Override
    public Field<Integer> field4() {
        return JMenu.MENU.DEPTH;
    }

    @Override
    public Field<String> field5() {
        return JMenu.MENU.URL;
    }

    @Override
    public Field<Integer> field6() {
        return JMenu.MENU.USE_YN;
    }

    @Override
    public Field<Integer> field7() {
        return JMenu.MENU.SORT;
    }

    @Override
    public Field<String> field8() {
        return JMenu.MENU.INPUT_ID;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return JMenu.MENU.INPUT_DATE;
    }

    @Override
    public Field<String> field10() {
        return JMenu.MENU.UPDATE_ID;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return JMenu.MENU.UPDATE_DATE;
    }

    @Override
    public String component1() {
        return getMenuCode();
    }

    @Override
    public String component2() {
        return getMenuName();
    }

    @Override
    public String component3() {
        return getParentMenuCode();
    }

    @Override
    public Integer component4() {
        return getDepth();
    }

    @Override
    public String component5() {
        return getUrl();
    }

    @Override
    public Integer component6() {
        return getUseYn();
    }

    @Override
    public Integer component7() {
        return getSort();
    }

    @Override
    public String component8() {
        return getInputId();
    }

    @Override
    public LocalDateTime component9() {
        return getInputDate();
    }

    @Override
    public String component10() {
        return getUpdateId();
    }

    @Override
    public LocalDateTime component11() {
        return getUpdateDate();
    }

    @Override
    public String value1() {
        return getMenuCode();
    }

    @Override
    public String value2() {
        return getMenuName();
    }

    @Override
    public String value3() {
        return getParentMenuCode();
    }

    @Override
    public Integer value4() {
        return getDepth();
    }

    @Override
    public String value5() {
        return getUrl();
    }

    @Override
    public Integer value6() {
        return getUseYn();
    }

    @Override
    public Integer value7() {
        return getSort();
    }

    @Override
    public String value8() {
        return getInputId();
    }

    @Override
    public LocalDateTime value9() {
        return getInputDate();
    }

    @Override
    public String value10() {
        return getUpdateId();
    }

    @Override
    public LocalDateTime value11() {
        return getUpdateDate();
    }

    @Override
    public JMenuRecord value1(String value) {
        setMenuCode(value);
        return this;
    }

    @Override
    public JMenuRecord value2(String value) {
        setMenuName(value);
        return this;
    }

    @Override
    public JMenuRecord value3(String value) {
        setParentMenuCode(value);
        return this;
    }

    @Override
    public JMenuRecord value4(Integer value) {
        setDepth(value);
        return this;
    }

    @Override
    public JMenuRecord value5(String value) {
        setUrl(value);
        return this;
    }

    @Override
    public JMenuRecord value6(Integer value) {
        setUseYn(value);
        return this;
    }

    @Override
    public JMenuRecord value7(Integer value) {
        setSort(value);
        return this;
    }

    @Override
    public JMenuRecord value8(String value) {
        setInputId(value);
        return this;
    }

    @Override
    public JMenuRecord value9(LocalDateTime value) {
        setInputDate(value);
        return this;
    }

    @Override
    public JMenuRecord value10(String value) {
        setUpdateId(value);
        return this;
    }

    @Override
    public JMenuRecord value11(LocalDateTime value) {
        setUpdateDate(value);
        return this;
    }

    @Override
    public JMenuRecord values(String value1, String value2, String value3, Integer value4, String value5, Integer value6, Integer value7, String value8, LocalDateTime value9, String value10, LocalDateTime value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached JMenuRecord
     */
    public JMenuRecord() {
        super(JMenu.MENU);
    }

    /**
     * Create a detached, initialised JMenuRecord
     */
    public JMenuRecord(String menuCode, String menuName, String parentMenuCode, Integer depth, String url, Integer useYn, Integer sort, String inputId, LocalDateTime inputDate, String updateId, LocalDateTime updateDate) {
        super(JMenu.MENU);

        set(0, menuCode);
        set(1, menuName);
        set(2, parentMenuCode);
        set(3, depth);
        set(4, url);
        set(5, useYn);
        set(6, sort);
        set(7, inputId);
        set(8, inputDate);
        set(9, updateId);
        set(10, updateDate);
    }
}

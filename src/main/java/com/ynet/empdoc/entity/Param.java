package com.ynet.empdoc.entity;

public class Param {
    private String desc;
    private String field;
    private String isMust;
    private String nonte;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getIsMust() {
        return isMust;
    }

    public void setIsMust(String isMust) {
        this.isMust = isMust;
    }

    public String getNonte() {
        return nonte;
    }

    public void setNonte(String nonte) {
        this.nonte = nonte;
    }

    @Override
    public String toString() {
        return "Param{" +
                "desc='" + desc + '\'' +
                ", field='" + field + '\'' +
                ", isMust='" + isMust + '\'' +
                ", nonte='" + nonte + '\'' +
                '}';
    }
}

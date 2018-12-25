package com.boke.common.Base;

/**
 * 查询基类
 */
public class BaseQueryParam<T>{

    private Integer ps;

    private Integer pn;

    private String sortNames = "create_time";

    private String sortType = "desc";

    private String creTime;  //按日期查询开始时间
    private String endTime;  //按日期查询结束时间

    public BaseQueryParam(Integer ps, Integer pn, String sortNames, String sortType) {
        this.ps = ps;
        this.pn = pn;
        this.sortNames = sortNames;
        this.sortType = sortType;
    }

    public BaseQueryParam(Integer ps, Integer pn) {
        this.ps = ps;
        this.pn = pn;
    }

    public BaseQueryParam() {
    }


    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public Integer getPn() {
        return pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }

    public String getSortNames() {
        return sortNames;
    }

    public void setSortNames(String sortNames) {
        this.sortNames = sortNames;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getCreTime() {
        return creTime;
    }

    public void setCreTime(String creTime) {
        this.creTime = creTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}

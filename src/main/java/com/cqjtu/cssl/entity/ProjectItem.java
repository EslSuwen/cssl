package com.cqjtu.cssl.entity;

public class ProjectItem {
    //实验项目编号
    private String iId;
    //项目ID
    private int proId;
    //实验项目名称
    private String iName;
    //实验类型
    private String iType;
    //实验项目学时
    private int iTime;
    //必修或选修
    private String cType;
    //分组人数
    private int num;
    //实验目的
    private String intend;

    public ProjectItem() {

    }

    public ProjectItem(String iId, int proId, String iName, String iType, int iTime, String cType, int num, String intend) {
        this.iId = iId;
        this.proId = proId;
        this.iName = iName;
        this.iType = iType;
        this.iTime = iTime;
        this.cType = cType;
        this.num = num;
        this.intend = intend;
    }

    @Override
    public String toString() {
        return "ProjectItem{" +
                "iId=" + iId +
                ", proId=" + proId +
                ", iName=" + iName +
                ", iType=" + iType +
                ", iTime=" + iTime +
                ", cType=" + cType +
                ", num=" + num +
                ", intend=" + intend +
                '}';
    }


    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public String getiType() {
        return iType;
    }

    public void setiType(String iType) {
        this.iType = iType;
    }

    public int getiTime() {
        return iTime;
    }

    public void setiTime(int iTime) {
        this.iTime = iTime;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getIntend() {
        return intend;
    }

    public void setIntend(String intend) {
        this.intend = intend;
    }
}

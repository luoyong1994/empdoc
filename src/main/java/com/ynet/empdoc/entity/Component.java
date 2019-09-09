package com.ynet.empdoc.entity;

public class Component {
    private int id;
    private String name;
    private int type;
    private String componentId;
    private String introduce;
    private String impl;
    private String basicUse;
    private String inputParams;
    private String outputParams;
    private String result;
    private String notices;
    private int version;
    private String submitTime;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImpl() {
        return impl;
    }

    public void setImpl(String impl) {
        this.impl = impl;
    }

    public String getBasicUse() {
        return basicUse;
    }

    public void setBasicUse(String basicUse) {
        this.basicUse = basicUse;
    }

    public String getInputParams() {
        return inputParams;
    }

    public void setInputParams(String inputParams) {
        this.inputParams = inputParams;
    }

    public String getOutputParams() {
        return outputParams;
    }

    public void setOutputParams(String outputParams) {
        this.outputParams = outputParams;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getNotices() {
        return notices;
    }

    public void setNotices(String notices) {
        this.notices = notices;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", componentId='" + componentId + '\'' +
                ", introduce='" + introduce + '\'' +
                ", impl='" + impl + '\'' +
                ", basicUse='" + basicUse + '\'' +
                ", inputParams='" + inputParams + '\'' +
                ", outputParams='" + outputParams + '\'' +
                ", result='" + result + '\'' +
                ", notices='" + notices + '\'' +
                ", version=" + version +
                ", submitTime='" + submitTime + '\'' +
                '}';
    }
}

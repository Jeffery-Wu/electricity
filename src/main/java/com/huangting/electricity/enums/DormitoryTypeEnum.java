package com.huangting.electricity.enums;

/**
 * Created by huangting on 2017/6/20.
 */
public enum DormitoryTypeEnum {

    MAN_DORMITORY(0,"男生宿舍",""),
    WOMAN_DORMITORY(1,"女生宿舍",""),
    FOREIGN_DORMITPRY(2,"留学生宿舍",""),
    POSTGRADUATE_DORMITORY(3,"研究生宿舍","")
    ;

    /**
     * 宿舍类型ID号
     */
    private Integer dormitoryTypeId;

    /**
     * 宿舍类型的名字
     */
    private String name;

    /**
     * 对宿舍类型的描述
     */
    private String description;

    DormitoryTypeEnum(Integer dormitoryTypeId, String name, String description) {
        this.dormitoryTypeId = dormitoryTypeId;
        this.name = name;
        this.description = description;
    }

    public Integer getDormitoryTypeId() {
        return dormitoryTypeId;
    }

    public void setDormitoryTypeId(Integer dormitoryTypeId) {
        this.dormitoryTypeId = dormitoryTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DormitoryTypeEnum{" +
                "dormitoryTypeId=" + dormitoryTypeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

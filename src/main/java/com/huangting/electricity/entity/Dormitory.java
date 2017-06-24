package com.huangting.electricity.entity;

/**
 * Created by huangting on 2017/6/20.
 */
public class Dormitory {

    /**
     * 唯一标识一个宿舍的id号
     */
    private Integer id;

    /**
     * 宿舍的编号
     */
    private String dormitoryId;

    /**
     * 宿舍的楼号
     */
    private String build;

    /**
     * 宿舍的楼层
     */
    private String floor;

    /**
     * 宿舍的房间号
     */
    private String room;

    /**
     * 宿舍的类型
     */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(String dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "id=" + id +
                ", dormitoryId='" + dormitoryId + '\'' +
                ", build='" + build + '\'' +
                ", floor='" + floor + '\'' +
                ", room='" + room + '\'' +
                ", type=" + type +
                '}';
    }
}

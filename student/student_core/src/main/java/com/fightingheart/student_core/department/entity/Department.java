package com.fightingheart.student_core.department.entity;

public class Department {
    private Integer id;

    private String departmentName;

    private Integer foundYear;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Integer getFoundYear() {
        return foundYear;
    }

    public void setFoundYear(Integer foundYear) {
        this.foundYear = foundYear;
    }
}
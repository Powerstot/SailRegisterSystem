package com.sail.domain;

public class User {
    private String lifePhoto;
    private String username;
    private String sno;
    private String email;
    private String classAndGrade;
    private String phone;
    private String skills;
    private String reason;

    public String getLifePhoto() {
        return lifePhoto;
    }

    public void setLifePhoto(String lifePhoto) {
        this.lifePhoto = lifePhoto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClassAndGrade() {
        return classAndGrade;
    }

    public void setClassAndGrade(String classAndGrade) {
        this.classAndGrade = classAndGrade;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "User{" +
                "lifePhoto='" + lifePhoto + '\'' +
                ", username='" + username + '\'' +
                ", sno='" + sno + '\'' +
                ", email='" + email + '\'' +
                ", classAndGrade='" + classAndGrade + '\'' +
                ", phone='" + phone + '\'' +
                ", skills='" + skills + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}

package com.react.springboot.reactSpringbootTest.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "member")
public class MemberModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private String id;
    @Column(name = "password")
    private String password;

    @Column(name = "addr")
    private String addr;
    @Column(name = "phone")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "MemberModel{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

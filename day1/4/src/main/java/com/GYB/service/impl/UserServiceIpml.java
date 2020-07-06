package com.GYB.service.impl;

import com.GYB.service.UserService;

import java.util.*;

public class UserServiceIpml  implements UserService {
    private String[] name;
    private List<String> ages;
    private Set<String> birthdays;
    private Map<String,String>  users;
    private Properties properties;

    public void setName(String[] name) {
        this.name = name;
    }

    public void setAges(List<String> ages) {
        this.ages = ages;
    }

    public void setBirthdays(Set<String> birthdays) {
        this.birthdays = birthdays;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println(Arrays.toString(name));
        System.out.println(ages);
        System.out.println(birthdays);
        System.out.println(users);
        System.out.println(properties );
    }
}

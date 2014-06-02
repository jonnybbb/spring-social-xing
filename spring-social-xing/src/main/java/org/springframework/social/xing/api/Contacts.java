package org.springframework.social.xing.api;

import java.util.List;

/**
*
*/
public class Contacts {
    private Integer total;
    private List<User> users;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

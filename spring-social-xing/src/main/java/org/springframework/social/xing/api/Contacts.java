package org.springframework.social.xing.api;

import java.util.List;

/**
*
*/
public class Contacts {
    private Integer total;
    private List<XingProfile> users;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<XingProfile> getUsers() {
        return users;
    }

    public void setUsers(List<XingProfile> users) {
        this.users = users;
    }
}

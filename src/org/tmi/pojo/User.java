package org.tmi.pojo;

public class User {
    private int id;
    private String userName;
    private String password;
    private int Role;
    private int employee_id;
    private String manager_id;

    public User() {
    }

    public User(int id, String userName, String password, int role, int employee_id, String manager_id) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        Role = role;
        this.employee_id = employee_id;
        this.manager_id = manager_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return Role;
    }

    public void setRole(int role) {
        Role = role;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", Role=" + Role +
                ", employee_id=" + employee_id +
                ", manager_id=" + manager_id +
                '}';
    }
}

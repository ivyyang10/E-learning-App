package com.techelevator.model;

public class UserDTO {
    private int id;

    public UserDTO(int id) {
        this.id = id;
    }

    public UserDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                '}';
    }
}

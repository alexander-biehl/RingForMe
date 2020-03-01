package com.example.alexb.ringforme.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by alexb on 8/30/2017.
 */

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    //public String nickName;
    public String phone;

    public User(String name, /*String nickName,*/
                String phone) {
        this.name = name;
        //this.nickName = nickName;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private long id;
        private String name;
        //private String nickName;
        private String phone;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        /*public UserBuilder setNickName(String nickName) {
            this.nickName = nickName;
            return this;
        }*/

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(name, /*nickName,*/ phone);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                "name='" + name   + '\'' +
                //"nickName='" + nickName + '\''+
                "phone='" + phone + '\'' +
                '}';
    }
}

package com.example.QuizProject.entity;

public class User {
    private String user_name;
    private String password;
    private boolean is_admin = false;

    public User(String user_name, String password, boolean is_admin){
        user_name = this.user_name;
        password = this.password;
        is_admin = this.is_admin;
    }

    public User(String user_name, String password){
        user_name = this.user_name;
        password = this.password;
    }

    public static class UserBuilder {
        private String user_name;
        private String password;
        private boolean is_admin;


        public UserBuilder userName(String user_name) {
            this.user_name = user_name;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder isAdmin(boolean is_admin) {
            this.is_admin = is_admin;
            return this;
        }

        public User build() {
            return new User(user_name, password, is_admin);
        }

    }


}

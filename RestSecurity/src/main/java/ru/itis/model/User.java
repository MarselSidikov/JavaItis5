package ru.itis.model;

/**
 * 25.01.17
 * User
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class User {
    private int id;
    private String login;
    private String hashPassword;
    private int age;
    private String name;
    private String token;

    public User() {
    }

    public User(String login, String hashPassword, int age, String name) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.age = age;
        this.name = name;
    }

    public User(int id, String login, String hashPassword, int age, String name, String token) {
        this.id = id;
        this.login = login;
        this.hashPassword = hashPassword;
        this.age = age;
        this.name = name;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

package easy;

import java.util.Date;

/**
 * @author:yuze
 * @description:user实体类
 * @data:2022/1/15
 */
public class User {
    public int age;
    public String sex;
    private String address;
    public Date birthday;

    public User(int age, String sex, String address, Date birthday) {
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}

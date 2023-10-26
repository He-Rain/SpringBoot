package com.kuang.poro;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component //注册bean到容器中
@ConfigurationProperties(prefix = "dog")
public class DogTwo {
    private String firstName;
    private Integer age;

    public DogTwo() {
    }

    public DogTwo(String firstName, Integer age) {
        this.firstName = firstName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DogTwo{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}

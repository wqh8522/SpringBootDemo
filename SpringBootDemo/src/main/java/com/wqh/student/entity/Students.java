package com.wqh.student.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Students {

    @Id
    //@GeneratedValue//自增主键
    //使用uuid
    @GenericGenerator(name = "idGenerator", strategy = "uuid")//使用hibernate的主键生成策略
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "id",length = 32)
    private String id;

    /**
     *  1.@NotNull 不能为null，但可以为empty (""," ","   ")
     *  2.@NotEmpty：不能为null，而且长度必须大于0 (" ","  ")
     * 3.@NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0 ("test")    即：必须有实际字符
     */

    @NotNull(message = "姓名必传")
    private String name;

    //@Min 该注解限制字段的最小值
    @Min(value = 20 ,message = "未满20岁的学生禁止注册！！")
    private Integer age;

    @NotNull(message = "金额必传")
    private Double money;

    public Students() {
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

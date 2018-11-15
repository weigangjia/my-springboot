package com.example.myspringboot.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 类名称：Person<br>
 * 类描述：<br>
 * 创建时间：2018年11月13日<br>
 *
 * @author jwg
 * @version 1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person{
    private String name;
    private Integer age;
}

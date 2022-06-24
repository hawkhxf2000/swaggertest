package com.example.swaggertest.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@ApiModel("用户信息实体")
public class UserDemo {

    @ApiModelProperty(value = "编号", allowEmptyValue = true)
    private Long id;

    @ApiModelProperty(value = "姓名", required = true)
    private String name;

    @ApiModelProperty(value = "年龄", required = true)
    private Integer age;

}

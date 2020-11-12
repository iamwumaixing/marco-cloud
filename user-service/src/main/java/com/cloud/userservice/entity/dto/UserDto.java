package com.cloud.userservice.entity.dto;

import com.cloud.common.base.BaseEntity;
import com.cloud.common.base.entity.BasePo;
import com.cloud.common.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author marco
 * @date 2020/11/12 12:28 上午
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseEntity<User> {

    @NotBlank(message = "The user name cannot be empty")
    @Length(min = 5, max = 20, message = "The username length is 5 to 20")
    private String username;

    @NotBlank(message = "The username cannot be empty")
    @Length(min = 5, max = 16, message = "The password length is 5 to 16")
    private String password;

    private String name;

}

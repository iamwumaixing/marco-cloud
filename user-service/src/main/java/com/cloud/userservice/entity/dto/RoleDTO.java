package com.cloud.userservice.entity.dto;

import com.cloud.common.entity.Role;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * @author marco
 * @date 2020/11/15 3:37 下午
 */
@Data
@ToString
public class RoleDTO {

    @NotBlank(message = "the role name cannot be empty")
    @Length(max = 20, message = "the role name length is too long")
    private String roleName;

    @Length(max = 255, message = "the description length max is 255")
    private String description;

    private Set<String> permissionId;

    /**
     * DTO -> PO
     *
     * @param roleDTO
     * @return
     */
    public static Role convertToPo(RoleDTO roleDTO) {
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());
        role.setDescription(roleDTO.getDescription());
        role.setPermissionId(roleDTO.getPermissionId());
        return role;
    }


}

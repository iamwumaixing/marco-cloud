package com.cloud.userservice.entity.dto;

import com.cloud.common.entity.Permission;
import lombok.Data;
import lombok.ToString;


/**
 * @author marco
 * @date 2020/12/6 8:13 下午
 */
@Data
@ToString
public class PermissionDTO {

    private String permissionName;

    private String url;

    private String method;

    private String description;

    /**
     * DTO -> PO
     *
     * @param permissionDTO
     * @return
     */
    public static Permission convertToPo(PermissionDTO permissionDTO) {
        Permission permission = new Permission();
        permission.setPermissionName(permissionDTO.getPermissionName());
        permission.setUrl(permissionDTO.getUrl());
        permission.setMethod(permissionDTO.getMethod());
        permission.setDescription(permissionDTO.getDescription());
        return permission;
    }


}

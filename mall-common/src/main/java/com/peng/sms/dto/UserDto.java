package com.peng.sms.dto;

import lombok.*;

import java.util.List;

/**
 * @author macrozheng
 * @description User information wrapper used in the permission framework
 * @github https://github.com/macrozheng
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    /**
     * User ID
     */
    private Long id;

    /**
     * Username
     */
    private String username;

    /**
     * Client ID
     */
    private String clientId;

    /**
     * List of user permissions
     */
    private List<String> permissionList;
}

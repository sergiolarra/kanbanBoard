/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kanban.security.dto;

import javax.validation.constraints.NotBlank;
import lombok.Data;

/**
 *
 * @author Sergio
 */
@Data
public class LoginUser {
    @NotBlank
    private String username;
    @NotBlank
    private String password;
}

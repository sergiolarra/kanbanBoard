/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kanban.security.dto;

import java.util.Collection;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Sergio
 */
@Data
@AllArgsConstructor
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String username;
    private String id_user;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token, String username, Collection<? extends GrantedAuthority> authorities, String id_user) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
        this.id_user = id_user;
    }
    
    
}

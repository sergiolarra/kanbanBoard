/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kanban.security.model;

import com.kanban.model.Task;
import com.kanban.security.model.Rol;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.management.ConstructorParameters;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.*;

/**
 *
 * @author Sergio
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class Usuario implements Serializable{
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_user")
    private Long idUsuario;
    
    
    @NotNull
    private String name;
    
   
    @Column(unique = true)
    @NotNull
    private String username;
    
    
    @NotNull
    private String password;
    
    @OneToMany
    @JoinColumn(name="id_user")
    private List<Task>tasks;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_rol", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol>roles = new HashSet<>();

    public Usuario(@NotNull String name, @NotNull String username,@NotNull String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kanban.security.dao;

import com.kanban.security.enums.RolNombre;
import com.kanban.security.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sergio
 */
@Repository
public interface RolDao extends JpaRepository<Rol, Long>{
    Rol findByRolNombre(RolNombre rolNombre);
    
}

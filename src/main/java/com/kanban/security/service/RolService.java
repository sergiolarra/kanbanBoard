/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kanban.security.service;

import com.kanban.security.dao.RolDao;
import com.kanban.security.enums.RolNombre;
import com.kanban.security.model.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sergio
 */
@Service
@Transactional
public class RolService {
    
    @Autowired
    RolDao rolDao;
    
    public Rol getByRolName(RolNombre rolNombre){
        return rolDao.findByRolNombre(rolNombre);
    }
} 

package com.kanban.security.service;

import com.kanban.security.dao.UsuarioDao;
import com.kanban.security.model.Rol;
import com.kanban.security.model.Usuario;
import java.util.ArrayList;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sergio
 */
@Service
@Slf4j
@Transactional
public class UsuarioService {
//
    @Autowired
    private UsuarioDao usuarioDao;

    public Usuario getByUserName(String username){
        return usuarioDao.findByUsername(username);
    }
    
    public boolean existsByUsername(String username){
        return usuarioDao.existsByUsername(username);
    }
    
    public void save(Usuario usuario){
        usuarioDao.save(usuario);
    }
}

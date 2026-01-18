package com.fullProject.demo.jwt.service;

import com.fullProject.demo.jwt.configuration.JwtRequestFilter;
import com.fullProject.demo.jwt.dao.UserDao;
import com.fullProject.demo.jwt.entity.JwtRequest;
import com.fullProject.demo.jwt.entity.JwtResponse;
import com.fullProject.demo.jwt.entity.User;
import com.fullProject.demo.jwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findById(username).get();
        if(user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(), user.getUserPassword(), getAuthorities(user));
        }else{
            throw new UsernameNotFoundException("Username is not valid");
        }
    }

    private Set getAuthorities(User user){
        Set authorities = new HashSet();
        user.getRoles().forEach(role ->{
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        });
        return authorities;
    }
}

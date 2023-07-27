package com.example.examserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
@AllArgsConstructor
public class Authority implements GrantedAuthority {

    private String authority;
}

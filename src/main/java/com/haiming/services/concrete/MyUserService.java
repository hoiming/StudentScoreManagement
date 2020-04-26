package com.haiming.services.concrete;

import com.haiming.dao.User;
import com.haiming.dao.UserDynamicSqlSupport;
import com.haiming.dao.UserMapper;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class MyUserService<T extends User> implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userMapper.selectOne(s -> s.where(UserDynamicSqlSupport.username, isEqualTo(username)));
        if(!userOptional.isPresent()){
            throw new UsernameNotFoundException("unable to find user by username " + username);
        }
        User user = userOptional.get();
        List<SimpleGrantedAuthority> authoritiesList = new ArrayList<>();
        if(StringUtils.isNotBlank(user.getAuthorities())){
            String[] authorities = user.getAuthorities().split(",");
            for(String authority : authorities){
                if(StringUtils.isNotBlank(authority)){
                    authoritiesList.add(new SimpleGrantedAuthority(authority.trim()));
                }
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authoritiesList);
    }
}

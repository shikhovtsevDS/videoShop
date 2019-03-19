package ru.shikhovtsev.videoShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.shikhovtsev.videoShop.model.User;
import ru.shikhovtsev.videoShop.model.UserRole;
import ru.shikhovtsev.videoShop.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.createUser(login);

        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(UserRole.ADMIN.name()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),
                                                                                        user.getPassword(),
                                                                                        roles);
        return userDetails;
    }

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailServiceImpl();
    }
}

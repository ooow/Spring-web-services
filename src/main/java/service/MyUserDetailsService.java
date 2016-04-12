package service;

import DAO.UserDao;
import Model.Role;
import Model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Гога on 11.04.2016.
 */
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new UserDao().findByUserName(username);
        if (user == null)
            throw new UsernameNotFoundException("The user " + username + " doesn't exists.");
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
        return buildUserForAuthentication(user, authorities);
    }

    private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user,
                                                                                          List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(), authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Role userRole) {

        Set<GrantedAuthority> setAuths = new HashSet<>();
        setAuths.add(new SimpleGrantedAuthority(userRole.getTitle()));
        List<GrantedAuthority> Result = new ArrayList<>(setAuths);
        return Result;
    }
}

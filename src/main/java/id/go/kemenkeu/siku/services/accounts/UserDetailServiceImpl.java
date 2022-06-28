package id.go.kemenkeu.siku.services.accounts;

import id.go.kemenkeu.siku.models.accounts.RoleFeature;
import id.go.kemenkeu.siku.models.accounts.User;
import id.go.kemenkeu.siku.models.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if(user.getActive()){
            System.out.println(user.getRole().getId());
            for(RoleFeature roleFeature:user.getRole().getRoleFeature()){
                System.out.println(roleFeature.getFeature().getName());
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + roleFeature.getFeature().getName()));
            }
            System.out.println(user.getRole().getName());
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().getName()));
        }else{
            //TODO: Jika tidak aktif
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);


    }
}

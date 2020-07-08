package nl.miwgroningen.cohort3.alwin.buzzword.demo.service;

import nl.miwgroningen.cohort3.alwin.buzzword.demo.repository.BuzzUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BuzzUserDetailsService implements UserDetailsService {

    @Autowired
    BuzzUserRepository buzzUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return buzzUserRepository.findByUsername(s).orElseThrow(
                () -> new UsernameNotFoundException("User " + s + " was not found")
        );
    }
}

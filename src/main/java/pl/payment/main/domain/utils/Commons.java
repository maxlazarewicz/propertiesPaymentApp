package pl.payment.main.domain.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Commons {
    public String getPrincipal() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails) {
            return new String(((UserDetails)principal).getUsername());
        } else {
            return new String(principal.toString());
        }
    }
}

package com.leszigotos.api.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;


/**
 * Entity class representing a user in the application.
 *
 * <p>
 * This entity class defines the structure of a user within the application. It includes fields
 * for the user's ID, username, email, and password. Additionally, it implements the UserDetails
 * interface from Spring Security to provide information about the user's authentication and
 * authorization status.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 05/12/2024
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user_app")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, updatable = false, nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    /**
     * Returns the authorities granted to the user. Currently set to an empty list.
     *
     * @return A collection of GrantedAuthority representing the authorities granted to
     * the user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    /**
     * Indicates whether the user's account has not expired.
     *
     * @return {@code true} if the user's account is non-expired, {@code false} otherwise.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is not locked.
     *
     * @return {@code true} if the user is not locked, {@code false} otherwise.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Indicates whether the user's credentials (password) are not expired.
     *
     * @return {@code true} if the user's credentials are non-expired, {@code false}
     * otherwise.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Indicates whether the user is enabled.
     *
     * @return {@code true} if the user is enabled, {@code false} otherwise.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

}

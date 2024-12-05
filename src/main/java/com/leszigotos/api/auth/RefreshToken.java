package com.leszigotos.api.auth;

import com.leszigotos.api.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Entity class representing a refresh token used for token refreshing.
 *
 * <p>
 * This entity stores information about a refresh token, including its unique identifier,
 * associated user, token value, expiration date, and revocation status.
 * </p>
 *
 * @author Jérémy Woirhaye
 * @version 1.0
 * @since 05/12/2024
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken {

	/**
	 * Indicates whether the refresh token has been revoked.
	 */
	private boolean revoked;

	/**
	 * The unique identifier for the refresh token.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * The user associated with the refresh token.
	 */
	@ManyToOne
	private User user;

	/**
	 * The unique token value of the refresh token.
	 */
	@Column(nullable = false, unique = true, updatable = false)
	private String token;

	/**
	 * The expiration date of the refresh token.
	 */
	@Column(nullable = false, updatable = false)
	private Instant expiryDate;

}


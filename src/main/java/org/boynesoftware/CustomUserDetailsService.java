package org.boynesoftware;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.boynesoftware.configuration.model.Role;
import org.boynesoftware.configuration.model.User;
import org.boynesoftware.configuration.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class CustomUserDetailsService implements UserDetailsService
{

	private final UserRepository userRepository;

	@Autowired
	public CustomUserDetailsService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user = userRepository.findById(username);
		if (user == null)
		{
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		return new UserRepositoryUserDetails(user);
	}

	private final static class UserRepositoryUserDetails extends User implements UserDetails
	{

		private static final long serialVersionUID = 1L;

		private UserRepositoryUserDetails(User user)
		{
			super(user);
		}

		public String getPassword()
		{
			System.err.println("getting password "+super.getPassword());
			return super.getPassword();
		}

		public String getUsername()
		{
			System.err.println("getting password "+super.getUserId());

			return getUserId();
		}

		public boolean isAccountNonExpired()
		{
			return true;
		}

		public boolean isAccountNonLocked()
		{
			return true;
		}

		public boolean isCredentialsNonExpired()
		{
			return true;
		}

		public boolean isEnabled()
		{
			return true;
		}

		public Collection<? extends GrantedAuthority> getAuthorities()
		{
			return super.getRoles();
		}

	}

}

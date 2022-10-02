/*
 * author: Sadik Hassan
 * created: 11:39 am, 29/09/2022
 */
package com.spring.springsecurityjwt.controller;


import com.spring.springsecurityjwt.model.Authentication;
import com.spring.springsecurityjwt.model.AuthenticationResponse;
import com.spring.springsecurityjwt.services.Jwtutil;
import com.spring.springsecurityjwt.services.MyUserDetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Resource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsServices userDetailsService;
    @Autowired
    private Jwtutil jwtTokenUtil;
    @RequestMapping({"/hello"})
    public String Hello(){
        return "Hello World!";
    }

    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?>createAuthenticationToken(@RequestBody Authentication authentication) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authentication.getUsername(), authentication.getPassword()));
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect Username or Password!",e);
        }
        final UserDetails userDetails=userDetailsService.loadUserByUsername(authentication.getUsername());
        final String jwt=jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}

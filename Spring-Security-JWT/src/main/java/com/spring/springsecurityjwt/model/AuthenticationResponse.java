package com.spring.springsecurityjwt.model;
/*
 * author: Sadik Hassan
 * created: 2:52 pm, 02/10/2022
 */

public class AuthenticationResponse {
 private final String jwt;

 public AuthenticationResponse(String jwt) {
  this.jwt = jwt;
 }

 public String getJwt() {
  return jwt;
 }
}

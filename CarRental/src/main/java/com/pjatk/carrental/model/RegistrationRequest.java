package com.pjatk.carrental.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class RegistrationRequest {
    private   String firstName;
    private   String lastName;
    private   String userName;
    private   String password;

}

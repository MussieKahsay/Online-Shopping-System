package edu.miu.cs.cs425.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserSignInDetail {
    Integer id;
    String firstNAme;
    String lastName;
    String signinStatus;

}
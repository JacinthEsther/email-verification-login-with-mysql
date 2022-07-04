package com.example.emailverificationmysql.registration;


import com.example.emailverificationmysql.appuser.AppUser;
import com.example.emailverificationmysql.appuser.AppUserRole;
import com.example.emailverificationmysql.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private EmailValidator emailValidator;
    private final AppUserService appUserService;
    public String register(RegistrationRequest request) {
      boolean isValidEmail=  emailValidator.test(request.getEmail());

      if(!isValidEmail){
          throw new IllegalStateException("email not valid");
      }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getFirstName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}

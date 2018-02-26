package org.ops4j.security;

import static javax.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;

import java.util.Arrays;
import java.util.HashSet;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

@ApplicationScoped
public class SimpleIdentityStore implements IdentityStore {

    public CredentialValidationResult validate(UsernamePasswordCredential credential) {
        String user = credential.getCaller();
        Password password = credential.getPassword();
        if (user.equals("operator") && password.compareTo("secret")) {
            return new CredentialValidationResult(user, new HashSet<>(Arrays.asList("USER")));
        }
        return INVALID_RESULT;
    }
}

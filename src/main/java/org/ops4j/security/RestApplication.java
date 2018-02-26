package org.ops4j.security;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("api")
@BasicAuthenticationMechanismDefinition(realmName = "demo")
@DeclareRoles({"USER", "ADMIN" })
@ApplicationScoped
public class RestApplication extends Application {

}

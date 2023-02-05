package br.com.dbufalo.financesapi.startup;

import br.com.dbufalo.financesapi.model.AuthenticationUser;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class Startup {
    @Transactional
    public void startUp(@Observes StartupEvent evt) {
        // reset and load all test users
//        AuthenticationUser.deleteAll();
//        AuthenticationUser.add("admin", "admin", "123123123","admin");
//        AuthenticationUser.add("user", "user", "312312312","user");
    }
}

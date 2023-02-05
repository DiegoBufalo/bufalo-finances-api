package br.com.dbufalo.financesapi.repository;

import br.com.dbufalo.financesapi.model.Wallet;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WalletRepository implements PanacheRepositoryBase<Wallet, Long> {

}

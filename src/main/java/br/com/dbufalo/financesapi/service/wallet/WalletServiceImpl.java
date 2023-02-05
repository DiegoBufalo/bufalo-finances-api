package br.com.dbufalo.financesapi.service.wallet;

import br.com.dbufalo.financesapi.errors.NotFoundObject;
import br.com.dbufalo.financesapi.model.User;
import br.com.dbufalo.financesapi.model.Wallet;
import br.com.dbufalo.financesapi.repository.UserRepository;
import br.com.dbufalo.financesapi.repository.WalletRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;

    public WalletServiceImpl(WalletRepository walletRepository, UserRepository userRepository) {
        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Double incrementCashAmount(Long userId, Double amount) {
        User user = userRepository.findByIdOptional(userId).orElseThrow(() -> {
            throw new NotFoundObject("Carteira não encontrada");
        });

        Wallet wallet = user.getWallet();
        wallet.incrementCashAmount(amount);
        return wallet.getCashValue();
    }

    @Override
    public Double decrementCashAmount(Long userId, Double amount) {
        User user = userRepository.findByIdOptional(userId).orElseThrow(() -> {
            throw new NotFoundObject("Carteira não encontrada");
        });

        Wallet wallet = user.getWallet();
        wallet.decrementCashAmount(amount);
        return wallet.getCashValue();
    }
}

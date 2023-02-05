package br.com.dbufalo.financesapi.service.wallet;

public interface WalletService  {
    Double incrementCashAmount(Long userId, Double amount);

    Double decrementCashAmount(Long userId, Double amount);
}

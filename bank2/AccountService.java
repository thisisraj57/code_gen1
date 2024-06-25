public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account openAccount(Account account) {
        // Save the account to the database
        Account savedAccount = accountRepository.save(account);

        // Notify the customer of their account status
        notifyCustomer(savedAccount);

        return savedAccount;
    }

    private void notifyCustomer(Account account) {
        // Send an email or SMS to the customer
        // ...
    }

}
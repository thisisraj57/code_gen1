public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with id :" + id));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public void approveAccount(Long id) {
        Account account = getAccount(id);
        account.setStatus("APPROVED");
        accountRepository.save(account);
        // ... notify customer of account approval
    }

    public void rejectAccount(Long id) {
        Account account = getAccount(id);
        account.setStatus("REJECTED");
        accountRepository.save(account);
        // ... notify customer of account rejection
    }
}
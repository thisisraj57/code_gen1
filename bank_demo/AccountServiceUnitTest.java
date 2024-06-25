public class AccountServiceUnitTest {

    @Autowired private AccountRepository accountRepository;
    private AccountService accountService;

    @BeforeEach
    public void setUp() {
        accountService = new AccountService(accountRepository);
    }

    @Test
    public void testCreateAccount() {
        Account account = new Account("1234567890", "SAVINGS", "PENDING");
        Account savedAccount = accountService.createAccount(account);
        assertThat(savedAccount).isNotNull();
        assertThat(savedAccount.getId()).isGreaterThan(0L);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account("1234567890", "SAVINGS", "PENDING");
        Account savedAccount = accountService.createAccount(account);
        savedAccount.setStatus("APPROVED");
        Account updatedAccount = accountService.updateAccount(savedAccount);
        assertThat(updatedAccount).isNotNull();
        assertThat(updatedAccount.getStatus()).isEqualTo("APPROVED");
    }

    @Test
    public void testGetAccount() {
        Account account = new Account("1234567890", "SAVINGS", "PENDING");
        Account savedAccount = accountService.createAccount(account);
        Account fetchedAccount = accountService.getAccount(savedAccount.getId());
        assertThat(fetchedAccount).isNotNull();
        assertThat(fetchedAccount.getId()).isEqualTo(savedAccount.getId());
    }

    @Test
    public void testGetAllAccounts() {
        Account account1 = new Account("1234567890", "SAVINGS", "PENDING");
        accountService.createAccount(account1);
        Account account2 = new Account("0987654321", "CURRENT", "APPROVED");
        accountService.createAccount(account2);
        List<Account> accounts = accountService.getAllAccounts();
        assertThat(accounts).isNotEmpty();
        assertThat(accounts).hasSize(2);
    }

    @Test
    public void testDeleteAccount() {
        Account account = new Account("1234567890", "SAVINGS", "PENDING");
        Account savedAccount = accountService.createAccount(account);
        accountService.deleteAccount(savedAccount.getId());
        Optional<Account> deletedAccount = accountRepository.findById(savedAccount.getId());
        assertThat(deletedAccount).isEmpty();
    }

    @Test
    public void testApproveAccount() {
        Account account = new Account("1234567890", "SAVINGS", "PENDING");
        Account savedAccount = accountService.createAccount(account);
        accountService.approveAccount(savedAccount.getId());
        Account approvedAccount = accountService.getAccount(savedAccount.getId());
        assertThat(approvedAccount).isNotNull();
        assertThat(approvedAccount.getStatus()).isEqualTo("APPROVED");
    }

    @Test
    public void testRejectAccount() {
        Account account = new Account("1234567890", "SAVINGS", "PENDING");
        Account savedAccount = accountService.createAccount(account);
        accountService.rejectAccount(savedAccount.getId());
        Account rejectedAccount = accountService.getAccount(savedAccount.getId());
        assertThat(rejectedAccount).isNotNull();
        assertThat(rejectedAccount.getStatus()).isEqualTo("REJECTED");
    }
}
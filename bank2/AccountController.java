public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.ok(createdAccount);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
        Account account = accountService.getAccount(accountId);
        return ResponseEntity.ok(account);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
        Account updatedAccount = accountService.updateAccount(accountId, account);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{accountId}/approve")
    public ResponseEntity<Void> approveAccount(@PathVariable Long accountId) {
        accountService.approveAccount(accountId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{accountId}/notify")
    public ResponseEntity<Void> notifyCustomer(@PathVariable Long accountId) {
        accountService.notifyCustomer(accountId);
        return ResponseEntity.ok().build();
    }
}
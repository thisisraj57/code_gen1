public class AccountManagementController {

    @PostMapping("/open-account")
    public ResponseEntity<Account> openAccount(@RequestBody AccountRequest request) {
        // Validate request
        // Create new account
        Account account = accountService.openAccount(request);      
        // Send notification to customer

        return ResponseEntity.created(URI.create("/accounts/" + account.getId())).body(account);
    }

    @GetMapping("/approve-account/{accountId}")
    public ResponseEntity<Account> approveAccount(@PathVariable Long accountId) {
        // Authenticate bank representative
        // Approve account
        Account account = accountService.approveAccount(accountId);
        // Send notification to customer

        return ResponseEntity.ok(account);
    }

    @GetMapping("/reject-account/{accountId}")
    public ResponseEntity<Account> rejectAccount(@PathVariable Long accountId) {
        // Authenticate bank representative
        // Reject account
        Account account = accountService.rejectAccount(accountId);
        // Send notification to customer

        return ResponseEntity.ok(account);
    }
}
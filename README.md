# Financial Accounting 

In financial accounting, a distinction is made between asset and liability costs. An account is characterised by debit (left-hand side) and credit (right-hand side). \n
Asset account ► Debit: opening balance, increases; credit: Decreases. 
Liability account ► Debit: Decreases; Credit: Opening balance, increases. \n
Commands include (i) Login(user,password); (ii) Create(name,type,initialBalance) (creates an account); (iii) Book(debit,credit,amount) (posts debit to credit); (iv) Undo (undoes last posting); (v) View(account) (displays status of account and transactions); (vi) ViewChangeLog (displays change log) \n
A distinction is made between the roles (i) Administrator, (ii) Clerk and (iii) Viewer. 
- The Administrator role is authorised to execute the Login, Create and ViewChangeChangeLog commands. 
- The Clerk role is authorised to execute the Book, Undo and View commands. 
- The Viewer role is authorised to execute the View command. 
A user is registered on a proxy with name, password (encrypted with MD5) and role. 
A change document is characterised by (i) consecutive ID, (ii) timestamp in Unix seconds, (iii) debit account, (iv) credit account, (v) amount, (vi) type [posting | cancellation]. 
For simulation purposes, three asset and three liability accounts are created, 25 postings are made and 3 postings are cancelled.

---

Ppplication simulates financial transactions, using the command, proxy, and memento design pattern.
Test management is done using both Cucumber and JUnit. 

---

As part of an university project 

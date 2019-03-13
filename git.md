# Git command line
1. Add file:
   - Add a file: `git add <file>`
   - Add all file: `git add .`
   - Unstage (delete the added file): `git reset <file/directory>`
2. Reset file to head: `git checkout <FILE>` 
3. Commit: `git commit -m "<description>"`
4. Pull: `git pull`
5. Merge: git merge <from branch>
6. Checkout:
   - Switch branch: `git checkout <name Branch>`
   - Switch commit: `git checkout <number commit>`
7. Delete commit on web:
   - Step 1: `git reset --hard <commit_id>`
   - Step 2: `git push <origin> <branch> --force `
8. Clone:
   - clone from branch; `git clone -b <name_branch> link`
9. Config Authentication:
   - set user: git config [--global] user.name <"name">
   - set email: git config [--global] user.email <"email">
   - set password: git config [--global] user.password <"password">
## Fix error
1. Fix error **Access denied, fatal: Authentication failed**
   - go to Credential Manager -> Windows Credentials -> Replace old password

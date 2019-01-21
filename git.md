# Git command line
1. Add file:
   - Add a file: `git add <file>`
   - Add all file: `git add .`
   - Unstage (delete the added file): `git reset <file/directory>`
2. Commit: `git commit -m "<description>"`
3. Pull: `git pull`
4. Merge: git merge <from branch>
5. Checkout:
   - Switch branch: `git checkout <name Branch>`
   - Switch commit: `git checkout <number commit>`
6. Delete commit on web:
   - Step 1: `git reset --hard <commit_id>`
   - Step 2: `git push <origin> <branch> --force `

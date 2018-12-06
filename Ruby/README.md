# Ruby
## Concept
1. [**Ruby**](https://www.ruby-lang.org/en/): is a dynamic, open source programming language with a focus on simplicity and productivity.
2. [**Devkit**](https://github.com/rdp/rubyinstaller/wiki/Development-Kit): : is a toolkit that to build and use native **C/C++** for Ruby on Windows.
3. [**Bundler**](https://bundler.io/): manager ruby gems dependencies for project.
4. [**Scope**](https://www.techotopia.com/index.php/Ruby_Variable_Scope): defines where in a program a variable is accessible.
   - Local: are to the code construct in which they are declare.
   - Global: are accessible from anywhere in the Ruby program.
   - Class: shared between a class, its subclasses and its instances, as same protected static in java.
   - Instance: Shared across all methods for same object.
   - Constant: values which, once assigned a value, should not be changed.
## Install
1. [Download](https://rubyinstaller.org/downloads/).
   - Check: `ruby --v`.
2. install Bundler: `gem install bundler`.
## Syntax
1. [**Comment**](https://www.techotopia.com/index.php/Understanding_Ruby_Variables): 
   - single line: `#<comment>`
   - multiple line: `=begin <comment> =end`
2. **Variable**: dynamic type.
   - declare: `<variable> = <value >`
3. **Convert**: 
   - To float: 
        - `<variable>.to_f`
        - `Float (<value>)` 
   - To string: `<variable>.to_s(<base>)`
   - To integer: `Integer (<value>)`
4. **Scope**: 
   - Global: `$<name>`
   - Instance: `@<name>`
   - Local: `<name>` [a-z] or _
   - Constant: `<name>` [A-Z]
   - Class: `@@<name>`
5. [**Method**](https://www.techotopia.com/index.php/Ruby_Methods): `def <name> [code] end`
6. **Import code**: import code from ruby file.
   - Require: import a file code.
   - [Require_all](https://github.com/jarmo/require_all): automatically load directory full of code.
        - require_all: load directory full of code
        - require_rel: load file relative to the current file.
        - autoload_all: 
## Run
1. File: `ruby <name_file.rb>`
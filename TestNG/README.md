# [TestNG]()


## Concept: 
1. [Test Case](https://en.wikipedia.org/wiki/Test_case): is a specification of the inputs, execution conditions, testing procedure, and expected results that define a single test to be executed to achieve a particular software testing objective, such as to exercise a particular program path or to verify compliance with a specific requirement.
2. [Test Suite](https://en.wikipedia.org/wiki/Test_suite): is a collection of <strong>test cases</strong>. Typically, it contains detailed instructions or goals for each collection of test cases and information on the system configuration to be used during testing.
## Annotation

1. `@BeforeSuite`: Run before all tests in this suite have run.
2. `@AfterSuite`: Run after all tests in this suite have run.
3. `@BeforeTest`: Run before any test method belonging to the classes inside the `<test>` tag is run.
4. `@AfterTest`: Run after all the test methods belonging to the classes inside the `<test>` tag have run.
5. `@BeforeGroups`: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.
6. `@AfterGroups`: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.
7. `@BeforeClass`: Run before the first test method in the current class is invoked.
8. `@AfterClass`: Run after all the test methods in the current class have been run.
9. `@BeforeMethod`: Run before each test method.
10. `@AfterMethod`: Run after each test method.

## [Test Suite](https://testng.org/doc/documentation-main.html#testng-xml): to execute so many test cases on a run.

1. `<suite>`:
   - `name`: 
   - `verbose`: 
   - `allow-return-values="true"`: 
2. `<test>`:
   - `name`: specific name of test.
   - `allow-return-values="true"`: 
3. `<classes>`:
4. `<class>`: 
5. `<packages>`:
6. `<package>`:
   - `name`: specific name of package

### Example

   <details>

   ```xml
   <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
  
    <suite name="Suite1" verbose="1" >
    <test name="Nopackage" >
        <classes>
            <class name ="NoPackageTest" />
        </classes>
    </test>
    
    <test name="Regression1">
        <groups>
            <run>
                <exclude name="brokenTests"  />
                <include name="checkinTests"  />
            </run>
        </groups>
        <classes>
            <class name="test.sample.ParameterSample">
                <methods>
                    <include name="testMethod" />
                </methods>
            </class>
            <class name="test.sample.ParameterTest"/>
        </classes>
    </test>
    </suite>

   ```
   </details>

## Test code:
1. <strong>Test method</strong>: Annotated with `@Test`, ignore return.
2.  <strong>Test Groups</strong>: 

## Reference
1. [Tooldqa.com](http://toolsqa.com/testng/what-is-testng/)
2. [testng.org](https://testng.org/doc/index.html)
3. [tutorialspoint.com](http://www.tutorialspoint.com/testng/)

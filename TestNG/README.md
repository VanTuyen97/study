# [TestNG]()


## Concept: 
1. **[Test Case](https://en.wikipedia.org/wiki/Test_case)**: is a specification of the inputs, execution conditions, testing procedure, and expected results that define a single test to be executed to achieve a particular software testing objective, such as to exercise a particular program path or to verify compliance with a specific requirement.
2. **[Test Suite](https://en.wikipedia.org/wiki/Test_suite)**: is a collection of **test cases**. Typically, it contains detailed instructions or goals for each collection of test cases and information on the system configuration to be used during testing.
## Annotation

1. **@BeforeSuite**: Run before all tests in this suite have run.
2. **@AfterSuite**: Run after all tests in this suite have run.
3. **@BeforeTest**: Run before any test method belonging to the classes inside the **`<test>`** tag is run.
4. **@AfterTest**: Run after all the test methods belonging to the classes inside the **`<test>`** tag have run.
5. **@BeforeGroups**: The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.
6. **@AfterGroups**: The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.
7. **@BeforeClass**: Run before the first test method in the current class is invoked.
8. **@AfterClass**: Run after all the test methods in the current class have been run.
9. **@BeforeMethod**: Run before each test method.
10. **@AfterMethod**: Run after each test method.

## [Test Suite](https://testng.org/doc/documentation-main.html#testng-xml): to execute so many test cases on a run.

- [Test Group](https://testng.org/doc/documentation-main.html#test-groups): groupings of test methods.
- [Group method](https://testng.org/doc/documentation-main.html#method-groups): Can also exclude or include individual methods.
- [Groups of groups](https://testng.org/doc/documentation-main.html#groups-of-groups): Groups can also include other groups.
- [Exclusion groups](https://testng.org/doc/documentation-main.html#exclusions): TestNG allows you to include groups as well as exclude them.
- [Partial groups](https://testng.org/doc/documentation-main.html#partial-groups): Can define groups at the class level and then add groups at the all method level.
- [Parameters](https://testng.org/doc/documentation-main.html#parameters): Test methods allow pass parammeter from testng.xml file.
    - [Parameters with DataProviders](https://testng.org/doc/documentation-main.html#parameters-dataproviders): Pass complex parameters (array) to test method. This test will run muntiple times.
- [Dependencies](https://testng.org/doc/documentation-main.html#dependent-methods): Need a test methods to be invoked before this method is call.
    - [Dependencies with annotations](https://testng.org/doc/documentation-main.html#dependencies-with-annotations): Use the attributes dependsOnMethods or dependsOnGroups of **@Test** annotation.
    - [Dependencies in XML](https://testng.org/doc/documentation-main.html#dependencies-in-xml):  Can specify your group dependencies in the testng.xml file.
- [Parallelism and time-outs](https://testng.org/doc/documentation-main.html#parallel-running): Run tests in separate threads in various ways.
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

## Test code example:
**Notice**:  Netbean, to run must config path to testng.xml file in [pom.xml](pom.xml).
1. [**Start**](src/test/java/com/vantuyen361/testng/start): the first test example.
2. [**Group**](src/test/java/com/vantuyen361/testng/group): one more annotation of TestNG which can be used in the execution of multiple tests.
3.  [**Annotation**](src/test/java/com/vantuyen361/testng/annotation): use annotation in test case. 
4.  [**Dependent Test**](src/test/java/com/vantuyen361/testng/dependent):  invoke methods in a Test case before this test method run.
## Reference
1. [Tooldqa.com](http://toolsqa.com/testng/what-is-testng/)
2. [testng.org](https://testng.org/doc/index.html)
3. [tutorialspoint.com](http://www.tutorialspoint.com/testng/)
## Run testNG.xml by command line
- Default: `mvn test -Dsurefire.suiteXmlFiles='<path.xml>'`
- <details>
    <summary>Set variable in Pom</summary>

    - <details>
        <summary>Step 1: add plugin <code>maven-surefire-plugin</code></summary>

        ```xml
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.18.1</version>
            <configuration>
                <forkCount>0</forkCount>
                <suiteXmlFiles>
                    <!-- pattern path file to TtestNG.xml -->
                    <suiteXmlFile>${project.basedir}src/test/com/vantuyen361/testng/${testNGFile}</suiteXmlFile>
                </suiteXmlFiles>
            </configuration>
        </plugin>
        ```
        </details>
    - Step 2: run `mvn test -DtestNGFile="TestNG.xml"`
    </details>

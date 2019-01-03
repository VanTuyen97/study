# Maven
## Create jar file
1. With dependence (scope differ test): 
  - Run with command: `mvn clean compile assembly:single` 
  - Addition pulgin build
    ```maven
    <build>
      <plugins>
        <plugin>
          <artifactId>maven-assembly-plugin</artifactId>
          <configuration>
            <archive>
              <manifest>
                <mainClass>fully.qualified.MainClass</mainClass>
              </manifest>
            </archive>
            <descriptorRefs>
              <descriptorRef>jar-with-dependencies</descriptorRef>
            </descriptorRefs>
          </configuration>
        </plugin>
      </plugins>
    </build>
    ```

# Maven
## Create jar file
1. With dependence (scope differ test): 
   - Run with command: `mvn assembly:single -DdescriptorId=jar-with-dependencies package -DskipTest` 
   - Addition pulgin build
      ```maven
      <build>
        <plugins>
          <plugin>
            <artifactId>maven-assembly-plugin</artifactId>
            <configuration>
              <archive>
                <manifest>
                  <!--Class contain main method-->
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

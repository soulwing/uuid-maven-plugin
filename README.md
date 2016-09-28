uuid-maven-plugin
=================

A Maven plugin that produces a random UUID in a build property.

By default this plugin binds to the `initialize` build phase.

Usage:

```
<build>
  <plugins>
    <plugin>
      <groupId>org.soulwing</groupId>
      <artifactId>uuid-maven-plugin</artifactId>
      <version>1.0.0</version>
      <executions>
        <execution>
          <goals>
            <goal>uuid</goal>
          </goals>
          <configuration>
            <targetProperty>my.uuid</targetProperty>
          </configuration>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```

If you want a UUID type other than random, feel free to send me a pull request
with an implementation.

package org.soulwing.maven.uuid;

import java.util.UUID;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * A mojo that generates a UUID.
 *
 * @author Carl Harris
 */
@Mojo(name = "uuid", defaultPhase = LifecyclePhase.INITIALIZE)
public class UuidMojo extends AbstractMojo {

  private static final String RANDOM_TYPE = "random";

  @Component(role = MavenSession.class)
  protected MavenSession session;

  @Parameter(name = "targetProperty", required = true)
  private String targetProperty;

  @Parameter(name = "type", defaultValue = RANDOM_TYPE)
  private String type;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    final UUID uuid = generateUuid();
    getLog().info("setting property " + targetProperty + "=" + uuid);
    session.getCurrentProject().getProperties().setProperty(targetProperty,
        uuid.toString());
  }

  private UUID generateUuid() throws MojoExecutionException {
    if (RANDOM_TYPE.equals(type.trim())) {
      return UUID.randomUUID();
    }
    throw new MojoExecutionException("unrecognized UUID type '" + type + "'");
  }

}

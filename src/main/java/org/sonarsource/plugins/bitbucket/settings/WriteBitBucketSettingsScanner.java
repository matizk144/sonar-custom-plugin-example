/*
 * Example Plugin for SonarQube
 * Copyright (C) 2009-2016 SonarSource SA
 * mailto:contact AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonarsource.plugins.bitbucket.settings;

import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.utils.log.Loggers;

public class WriteBitBucketSettingsScanner implements Sensor {

  @Override
  public void describe(SensorDescriptor descriptor) {
    descriptor.name(getClass().getName());
  }

  @Override
  public void execute(SensorContext context) {
    if (context.config().getBoolean(BitBucketProperties.PULL_REQUEST).isPresent() &&
        context.config().getBoolean(BitBucketProperties.PULL_REQUEST).get()) {
      // print log only if property is set to true
      Loggers.get(getClass()).info("---------------------------");
      Loggers.get(getClass()).info("--BITBUCKET CONFIGURATION--");
      Loggers.get(getClass()).info("---------------------------");
      Loggers.get(getClass()).info("Server: " + context.config().get(BitBucketProperties.HOST));
      Loggers.get(getClass()).info("Project key: " + context.config().get(BitBucketProperties.PROJECT_KEY));
      Loggers.get(getClass()).info("Repository: " + context.config().get(BitBucketProperties.REPO));
      Loggers.get(getClass()).info("---------------------------");
    }
  }

}

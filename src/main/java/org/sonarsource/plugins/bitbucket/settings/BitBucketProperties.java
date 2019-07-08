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

import java.util.List;
import org.sonar.api.config.PropertyDefinition;
import org.sonar.api.resources.Qualifiers;
import org.sonar.api.web.page.Page.Qualifier;

import static java.util.Arrays.asList;

import java.util.Arrays;

public class BitBucketProperties {

  public static final String HOST = "sonar.bitbucket.host";
  public static final String PROJECT_KEY = "sonar.bitbucket.projectKey";
  public static final String REPO = "sonar.bitbucket.repo";
  public static final String TOKEN = "sonar.bitbucket.token";
  public static final String PULL_REQUEST = "sonar.bitbucket.fillPullRequest";
  public static final String CATEGORY = "BitBucket Properties";

  private BitBucketProperties() {
    // only statics
  }

  public static List<PropertyDefinition> getProperties() {
    return asList(
      PropertyDefinition.builder(HOST)
        .name("Host")
        .description("Server address")
        .defaultValue("")
        .category(CATEGORY)
        .build(),
        PropertyDefinition.builder(PROJECT_KEY)
        .name("Project key")
        .description("Project key")
        .defaultValue("")
        .category(CATEGORY)
        .onlyOnQualifiers(Qualifiers.PROJECT)
        .build(),
        PropertyDefinition.builder(REPO)
        .name("Repository name")
        .description("Repository name")
        .defaultValue("")
        .category(CATEGORY)
        .onlyOnQualifiers(Qualifiers.PROJECT)
        .build(),
        PropertyDefinition.builder(TOKEN)
        .name("Authorization token")
        .description("API Token used for call BitBucket API")
        .defaultValue("")
        .category(CATEGORY)
        .onQualifiers(Qualifiers.PROJECT)
        .build()                           
        );
  }

}

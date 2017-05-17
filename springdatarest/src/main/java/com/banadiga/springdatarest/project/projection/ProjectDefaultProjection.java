package com.banadiga.springdatarest.project.projection;

import com.banadiga.springdatarest.project.Project;

import org.springframework.data.rest.core.config.Projection;

// FIXME Set as default for Project
@Projection(types = Project.class, name = "default")
public interface ProjectDefaultProjection {

  String getName();

  String getDescription();
}

package io.github.ritter4u.POCGISAPI.Domain.Polygons;

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface PolygonsRepository : JpaRepository<Polygons, Long> {
}
package io.github.ritter4u.POCGISAPI.Infrastructure.Repository;

import io.github.ritter4u.POCGISAPI.Domain.Polygon.Entity.PolygonEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PolygonEntityRepository : JpaRepository<PolygonEntity, Long> {
}
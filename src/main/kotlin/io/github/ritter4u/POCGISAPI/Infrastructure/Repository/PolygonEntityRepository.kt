package io.github.ritter4u.POCGISAPI.Infrastructure.Repository;

import io.github.ritter4u.POCGISAPI.Domain.Polygon.Entity.PolygonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PolygonEntityRepository : JpaRepository<PolygonEntity, Long> {
}
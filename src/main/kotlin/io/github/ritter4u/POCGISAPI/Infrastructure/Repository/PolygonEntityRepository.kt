package io.github.ritter4u.POCGISAPI.Infrastructure.Repository;

import io.github.ritter4u.POCGISAPI.Domain.Polygon.Entity.PolygonEntity
import io.github.ritter4u.POCGISAPI.Domain.Polygon.PolygonQueryParam
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface PolygonEntityRepository : JpaRepository<PolygonEntity, Long> {
}
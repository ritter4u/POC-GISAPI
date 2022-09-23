package io.github.ritter4u.POCGISAPI.Infrastructure.Jpa;

import org.springframework.data.jpa.repository.JpaRepository

interface PolygonEntityRepository : JpaRepository<PolygonEntity, Long> {
}
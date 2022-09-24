package io.github.ritter4u.POCGISAPI.Infrastructure.Service

import io.github.ritter4u.POCGISAPI.Domain.Polygon.DTO.PolygonDTO
import io.github.ritter4u.POCGISAPI.Domain.Polygon.PolygonQueryParam
import io.github.ritter4u.POCGISAPI.Infrastructure.Repository.PolygonEntityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class PolygonService {
    @Autowired
    lateinit var polygonRepository: PolygonEntityRepository
}
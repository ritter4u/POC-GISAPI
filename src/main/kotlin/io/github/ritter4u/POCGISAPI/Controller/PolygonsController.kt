package io.github.ritter4u.POCGISAPI.Controller

import io.github.ritter4u.POCGISAPI.Domain.Polygon.Entity.PolygonEntity
import io.github.ritter4u.POCGISAPI.Domain.Polygon.Polygon
import io.github.ritter4u.POCGISAPI.Domain.Polygon.PolygonQueryParam
import io.github.ritter4u.POCGISAPI.Infrastructure.Service.PolygonService
import io.github.ritter4u.POCGISAPI.Infrastructure.Repository.PolygonEntityRepository
import io.swagger.annotations.Api
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PagedResourcesAssembler
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.annotations.ApiIgnore

@RestController
public class PolygonsController(
    private val polygonRepository: PolygonEntityRepository,
//    private val modelMapper: ModelMapper,
) {
    @Autowired
    private lateinit var polygonService: PolygonService
    @GetMapping("/Polygon/GetAll", produces = ["application/json"])

    fun getPoligonList(
        @ModelAttribute params: PolygonQueryParam,
        @ApiIgnore pageable: Pageable,
        @ApiIgnore pagedResourcesAssembler: PagedResourcesAssembler<PolygonEntity>,
    ): ResponseEntity<*> {
        val polygons = this.polygonRepository.findAll(pageable)
        return ResponseEntity.ok(
            pagedResourcesAssembler.toModel(polygons)
        )
    }
}

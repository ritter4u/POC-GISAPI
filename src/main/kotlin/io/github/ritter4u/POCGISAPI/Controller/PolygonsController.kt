package io.github.ritter4u.POCGISAPI.Controller

import io.github.ritter4u.POCGISAPI.Domain.Polygons.PolygonsRepository
import org.modelmapper.ModelMapper
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@Api(description = "GIS API")
@RestController
@RequestMapping("/Polygon")
public class PolygonsController(
    private val polygonRepository : PolygonsRepository,
    private val modelMapper: ModelMapper
) {
}
package io.github.ritter4u.POCGISAPI.Domain.Polygon.DTO

import io.github.ritter4u.POCGISAPI.Domain.Polygon.Entity.PolygonEntity

data class PolygonDTO(
    val gid: Long?,
    val pnu: String?,
    val jibun: String?,
    val bchk: String?,
    val sgg_oid: Double?,
    val col_adm_se: String?,
    val geom: String?
)



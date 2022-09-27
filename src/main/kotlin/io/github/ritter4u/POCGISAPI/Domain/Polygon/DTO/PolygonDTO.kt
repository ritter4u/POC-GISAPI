package io.github.ritter4u.POCGISAPI.Domain.Polygon.DTO

import org.locationtech.jts.geom.Geometry
import java.io.Serializable

data class PolygonDTO
    (
    val gid: Long?,
    val pnu: String?,
    val jibun: String?,
    val bchk: String?,
    val sgg_oid: Double?,
    val col_adm_se: String?,
    val geom: Geometry?,
) : Serializable
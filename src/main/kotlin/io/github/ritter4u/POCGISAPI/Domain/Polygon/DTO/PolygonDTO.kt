package io.github.ritter4u.POCGISAPI.Domain.Polygon.DTO

import net.postgis.jdbc.geometry.Geometry
import org.locationtech.jts.geom.MultiPolygon


data class PolygonDTO(
    val gid: Long?,
    val pnu: String?,
    val jibun: String?,
    val bchk: String?,
    val sgg_oid: Double?,
    val col_adm_se: String?,
//    val geom: Geometry?
)



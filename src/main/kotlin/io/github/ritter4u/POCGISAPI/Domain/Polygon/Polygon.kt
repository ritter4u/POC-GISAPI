package io.github.ritter4u.POCGISAPI.Domain.Polygon

import io.github.ritter4u.POCGISAPI.Domain.Polygon.DTO.PolygonDTO
import net.postgis.jdbc.geometry.Geometry
import org.locationtech.jts.geom.MultiPolygon

interface Polygon {
    val gid: Long?
    var pnu: String?
    var jibun: String?
    var bchk: String?
    var sgg_oid: Double?
    var col_adm_se: String?
//    var geom: Geometry?
    fun toDTO(
        gid: Long ? =null,
        pnu: String? = null,
        jibun: String? = null,
        bchk: String? = null,
        sgg_oid: Double? = null,
        col_adm_se: String? = null,
//        geom: Geometry? = null
    ): PolygonDTO
}

data class PolygonCreateForm(
    var gid: Long,
    var pnu: String,
    var jibun: String,
    var bchk: String,
    var sgg_oid: Double,
    var col_adm_se: String,
//    var geom: Geometry
)

data class PolygonUpdateForm(
    var pnu: String,
    var jibun: String,
    var bchk: String,
    var sgg_oid: Double,
    var col_adm_se: String,
//    var geom: Geometry
)

data class PolygonQueryParam(
    val pnu: String? = null,
    var jibun: String? = null,
    var bchk: String? = null,
    val sgg_oid: Double? = null,
    val col_adm_se: String? = null,
//    var geom: String? = null
)

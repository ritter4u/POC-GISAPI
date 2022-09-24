package io.github.ritter4u.POCGISAPI.Domain.Polygon

import io.github.ritter4u.POCGISAPI.Domain.Polygon.DTO.PolygonDTO
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.text.Normalizer.Form.NFD
import java.text.Normalizer.normalize
import java.util.*

interface Polygon {
    val gid: Long?
    var pnu: String?
    var jibun: String?
    var bchk: String?
    var sgg_oid: Double?
    var col_adm_se: String?
    val geom : String?
    fun toDTO(
        gid: Long ? =null,
        pnu: String? = null,
        jibun: String? = null,
        bchk: String? = null,
        sgg_oid: Double? = null,
        col_adm_se: String? = null,
        geom: String? = null
    ): PolygonDTO
}

data class PolygonCreateForm(
    var gid: Long,
    var pnu: String,
    var jibun: String,
    var bchk: String,
    var sgg_oid: Double,
    var col_adm_se: String,
    var geom : String
)

data class PolygonUpdateForm(
    var pnu: String,
    var jibun: String,
    var bchk: String,
    var sgg_oid: Double,
    var col_adm_se: String,
    var geom : String
)

data class PolygonQueryParam(
    val pnu: String? = null,
    var jibun: String? = null,
    var bchk: String? = null,
    val sgg_oid: Double? = null,
    val col_adm_se: String? = null,
    val geom : String? = null,
)
//
//data class PolygonDTO(
//    val gid: Long?,
//    val pnu: String?,
//    val jibun: String?,
//    val bchk: String?,
//    val sgg_oid: Double?,
//    val col_adm_se: String?,
//    val geom: String?
//)
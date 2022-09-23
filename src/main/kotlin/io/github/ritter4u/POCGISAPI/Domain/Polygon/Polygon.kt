package io.github.ritter4u.POCGISAPI.Domain.Polygon

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

fun String.slugify(): String = normalize(this, NFD)
    .replace("[^\\w\\s-]".toRegex(), "")
    .replace('-', ' ').trim()
    .replace("\\s+".toRegex(), "-")
    .lowercase(Locale.getDefault())

interface PolygonRepository {
    fun getAllPolygons(pageable: Pageable, param: PolygonQueryParam): Page<out Polygon>
    fun findPolygonByGid(gid:Long):Polygon
    fun findPolygonByPnu(pnu:String):Polygon
    fun findPolygonByJibun(jibun:String):Polygon
    fun findPolygonByBchk(bchk:String):Polygon
    fun findPolygonBySggOid(sgg_oid:Double):Polygon
    fun findPolygonByColAdmSe(col_adm_se:String):Polygon

    fun deletePolygon(Polygon: Polygon)
    fun savePolygon(Polygon: Polygon): Polygon
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

data class PolygonDTO(
    val gid: Long?,
    val pnu: String?,
    val jibun: String?,
    val bchk: String?,
    val sgg_oid: Double?,
    val col_adm_se: String?,
    val geom: String?
)
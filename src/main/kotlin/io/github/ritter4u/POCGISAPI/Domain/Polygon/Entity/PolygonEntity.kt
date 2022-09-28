package io.github.ritter4u.POCGISAPI.Domain.Polygon.Entity

import io.github.ritter4u.POCGISAPI.Domain.Polygon.DTO.PolygonDTO
import io.github.ritter4u.POCGISAPI.Domain.Polygon.Polygon
import net.minidev.json.annotate.JsonIgnore
import org.locationtech.jts.geom.Geometry
import javax.persistence.*

@Table(
    name = "lsmd_cont_ldreg_11110", indexes = [
        Index(name = "idx_polygons_gid", columnList = "gid")
    ]
)
@Entity
class PolygonEntity : Polygon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override val gid: Long? = null
    override var pnu: String? = null
    override var jibun: String? = null
    override var bchk: String? = null
    override var sgg_oid: Double? = null
    override var col_adm_se: String? = null
    @JsonIgnore
    @Column(name = "geom", columnDefinition = "geometry(multipolygon, 5179)")
    override var geom: Geometry? = null

    override fun toDTO(
        gid: Long?,
        pnu: String?,
        jibun: String?,
        bchk: String?,
        sgg_oid: Double?,
        col_adm_se: String?,
        geom: Geometry?,
    ): PolygonDTO {
        return PolygonDTO(
            gid = gid,
            pnu = pnu,
            jibun = jibun,
            bchk = bchk,
            sgg_oid = sgg_oid,
            col_adm_se = col_adm_se,
            geom = geom
        )
    }
}

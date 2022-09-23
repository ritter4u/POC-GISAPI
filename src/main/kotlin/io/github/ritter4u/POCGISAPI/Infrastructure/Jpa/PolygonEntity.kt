package io.github.ritter4u.POCGISAPI.Infrastructure.Jpa

import io.github.ritter4u.POCGISAPI.Domain.Polygon.Polygon
import io.github.ritter4u.POCGISAPI.Domain.Polygon.PolygonDTO
import javax.persistence.*

@Table(name = "lsmd_cont_ldreg_11110", indexes = [
    Index(name = "idx_polygons_gid", columnList = "gid")
])
@Entity
class PolygonEntity: Polygon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gid", nullable = false)
    override var gid: Long? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pnu", nullable = true)
    override var pnu: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jibun", nullable = true)
    override var jibun: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bchk", nullable = true)
    override var bchk: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sgg_oid", nullable = true)
    override var sgg_oid: Double? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "col_adm_se", nullable = true)
    override var col_adm_se: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "geom", nullable = true)
    override var geom: String? = null

    @ManyToOne
    @JoinColumn(name = "polygon_entity_ID")
    open var polygonEntity: PolygonEntity? = null

    override fun toDTO(gid: Long?,
                       pnu: String?,
                       jibun: String?,
                       bchk: String?,
                       sgg_oid: Double?,
                       col_adm_se: String?,
                       geom: String?
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

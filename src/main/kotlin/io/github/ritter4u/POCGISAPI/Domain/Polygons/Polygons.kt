package io.github.ritter4u.POCGISAPI.Domain.Polygons

import javax.persistence.*

@Entity
@Table(name = "lsmd_cont_ldreg_11110", indexes = [
    Index(name = "idx_polygons_gid", columnList = "gid")
])
open class Polygons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gid", nullable = false)
    open var id: Long? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pnu", nullable = true)
    open var pnu: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "jibun", nullable = true)
    open var jibun: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bchk", nullable = true)
    open var bchk: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sgg_oid", nullable = true)
    open var sgg_oid: Double? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "col_adm_se", nullable = true)
    open var col_adm_se: String? = null

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "geom", nullable = true)
    open var geom: String? = null
}
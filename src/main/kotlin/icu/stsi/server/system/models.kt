package icu.stsi.server.system

import javax.persistence.*
import com.fasterxml.jackson.annotation.*
import icu.stsi.server.utils.PointType
import java.sql.Timestamp

@Entity
@Table(name = "points")
data class Point(
        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0L,

        @JsonProperty("description")
        @Column(name = "description", length = 1000)
        val description: String = "",

        @JsonProperty("latitude")
        @Column(name = "latitude", length = 20)
        val latitude: Double = 0.0,

        @JsonProperty("longitude")
        @Column(name = "longitude", length = 20)
        val longitude: Double = 0.0,

        @Column(name = "point_type", length = 20)
        @Enumerated(EnumType.STRING)
        val point_type: PointType? = null,

        @JsonProperty("created_at")
        @Column(name = "created_at", length = 20, nullable = true)
        var created_at: Timestamp? = null,

        @JsonProperty("updated_at")
        @Column(name = "updated_at", length = 20, nullable = true)
        var updated_at: Timestamp? = null
)
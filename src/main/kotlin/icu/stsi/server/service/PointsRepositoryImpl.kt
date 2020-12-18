package icu.stsi.server.service

import com.fasterxml.jackson.annotation.JsonFormat
import icu.stsi.server.system.Point
import icu.stsi.server.system.PointsRepository
import org.springframework.stereotype.Service
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.*


@Service
class PointsRepositoryImpl(private val pointsRepository: PointsRepository) {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private val lastUpdate: LocalDateTime? = LocalDateTime.now()

    fun all(): Iterable<Point> = pointsRepository.findAll()

    fun get(id: Long): Optional<Point> = pointsRepository.findById(id)

    fun add(point: Point): Point {
        point.created_at = Timestamp.valueOf(lastUpdate)
        point.updated_at = Timestamp.valueOf(lastUpdate)
        return pointsRepository.save(point)
    }

    fun edit(id: Long, point: Point): Point {
        point.updated_at = Timestamp.valueOf(lastUpdate)
        return pointsRepository.save(point.copy(id = id))
    }

    fun remove(id: Long) = pointsRepository.deleteById(id)
}
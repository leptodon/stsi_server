package icu.stsi.server.system

import icu.stsi.server.service.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("points")
class PointsController(private val pointsRepositoryImpl: PointsRepositoryImpl) {
    @GetMapping
    fun index() = pointsRepositoryImpl.all()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody point: Point){
        pointsRepositoryImpl.add(point)
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun read(@PathVariable id: Long) = pointsRepositoryImpl.get(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody product: Point) = pointsRepositoryImpl.edit(id, product)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = pointsRepositoryImpl.remove(id)
}
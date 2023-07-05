package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    List<Meal> findAllByUserId(int userId);

    List<Meal> findAllByDateTimeBetweenAndUserId(LocalDateTime st, LocalDateTime end, int userId);

    Meal save(Meal meal, int userId);

    @Transactional
    @Modifying
//    @Query(name = User.DELETE)
    @Query("DELETE FROM Meal u WHERE u.id=:id and u.id=:user_id")
    int delete(@Param("id") int id, @Param("user_id") int userId);

    Meal findMealByIdAndUserId(int id, int userId);
}

package ru.parallelProject.parallel.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.parallelProject.parallel.model.Meal;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {
}

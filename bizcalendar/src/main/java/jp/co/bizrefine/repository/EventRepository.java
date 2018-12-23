package jp.co.bizrefine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.bizrefine.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {}

package dev.innov8.sekhmet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.innov8.sekhmet.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}

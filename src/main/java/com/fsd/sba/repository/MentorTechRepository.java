package com.fsd.sba.repository;

import com.fsd.sba.entity.MentorTechnology;
import com.fsd.sba.entity.MentorTechnologyId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorTechRepository extends JpaRepository<MentorTechnology, MentorTechnologyId> {

    @Modifying
    @Query("delete from MentorTechnology mt where mt.userId=:userId")
    void deleteByUserId(@Param("userId") Long userId);
}

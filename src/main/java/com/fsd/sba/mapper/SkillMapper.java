package com.fsd.sba.mapper;

import com.fsd.sba.entity.MentorSkill;
import com.fsd.sba.entity.Skill;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface SkillMapper {
    @Select("SELECT * FROM SKILL")
    List<Skill> findAll();
}

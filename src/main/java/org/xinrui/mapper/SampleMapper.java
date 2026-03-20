package org.xinrui.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.xinrui.dto.SampleRegistrationDto;

import java.time.LocalDate;

@Mapper
public interface SampleMapper {
    SampleRegistrationDto selectSampleRegistrationBySAId(Long screeningArchivesId);

    LocalDate selectCollectDateBySAId(@Param("screeningArchivesId") Long screeningArchivesId);
}

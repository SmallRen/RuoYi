package com.ruoyi.project.system.teachbuild.mapper;

import com.ruoyi.project.system.teachbuild.domain.TeachBuild;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeachBuildMapper {
    @Select("select teach_Build_Id as teachBuildId,teach_Build_Name as teachBuildName," +
            "teach_Build_Location as teachBuildLocation,teach_Build_Img as teachBuildImg," +
            "teach_Build_Layer as teachBuildLayer,teach_Build_Laboratory_Count as teachBuildLaboratoryCount," +
            "create_Time as createTime,update_Time as updateTime" +
            " from Teach_Build")
    List<TeachBuild> finAll();
    TeachBuild find(Long id);
}

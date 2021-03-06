package com.ruoyi.project.system.laboratory.mapper;

import com.ruoyi.project.system.laboratory.domain.Laboratory;
import com.ruoyi.project.system.table.domain.SysTable;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaboratoryMapper {
    /**
     * 删除
     *
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     * 主键查询
     *
     * @param laboratoryId
     * @return
     */
    Laboratory selectById(Long laboratoryId);

    /**
     * 查询所有
     *
     * @return
     */
    List<Laboratory> selectList();

    /**
     * 保存
     *
     * @param laboratory
     * @return
     */
    Long save(Laboratory laboratory);

    void updateImg(@Param("laboratoryImg") String laboratoryImg, @Param("laboratoryId") Long laboratoryId);

    Long update(Laboratory laboratory);

    List<Laboratory> findLaboratoryByBuildId(Long id);

    List<Laboratory> checkDeptExistLaboratory(Long deptId);

}

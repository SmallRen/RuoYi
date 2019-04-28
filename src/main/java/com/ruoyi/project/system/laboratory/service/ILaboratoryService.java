package com.ruoyi.project.system.laboratory.service;

import com.ruoyi.project.system.laboratory.domain.Laboratory;

import java.util.List;

public interface ILaboratoryService {
    /**
     * 删除
     * @param ids
     */
    void deleteByIds(String ids);

    /**
     * 主键查询
     * @param laboratoryId
     * @return
     */
    Laboratory selectById(Long laboratoryId);

    /**
     * 查询所有
     * @return
     */
    List<Laboratory> selectList( );

    /**
     * 保存
     * @param laboratory
     * @return
     */
    Long save(Laboratory laboratory);

    /**
     * 插入图片
     * @param laboratoryImg
     */
    void updateImg(String laboratoryImg,Long laboratoryId);

    /**
     * 更新
     * @param laboratory
     * @return
     */
    Long update(Laboratory laboratory);
}

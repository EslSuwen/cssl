package com.cqjtu.cssl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cqjtu.cssl.entity.ExpFile;
import com.cqjtu.cssl.entity.ExpFileStore;
import com.cqjtu.cssl.mapper.ExpFileStoreMapper;
import com.cqjtu.cssl.service.ExpFileService;
import com.cqjtu.cssl.service.ExpFileStoreService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目资料存储服务实现类
 *
 * @author suwen
 * @since 2020-07-07
 */
@Service
public class ExpFileStoreServiceImpl extends ServiceImpl<ExpFileStoreMapper, ExpFileStore>
    implements ExpFileStoreService {

  private final ExpFileService expFileService;

  @Autowired
  public ExpFileStoreServiceImpl(ExpFileService expFileService) {
    this.expFileService = expFileService;
  }

  @Override
  public boolean saveFile(ExpFileStore expFileStore) {
    Integer proId = expFileStore.getProId();
    String typeName = expFileStore.getTypeName();
    remove(new QueryWrapper<ExpFileStore>().eq("pro_id", proId).eq("type_name", typeName));
    if (save(expFileStore)) {
      @NonNull
      Integer no =
          getOne(
                  new QueryWrapper<ExpFileStore>()
                      .eq("pro_id", proId)
                      .eq("type_name", typeName)
                      .last("LIMIT 1"))
              .getNo();
      ExpFile expFile = new ExpFile();
      expFile.setProId(proId);
      switch (typeName) {
        case "考勤名单":
          expFile.setAttend(no);
          break;
        case "实验任务书":
          expFile.setTask(no);
          break;
        case "实验成绩":
          expFile.setGrade(no);
          break;
        case "评分标准表":
          expFile.setScheme(no);
          break;
        case "实验报告":
          expFile.setReport(no);
          break;
        default:
          throw new IllegalArgumentException("typeName error");
      }
      if (!expFileService.updateById(expFile)) {
        return expFileService.save(expFile);
      }
      return true;
    }
    return false;
  }

  @Override
  public List<ExpFileStore> getQuickFile(Integer proId) {
    return baseMapper.getQuickFile(proId);
  }
}

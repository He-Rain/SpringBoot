package com.sunyx.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunyx.entity.Storage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunyx.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface StorageService extends IService<Storage> {

    IPage pageCC(IPage<Storage> page, Wrapper wrapper);
}

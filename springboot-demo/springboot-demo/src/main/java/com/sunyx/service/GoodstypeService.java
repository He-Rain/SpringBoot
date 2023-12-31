package com.sunyx.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunyx.entity.Goodstype;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunyx.entity.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface GoodstypeService extends IService<Goodstype> {
    IPage pageCC(IPage<Goodstype> page, Wrapper wrapper);
}

package com.sunyx.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sunyx.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sunyx.entity.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface GoodsService extends IService<Goods> {
    IPage pageCC(IPage<Goods> page, Wrapper wrapper);
}

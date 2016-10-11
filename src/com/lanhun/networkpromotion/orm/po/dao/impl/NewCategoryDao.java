package com.lanhun.networkpromotion.orm.po.dao.impl;

import org.springframework.stereotype.Repository;

import com.lanhun.framework.orm.dao.impl.BaseDao;
import com.lanhun.networkpromotion.orm.po.NewCategory;
import com.lanhun.networkpromotion.orm.po.dao.INewCategoryDao;

@Repository
public class NewCategoryDao extends BaseDao<NewCategory, String> implements INewCategoryDao {
}

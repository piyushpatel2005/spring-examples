package com.piyushpatel2005.common.web;

import com.piyushpatel2005.common.persistence.model.IEntity;

public interface IUriMapper {

  <T extends IEntity> String getUriBase(final Class<T> clazz);
}

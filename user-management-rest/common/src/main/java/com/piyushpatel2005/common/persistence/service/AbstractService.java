package com.piyushpatel2005.common.persistence.service;

import com.piyushpatel2005.common.persistence.model.INameableEntity;

public abstract class AbstractService<T extends INameableEntity> extends AbstractRawService<T> implements IService<T> {

    public AbstractService() {
        super();
    }

    // API

}

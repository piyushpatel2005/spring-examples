package com.piyushpatel2005.common.persistence.service;

import com.piyushpatel2005.common.interfaces.IByNameApi;
import com.piyushpatel2005.common.interfaces.IWithName;

public interface IService<T extends IWithName> extends IRawService<T>, IByNameApi<T> {

    //

}

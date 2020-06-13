package com.piyushpatel2005.common.interfaces;

public interface IByNameApi<T extends IWithName> {

    T findOneByName(final String name);

}

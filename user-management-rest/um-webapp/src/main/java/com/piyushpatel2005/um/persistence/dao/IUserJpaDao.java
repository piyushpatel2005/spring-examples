package com.piyushpatel2005.um.persistence.dao;

import com.piyushpatel2005.um.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.piyushpatel2005.common.interfaces.IByNameApi;

public interface IUserJpaDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, IByNameApi<User> {
    //
}

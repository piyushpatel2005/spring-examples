package com.piyushpatel2005.um.persistence.dao;

import com.piyushpatel2005.common.interfaces.IByNameApi;
import com.piyushpatel2005.um.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserJpaDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, IByNameApi<User> {
}

package com.piyushpatel2005.um.persistence.dao;

import com.piyushpatel2005.common.interfaces.IByNameApi;
import com.piyushpatel2005.um.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IRoleJpaDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>, IByNameApi<Role> {
}

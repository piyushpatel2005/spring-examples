package com.piyushpatel2005.um.persistence.dao;

import com.piyushpatel2005.common.interfaces.IByNameApi;
import com.piyushpatel2005.um.persistence.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IPrivilegeJpaDao extends JpaRepository<Privilege, Long>, JpaSpecificationExecutor<Privilege>, IByNameApi<Privilege> {
}

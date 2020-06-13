package com.piyushpatel2005.um.persistence.setup;

import java.util.Set;

import com.piyushpatel2005.um.persistence.model.Privilege;
import com.piyushpatel2005.um.persistence.model.Role;
import com.piyushpatel2005.um.persistence.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.piyushpatel2005.common.spring.util.Profiles;
import com.piyushpatel2005.um.service.IPrivilegeService;
import com.piyushpatel2005.um.service.IRoleService;
import com.piyushpatel2005.um.service.IUserService;
import com.piyushpatel2005.um.util.Um;
import com.piyushpatel2005.um.util.Um.Privileges;
import com.piyushpatel2005.um.util.Um.Roles;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

/**
 * This simple setup class will run during the bootstrap process of Spring and will create some setup data <br>
 * The main focus here is creating some standard privileges, then roles and finally some default users
 */
@Component
@Profile(Profiles.DEPLOYED)
public class SecuritySetup implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = LoggerFactory.getLogger(SecuritySetup.class);

    private boolean setupDone;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPrivilegeService privilegeService;

    public SecuritySetup() {
        super();
    }

    //

    /**
     * - note that this is a compromise - the flag makes this bean statefull which can (and will) be avoided in the future by a more advanced mechanism <br>
     * - the reason for this is that the context is refreshed more than once throughout the lifecycle of the deployable <br>
     * - alternatives: proper persisted versioning
     */
    @Override
    public final void onApplicationEvent(final ContextRefreshedEvent event) {
        if (!setupDone) {
            logger.info("Executing Setup");

            createPrivileges();
            createRoles();
            createUsers();

            setupDone = true;
            logger.info("Setup Done");
        }
    }

    // Privilege

    private void createPrivileges() {
        createPrivilegeIfNotExisting(Privileges.CAN_PRIVILEGE_READ);
        createPrivilegeIfNotExisting(Privileges.CAN_PRIVILEGE_WRITE);

        createPrivilegeIfNotExisting(Privileges.CAN_ROLE_READ);
        createPrivilegeIfNotExisting(Privileges.CAN_ROLE_WRITE);

        createPrivilegeIfNotExisting(Privileges.CAN_USER_READ);
        createPrivilegeIfNotExisting(Privileges.CAN_USER_WRITE);
    }

    final void createPrivilegeIfNotExisting(final String name) {
        createPrivilegeIfNotExisting(name, name);
    }

    final void createPrivilegeIfNotExisting(final String name, final String description) {
        final Privilege entityByName = privilegeService.findOneByName(name);
        if (entityByName == null) {
            final Privilege entity = new Privilege(name, description);
            privilegeService.create(entity);
        }
    }

    // Role

    private void createRoles() {
        final Privilege canPrivilegeRead = privilegeService.findOneByName(Privileges.CAN_PRIVILEGE_READ);
        final Privilege canPrivilegeWrite = privilegeService.findOneByName(Privileges.CAN_PRIVILEGE_WRITE);
        final Privilege canRoleRead = privilegeService.findOneByName(Privileges.CAN_ROLE_READ);
        final Privilege canRoleWrite = privilegeService.findOneByName(Privileges.CAN_ROLE_WRITE);
        final Privilege canUserRead = privilegeService.findOneByName(Privileges.CAN_USER_READ);
        final Privilege canUserWrite = privilegeService.findOneByName(Privileges.CAN_USER_WRITE);

        Preconditions.checkNotNull(canPrivilegeRead);
        Preconditions.checkNotNull(canPrivilegeWrite);
        Preconditions.checkNotNull(canRoleRead);
        Preconditions.checkNotNull(canRoleWrite);
        Preconditions.checkNotNull(canUserRead);
        Preconditions.checkNotNull(canUserWrite);

        createRoleIfNotExisting(Roles.ROLE_ADMIN, Sets.<Privilege> newHashSet(canUserRead, canUserWrite, canRoleRead, canRoleWrite, canPrivilegeRead, canPrivilegeWrite));
    }

    final void createRoleIfNotExisting(final String name, final Set<Privilege> privileges) {
        final Role entityByName = roleService.findOneByName(name);
        if (entityByName == null) {
            final Role entity = new Role(name);
            entity.setPrivileges(privileges);
            roleService.create(entity);
        }
    }

    // User

    final void createUsers() {
        final Role roleAdmin = roleService.findOneByName(Roles.ROLE_ADMIN);

        // createUserIfNotExisting(SecurityConstants.ADMIN_USERNAME, SecurityConstants.ADMIN_PASS, Sets.<Role> newHashSet(roleAdmin));
        createUserIfNotExisting(Um.ADMIN_EMAIL, Um.ADMIN_PASS, Sets.<Role> newHashSet(roleAdmin));
    }

    final void createUserIfNotExisting(final String loginName, final String pass, final Set<Role> roles) {
        final User entityByName = userService.findOneByName(loginName);
        if (entityByName == null) {
            final User entity = new User(loginName, pass, roles);
            userService.create(entity);
        }
    }

}

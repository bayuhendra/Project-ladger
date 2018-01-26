package com.ledger.user.management.application.impl;

import com.ledger.common.dto.usermanagement.PrivilegeDTO;
import com.ledger.common.dto.usermanagement.RoleDTO;
import com.ledger.common.dto.usermanagement.RolePrivilegeDTO;
import com.ledger.shared.type.AccessType;
import com.ledger.shared.type.StatusData;
import com.ledger.user.management.application.RoleService;
import com.ledger.user.management.domain.privilege.PrivilegeRepository;
import com.ledger.user.management.domain.role.Role;
import com.ledger.user.management.domain.role.RoleRepository;
import com.ledger.user.management.interfaces.web.facade.dto.assembler.role.RoleDTOAssembler;
import com.ledger.user.management.interfaces.web.facade.dto.assembler.role.RolePrivilegeDTOAssembler;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.Validate;

/**
 *
 * @author bayutridewanto
 */
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;
    private RoleDTOAssembler roleDTOAssembler;
    private RolePrivilegeDTOAssembler rolePrivilegeDTOAssembler;

    @Override
    public void saveOrUpdate(RoleDTO roleDTO) {
        Role role = roleRepository.findByID(roleDTO.getRoleID());

        if (role == null) {
            role = roleDTOAssembler.toDomain(roleDTO);
        } else {
            /* update specification */
            role.assignNewSpecification(
                    roleDTO.getRoleName(),
                    roleDTO.getRoleDescription(),
                    roleDTO.getRoleStatus(),
                    rolePrivilegeDTOAssembler.toDomains(roleDTO.getRolePrivilegeDTOs()));
        }

        roleRepository.saveOrUpdate(role);
    }

    @Override
    public RoleDTO findByID(String roleID) {
        Validate.notNull(roleRepository);
        Role role = (Role) roleRepository.findByID(roleID);
        if (role != null) {
            return roleDTOAssembler.toDTO(role);
        }

        return null;
    }

    @Override
    public List<RoleDTO> findAll() {
        Validate.notNull(roleRepository);
        List<Role> roles = (List<Role>) roleRepository.findAll();
        return roleDTOAssembler.toDTOs(roles);
    }

    @Override
    public List<RoleDTO> findAllByStatus(StatusData statusData) {
        Validate.notNull(roleRepository);
        List<Role> roles = (List<Role>) roleRepository.findAllByStatus(statusData);
        return roleDTOAssembler.toDTOs(roles);
    }

    @Override
    public List<RoleDTO> findByParameter(String roleName) {
        Validate.notNull(roleRepository);
        List<Role> roles = (List<Role>) roleRepository.findByParameter(roleName);
        return roleDTOAssembler.toDTOs(roles);
    }

    @Override
    public List<String> grantedAuthoritys(String roleID) {
        List<String> privileges = new ArrayList();
        Role role = roleRepository.findByID(roleID);
        if (role != null) {
            RoleDTO roleDTO = roleDTOAssembler.toDTO(role);
            for (RolePrivilegeDTO rolePrivilegeDTO : roleDTO.getRolePrivilegeDTOs()) {
                if (rolePrivilegeDTO.getAccessType() == AccessType.DENY) {
                    privileges.remove(rolePrivilegeDTO.getPrivilegeDTO().getPrivilegeID());
                    privileges.removeAll(privileges(rolePrivilegeDTO.getPrivilegeDTO().getChildren()));
                } else {
                    privileges.add(rolePrivilegeDTO.getPrivilegeDTO().getPrivilegeID());
                    privileges.addAll(privileges(rolePrivilegeDTO.getPrivilegeDTO().getChildren()));
                }
            }
        }
        return privileges;
    }

    protected List<String> privileges(List<PrivilegeDTO> children) {
        List<String> auth = new ArrayList<>();
        for (PrivilegeDTO privilege : children) {
            auth.add(privilege.getPrivilegeID());
            auth.addAll(privileges(privilege.getChildren()));
        }
        return auth;
    }

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public void setPrivilegeRepository(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }

    public void setRoleDTOAssembler(RoleDTOAssembler roleDTOAssembler) {
        this.roleDTOAssembler = roleDTOAssembler;
    }

    public void setRolePrivilegeDTOAssembler(RolePrivilegeDTOAssembler rolePrivilegeDTOAssembler) {
        this.rolePrivilegeDTOAssembler = rolePrivilegeDTOAssembler;
    }

}

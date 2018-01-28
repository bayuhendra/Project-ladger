package com.ledger.user.management.application.impl;

import com.ledger.common.dto.usermanagement.UserDTO;
import com.ledger.common.dto.usermanagement.UserLoginInfoDTO;
import com.ledger.shared.status.StatusCode;
import com.ledger.shared.type.AccessType;
import com.ledger.shared.type.JenisKelaminType;
import com.ledger.shared.type.JobDivision;
import com.ledger.shared.type.JobLocation;
import com.ledger.shared.type.PendidikanType;
import com.ledger.shared.type.ReleaseType;
import com.ledger.shared.type.StatusData;
import com.ledger.shared.type.TingkatanType;
import com.ledger.user.management.application.UserService;
import com.ledger.user.management.domain.privilege.Privilege;
import com.ledger.user.management.domain.privilege.PrivilegeBuilder;
import com.ledger.user.management.domain.role.Role;
import com.ledger.user.management.domain.role.RoleBuilder;
import com.ledger.user.management.domain.role.RolePrivilege;
import com.ledger.user.management.domain.role.RolePrivilegeBuilder;
import com.ledger.user.management.domain.user.AccessTime;
import com.ledger.user.management.domain.user.AccessTimeBuilder;
import com.ledger.user.management.domain.user.User;
import com.ledger.user.management.domain.user.UserBuilder;
import com.ledger.user.management.domain.user.UserLoginInfo;
import com.ledger.user.management.domain.user.UserLoginInfoBuilder;
import com.ledger.user.management.domain.user.UserRepository;
import com.ledger.user.management.domain.user.UserSpecification;
import com.ledger.user.management.domain.user.UserSpecificationBuilder;
import com.ledger.user.management.interfaces.web.facade.dto.assembler.user.UserDTOAssembler;
import com.ledger.user.management.interfaces.web.facade.dto.assembler.user.UserLoginInfoDTOAssembler;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author bayutridewanto
 */
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserDTOAssembler userDTOAssembler;

    @Override
    public void saveOrUpdate(UserDTO userDTO) {
        User user = userRepository.findByID(userDTO.getUserName());
        if (user == null) {
            user = userDTOAssembler.toDomain(userDTO);
        } else {
            /* update specification */
            user.assignNewSpecification(userDTOAssembler.toDomain(userDTO));
        }

        userRepository.saveOrUpdate(user);
    }

    @Override
    public UserDTO findByID(String userName) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByID(userName);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public UserDTO findByRemote(String remote) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByRemote(remote);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public List<UserDTO> findAllUser() {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findAllUser();
        return userDTOAssembler.toDTOs(users);
    }

    @Override
    public List<UserDTO> findByParameter(String fullName, String userName, String roleID, StatusData userStatus) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findByParameter(fullName, userName, roleID, userStatus);
        if (users != null) {
            return userDTOAssembler.toDTOs(users);
        }

        return null;
    }

    @Override
    public StatusCode release(String releaseType, String release) {
        Validate.notNull(userRepository);
        User user;
        if (releaseType.equals(ReleaseType.USERNAME.name())) {
            user = userRepository.findByID(release);
        } else {
            user = userRepository.findByRemote(release);
        }
        if (user != null) {
            user.getUserSpecification().getUserLoginInfo().assignDeleteRemote();
            userRepository.saveOrUpdate(user);
            return StatusCode.CREATED;
        }
        return StatusCode.FOUND;
    }

    @Override
    public StatusCode releaseAll() {
        Validate.notNull(userRepository);
        userRepository.releaseAll();
        return StatusCode.CREATED;
    }

    @Override
    public int count(String roleID) {
        Validate.notNull(userRepository);
        return userRepository.count(roleID);
    }

    @Override
    public StatusCode updatePassword(String userName, String newPassword) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.assignNewPassword(new BCryptPasswordEncoder().encode(newPassword));
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode updateLockUnlock(String userName, Integer loginAttempt) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.getUserSpecification().getUserLoginInfo().assignNewLoginAttempt(loginAttempt);
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode updateLoginInfo(String userName, UserLoginInfoDTO loginInfo) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.getUserSpecification().assignNewLoginInfo(new UserLoginInfoDTOAssembler().toDomain(loginInfo));
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public StatusCode delete(String userName) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        user.assignNewStatus(StatusData.DELETED);
        userRepository.saveOrUpdate(user);
        return StatusCode.UPDATED;
    }

    @Override
    public Boolean isNotExistUserName(String userName) {
        Validate.notNull(userRepository);
        User user = userRepository.findByID(userName);
        return user.getUserName() == null ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public Boolean isNotExistIPAddress(String ipAddress) {
        Validate.notNull(userRepository);
        User user = userRepository.findByRemote(ipAddress);
        return user.getUserName() == null ? Boolean.TRUE : Boolean.FALSE;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void setUserDTOAssembler(UserDTOAssembler userDTOAssembler) {
        this.userDTOAssembler = userDTOAssembler;
    }

    @Override
    public UserDTO findByKtp(String ktp) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByKtp(ktp);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public UserDTO getDummy() {

        AccessTime accessTime = new AccessTimeBuilder()
                .setFridayEnd(new Date())
                .setFridayStart(new Date())
                .setMondayEnd(new Date())
                .setMondayStart(new Date())
                .setSaturdayEnd(new Date())
                .setSaturdayStart(new Date())
                .setSundayEnd(new Date())
                .setSundayStart(new Date())
                .setThursdayEnd(new Date())
                .setThursdayStart(new Date())
                .setTuesdayEnd(new Date())
                .setTuesdayStart(new Date())
                .setWednesdayEnd(new Date())
                .setWednesdayStart(new Date())
                .createAccessTime();

        UserLoginInfo userLoginInfo = new UserLoginInfoBuilder()
                .setCredentialsExpiredDate(new Date())
                .setLastLogin(new Date())
                .setLastLoginFailed(new Date())
                .setLoginAttempt(1)
                .setLoginDate(new Date())
                .setLogoutDate(new Date())
                .setRemoteAddress("remoteAddress")
                .setRemoteHost("remoteHost")
                .setSessionID("sessionID")
                .createUserLoginInfo();

        UserSpecification specification = new UserSpecificationBuilder()
                .setAccessTime(accessTime)
                .setEmail("a@a.com")
                .setEscute(null)
                .setFullName("Atmaji")
                .setImmediateSupervisorUserName(null)
                .setUserLoginInfo(userLoginInfo)
                .createUserSpecification();

        Privilege privilege = new PrivilegeBuilder()
                .setCreationalBy("a")
                .setCreationalDate(new Date())
                .setIcon("Icon")
                .setMenu(true)
                .setMenuName("MenuName")
                .setParentID("11")
                .setPrivilegeID("11")
                .setPrivilegeName("PrivilegeName")
                .setPrivilegeStatus(StatusData.ACTIVE)
                .setTabName("TabName")
                .setUrl("X")
                .createPrivilege();

        RolePrivilege rolePrivilege = new RolePrivilegeBuilder()
                .setAccessType(AccessType.ALLOW)
                .setPrivilege(privilege)
                .createRolePrivilege();
        List<RolePrivilege> listRolePrevilage = new ArrayList<>();
        listRolePrevilage.add(rolePrivilege);

        Role role = new RoleBuilder()
                .setRoleID("11")
                .setRoleName("NEw")
                .setRolePrivileges(listRolePrevilage)
                .setRoleStatus(StatusData.DELETED)
                .setCreationalBy("creationalBy")
                .setCreationalDate(new Date())
                .setRoleDescription("roleDescription")
                .createRole();

        User user = new UserBuilder()
                .setCreationalBy("A")
                .setCreationalDate(new Date())
                .setNip("11")
                .setPassword("Password123")
                .setUserID("11")
                .setUserName("KK")
                .setUserSpecification(specification)
                .setUserStatus(StatusData.ACTIVE)
                .createUser();
        return userDTOAssembler.toDTO(user);
    }

    @Override
    public UserDTO findByUserID(String userID) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByUserID(userID);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

    @Override
    public List<UserDTO> findByParamsMap(Map map) {
        Validate.notNull(userRepository);
        List<User> listMahasiswa = userRepository.findByParamsMap(map);
        if (listMahasiswa != null) {
            return (List<UserDTO>) userDTOAssembler.toDTOs(listMahasiswa);
        }
        return null;
    }

    @Override
    public List<UserDTO> findByRoleID(String roleID) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findByRoleID(roleID);
        return userDTOAssembler.toDTOs(users);
    }

    @Override
    public List<UserDTO> findAllMahasiswa(long roleid) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findAllByMahasiswa(roleid);
        if (users != null) {
            return userDTOAssembler.toDTOs(users);
        }
        return null;
    }

    @Override
    public List<UserDTO> findByUsername(String userName) {
        Validate.notNull(userRepository);
        List<User> users = (List<User>) userRepository.findByUsername(userName);
        return userDTOAssembler.toDTOs(users);
    }

    @Override
    public UserDTO findByEmail(String email) {
        Validate.notNull(userRepository);
        User user = (User) userRepository.findByEmail(email);
        if (user != null) {
            return userDTOAssembler.toDTO(user);
        }

        return null;
    }

}

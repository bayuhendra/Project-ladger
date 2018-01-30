/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ledger.main.viewmodel.financial.management;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ledger.common.dto.usermanagement.AccessTimeDTO;
import com.ledger.common.dto.usermanagement.AccessTimeDTOBuilder;
import com.ledger.common.dto.usermanagement.RoleDTO;
import com.ledger.common.dto.usermanagement.RoleDTOBuilder;
import com.ledger.common.dto.usermanagement.UserDTO;
import com.ledger.common.dto.usermanagement.UserDTOBuilder;
import com.ledger.common.dto.usermanagement.UserLoginInfoDTO;
import com.ledger.common.dto.usermanagement.UserSpecificationDTO;
import com.ledger.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.ledger.common.security.SecurityUtil;
import com.ledger.shared.status.StatusCode;
import com.ledger.shared.type.JobDivision;
import com.ledger.shared.type.JobLocation;
import com.ledger.shared.type.ReleaseType;
import com.ledger.shared.type.StatusData;
import com.ledger.shared.zul.CommonViewModel;
import com.ledger.shared.zul.PageNavigation;
import com.ledger.user.management.application.RoleService;
import com.ledger.user.management.application.UserService;
import com.ledger.user.management.application.security.SecurityCacheHelper;
import com.ledger.user.management.interfaces.web.ui.navigation.UserNavigation;
import com.ledger.util.CommonUtil;
import com.ledger.util.DateUtil;
import com.ledger.util.SqlFilterUtil;
import com.ledger.util.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.resource.Labels;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author BayuHS
 */
public class DaftarUserVM {

    @WireVariable
    UserService userService;

    @WireVariable
    RoleService roleService;

    /* search option*/
    private String searchUserName;
    private String searchFullName;
    private String searchRoleID;
    private StatusData searchUserStatus;

    private List<RoleDTO> roleDTOs = new ArrayList<RoleDTO>();
    private RoleDTO roleDTO = new RoleDTO();

    private List<UserDTO> userDTOs;
    private UserDTO userDTO;
    private String primaryBranchName;
    private String supervisorName;
    private String deleted;
    private PageNavigation previous;
    private String confirmPassword;
    private String password;
    private String message;
    private String release;
    private ReleaseType releaseType;
    private boolean checked;
    private int pageSize;
    private int activePage;
    private String lockUnlock;

    @Init
    public void init(@ContextParam(ContextType.COMPONENT) Window window,
            @ExecutionArgParam("user") UserDTO user,
            @ExecutionArgParam("previous") PageNavigation previous,
            @ExecutionArgParam("deleted") String deleted,
            @ExecutionArgParam("search") Map<String, Object> search,
            @ExecutionArgParam("propertyParam") Map<String, Object> prop) {
        searchUserStatus = StatusData.ACTIVE;
        roleDTO = roleService.findByID("ADMIN");
        if (window.getId().isEmpty()) {
            if (user == null) {
                UserSpecificationDTO userSpecificationDTO = new UserSpecificationDTOBuilder()
                        .setImmediateSupervisorUserName("admin")
                        .setPrimaryBranchID("123456789")
                        .setAccessTimeDTO(initAccessTime())
                        .setUserLoginInfoDTO(new UserLoginInfoDTO())
                        .createUserSpecificationDTO();
                userDTO = new UserDTOBuilder()
                        .setCreationalBy(SecurityUtil.getUserName())
                        .setPassword(new BCryptPasswordEncoder().encode("Password123"))
                        .setUserSpecificationDTO(userSpecificationDTO)
                        .setUserStatus(StatusData.ACTIVE)
                        .createUserDTO();
            } else {
                this.userDTO = user;
                this.previous = previous;
                this.deleted = deleted;

                if (userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt() != 0) {
                    lockUnlock = "lock";
                } else {
                    lockUnlock = "Unlock";
                }
            }

            if (search != null) {
                this.searchFullName = (String) search.get("searchFullName");
                this.searchUserName = (String) search.get("searchUserName");
                this.searchRoleID = (String) search.get("searchRoleID");
                this.searchUserStatus = (StatusData) search.get("userStatus");
            }

            if (prop != null) {
                this.supervisorName = (String) prop.get("supervisorName");
                this.primaryBranchName = (String) prop.get("primaryBranchName");
                this.checked = (Boolean) prop.get("checked");
            }

            if (deleted != null) {
                if (deleted.equals("deleted")) {
                    userDTO.setUserStatus(StatusData.DELETED);
                }
            }

            checked = userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getCredentialsExpiredDate() == null;

        } else {
            pageSize = CommonViewModel.PAGE_SIZE;
            activePage = 1;
        }
    }

    public AccessTimeDTO initAccessTime() {
        Date startTime = DateUtil.stringToDate("00:00", "HH:mm");
        Date endTime = DateUtil.stringToDate("23:59", "HH:mm");

        return new AccessTimeDTOBuilder()
                .setMondayStart(startTime).setMondayEnd(endTime)
                .setTuesdayStart(startTime).setTuesdayEnd(endTime)
                .setWednesdayStart(startTime).setWednesdayEnd(endTime)
                .setThursdayStart(startTime).setThursdayEnd(endTime)
                .setFridayStart(startTime).setFridayEnd(endTime)
                .setSaturdayStart(startTime).setSaturdayEnd(endTime)
                .setSundayStart(startTime).setSundayEnd(endTime)
                .createAccessTimeDTO();
    }

    @Command("buttonConfirm")
    public void buttonConfirm(@ContextParam(ContextType.VIEW) Window window) throws JsonProcessingException {
        if (previous == PageNavigation.CREATE) {
            /* Check exist code */

            if ((userDTO.getUserName() != null && !userDTO.getUserName().trim().equals("")) || (userDTO.getUserSpecificationDTO().getEmail() != null && !userDTO.getUserSpecificationDTO().getEmail().trim().equals(""))) {
                userDTO.setUserName(userDTO.getUserName().toUpperCase());
                UserDTO user = userService.findByID(userDTO.getUserName());
                if (user != null) {
                    if (user.getUserName().equals(userDTO.getUserName())) {
                        CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"User Name", userDTO.getUserName()}));
                    }
                } else if (user == null) {
                    user = userService.findByEmail(userDTO.getUserSpecificationDTO().getEmail());
                    if (user != null) {
                        if (user.getUserSpecificationDTO().getEmail().equals(userDTO.getUserSpecificationDTO().getEmail())) {
                            CommonViewModel.showInformationMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"email", userDTO.getUserSpecificationDTO().getEmail()}));
                        }
                    } else {
                        ListModelList<UserDTO> userList = new ListModelList<>(userService.findAllUser());
                        String userID = "";
                        if (userList.isEmpty()) {
                            userID = "USER003";
                        } else {
                            userID = getLatestObjectID(userList, "userID");
                        }
                        userDTO.setUserID(userID);
                        userDTO.setCreationalDate(new Date());
                        userDTO.setUserName(userDTO.getUserName().toUpperCase());
                        userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
                        try {
                            userService.saveOrUpdate(userDTO);
                            CommonViewModel.showInformationMessagebox("User Name " + userDTO.getUserName() + " has successfully created", UserNavigation.DASHBOARD, null, window);
                        } catch (Exception e) {
                            CommonViewModel.showErrorMessagebox(Labels.getLabel("error.message.conflict.repository", new String[]{"User Name", userDTO.getUserName()}));
                        }
                    }
                }
            }
        } else if (previous == PageNavigation.UPDATE) {
            userService.saveOrUpdate(userDTO);
            CommonViewModel.showInformationMessagebox("User Name " + userDTO.getUserName() + " has successfully updated", UserNavigation.USER_SEARCH, null, window);
        } else {
            userService.delete(userDTO.getUserName());
            CommonViewModel.showInformationMessagebox("User Name " + userDTO.getUserName() + " has successfully deleted", UserNavigation.USER_SEARCH, null, window);
        }
    }

    protected String getLatestObjectID(ListModelList list, String attribute) {
        int count = 0;
        int pointer = 0;
        int max = 0;
        String s = "";
        for (Object obj : list) {
            Map<String, Object> map = CommonUtil.convertObject2Map(obj);
            String att = attribute;
            String[] arr = new String[attribute.length()];
            String key = "";

            if (att.contains(".")) {
                arr = att.split("\\.");
                int f = 1;
                for (Object x : arr) {
                    if (f != arr.length) {
                        map = CommonUtil.convertObject2Map(map.get(x.toString()));
                    } else {
                        key = x.toString();
                    }
                    f += 1;
                }
            } else {
                key = att;
            }

            att = map.get(key).toString();

            String temp = "";
            int countTemp = 0;
            for (int i = att.length(); i > 0; i--) {
                if (Character.isLetter(att.charAt(i - 1))) {
                    pointer = i;
                    s = att.substring(0, pointer);
                    break;
                }
                countTemp += 1;
                temp = att.charAt(i - 1) + temp;
            }
            if (Integer.parseInt(temp) > max) {
                max = Integer.parseInt(temp);
            }
            count = countTemp;
        }

        return s + String.format("%0" + count + "d", max + 1);
    }

    @Command({"buttonOk", "buttonClose"})
    public void buttonOk(@ContextParam(ContextType.VIEW) Window window) {
        CommonViewModel.onCloseTab();
    }

    @Command("buttonBack")
    public void buttonBack(@ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", userDTO);
        params.put("previous", previous);
        params.put("search", searchParam());
        params.put("propertyParam", propertyParam());
        if (previous == PageNavigation.CREATE) {
            CommonViewModel.navigateTo(UserNavigation.USER_CREATE, window, params);
        } else if (previous == PageNavigation.UPDATE) {
            params.put("previous", PageNavigation.CONFIRM);
            CommonViewModel.navigateTo(UserNavigation.USER_UPDATE, window, params);
        } else if (previous == PageNavigation.CONFIRM || previous == PageNavigation.SEARCH) {
            CommonViewModel.navigateTo(UserNavigation.USER_SEARCH, window, params);
        }
    }

    @Command("buttonSearch")
    @NotifyChange("userDTOs")
    public void buttonSearch() {

        int count = 0;

        Map params = new HashMap();
        params.put("namaUser", searchUserName);
        count = checkCountParameter(count, searchUserName);
        params.put("roleID", searchRoleID);
        count = checkCountParameter(count, searchRoleID);
        params.put("userStatus", searchUserStatus);
        count = checkCountParameter(count, searchUserStatus);

        if (count < 1) {
            Messagebox.show("Minimal harus memasukkan 1 parameter pencarian", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
            return;
        }

        userDTOs = userService.findByParameter(
                SqlFilterUtil.bothLike(searchFullName),
                SqlFilterUtil.bothLike(searchUserName),
                searchRoleID == null ? "%%" : searchRoleID,
                searchUserStatus);

        if (userDTOs.isEmpty()) {
            Messagebox.show("Data Tidak Ditemukan", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        }
    }

    @Command("selectRole")
    public void selectRole(@BindingParam("obj") RoleDTO selectedRole) {
        userDTO.setRoleDTO(selectedRole);
    }

    @Command("selectRoleSearch")
    public void selectRoleSearch(@BindingParam("obj") RoleDTO selectedRole) {
        searchRoleID = selectedRole.getRoleID();
    }

    @Command("selectReleaseType")
    @NotifyChange("releaseType")
    public void selectReleaseType(@BindingParam("obj") ReleaseType releaseType) {
        this.releaseType = releaseType;
    }

    @Command("checkedLock")
    public void checkedLock(@BindingParam("obj") Boolean locked) {
        if (locked) {
            userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().setLoginAttempt(3);
        } else {
            userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().setLoginAttempt(0);
        }
    }

    @Command("buttonSubmit")
    public void buttonSubmit(@ContextParam(ContextType.VIEW) Window window) {
        userDTO.setRoleDTO(roleDTO);
        Map<String, Object> params = new HashMap<>();
        params.put("user", userDTO);
        params.put("propertyParam", propertyParam());
        if (previous == null) {
            params.put("previous", PageNavigation.CREATE);
        } else if (previous.equals(PageNavigation.SEARCH) || previous.equals(PageNavigation.CONFIRM)) {
            params.put("previous", PageNavigation.UPDATE);
        } else if (previous.equals(PageNavigation.CREATE)) {
            params.put("previous", PageNavigation.CREATE);
        }
        CommonViewModel.navigateToWithoutDetach(UserNavigation.APPROVEREGISTER, window, params);
    }

    @Command("buttonUpdate")
    public void buttonUpdate(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_UPDATE, window, params);
    }

    @Command("buttonDelete")
    public void buttonDelete(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("deleted", "deleted");
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_READ, window, params);
    }

    @Command("buttonView")
    public void buttonView(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_READ, window, params);
    }

    @Command("buttonLockUnlock")
    public void buttonLockUnlock(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_LOCK_UNLOCK, window, params);
    }

    @Command("buttonResetPassword")
    public void buttonResetPassword(@BindingParam("object") UserDTO obj, @ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("user", obj);
        params.put("previous", PageNavigation.SEARCH);
        params.put("search", searchParam());
        CommonViewModel.navigateTo(UserNavigation.USER_RESET_PASSWORD, window, params);
    }

    @Command("buttonRelease")
    @NotifyChange("message")
    public void buttonRelease() {
        message = null;
        if (releaseType == ReleaseType.ALL || releaseType == null) {
            StatusCode statusCode = userService.releaseAll();
            if (statusCode == StatusCode.CREATED) {
                CommonViewModel.showInformationMessagebox("All User has been successfully released");
                CommonViewModel.goToGlobalCommandCloseTab();
            }
        } else if (releaseType != null && release != null && !release.trim().isEmpty()) {
            StatusCode statusCode = userService.release(releaseType.toString(), release);
            if (statusCode == StatusCode.CREATED) {
                CommonViewModel.showInformationMessagebox(releaseType.toString() + " : " + release + " has been successfully released");
                CommonViewModel.goToGlobalCommandCloseTab();
            } else {
                CommonViewModel.showErrorMessagebox(releaseType.toString() + " : " + release + " cannot find in the system. Please check again.");
            }
        } else {
            message = "This field may not be empty or contain only spaces.";
        }
    }

    @Command("buttonSavePassword")
    @NotifyChange("message")
    public void buttonSavePassword(@ContextParam(ContextType.VIEW) Window window) {
        if (password != null && confirmPassword != null && password.equals(confirmPassword)) {
            //update password
            try {
                userService.updatePassword(userDTO.getUserName(), password);
                SecurityCacheHelper.invalidate(SecurityCacheHelper.USER_DETAIL, userDTO.getUserName());
                CommonViewModel.showInformationMessagebox("Password UserName " + userDTO.getUserName() + " has successfully updated", UserNavigation.USER_SEARCH, null, window);
            } catch (Exception ex) {
                CommonViewModel.showErrorMessagebox(ex.getMessage());
            }
        } else {
            message = Labels.getLabel("user.label.verifyPassword");
        }
    }

    @Command("buttonSaveLockUnlock")
    public void buttonSaveLockUnlock(@ContextParam(ContextType.VIEW) Window window) {
        try {
            userService.updateLockUnlock(userDTO.getUserName(), userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt());
            /* Clear cache */

            SecurityCacheHelper.invalidate(SecurityCacheHelper.USER_DETAIL, userDTO.getUserName());
            if (userDTO.getUserSpecificationDTO().getUserLoginInfoDTO().getLoginAttempt() == 3) {
                CommonViewModel.showInformationMessagebox("UserName " + userDTO.getUserName() + " has been locked", UserNavigation.USER_SEARCH, null, window);
            } else {
                CommonViewModel.showInformationMessagebox("UserName " + userDTO.getUserName() + " has been unlocked", UserNavigation.USER_SEARCH, null, window);
            }
        } catch (Exception ex) {
            CommonViewModel.showErrorMessagebox(ex.getMessage());
        }
    }

    /*Listbox*/
    public ReleaseType[] getListRelease() {
        return ReleaseType.values();
    }

    public List<RoleDTO> getRoleList() {
        RoleDTO roleNull = new RoleDTOBuilder().setRoleName("-- Please Select --").createRoleDTO();
        List<RoleDTO> roles = new ArrayList<>();
        roles.add(roleNull);
        roles = roleService.findAllByStatus(StatusData.ACTIVE);
        return roles;
    }

    public String getPrimaryBranchName() {
        this.primaryBranchName = "DJP Pusat";
        return primaryBranchName;
    }

    public String getSupervisorName() {
//        if (userDTO.getUserSpecificationDTO().getImmediateSupervisorUserName() != null && supervisorName == null) {
//            UserDTO supervisor = userService.findByID(userDTO.getUserSpecificationDTO().getImmediateSupervisorUserName());
//            supervisorName = supervisor.getUserSpecificationDTO().getFullName();
//        }
        return supervisorName;
    }

    /*Helper*/
    public String timeToString(Date date) {
        return DateUtil.dateToString(date, "HH:mm");
    }

    public String toSentenceCase(String word) {
        if (word == null || word.trim().isEmpty()) {
            return word;
        }
        return word.charAt(0) + word.substring(1).toLowerCase();
    }

    public int checkCountParameter(int count, Object obj) {
        if (StringUtil.hasValue(obj)) {
            count += 1;
        }
        return count;
    }

    public Map<String, Object> searchParam() {
        Map<String, Object> params = new HashMap<>();
        params.put("searchFullName", searchFullName);
        params.put("searchUserName", searchUserName);
        params.put("searchRoleID", searchRoleID);
        params.put("searchUserStatus", searchUserStatus);
        return params;
    }

    public Map<String, Object> propertyParam() {
        Map<String, Object> params = new HashMap<>();
        params.put("primaryBranchName", primaryBranchName);
        params.put("supervisorName", supervisorName);
        params.put("checked", checked);
        return params;
    }

    /* Getter&Setter */
    public List<UserDTO> getUserDTOs() {
        return userDTOs;
    }

    public void setUserDTOs(List<UserDTO> userDTOs) {
        this.userDTOs = userDTOs;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getSearchUserName() {
        return searchUserName;
    }

    public void setSearchUserName(String searchUserName) {
        this.searchUserName = searchUserName;
    }

    public String getSearchFullName() {
        return searchFullName;
    }

    public void setSearchFullName(String searchFullName) {
        this.searchFullName = searchFullName;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public PageNavigation getPrevious() {
        return previous;
    }

    public void setPrevious(PageNavigation previous) {
        this.previous = previous;
    }

    public void setPrimaryBranchName(String primaryBranchName) {
        this.primaryBranchName = primaryBranchName;
    }

    public void setSupervisorName(String supervisorName) {
        this.supervisorName = supervisorName;
    }

    public String getSearchRoleName() {
        return searchRoleID;
    }

    public void setSearchRoleName(String searchRoleID) {
        this.searchRoleID = searchRoleID;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public ReleaseType getReleaseType() {
        return releaseType;
    }

    public void setReleaseType(ReleaseType releaseType) {
        this.releaseType = releaseType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearchRoleID() {
        return searchRoleID;
    }

    public void setSearchRoleID(String searchRoleID) {
        this.searchRoleID = searchRoleID;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getActivePage() {
        return activePage;
    }

    public void setActivePage(int activePage) {
        this.activePage = activePage;
    }

    public ListModelList<JobDivision> getListJobDivision() {
        return new ListModelList<>(JobDivision.values());
    }

    public String getLockUnlock() {
        return lockUnlock;
    }

    public void setLockUnlock(String lockUnlock) {
        this.lockUnlock = lockUnlock;
    }

    public StatusData getSearchUserStatus() {
        return searchUserStatus;
    }

    public void setSearchUserStatus(StatusData searchUserStatus) {
        this.searchUserStatus = searchUserStatus;
    }

}

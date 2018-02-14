package com.ledger.main.viewmodel.financial.management;

import com.ledger.common.dto.usermanagement.AccessTimeDTO;
import com.ledger.common.dto.usermanagement.AccessTimeDTOBuilder;
import com.ledger.common.dto.usermanagement.RoleDTO;
import com.ledger.common.dto.usermanagement.UserDTO;
import com.ledger.common.dto.usermanagement.UserDTOBuilder;
import com.ledger.common.dto.usermanagement.UserLoginInfoDTO;
import com.ledger.common.dto.usermanagement.UserSpecificationDTO;
import com.ledger.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.ledger.shared.type.StatusData;
import com.ledger.user.management.application.RoleService;
import com.ledger.user.management.application.UserService;
import com.ledger.util.DateUtil;
import com.ledger.util.StringUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

/**
 *
 * @author lintang
 */
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class DaftarUserVM {

    @WireVariable
    UserService userService;

    @WireVariable
    RoleService roleService;

    private String fullname;
    private String email;
    private String username;
    private String password;
    private String namaUsaha;
    private String jenisUsaha;

    private RoleDTO roleDTO = new RoleDTO();
    private List<UserDTO> userDTOs;
    private UserDTO userDTO = new UserDTO();

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

    @Command("buttonCancel")
    @NotifyChange("*")
    public void buttonCancel(@ContextParam(ContextType.VIEW) Window window) {
        window.detach();
    }

    @Command("buttonRegister")
    public void buttonRegister(@ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", userDTO);

        UserDTO userByEmail = userService.findByEmail(email);
        UserDTO userByUsername = null;
        List<UserDTO> listUser = userService.findByUsername(username);
        if (!listUser.isEmpty()) {
            userByUsername = listUser.get(0);
        }

        if (userByEmail != null) {
            Messagebox.show("Email Sudah Terdaftar", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        } else if (userByUsername != null) {
            Messagebox.show("Username Sudah Terdaftar", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        } else if (userByEmail != null && userByUsername != null) {
            Messagebox.show("Username dan Email Sudah Terdaftar", "Peringatan", Messagebox.OK, Messagebox.EXCLAMATION);
        } else {
            roleDTO = roleService.findByID("USER");
            UserSpecificationDTO userSpecificationDTO = new UserSpecificationDTOBuilder()
                    .setPrimaryBranchID("123456789")
                    .setEmail(email)
                    .setFullName(fullname)
                    .setImmediateSupervisorUserName(namaUsaha)
                    .setEscute(jenisUsaha)
                    .setAccessTimeDTO(initAccessTime())
                    .setUserLoginInfoDTO(new UserLoginInfoDTO())
                    .createUserSpecificationDTO();
            userDTO = new UserDTOBuilder()
                    .setUserID(UUID.randomUUID().toString())
                    .setCreationalBy(fullname)
                    .setCreationalDate(new Date())
                    .setUserName(username)
                    .setPassword(new BCryptPasswordEncoder().encode(password))
                    .setUserSpecificationDTO(userSpecificationDTO)
                    .setUserStatus(StatusData.ACTIVE)
                    .createUserDTO();

            userDTO.setRoleDTO(roleDTO);
            userService.saveOrUpdate(userDTO);
            Messagebox.show("Registrasi Akun Berhasil", "Information", Messagebox.OK, Messagebox.INFORMATION);
            window.detach();
        }

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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamaUsaha() {
        return namaUsaha;
    }

    public void setNamaUsaha(String namaUsaha) {
        this.namaUsaha = namaUsaha;
    }

    public String getJenisUsaha() {
        return jenisUsaha;
    }

    public void setJenisUsaha(String jenisUsaha) {
        this.jenisUsaha = jenisUsaha;
    }

}

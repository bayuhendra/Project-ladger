package com.ledger.main.viewmodel.financial.management.profile;

import com.ledger.common.dto.usermanagement.AccessTimeDTO;
import com.ledger.common.dto.usermanagement.AccessTimeDTOBuilder;
import com.ledger.common.dto.usermanagement.RoleDTO;
import com.ledger.common.dto.usermanagement.UserDTO;
import com.ledger.common.dto.usermanagement.UserDTOBuilder;
import com.ledger.common.dto.usermanagement.UserLoginInfoDTO;
import com.ledger.common.dto.usermanagement.UserSpecificationDTO;
import com.ledger.common.dto.usermanagement.UserSpecificationDTOBuilder;
import com.ledger.common.security.SecurityUtil;
import com.ledger.shared.type.StatusData;
import com.ledger.shared.zul.PageNavigation;
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
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
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
public class UpdateProfileVM {

    @WireVariable
    UserService userService;

    private String fullname;
    private String email;
    private String username;
    private String password;
    private String namaUsaha;
    private String jenisUsaha;
    private String handphone;
    private String alamatRumah;
    private String alamatUsaha;

    private RoleDTO roleDTO = new RoleDTO();
    private List<UserDTO> userDTOs;
    private UserDTO userDTO = new UserDTO();

    @Init
    public void init(
            @ExecutionArgParam("userDTO") UserDTO user,
            @ExecutionArgParam("previous") PageNavigation previous) {

        initData();
    }

    private void initData() {
        userDTO = userService.findByID(SecurityUtil.getUserName());
        fullname = userDTO.getUserSpecificationDTO().getFullName();
        email = userDTO.getUserSpecificationDTO().getEmail();
        username = userDTO.getUserName();
        password = userDTO.getPassword();
        handphone = userDTO.getNip();
        alamatRumah = userDTO.getUserSpecificationDTO().getPrimaryBranchID();
        namaUsaha = userDTO.getUserSpecificationDTO().getImmediateSupervisorUserName();
        jenisUsaha = userDTO.getUserSpecificationDTO().getEscute();
        alamatUsaha = userDTO.getUserSpecificationDTO().getMobilePhone();
    }

    @Command("buttonSave")
    @NotifyChange("userDTO")
    public void buttonSave(@ContextParam(ContextType.VIEW) Window window) {
        Map<String, Object> params = new HashMap<>();
        params.put("userDTO", userDTO);

        userDTO = userService.findByID(SecurityUtil.getUserName());
        userDTO.setNip(handphone);
        userDTO.getUserSpecificationDTO().setPrimaryBranchID(alamatRumah);
        userDTO.getUserSpecificationDTO().setFullName(fullname);
        userDTO.getUserSpecificationDTO().setImmediateSupervisorUserName(namaUsaha);
        userDTO.getUserSpecificationDTO().setEscute(jenisUsaha);
        userDTO.getUserSpecificationDTO().setPrimaryBranchID(alamatRumah);
        userDTO.getUserSpecificationDTO().setMobilePhone(alamatUsaha);
        userService.saveOrUpdate(userDTO);
        Messagebox.show("Data Profile Berhasil Diperbaharui", "Information", Messagebox.OK, Messagebox.INFORMATION);
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

    public String getHandphone() {
        return handphone;
    }

    public void setHandphone(String handphone) {
        this.handphone = handphone;
    }

    public String getAlamatRumah() {
        return alamatRumah;
    }

    public void setAlamatRumah(String alamatRumah) {
        this.alamatRumah = alamatRumah;
    }

    public String getAlamatUsaha() {
        return alamatUsaha;
    }

    public void setAlamatUsaha(String alamatUsaha) {
        this.alamatUsaha = alamatUsaha;
    }

}

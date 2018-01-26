package com.ledger.user.management.application.impl;

//package com.ledger.user.management.application.impl;
//
//import com.bitozen.skk.common.dto.usermanagement.CompanyProfileDTO;
//import com.ledger.user.management.application.CompanyProfileService;
//import com.ledger.user.management.domain.company.profile.CompanyProfile;
//import com.ledger.user.management.domain.company.profile.CompanyProfileRepository;
//import com.ledger.user.management.interfaces.web.facade.dto.assembler.companyprofile.CompanyProfileDTOAssembler;
//import java.util.List;
//import java.util.Map;
//import org.apache.commons.lang.Validate;
//
///**
// *
// * @author RBS
// */
//public class CompanyProfileImpl implements CompanyProfileService {
//
//    private CompanyProfileRepository companyProfileRepository;
//    private CompanyProfileDTOAssembler companyProfileDTOAssembler;
//
//    public void setCompanyProfileRepository(CompanyProfileRepository companyProfileRepository) {
//        this.companyProfileRepository = companyProfileRepository;
//    }
//
//    public void setCompanyProfileDTOAssembler(CompanyProfileDTOAssembler companyProfileDTOAssembler) {
//        this.companyProfileDTOAssembler = companyProfileDTOAssembler;
//    }
//
//    @Override
//    public void saveOrUpdate(CompanyProfileDTO companyProfileDTO) {
//        CompanyProfile companyProfile = companyProfileRepository.findByID(companyProfileDTO.getFullname());
//        if (companyProfile == null) {
//            companyProfile = companyProfileDTOAssembler.toDomain(companyProfileDTO);
//        } else {
//            /* update specification */
//            companyProfile.assignNewCompanyProfile(companyProfileDTOAssembler.toDomain(companyProfileDTO));
//        }
//
//        companyProfileRepository.saveOrUpdate(companyProfile);
//    }
//
//    @Override
//    public CompanyProfileDTO findByID(String fullname) {
//        Validate.notNull(companyProfileRepository);
//        CompanyProfile companyProfile = (CompanyProfile) companyProfileRepository.findByID(fullname);
//        if (companyProfile != null) {
//            return companyProfileDTOAssembler.toDTO(companyProfile);
//        }
//
//        return null;
//    }
//
//    @Override
//    public List<CompanyProfileDTO> findAllCompany() {
//        Validate.notNull(companyProfileRepository);
//        List<CompanyProfile> companyProfiles = (List<CompanyProfile>) companyProfileRepository.findAll();
//        return companyProfileDTOAssembler.toDTO(companyProfiles);
//    }
//
//    @Override
//    public void deleteData(CompanyProfileDTO companyProfile) {
//        CompanyProfile c = companyProfileDTOAssembler.toDomain(companyProfile);
//        companyProfileRepository.deleteData(c);
//    }
//
//    @Override
//    public CompanyProfileDTO getDummy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public List<CompanyProfileDTO> findByParams(Map map) {
//        Validate.notNull(companyProfileRepository);
//        List<CompanyProfile> listCompanyProfile = companyProfileRepository.findByParams(map);
//        if (listCompanyProfile != null) {
//            return (List<CompanyProfileDTO>) companyProfileDTOAssembler.toDTO(listCompanyProfile);
//        }
//        return null;
//    }
//
//}

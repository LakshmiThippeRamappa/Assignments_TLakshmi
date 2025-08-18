package com.example.patient_service.service;

import com.example.patient_service.dto.PatientRequest;
import com.example.patient_service.dto.PatientResponse;
import com.example.patient_service.entity.InsuranceInfo;
import com.example.patient_service.entity.Patient;
import com.example.patient_service.exception.NotFoundException;
import com.example.patient_service.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repo;

    public PatientServiceImpl(PatientRepository repo) {
        this.repo = repo;
    }

    @Override
    public PatientResponse create(PatientRequest r) {
        Patient p = mapToEntity(new Patient(), r);
        p = repo.save(p);
        return mapToResponse(p);
    }

    @Override
    public PatientResponse update(Long id, PatientRequest r) {
        Patient existing = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient not found: " + id));
        mapToEntity(existing, r);
        existing = repo.save(existing);
        return mapToResponse(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientResponse get(Long id) {
        return repo.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new NotFoundException("Patient not found: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PatientResponse> list(String q) {
        List<Patient> data = (q == null || q.isBlank())
                ? repo.findAll()
                : repo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(q, q);
        return data.stream().map(this::mapToResponse).toList();
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Patient not found: " + id);
        }
        repo.deleteById(id);
    }

    /* ------------ mapping helpers ------------ */

    private Patient mapToEntity(Patient p, PatientRequest r) {
        p.setFirstName(r.getFirstName());
        p.setLastName(r.getLastName());
        p.setDateOfBirth(r.getDateOfBirth());
        p.setGender(r.getGender());
        p.setEmail(r.getEmail());
        p.setPhone(r.getPhone());
        p.setAddressLine1(r.getAddressLine1());
        p.setAddressLine2(r.getAddressLine2());
        p.setCity(r.getCity());
        p.setState(r.getState());
        p.setZipCode(r.getZipCode());

        if (r.getInsurance() != null) {
            InsuranceInfo ins = new InsuranceInfo(
                    r.getInsurance().getProvider(),
                    r.getInsurance().getPolicyNumber(),
                    r.getInsurance().getValidTill()
            );
            p.setInsurance(ins);
        } else {
            p.setInsurance(null);
        }
        return p;
    }

    private PatientResponse mapToResponse(Patient p) {
        PatientResponse.Insurance ins = null;
        if (p.getInsurance() != null) {
            ins = new PatientResponse.Insurance(
                    p.getInsurance().getProvider(),
                    p.getInsurance().getPolicyNumber(),
                    p.getInsurance().getValidTill()
            );
        }
        return new PatientResponse(
                p.getId(),
                p.getFirstName(),
                p.getLastName(),
                p.getDateOfBirth(),
                p.getGender(),
                p.getEmail(),
                p.getPhone(),
                p.getAddressLine1(),
                p.getAddressLine2(),
                p.getCity(),
                p.getState(),
                p.getZipCode(),
                ins
        );
    }
}

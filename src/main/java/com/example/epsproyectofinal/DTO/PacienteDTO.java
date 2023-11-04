package com.example.epsproyectofinal.DTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public class PacienteDTO {
    private File pacienteFormData;
    private List<Integer> alergiasId;

    public File getPacienteFormData() {
        return pacienteFormData;
    }

    public void setPacienteFormData(File pacienteFormData) {
        this.pacienteFormData = pacienteFormData;
    }

    public List<Integer> getAlergiasId() {
        return alergiasId;
    }

    public void setAlergiasId(List<Integer> alergiasId) {
        this.alergiasId = alergiasId;
    }
}

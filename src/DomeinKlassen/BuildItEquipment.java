/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomeinKlassen;

import java.util.Objects;

/**
 *
 * @author Dries
 */
public class BuildItEquipment {
    private String description, type, requirement;
    private int code;

    public BuildItEquipment(int code, String type, String description, String requirement) {
        this.code = code;
        this.description = description;
        this.type = type;
        this.requirement = requirement;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {                                             //Mag niet gebruikt worden.
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "Code: " + code + ", description: " + description + ", type: " + type + " ";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BuildItEquipment other = (BuildItEquipment) obj;
        if (this.code != other.code) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
    
}

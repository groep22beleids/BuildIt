/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

/**
 *
 * @author Dries
 */
public class Requirement {
    private String description;

    public Requirement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean equals(Requirement r){
        return this.description.equals(r.getDescription());
    }

    @Override
    public String toString() {
        return description;
    }
    
}

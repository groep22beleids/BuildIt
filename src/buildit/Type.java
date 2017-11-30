/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buildit;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Dries
 */
public class Type{
    private ArrayList<Requirement> requirementsList;
    private String name;
    private String test;
    private String test2;
    private String test3;
    private String mayatest;
    private String test4;
    
    public Type() {
        name = null;
        requirementsList = new ArrayList<Requirement>();
    }

    public Type(String name, ArrayList<Requirement> requirementsList) {
        this.name = name;
        this.requirementsList = requirementsList;
    }

    public ArrayList<Requirement> getRequirementsList() {
        return requirementsList;
    }

    public void setRequirementsList(ArrayList<Requirement> requirementsList) {
        this.requirementsList = requirementsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean equals(Type t){
        boolean gevonden = false;
        int i = 0;
        do{
           gevonden = false;
           for(Requirement r : t.getRequirementsList()){
               if(this.getRequirementsList().get(i).equals(r))
                   gevonden = true;
           }
           i++;
        } while((gevonden) && (i < this.getRequirementsList().size()));
        if(!this.getName().equals(t.getName()))
            gevonden = false;
        return gevonden;
    }

    @Override
    public String toString() {
        String text;
        text = "Name: " + this.getName() + "/n";
        text = text + "Requirements: /n";
        for(Requirement r : this.getRequirementsList())
            text = text + r.toString() + "/n";
        return  text;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.requirementsList);
        hash = 67 * hash + Objects.hashCode(this.name);
        return hash;
    }
}

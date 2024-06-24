package rw.ac.rca.online_shopping_system.exceptions;

public class ResourceNotFoundException extends  RuntimeException{
    public String property;
    public String value;
    public String entity;

    public String message;


    public ResourceNotFoundException(String entity, String value, String property){
        super(String.format("%s with %s %s not found", entity, property, value));
        this.entity = entity;
        this.value = value;
        this.property = property;
    }
}

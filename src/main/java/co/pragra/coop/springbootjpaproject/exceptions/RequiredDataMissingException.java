package co.pragra.coop.springbootjpaproject.exceptions;

public class RequiredDataMissingException  extends  RuntimeException{
    public RequiredDataMissingException(String message) {super(message);}
}

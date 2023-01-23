public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        return checkNameMinLength(name) == true
                && checkNameMaxLength(name) == true
                && checkNameNoExtraSpaces(name) == true
                && checkNameSpaceInTheMiddle(name) == true;
    }

    private boolean checkNameMinLength (String name){
        return name.length() >= 3;
    }
    private boolean checkNameMaxLength (String name){
        return name.length() <= 19;
    }
    private boolean checkNameNoExtraSpaces (String name){
        return !name.startsWith(" ") && !name.endsWith(" ");
    }
    private boolean checkNameSpaceInTheMiddle (String name){
        String[] nameToArray = name.split(" ");
        return nameToArray.length == 2;
    }

}
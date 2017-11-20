package Assignment8;

enum Category {
    NEW, USED, CERTIFIED;

    public static Category getCategory(String car) {
        switch (car) {
            case "used":
                return USED;
            case "new":
                return NEW;
            case "certified":
                return CERTIFIED;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case NEW:
                return "NEW";
            case USED:
                return "USED";
            case CERTIFIED:
                return "CERTIFIED";
            default:
                throw new IllegalArgumentException();
        }
    }
}
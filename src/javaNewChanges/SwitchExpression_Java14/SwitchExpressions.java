package javaNewChanges.SwitchExpression_Java14;

public class SwitchExpressions {
    public static void main(String[] args) {


        Days day = Days.SATURDAY;

        // 1. Using traditional switch statement
        System.out.println("Example -- 1-- Using traditional switch statement");
        System.out.println(getDayTypeOldStyle(day));

        // 1. Using enhanced switch - grouping cases
        System.out.println("Example -- 1 -- Using enhanced switch - grouping cases");
        System.out.println(getDayTypeNewStyle(day));

        // 2. Using Old Style Switch to demonstrate fall through if break is not used
        System.out.println("Example -- 2 -- Using Old Style Switch to demonstrate fall through");
        int number = 2;
        switch (number) {
            case 1:
                System.out.println("Number is 1");
            case 2:
                System.out.println("Number is 2");
            case 3:
                System.out.println("Number is 3");
            default:
                System.out.println("Not in range");
        }


        /* 2. Using New Style Switch to demonstrate NO fall through and no need of break
         * But fall through can be achieved with New Switch expressions if we use : instead of -> (refer example - 1)
         */
        System.out.println("Example -- 2 -- Using New Style Switch to demonstrate NO fall through");
        number = 2;
        switch (number) {
            case 1 -> System.out.println("Number is 1");
            case 2 -> System.out.println("Number is 2");
            case 3 -> System.out.println("Number is 3");
            default -> System.out.println("Not in range");
        }

        /*  3. Using old style Switch, we can't return a value from directly, we need to use a variable
         *   But Using New Style Switch, we can return a value directly
         */
        System.out.println("Example -- 3 -- Using New Style Switch to return a value directly");
        number = 2;
        String numString = switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            default -> "Not in range";
        }; // notice that we use semi-colon here, because New Style switch is an expression and returns a value

        System.out.println(numString);
        // 3.1 We can use yield to return value from a block
        number = 4;
        String numString2 = switch (number) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            default -> {
                System.out.println("Not in range");
                yield "Not in range";
            }
        };

        /*
         * 4. Using New Style Switch Statement, Comiler forces to cover all the cases, either using all enum constants or using default case
         * If we miss any case, it will give compilation error
         */
        System.out.println("Example -- 4 -- Using New Style Switch Statement, Compiler forces to cover all the cases");
        Days day2 = Days.MONDAY;
        switch (day2) {
            case MONDAY -> System.out.println("Start of the work week!");
            case TUESDAY -> System.out.println("Second day of the work week.");
            case WEDNESDAY -> System.out.println("Midweek day.");
            case SATURDAY -> System.out.println("Weekend!");
            case SUNDAY -> System.out.println("Rest day.");
            default -> System.out.println("Invalid day."); // If we comment this line, it will give compilation error because we have missed THURSDAY and FRIDAY cases
        }

        /*
         * 5. We can also use Old style case Labels with New Style Switch Expressions, but then we need to use break or yield to return a value
         *    But using -> is preferred way
         */
        System.out.println("Example -- 5 -- Using Old style case Labels with New Style Switch Expressions");
        number = 1;
        String numString3 = switch (number) {
            case 1, 2: // Case Grouping
                yield "One or may be Two"; // Yielding value
            case 3:
                yield "Three";
            default:
                yield "Not in range";
        };
        System.out.println(numString3); 
    }


    // 1. Using traditional switch statement
    private static String getDayTypeOldStyle(Days day) {
        String activity = "";
        switch (day) {
            case MONDAY:
                activity = "Start of the work week!";
                break;
            case TUESDAY:
                activity = "Second day of the work week.";
                break;
            case WEDNESDAY:
                activity = "Midweek day.";
                break;
            case THURSDAY:
                activity = "Almost the weekend!";
                break;
            case FRIDAY:
                activity = "Last day of the work week!";
                break;
            case SATURDAY:
                activity = "Weekend!";
                break;
            case SUNDAY:
                activity = "Rest day.";
                break;
            default:
                activity = "Invalid day.";
        }
        return activity;
    }

    // 2. Using enhanced switch - grouping cases
    private static String getDayTypeNewStyle(Days day) {
        String activity = "";
        switch (day) {
            case SATURDAY, SUNDAY:
                System.out.println("Weekend");
                 break;
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY:
                System.out.println("Weekday");
                break;
            default :
                System.out.println("Invalid day");
        };
        return activity;
    }


}
